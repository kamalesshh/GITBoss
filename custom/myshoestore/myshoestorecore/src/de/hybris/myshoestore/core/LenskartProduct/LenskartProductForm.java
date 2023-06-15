package de.hybris.myshoestore.core.LenskartProduct;


import de.hybris.myshoestore.core.jalo.LenskartBrand;

import java.util.List;
import java.util.Set;

public class LenskartProductForm
{
    private String name;
    private Integer size;

    private String colour;


    public Set<LenskartBrand> getLenskartBrand() {
        return lenskartBrand;
    }

    public void setLenskartBrand(Set<LenskartBrand> lenskartBrand) {
        this.lenskartBrand = lenskartBrand;
    }

    private Set<LenskartBrand> lenskartBrand;


    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }


}
