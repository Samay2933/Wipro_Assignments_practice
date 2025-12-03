<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>Contact Manager</title>
	<link rel="stylesheet" href="styles.css">
</head>
<body>
	<div class="wrapper flex-center">
		<h1>Contact Manager</h1>
		<p>Manage all your contacts in more efficient way.</p>

		<!--Add Contact-->
		<input type="button" value="Add Contacts" class="btn1 btn">
		
		<div class="form-container1">
			<form action="ContactController" method="POST" class="form flex-center">
				<input type="hidden" name="action" value="add">
				<div>
					<label for="name-field">Name: </label> 
					<input type="text" id="name-field" name="name" required>    
				</div>
				
				<div>
					<label for="phone-field" class="phone-label">Phone Number: </label>
					<input type="tel" id="phone-field" name="phone" required>          <!--  name attribute in input - request.getParameter("phone");  - parameter= name -->
				</div>
				<input type="submit" class="btn2 btn" value="Add">
				
			</form>
		</div>
		

		<!-- Modidy Student-->
		<input type="button" value="Modify Contact" class="btn4 btn">

		<div class="form-container4">
			<form action="ContactController" method="POST" class="form flex-center">
				<input type="hidden" name="action" value="modify">
				<div>
					<label for="id_field">Id: </label> 
					<input type="text" id="id_field" name="id" required>    
				</div>
				<div>
					<label for="name-field">Name: </label> 
					<input type="text" id="name-field" name="name" required>    
				</div>
				
				<div>
					<label for="phone-field" class="phone-label">Phone Number: </label>
					<input type="tel" id="phone-field" name="phone" required>          <!--  name attribute in input - request.getParameter("phone");  - parameter= name -->
				</div>
				<input type="submit" class="btn5 btn" value="Modify">
			</form>
		</div>


		<!--Delete Contacts-->
		<input type="button" value="Delete Contact" class="btn6 btn">

		<div class="form-container6">
			<form action="ContactController" method="POST" class="form flex-center">
				<input type="hidden" name="action" value="delete">
				<div>
					<label for="id_field">Id: </label> 
					<input type="text" id="id_field" name="id" required>    
				</div>
				<input type="submit" class="btn7 btn" value="Delete">
			</form>
		</div>

		<!-- View Details-->
		<a href='ContactController?action=view' >
			<button class="btn btn3">View Details</button>
		</a>
	</div>

	<script src="scripts.js"></script>
		
</body>
</html>