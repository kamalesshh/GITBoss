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
                 <form:form action="update-recipe-title" method="get">
             	    <button type="submit" class="btn btn-primary btn-block">
                         <spring:theme code="Update Recipe" text="Update Recipe"/>
                     </button>
                 </form:form>
             </div>
         </div>
         <div class="col-sm-6 col-sm-pull-6">
             <div class="accountActions">
                 <form:form action="create-recipe" method="get">
             	    <button type="submit" class="btn btn-primary btn-block">
                         <spring:theme code="Create Recipe" text="Create Recipe"/>
                     </button>
                 </form:form>
             </div>
         </div>
     </div>

 <br>


<c:if test="${not empty  recipeData}">
<table>
   <tr>
    <th><spring:theme code="Code"/></th>
    <th><spring:theme code="Title"/></th>
   <th><spring:theme code="Description"/></th>
   <th><spring:theme code="Complicated"/></th>


           </tr>
<c:forEach items="${recipeData}" var="recipeData">
<tr>
<td>${recipeData.code}</td>
<td>${recipeData.title}</td>
<td>${recipeData.description}</td>
<td>${recipeData.isComplicated}</td>
<td>
		    <form:form action="remove-recipe/${recipeData.code}" method="post">
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