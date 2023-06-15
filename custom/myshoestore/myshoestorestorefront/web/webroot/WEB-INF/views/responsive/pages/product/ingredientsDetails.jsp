<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.lang.*" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement" %>

 <template:page pageTitle="${pageTitle}">

<c:if test="${not empty  ingredientsData}">
<table>
   <tr>
    <th><spring:theme code="Name"/></th>
    <th><spring:theme code="Quantity"/></th>
   <th><spring:theme code="Unit"/></th>


           </tr>
<c:forEach items="${ingredientsData}" var="ingredientsData">
<tr>
<td>${ingredientsData.name}</td>
<td>${ingredientsData.quantity}</td>
<td>${ingredientsData.unit}</td>


</tr>
</c:forEach>
</table>
</c:if>
</template:page>