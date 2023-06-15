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


<div class="row">
        <div class="col-sm-6 col-sm-push-6">
            <div class="accountActions">
                <form:form action="update-newproduct-color" method="get">
            	    <button type="submit" class="btn btn-primary btn-block">
                        <spring:theme code="Update NewProduct" text="Update NewProduct"/>
                    </button>
                </form:form>
            </div>
        </div>
        <div class="col-sm-6 col-sm-pull-6">
            <div class="accountActions">
                <form:form action="create-newproduct" method="get">
            	    <button type="submit" class="btn btn-primary btn-block">
                        <spring:theme code="Create NewProduct" text="Create NewProduct"/>
                    </button>
                </form:form>
            </div>
        </div>
    </div>

<br>


<c:if test="${not empty  newProductData}">
<table>
   <tr>
    <th><spring:theme code="Code"/></th>
    <th><spring:theme code="Name"/></th>
   <th><spring:theme code="Description"/></th>
    <th><spring:theme code="Size"/></th>
    <th><spring:theme code="Color"/></th>
    <th><spring:theme code="Price"/></th>


           </tr>
<c:forEach items="${newProductData}" var="newProductData">
<tr>
<td>${newProductData.code}</td>
<td>${newProductData.name}</td>
<td>${newProductData.description}</td>
<td>${newProductData.size}</td>
<td>${newProductData.color}</td>
<td>${newProductData.price}</td>
		<td>
		    <form:form action="remove-newproduct/${newProductData.code}" method="post">
		        <button type="submit" class="btn btn-danger btn-block">
                    <spring:theme code="Delete" text="Delete"/>
                </button>
            </form:form>
		</td>
</tr>
</c:forEach>
</table>
</c:if>
</template:page>