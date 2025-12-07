// ----------------- BASE URLS -----------------
const API_BASE = 'http://localhost:8082/api';
const USER_API_BASE = 'http://localhost:8081/api';

// ----------------- ON LOAD -----------------
window.onload = function() {
    const ownerId = localStorage.getItem('ownerId');
    const username = localStorage.getItem('ownerUsername');
    const token = localStorage.getItem('ownerToken');

    if (ownerId && username && token) {
        showMainSection(username, ownerId);
        loadMyApps();
        loadAppsForReview();
    } else {
        showAuthSection();
    }
};

// ----------------- AUTH TAB HELPERS -----------------
// Supports both: showAuthTab('loginForm') and showAuthTab(this, 'loginForm')
function showAuthTab(arg1, arg2) {
    let elem, tabName;
    if (typeof arg1 === 'string') {
        tabName = arg1;
        elem = null;
    } else {
        elem = arg1;
        tabName = arg2;
    }

    document.querySelectorAll('#authSection .tab-content')
        .forEach(content => content.classList.remove('active'));
    document.querySelectorAll('#authSection .tab')
        .forEach(tab => tab.classList.remove('active'));

    const content = document.getElementById(tabName);
    if (content) content.classList.add('active');

    if (elem && elem.classList) {
        elem.classList.add('active');
    } else {
        // fallback: mark correct tab by text if elem not provided
        document.querySelectorAll('#authSection .tab').forEach(btn => {
            if (tabName === 'loginForm' && btn.textContent.trim().toLowerCase() === 'login') {
                btn.classList.add('active');
            }
            if (tabName === 'registerForm' && btn.textContent.trim().toLowerCase() === 'register') {
                btn.classList.add('active');
            }
        });
    }
}

// ----------------- MAIN TAB HELPERS -----------------
// Supports both: showTab('create') and showTab(this, 'create')
function showTab(arg1, arg2) {
    let elem, tabName;
    if (typeof arg1 === 'string') {
        tabName = arg1;
        elem = null;
    } else {
        elem = arg1;
        tabName = arg2;
    }

    document.querySelectorAll('#mainSection .tab-content')
        .forEach(content => content.classList.remove('active'));
    document.querySelectorAll('#mainSection .tab')
        .forEach(tab => tab.classList.remove('active'));

    const content = document.getElementById(tabName);
    if (content) content.classList.add('active');

    if (elem && elem.classList) {
        elem.classList.add('active');
    } else {
        document.querySelectorAll('#mainSection .tab').forEach(btn => {
            const label = btn.textContent.trim().toLowerCase();
            if (tabName === 'create' && label.includes('add')) btn.classList.add('active');
            if (tabName === 'manage' && label.includes('manage')) btn.classList.add('active');
            if (tabName === 'reviews' && label.includes('review')) btn.classList.add('active');
            if (tabName === 'announce' && label.includes('update')) btn.classList.add('active');
            if (tabName === 'stats' && label.includes('statistics')) btn.classList.add('active');
        });
    }

    if (tabName === 'reviews') {
        loadAppsForReview();
    }
}

// ----------------- AUTH / MAIN VISIBILITY -----------------
function showMainSection(username, ownerId) {
    document.getElementById('authSection').classList.add('hidden');
    document.getElementById('mainSection').classList.remove('hidden');
    document.getElementById('loggedInOwner').textContent = username;
    document.getElementById('loggedInOwnerId').textContent = ownerId;
}

function showAuthSection() {
    document.getElementById('mainSection').classList.add('hidden');
    document.getElementById('authSection').classList.remove('hidden');
}

// ----------------- MESSAGE HELPER -----------------
function showMessage(message, type, isAuth = false) {
    const messagesDiv = isAuth ? document.getElementById('authMessages') : document.getElementById('messages');
    messagesDiv.innerHTML = `<div class="message ${type}">${message}</div>`;
    setTimeout(() => messagesDiv.innerHTML = '', 5000);
}

// ----------------- AUTH HEADERS HELPER (JWT) -----------------
function buildAuthHeaders(extra = {}) {
    const token = localStorage.getItem('ownerToken');
    const headers = { ...extra };
    if (token) {
        headers['Authorization'] = 'Bearer ' + token;
    }
    return headers;
}

// ----------------- REGISTER OWNER -----------------
async function registerOwner() {
    const data = {
        username: document.getElementById('regUsername').value.trim(),
        email: document.getElementById('regEmail').value.trim(),
        password: document.getElementById('regPassword').value,
        companyName: document.getElementById('regCompany').value.trim()
    };

    const emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    if (!data.email || !emailRegex.test(data.email)) {
        showMessage('Please enter a valid email address (example: name@example.com).', 'error', true);
        return;
    }
    if (!data.username) {
        showMessage('Username is required.', 'error', true);
        return;
    }
    if (!data.password || data.password.length < 6) {
        showMessage('Password must be at least 6 characters long.', 'error', true);
        return;
    }

    try {
        const response = await fetch(`${API_BASE}/owners/register`, {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify(data)
        });

        if (response.ok) {
            showMessage('Registration successful! Please login.', 'success', true);

            const loginTabBtn = Array.from(document.querySelectorAll('#authSection .tab'))
                .find(b => b.textContent.trim().toLowerCase() === 'login');

            showAuthTab(loginTabBtn || 'loginForm', 'loginForm');

            document.getElementById('regUsername').value = '';
            document.getElementById('regEmail').value = '';
            document.getElementById('regPassword').value = '';
            document.getElementById('regCompany').value = '';
        } else {
            const text = await response.text();
            let errMsg = text;
            try { errMsg = JSON.parse(text).message || text; } catch(e) {}
            showMessage(errMsg || 'Registration failed', 'error', true);
        }
    } catch (error) {
        showMessage('Error: ' + error.message, 'error', true);
    }
}

// ----------------- LOGIN OWNER (fix ownerId + token) -----------------
async function loginOwner() {
    const username = document.getElementById('loginUsername').value;
    const password = document.getElementById('loginPassword').value;

    if (!username || !password) {
        showMessage('Please enter username & password', 'error', true);
        return;
    }

    try {
        const url = `${API_BASE}/owners/login?username=${encodeURIComponent(username)}&password=${encodeURIComponent(password)}`;
        const response = await fetch(url, { method: 'POST' });

        if (!response.ok) {
            const text = await response.text();
            let errMsg = text;
            try { errMsg = JSON.parse(text).message || text; } catch(e) {}
            showMessage(errMsg || 'Invalid username or password', 'error', true);
            return;
        }

        const result = await response.json();
        // Backend LoginResponse: token, ownerId, username, email
        const ownerId = result.ownerId ?? result.id;
        const name = result.username || 'Owner';
        const token = result.token;

        if (!ownerId) {
            showMessage('Login failed: server did not return owner id', 'error', true);
            return;
        }

        localStorage.setItem('ownerId', ownerId);
        localStorage.setItem('ownerUsername', name);
        if (token) localStorage.setItem('ownerToken', token);

        showMainSection(name, ownerId);
        loadMyApps();
        loadAppsForReview();
        showMessage(`Welcome back, ${name}!`, 'success');
    } catch (err) {
        showMessage('Error: ' + err.message, 'error', true);
    }
}

function logoutOwner() {
    localStorage.removeItem('ownerId');
    localStorage.removeItem('ownerUsername');
    localStorage.removeItem('ownerToken');
    showAuthSection();
    showMessage('Logged out successfully!', 'success', true);
}

// ----------------- CREATE APP (uses JWT) -----------------
async function createApp() {
    const ownerId = localStorage.getItem('ownerId');
    if (!ownerId) {
        showMessage('Please login first!', 'error');
        return;
    }

    const data = {
        ownerId: parseInt(ownerId, 10),
        name: document.getElementById('appName').value,
        description: document.getElementById('appDescription').value,
        version: document.getElementById('appVersion').value,
        category: document.getElementById('appCategory').value,
        genre: document.getElementById('appGenre').value,
        rating: parseFloat(document.getElementById('appRating').value) || null,
        isVisible: document.getElementById('appVisibility').value === 'true',
        releaseDate: new Date().toISOString()
    };

    try {
        const response = await fetch(`${API_BASE}/applications`, {
            method: 'POST',
            headers: buildAuthHeaders({ 'Content-Type': 'application/json' }),
            body: JSON.stringify(data)
        });

        if (response.ok) {
            const result = await response.json();
            showMessage(`Application added! App ID: ${result.id}`, 'success');
            document.getElementById('appName').value = '';
            document.getElementById('appDescription').value = '';
            document.getElementById('appVersion').value = '';
            document.getElementById('appGenre').value = '';
            document.getElementById('appRating').value = '';
            loadMyApps();
            loadAppsForReview();
        } else {
            const text = await response.text();
            let errMsg = text;
            try { errMsg = JSON.parse(text).message || text; } catch(e){}
            showMessage('Failed to add application: ' + (errMsg || response.statusText), 'error');
        }
    } catch (error) {
        showMessage('Failed to add application: ' + error.message, 'error');
    }
}

// ----------------- LOAD OWNER APPS (uses JWT) -----------------
async function loadMyApps() {
    const ownerId = localStorage.getItem('ownerId');
    const appsList = document.getElementById('myAppsList');
    appsList.innerHTML = '<p>Loading...</p>';
    if (!ownerId) {
        appsList.innerHTML = '<p>Please login to see apps.</p>';
        return;
    }

    try {
        const response = await fetch(`${API_BASE}/applications/owner/${ownerId}`, {
            headers: buildAuthHeaders()
        });

        if (!response.ok) {
            const text = await response.text();
            let errMsg = text;
            try { errMsg = JSON.parse(text).message || text; } catch(e){}
            showMessage('Error loading apps: ' + (errMsg || `HTTP ${response.status}`), 'error');
            displayMyApps([]);
            return;
        }

        const apps = await response.json();
        const normalized = Array.isArray(apps) ? apps : (apps && Array.isArray(apps.data) ? apps.data : []);
        displayMyApps(normalized);
    } catch (error) {
        showMessage('Error loading apps: ' + error.message, 'error');
        displayMyApps([]);
    }
}

function displayMyApps(apps) {
    const appsList = document.getElementById('myAppsList');
    if (!Array.isArray(apps) || apps.length === 0) {
        appsList.innerHTML = '<p>No applications found.</p>';
        return;
    } 
    appsList.innerHTML = apps.map(app => `
        <div class="app-item">
            <div class="app-info">
                <h3>${escapeHtml(app.name)}</h3>
                <p><strong>ID:</strong> ${escapeHtml(app.id)} | <strong>Version:</strong> ${escapeHtml(app.version || 'N/A')} | 
                <strong>Category:</strong> ${escapeHtml(app.category || 'N/A')} | <strong>Downloads:</strong> ${escapeHtml(app.downloadCount || 0)}</p>
                <p><strong>Visible:</strong> ${app.isVisible ? 'Yes' : 'No'} | 
                <strong>Rating:</strong> ${escapeHtml(app.rating || 'Not rated')}</p>
            </div>
            <div class="app-actions">
                <button onclick="toggleVisibility(${app.id}, ${!app.isVisible})">
                    ${app.isVisible ? 'Hide' : 'Show'}
                </button>
                <button onclick="deleteApp(${app.id})" style="background: #dc3545;">Delete</button>
            </div>
        </div>
    `).join('');
}

function escapeHtml(value) {
    if (value === null || value === undefined) return '';
    return String(value)
        .replace(/&/g, '&amp;')
        .replace(/"/g, '&quot;')
        .replace(/'/g, '&#39;')
        .replace(/</g, '&lt;')
        .replace(/>/g, '&gt;');
}

// ----------------- APP ACTIONS (use JWT) -----------------
async function simulateDownload(appId) {
    try {
        const response = await fetch(`${API_BASE}/applications/${appId}/download`, {
            method: 'PATCH',
            headers: buildAuthHeaders()
        });
        if (response.ok) {
            showMessage('Download simulated! Check notification service console.', 'success');
            loadMyApps();
        } else {
            const text = await response.text();
            let errMsg = text;
            try { errMsg = JSON.parse(text).message || text; } catch(e){}
            showMessage('Failed to simulate download: ' + errMsg, 'error');
        }
    } catch (error) {
        showMessage('Error: ' + error.message, 'error');
    }
}

async function toggleVisibility(appId, isVisible) {
    try {
        const response = await fetch(`${API_BASE}/applications/${appId}/visibility?isVisible=${isVisible}`, {
            method: 'PATCH',
            headers: buildAuthHeaders()
        });
        if (response.ok) {
            showMessage('Visibility updated', 'success');
            loadMyApps();
        } else {
            const text = await response.text();
            let errMsg = text;
            try { errMsg = JSON.parse(text).message || text; } catch(e){}
            showMessage('Failed to update visibility: ' + errMsg, 'error');
        }
    } catch (error) {
        showMessage('Error: ' + error.message, 'error');
    }
}

async function deleteApp(appId) {
    if (!confirm('Are you sure?')) return;
    try {
        const response = await fetch(`${API_BASE}/applications/${appId}`, {
            method: 'DELETE',
            headers: buildAuthHeaders()
        });
        if (response.ok) {
            showMessage('Application deleted', 'success');
            loadMyApps();
            loadAppsForReview();
        } else {
            const text = await response.text();
            let errMsg = text;
            try { errMsg = JSON.parse(text).message || text; } catch(e){}
            showMessage('Failed to delete app: ' + errMsg, 'error');
        }
    } catch (error) {
        showMessage('Error: ' + error.message, 'error');
    }
}

// ----------------- REVIEWS (apps list uses JWT, user-service no JWT) -----------------
async function loadAppsForReview() {
    const ownerId = localStorage.getItem('ownerId');
    const select = document.getElementById('reviewAppSelect');
    select.innerHTML = '<option value="">-- Select an app --</option>';
    if (!ownerId) return;

    try {
        const response = await fetch(`${API_BASE}/applications/owner/${ownerId}`, {
            headers: buildAuthHeaders()
        });
        if (!response.ok) return;
        const apps = await response.json();
        const normalized = Array.isArray(apps) ? apps : (apps && Array.isArray(apps.data) ? apps.data : []);
        select.innerHTML = '<option value="">-- Select an app --</option>' +
            normalized.map(app => `<option value="${escapeHtml(app.id)}">${escapeHtml(app.name)}</option>`).join('');
    } catch (error) {
        console.error('Error loading apps:', error);
    }
}

async function loadReviews() {
    const appId = document.getElementById('reviewAppSelect').value;
    if (!appId) {
        showMessage('Please select an app first', 'error');
        return;
    }

    try {
        const response = await fetch(`${USER_API_BASE}/reviews/app/${appId}`);
        if (!response.ok) {
            const text = await response.text();
            let errMsg = text;
            try { errMsg = JSON.parse(text).message || text; } catch(e){}
            showMessage('Failed to load reviews: ' + errMsg, 'error');
            return;
        }
        const reviews = await response.json();
        const normalized = Array.isArray(reviews) ? reviews : (reviews && Array.isArray(reviews.data) ? reviews.data : []);
        displayReviews(normalized);
    } catch (error) {
        showMessage('Error loading reviews: ' + error.message, 'error');
    }
}

function displayReviews(reviews) {
    const reviewsList = document.getElementById('reviewsList');
    if (!Array.isArray(reviews) || reviews.length === 0) {
        reviewsList.innerHTML = '<p>No reviews yet for this app.</p>';
        return;
    }

    reviewsList.innerHTML = reviews.map(review => `
        <div class="review-card">
            <p class="review-rating">Rating: ${'⭐'.repeat(Math.max(0, Math.min(5, review.rating || 0)))}</p>
            <p><strong>User ID:</strong> ${escapeHtml(review.userId)}</p>
            <p><strong>Comment:</strong> ${escapeHtml(review.comment || 'No comment')}</p>
            <p style="color: #999; font-size: 12px;">Posted: ${review.createdAt ? new Date(review.createdAt).toLocaleString() : 'N/A'}</p>
        </div>
    `).join('');
}

// ----------------- ANNOUNCEMENTS & STATS (use JWT) -----------------
async function sendAnnouncement() {
    const subject = document.getElementById('announceSubject').value;
    const message = document.getElementById('announceMessage').value;

    if (!subject || !message) {
        showMessage('Please enter both subject and message', 'error');
        return;
    }

    const data = { subject, message };

    try {
        const response = await fetch(`${API_BASE}/announcements/send`, {
            method: 'POST',
            headers: buildAuthHeaders({ 'Content-Type': 'application/json' }),
            body: JSON.stringify(data)
        });

        if (response.ok) {
            showMessage('Announcement sent! Check notification service console.', 'success');
            document.getElementById('announceSubject').value = '';
            document.getElementById('announceMessage').value = '';
        } else {
            const text = await response.text();
            let errMsg = text;
            try { errMsg = JSON.parse(text).message || text; } catch(e){}
            showMessage('Failed to send announcement: ' + errMsg, 'error');
        }
    } catch (error) {
        showMessage('Error: ' + error.message, 'error');
    }
}

async function loadStats() {
    const ownerId = localStorage.getItem('ownerId');
    if (!ownerId) return;

    try {
        const response = await fetch(`${API_BASE}/applications/owner/${ownerId}`, {
            headers: buildAuthHeaders()
        });
        if (!response.ok) {
            showMessage('Error loading stats: ' + response.statusText, 'error');
            return;
        }
        const apps = await response.json();
        const normalized = Array.isArray(apps) ? apps : (apps && Array.isArray(apps.data) ? apps.data : []);

        const totalApps = normalized.length;
        const totalDownloads = normalized.reduce((sum, app) => sum + (parseInt(app.downloadCount || 0, 10)), 0);
        const avgRating = totalApps > 0 ? (normalized.reduce((sum, app) => sum + (parseFloat(app.rating || 0)), 0) / totalApps) : 0;
        const visibleApps = normalized.filter(app => app.isVisible).length;

        document.getElementById('statsDisplay').innerHTML = `
            <div class="stat-card">
                <h3>Total Apps</h3>
                <div class="number">${totalApps}</div>
            </div>
            <div class="stat-card">
                <h3>Total Downloads</h3>
                <div class="number">${totalDownloads}</div>
            </div>
            <div class="stat-card">
                <h3>Avg Rating</h3>
                <div class="number">${avgRating.toFixed(2)}</div>
            </div>
            <div class="stat-card">
                <h3>Visible Apps</h3>
                <div class="number">${visibleApps}</div>
            </div>
        `;
    } catch (error) {
        showMessage('Error loading stats: ' + error.message, 'error');
    }
}
