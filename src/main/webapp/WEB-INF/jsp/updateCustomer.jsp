<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>UPDATING CUSTOMER</h1>
<form action="updateCustomer" method="post">
    CustomerID<input name="id" value="${customer.id}" />
    
    First Name: <input type="text" name="firstName" value="${customer.firstName}" /><br/>
    Last Name: <input type="text" name="lastName" value="${customer.lastName}" /><br/>
    Email: <input type="email" name="email" value="${customer.email}" /><br/>
    <input type="submit" value="Update Customer" />
</form>

</body>
</html>