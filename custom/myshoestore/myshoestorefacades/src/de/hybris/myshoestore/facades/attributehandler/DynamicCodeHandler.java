package de.hybris.myshoestore.facades.attributehandler;

import de.hybris.myshoestore.core.model.RecipeModel;
import de.hybris.platform.servicelayer.model.attribute.DynamicAttributeHandler;

public class DynamicCodeHandler implements DynamicAttributeHandler<String, RecipeModel> {

        private static int nextCodeNumber = 0;

        @Override
        public String get(RecipeModel recipe) {
            if (recipe.getCode() == null) {
                String sequentialNumber = String.format("%04d", nextCodeNumber++);
                return "recipe-" + sequentialNumber;
            }
            return recipe.getCode();
        }

        @Override
        public void set(RecipeModel recipe, String value) {
            recipe.setCode(value);
        }
    }
