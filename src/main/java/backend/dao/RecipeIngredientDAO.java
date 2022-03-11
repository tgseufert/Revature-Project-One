package backend.dao;


import backend.model.Ingredient;
import backend.model.Recipe;
import backend.model.RecipeIngredient;
import backend.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class RecipeIngredientDAO {

    public void addLink(Recipe recipe, Ingredient ingredient,String quantity) throws IOException {
        RecipeIngredient recipeIngredient=new RecipeIngredient(recipe,ingredient, quantity);
        Session session= HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        session.persist(recipeIngredient);
        transaction.commit();
        System.out.println("added link between "+recipe +" & "+ingredient);

    }

    public void deleteLink(Recipe recipe) throws IOException {
        Session session = HibernateUtil.getSession();
        Transaction transaction=session.beginTransaction();
        Query query=session.createQuery("DElETE FROM RecipeIngredient WHERE recipe_id=:r_id");
        query.setParameter("r_id",recipe.getId());
        query.executeUpdate();
        transaction.commit();
        System.out.println("Deleted "+recipe.getName());


    }

    public void updateLink(Recipe recipe, Ingredient ingredient, String quantity) throws IOException {
            Session session = HibernateUtil.getSession();

            RecipeIngredient recipeIngredient=new RecipeIngredient(recipe,ingredient, quantity);
            Transaction transaction=session.beginTransaction();

            session.persist(recipeIngredient);
            transaction.commit();
            System.out.println("added link between "+recipe +" & "+ingredient);
    }


    public List<RecipeIngredient> getIngList(Recipe recipe) throws IOException {

        Session session = HibernateUtil.getSession();

        List<RecipeIngredient> recipeIngredientList;
        Query query =session.createQuery("FROM RecipeIngredient WHERE recipe=:id", RecipeIngredient.class);
        query.setParameter("id",recipe);
        recipeIngredientList=query.list();
        return recipeIngredientList;

    }
}
