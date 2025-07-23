<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
    <html>

    <head>
        <title>View Customers</title>
    </head>

    <body>
        <h2>Customer List</h2>
        <table border="1">
            <tr>
             <th>CustomerID</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>Email</th>
                <th>Account ID</th>
                <th>Balance</th>
               
                
                
            </tr>
            <c:forEach var="customer" items="${customerList}">
                <tr>
                	<td>${customer.id}</td>
                    <td>${customer.firstName}</td>
                    <td>${customer.lastName}</td>
                    <td>${customer.email}</td>
                    <td>${customer.account.accountId}</td>
                    <td>${customer.account.balance}</td>
                    
                    <td>
                <a href="deleteCustomer?id=${customer.id}" onclick="return confirm('Are you sure you want to delete this customer?');">Delete</a>
            </td>
            <td>
                <a href="editCustomer?id=${customer.id}" onclick="return confirm('Are you sure you want to update this customer?');">Update</a>
            </td>
                </tr>
            </c:forEach>
        </table>
        <br />
        <a href="addCustomer.view">Add New Customer</a>
    </body>

    </html>