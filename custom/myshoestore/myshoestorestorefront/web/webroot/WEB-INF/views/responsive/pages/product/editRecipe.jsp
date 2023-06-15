<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <title>Edit Recipe</title>
</head>
<body>
    <h2>Edit Recipe</h2>
    <form:form modelAttribute="recipeForm" method="post" action="/recipes/edit/${recipeForm.code}">
        <div>
            <label for="title">Title:</label>
            <form:input path="title" id="title"/>
            <form:errors path="title"/>
        </div>
        <div>
            <label for="description">Description:</label>
            <form:textarea path="description" id="description"/>
            <form:errors path="description"/>
        </div>
        <h3>Ingredients:</h3>
        <div id="ingredientsSection">
            <c:forEach var="ingredientsForm" items="${recipeForm.ingredients}" varStatus="status">
                <div>
                    <label for="ingredients_${status.index}_name">Name:</label>
                    <form:input path="ingredients[${status.index}].name" id="ingredient_${status.index}_name"/>
                    <form:errors path="ingredients[${status.index}].name"/>
                </div>
                <div>
                    <label for="ingredient_${status.index}_quantity">Quantity:</label>
                    <form:input path="ingredients[${status.index}].quantity" id="ingredient_${status.index}_quantity"/>
                    <form:errors path="ingredients[${status.index}].quantity"/>
                </div>
                <div>
                    <label for="ingredient_${status.index}_unit">Unit:</label>
                    <form:input path="ingredients[${status.index}].unit" id="ingredient_${status.index}_unit"/>
                    <form:errors path="ingredients[${status.index}].unit"/>
                </div>
            </c:forEach>
        </div>
        <button type="button" onclick="addIngredients()">Add Ingredient</button>
        <br/><br/>
        <input type="submit" value="Save"/>
    </form:form>

    <script>
        var ingredientsIndex = ${recipeForm.ingredients.size() - 1};

        function addIngredients() {
            var ingredientsSection = document.getElementById("ingredientsSection");

            var ingredientsDiv = document.createElement("div");

            var nameLabel = document.createElement("label");
            nameLabel.innerText = "Name:";
            ingredientsDiv.appendChild(nameLabel);

            var nameInput = document.createElement("input");
            nameInput.type = "text";
            nameInput.name = "recipeForm.ingredients[" + ingredientsIndex + "].name";
            ingredientsDiv.appendChild(nameInput);

            var quantityLabel = document.createElement("label");
            quantityLabel.innerText = "Quantity:";
            ingredientsDiv.appendChild(quantityLabel);

            var quantityInput = document.createElement("input");
            quantityInput.type = "text";
            quantityInput.name = "recipeForm.ingredients[" + ingredientsIndex + "].quantity";
            ingredientsDiv.appendChild(quantityInput);

            var unitLabel = document.createElement("label");
            unitLabel.innerText = "Unit:";
            ingredientsDiv.appendChild(unitLabel);

            var unitInput = document.createElement("input");
            unitInput.type = "text";
            unitInput.name = "recipeForm.ingredients[" + ingredientsIndex + "].unit";
            ingredientsDiv.appendChild(unitInput);

            ingredientsSection.appendChild(ingredientsDiv);

            ingredientsIndex++;
        }
    </script>
</body>
</html>
