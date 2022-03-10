package backend;

import backend.dao.RecipeDAO;
import backend.util.HibernateUtil;
import org.hibernate.Hibernate;
import org.hibernate.Session;

import java.io.IOException;

public class Application {

    public static void main(String[] args) throws IOException {
        Session session = HibernateUtil.getSession();

    }


}
