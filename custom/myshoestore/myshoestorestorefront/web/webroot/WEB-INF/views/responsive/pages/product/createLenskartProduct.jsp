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
<c:url value = "/create-lenskartproduct"/>
<h1>NewProduct Creation Form</h1>
<form:form action="create-lenskartproduct" method="post" modelAttribute="lenskartProductForm">
    <formElement:formInputBox idKey="lenskartproduct.name" labelKey="Product Name" path="name" inputCSS="text" mandatory="true"/>
    <formElement:formInputBox idKey="lenskartproduct.size" labelKey="Product Size" path="size" inputCSS="text" mandatory="true"/>
    <formElement:formInputBox idKey="lenskartproduct.colour" labelKey="Product colour" path="colour" inputCSS="text" mandatory="true"/>

    <div class="row">
        <div class="col-sm-6 col-sm-push-6">
            <div class="accountActions">
                <button type="submit" class="btn btn-primary btn-block">
                    <spring:theme code="Create" text="Create"/>
                </button>
            </div>
        </div>
        <div class="col-sm-6 col-sm-pull-6">
            <div class="accountActions">
                <a href="https://myshoestore:9002/myShoeStore/en/lenskart/create-lenskartproduct"
            	    <button type="button" method="get" class="btn btn-default btn-block backToHome">
                        <spring:theme code="Cancel" text="Cancel"/>
                    </button>
                </a>
            </div>
        </div>
    </div>
</form:form>
</template:page>