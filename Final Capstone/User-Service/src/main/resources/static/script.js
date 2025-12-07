// script.js - full working script

// API endpoints (keep same as your boilerplate)
const API_BASE = 'http://localhost:8081/api';
const OWNER_API_BASE = 'http://localhost:8082/api';

/* -------------------------
   Init on load - restore session
   ------------------------- */
window.onload = function() {
    const userId = localStorage.getItem('userId');
    const username = localStorage.getItem('username');
    if (userId && username) {
        showMainSection(username);
        getAllApps();
    }
};

/* -------------------------
   Tab helpers (do NOT rely on event)
   ------------------------- */
function showAuthTab(tabName) {
    document.querySelectorAll('#authSection .tab-content').forEach(c => c.classList.remove('active'));
    document.querySelectorAll('#authSection .tab').forEach(t => t.classList.remove('active'));

    const content = document.getElementById(tabName);
    if (content) content.classList.add('active');

    // find matching tab button using onclick attribute
    const btn = document.querySelector(`#authSection .tab[onclick*="${tabName}"]`);
    if (btn) btn.classList.add('active');
}

function showTab(tabName) {
    document.querySelectorAll('#mainSection .tab-content').forEach(c => c.classList.remove('active'));
    document.querySelectorAll('#mainSection .tab').forEach(t => t.classList.remove('active'));

    const content = document.getElementById(tabName);
    if (content) content.classList.add('active');

    const btn = document.querySelector(`#mainSection .tab[onclick*="${tabName}"]`);
    if (btn) btn.classList.add('active');
}

/* -------------------------
   Messaging / UI helpers
   ------------------------- */
function showMessage(message, type = 'success', isAuth = false) {
    const messagesDiv = isAuth ? document.getElementById('authMessages') : document.getElementById('messages');
    messagesDiv.innerHTML = `<div class="message ${type}">${message}</div>`;
    setTimeout(() => { messagesDiv.innerHTML = ''; }, 5000);
}

function showMainSection(username) {
    const userId = localStorage.getItem('userId');
    document.getElementById('authSection').classList.add('hidden');
    document.getElementById('mainSection').classList.remove('hidden');
    // Show username and user ID together
    document.getElementById('loggedInUser').textContent = `${username} (ID: ${userId})`;
}

function showAuthSection() {
    document.getElementById('mainSection').classList.add('hidden');
    document.getElementById('authSection').classList.remove('hidden');
}

/* -------------------------
   Auth API calls
   ------------------------- */
async function registerUser() {
    const username = document.getElementById('regUsername').value.trim();
    const email = document.getElementById('regEmail').value.trim();
    const password = document.getElementById('regPassword').value;
    const fullName = document.getElementById('regFullName').value.trim();

    // simple email format check
    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!email || !emailRegex.test(email)) {
        showMessage('Please enter a valid email address (example: name@example.com).', 'error', true);
        return;
    }

    if (!username) {
        showMessage('Username is required.', 'error', true);
        return;
    }
    if (!password || password.length < 6) {
        showMessage('Password must be at least 6 characters long.', 'error', true);
        return;
    }

    const data = { username, email, password, fullName };

    try {
        const resp = await fetch(`${API_BASE}/users/register`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        if (resp.ok) {
            await resp.json().catch(()=>{});
            showMessage('Registration successful! Please login with your credentials.', 'success', true);
            showAuthTab('loginForm');
            // clear form
            document.getElementById('regUsername').value = '';
            document.getElementById('regEmail').value = '';
            document.getElementById('regPassword').value = '';
            document.getElementById('regFullName').value = '';
        } else {
            let errText = `Registration failed: ${resp.status} ${resp.statusText}`;
            try {
                const err = await resp.json();
                if (err.message) errText = err.message;
                else if (err.error) errText = err.error;
                else errText = JSON.stringify(err);
            } catch(e){}
            showMessage(errText, 'error', true);
        }
    } catch (e) {
        showMessage('Error: ' + (e.message || e), 'error', true);
    }
}

async function loginUser() {
    const data = {
        username: document.getElementById('loginUsername').value.trim(),
        password: document.getElementById('loginPassword').value
    };

    try {
        const resp = await fetch(`${API_BASE}/users/login`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        if (resp.ok) {
            const result = await resp.json();
            // assume backend returns { id, username, ... }
            const id = result.id ?? result.userId ?? result.user?.id;
            const uname = result.username ?? result.user?.username ?? data.username;
            localStorage.setItem('userId', id);
            localStorage.setItem('username', uname);
            showMainSection(uname);
            getAllApps();
            showMessage(`Welcome back, ${uname}!`, 'success');
            // clear login inputs
            document.getElementById('loginUsername').value = '';
            document.getElementById('loginPassword').value = '';
        } else {
            let errMsg = 'Login failed: Invalid credentials';
            try {
                const err = await resp.json();
                if (err.message) errMsg = err.message;
            } catch(e){}
            showMessage(errMsg, 'error', true);
        }
    } catch (e) {
        showMessage('Error: ' + (e.message || e), 'error', true);
    }
}

function logoutUser() {
    localStorage.removeItem('userId');
    localStorage.removeItem('username');
    showAuthSection();
    showMessage('Logged out successfully!', 'success', true);
}

/* -------------------------
   Apps / Filters
   ------------------------- */
async function getAllApps() {
    try {
        // use visible-only endpoint so hidden apps do not appear
        const resp = await fetch(`${OWNER_API_BASE}/applications/visible`);
        if (!resp.ok) throw new Error(`Status ${resp.status}`);
        const apps = await resp.json();
        displayApps(apps);
    } catch (e) {
        showMessage('Error loading apps: ' + (e.message || e), 'error');
    }
}

async function searchApps() {
    const name = document.getElementById('searchName').value.trim();
    try {
        const resp = await fetch(
            `${OWNER_API_BASE}/applications/visible/search?name=${encodeURIComponent(name)}`
        );
        if (!resp.ok) throw new Error(`Status ${resp.status}`);
        const apps = await resp.json();
        displayApps(apps);
    } catch (e) {
        showMessage('Error searching apps: ' + (e.message || e), 'error');
    }
}

async function filterByCategory() {
    const category = document.getElementById('categoryFilter').value;
    if (!category) { getAllApps(); return; }
    try {
        const resp = await fetch(
            `${OWNER_API_BASE}/applications/visible/category/${encodeURIComponent(category)}`
        );
        if (!resp.ok) throw new Error(`Status ${resp.status}`);
        const apps = await resp.json();
        displayApps(apps);
    } catch (e) {
        showMessage('Error filtering apps: ' + (e.message || e), 'error');
    }
}

async function filterByRating() {
    const rating = document.getElementById('ratingFilter').value;
    if (!rating) { showMessage('Please enter a minimum rating', 'error'); return; }
    try {
        const resp = await fetch(
            `${OWNER_API_BASE}/applications/visible/rating/${encodeURIComponent(rating)}`
        );
        if (!resp.ok) throw new Error(`Status ${resp.status}`);
        const apps = await resp.json();
        displayApps(apps);
    } catch (e) {
        showMessage('Error filtering apps: ' + (e.message || e), 'error');
    }
}

function displayApps(apps) {
    const appsList = document.getElementById('appsList');
    if (!Array.isArray(apps) || apps.length === 0) {
        appsList.innerHTML = '<p>No applications found</p>';
        return;
    }
    appsList.innerHTML = apps.map(app => `
        <div class="app-card">
            <h3>${escapeHtml(app.name)}</h3>
            <p><strong>Category:</strong> ${escapeHtml(app.category || 'N/A')}</p>
            <p><strong>Genre:</strong> ${escapeHtml(app.genre || 'N/A')}</p>
            <p><strong>Version:</strong> ${escapeHtml(app.version || 'N/A')}</p>
            <p class="rating"><strong>Rating:</strong> ⭐ ${app.rating ?? 'Not rated'}</p>
            <p><strong>Downloads:</strong> ${app.downloadCount || 0}</p>
            <p>${escapeHtml(app.description || 'No description')}</p>
            <p><strong>App ID:</strong> ${app.id}</p>
            <button onclick="downloadApp(${app.id})">Download</button>
        </div>
    `).join('');
}

async function downloadApp(appId) {
    try {
        const response = await fetch(`${OWNER_API_BASE}/applications/${appId}/download`, {
            method: 'PATCH'
        });
        
        if (response.ok) {
            showMessage('✅ App downloaded successfully! Download count updated.', 'success');
            // Reload apps to show updated download count
            getAllApps();
        } else {
            showMessage('❌ Failed to download app', 'error');
        }
    } catch (error) {
        showMessage('❌ Error: ' + error.message, 'error');
    }
}

/* small helper to avoid injecting raw HTML from server-provided fields */
function escapeHtml(str) {
    if (str === null || str === undefined) return '';
    return String(str)
        .replace(/&/g, "&amp;")
        .replace(/</g, "&lt;")
        .replace(/>/g, "&gt;")
        .replace(/"/g, "&quot;")
        .replace(/'/g, "&#039;");
}

/* -------------------------
   Submit Review (robust)
   ------------------------- */
async function submitReview() {
    const uid = Number(localStorage.getItem('userId'));
    const uname = localStorage.getItem('username') || 'User';
    if (!uid || uid <= 0) {
        showMessage('Your session is invalid — please login again.', 'error');
        logoutUser();
        return;
    }

    const appId = Number(document.getElementById('reviewAppId').value);
    const rating = Number(document.getElementById('reviewRating').value);
    const comment = (document.getElementById('reviewComment').value || '').trim();

    if (!appId || appId <= 0) { showMessage('Enter valid App ID', 'error'); return; }
    if (!Number.isFinite(rating) || rating < 1 || rating > 5) { showMessage('Rating must be 1–5', 'error'); return; }
    if (!comment) { showMessage('Comment required', 'error'); return; }

    const data = { userId: uid, appId: appId, rating: rating, comment: comment };

    try {
        const resp = await fetch(`${API_BASE}/reviews`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        if (!resp.ok) {
            let errText = `Request failed: ${resp.status} ${resp.statusText}`;
            try {
                const errBody = await resp.json();
                if (errBody) {
                    if (errBody.message) errText = errBody.message;
                    else if (errBody.error) errText = errBody.error;
                    else errText = JSON.stringify(errBody);
                }
            } catch (e) {}
            showMessage(`Failed to submit review: ${errText}`, 'error');
            return;
        }

        showMessage('Review submitted successfully!', 'success');
        document.getElementById('reviewAppId').value = '';
        document.getElementById('reviewRating').value = '';
        document.getElementById('reviewComment').value = '';
    } catch (e) {
        const msg = (e && e.message) ? e.message : String(e);
        if (msg.toLowerCase().includes('failed to fetch')) {
            showMessage('Network error or CORS blocked the request. Check backend is running and CORS allowed.', 'error');
        } else {
            showMessage('Error: ' + msg, 'error');
        }
    }
}
