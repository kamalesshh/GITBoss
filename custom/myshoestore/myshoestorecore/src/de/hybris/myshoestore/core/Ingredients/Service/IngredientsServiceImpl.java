package de.hybris.myshoestore.core.Ingredients.Service;

import de.hybris.myshoestore.core.Ingredients.DAO.IngredientsDAO;
import de.hybris.myshoestore.core.model.IngredientsModel;
import org.apache.log4j.Logger;

import java.util.List;

public class IngredientsServiceImpl implements IngredientsService {

    public IngredientsDAO getIngredientsDAO() {
        return ingredientsDAO;
    }

    public void setIngredientsDAO(IngredientsDAO ingredientsDAO) {
        this.ingredientsDAO = ingredientsDAO;
    }

    private IngredientsDAO ingredientsDAO;
    private static final Logger LOG =
            Logger.getLogger(de.hybris.myshoestore.core.Ingredients.Service.IngredientsServiceImpl.class);

    @Override
    public List<IngredientsModel> getAllIngredients()
    {
        LOG.info("###### IngredientsServiceImpl ######");
        return ingredientsDAO.getAllIngredients();
    }

}
