package de.hybris.myshoestore.core.Recipe;


import de.hybris.myshoestore.core.Ingredients.IngredientsForm;
import de.hybris.platform.validation.annotations.NotBlank;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;

public class RecipeForm{
    private String code;
    @NotBlank(message = "Title is required")
    @Length(max = 50, message = "Title must be less than or equal to 50 characters")
    private String title;
    private String description;
    private Boolean isComplicated;
        private List<IngredientsForm> ingredients;

    public List<IngredientsForm> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsForm> ingredients) {
        this.ingredients = ingredients;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getComplicated() {
        return isComplicated;
    }

    public void setComplicated(Boolean complicated) {
        isComplicated = complicated;
    }
}