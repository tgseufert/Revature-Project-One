package backend;

import backend.dao.RecipeDAO;
import backend.model.Ingredient;
import backend.model.Recipe;
import backend.model.RecipeIngredient;
import backend.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        Session session = HibernateUtil.getSession();
    }


}
