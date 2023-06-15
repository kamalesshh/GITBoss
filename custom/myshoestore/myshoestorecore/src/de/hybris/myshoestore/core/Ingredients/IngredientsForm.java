package de.hybris.myshoestore.core.Ingredients;

import de.hybris.myshoestore.core.enums.Units;

public class IngredientsForm {
    private String name;
    private int quantity;
    private Units unit;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Units getUnit() {
        return unit;
    }

    public void setUnit(Units unit) {
        this.unit = unit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
