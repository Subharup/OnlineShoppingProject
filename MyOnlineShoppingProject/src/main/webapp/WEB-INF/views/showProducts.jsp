<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
  
<h1>Product List</h1>  
<table border="2" width="70%" cellpadding="2">  
<tr><th>Product ID</th><th>Product Name</th><th>Product Price</th><th>View Products</th></tr>  
   <c:forEach var="product" items="${productList}">   
   <tr>  
   <td>${product.productId}</td>  
   <td>${product.productName}</td>  
   <td>${product.productPrice}</td>
   <td><a href="${pageContext.request.contextPath}/viewProduct/${product.productId}">View Products</a></td>  
 </tr>  
   </c:forEach>  
   </table>  
    