<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<!-- Optional theme -->
<link rel="stylesheet" href="css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
<!-- Latest compiled and minified JavaScript -->
<script src="js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

<link rel="stlyesheet" href="css/login/login.css">
<script src="js/login/login.js" ></script>

</head>
<body>

  <div class="panel panel-primary">
  <div class="panel-heading">User List</div>
  <div class="panel-body">
  
  
  
  <form:form action="processUser.html" method="post" modelAttribute="user">
		
		
		<form:hidden path="id"/>
		
	    <div class="form-group">
	    <label for="name">Name:</label>
	    <form:input path="name" id="name" cssClass="form-control"/>
	    </div>
	    
	    <div class="form-group">
	    <label for="phoneNo">Phone No:</label>
	    <form:input path="phoneNo" id="phoneNo" cssClass="form-control"/>
	    </div>
	    
	   <div class="form-group">
	    <label for="dob">DOB</label>
	    <form:input path="dob" id="dob" cssClass="form-control"/>
	    </div> 
	    
	    <div class="form-group">
	    <label for="username">Username</label>
	    <form:input path="username" id="username" cssClass="form-control"/>
	    </div>
	    
	    <div class="form-group">
	    <label for="password">Password</label>
	    <form:input path="password" id="password" cssClass="form-control"/>
	    </div>

	  <button type="submit" class="btn btn-default">Submit</button>
	</form:form>
  
  </div>
  </div>
  
  

  <div class="panel panel-primary">
  <div class="panel-heading">User List</div>
  <div class="panel-body">
  <table class="table">
    <thead>
      <tr>
        <th>ID</th>
        <th>NAME</th>
        <th>PHONE NO</th>
        <th>DOB</th>
        <th>Action</th>
      
      </tr>
    </thead>
    <tbody>
    <c:forEach items="${userList}" var="row">
      <tr>
        <td>${row.id }</td>
        <td>${row.name }</td>
        <td>${row.phoneNo }</td>
        <td>${row.dob }</td>
        
        <td> <a href="edit.do?id=${row.id}">Edit</a></td>
        <td><a href="delete.do?id=${row.id}">Delete</a></td>
        
      </tr>
     </c:forEach>
    </tbody>
  </table>
  
  </div>
  </div>




</body>
</html>