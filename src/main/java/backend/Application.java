package backend;

import backend.dao.RecipeDAO;
import backend.dao.RecipeIngredientDAO;
import backend.model.Ingredient;
import backend.model.Recipe;
import backend.model.RecipeIngredient;
import backend.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Application {

    public static void main(String[] args) throws IOException {
        Session session = HibernateUtil.getSession();
/*
        RecipeIngredientDAO recipeIngredientDAO=new RecipeIngredientDAO();

        Recipe recipe_input=new Recipe( "Coffee", "make it");
        recipe_input.setId(2);

        List<Ingredient> recipeIngredientList;
        Query query=session.createQuery("SELECT i.name FROM RecipeIngredient ri INNER JOIN Ingredient i ON i.id=ri.ingredient WHERE ri.recipe=:id");
        query.setParameter("id",recipe_input);

        recipeIngredientList=query.list();
        System.out.println(recipeIngredientList.get(1)+". "+recipeIngredientList.get(2));

*/

//
//
//
//        Query query =session.createSQLQuery("select r.name, r.instructions, i.name,ri.quantity  from recipe r\n" +
//                "INNER join recipe_ingredients ri \n" +
//                "on r.id =ri.recipe_id \n" +
//                "INNER join ingredients i \n" +
//                "on i.id =ri.ingredient_id \n" +
//                "where r.id =:id");
//
//      Query query=session.createQuery("FROM RecipeIngredient WHERE recipe_ingredient_id=:id");
//        query.setParameter("id",recipe_input);
//
//
//        recipeIngredientList=query.getResultList();
//
//
    }


}
