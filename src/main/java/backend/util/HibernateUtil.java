package backend.util;

import backend.model.Recipe;
import backend.model.Ingredient;


import backend.model.RecipeIngredient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


import java.io.IOException;
import java.util.Properties;

public class HibernateUtil {

    private static SessionFactory sessionFactory;
    private static Session session;


    public static Session getSession() throws IOException {
        if(sessionFactory==null){
            Configuration config = new Configuration();
            Properties props = new Properties();
            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            props.load(loader.getResourceAsStream("hibernate.properties"));

            config.setProperties(props);
            config.addAnnotatedClass(Recipe.class);
            config.addAnnotatedClass(Ingredient.class);
            config.addAnnotatedClass(RecipeIngredient.class);
            ServiceRegistry serviceRegistry= new StandardServiceRegistryBuilder().applySettings(config.getProperties())
                    .build();

            sessionFactory =config.buildSessionFactory(serviceRegistry);
        }

        if(session==null){
            session = sessionFactory.openSession();
        }
        return session;
    }

    public static void closeSession() {
        session.close();
    }
}
