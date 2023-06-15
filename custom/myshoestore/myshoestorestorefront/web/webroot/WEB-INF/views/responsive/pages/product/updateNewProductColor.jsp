
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.lang.*" %>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/responsive/template"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="cms" uri="http://hybris.com/tld/cmstags"%>
<%@ taglib prefix="formElement" tagdir="/WEB-INF/tags/responsive/formElement" %>

<template:page pageTitle="${pageTitle}">
<c:url value = "/update-newproduct-color"/>
<form:form action="update-newproduct-color" method="post" modelAttribute="newProductForm">
<h1>Update NewProduct Color</h1>
    <formElement:formInputBox idKey="newProduct.code" labelKey="NewProduct Code" path="code" inputCSS="text" mandatory="true"/>
<h1>Enter New Color for NewProduct</h1>
    <formElement:formInputBox idKey="newProduct.color" labelKey="NewProduct Color" path="color" inputCSS="text" mandatory="true"/>
    <div class="row">
        <div class="col-sm-6 col-sm-push-6">
            <div class="accountActions">
                <button type="submit" class="btn btn-primary btn-block">
                    <spring:theme code="Update" text="Update"/>
                </button>
            </div>
        </div>
        <div class="col-sm-6 col-sm-pull-6">
            <div class="accountActions">
                <button type="button" class="btn btn-default btn-block backToHome">
                    <spring:theme code="Cancel" text="Cancel"/>
                </button>
            </div>
        </div>
    </div>
</form:form>

</template:page>
