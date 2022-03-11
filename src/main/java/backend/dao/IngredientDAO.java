package backend.dao;
import backend.model.Ingredient;
import backend.model.Recipe;
import backend.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.util.List;



public class IngredientDAO {
    public void addIngredient(Ingredient ingredient){
        try {
            Session session=HibernateUtil.getSession();
            if (getIngredientByName(ingredient.getName())==null){
                Transaction transaction=session.beginTransaction();
                session.persist(ingredient);
                transaction.commit();
                System.out.println("added "+ingredient.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Ingredient getIngredientByName(String name){
        try{
            Session session = HibernateUtil.getSession();
            Query query=session.createQuery("FROM Ingredient WHERE name=:name",Ingredient.class);
            query.setParameter("name", name);
            List<Ingredient> IngredientList=query.list();
            if (IngredientList.size() == 1) {
                return IngredientList.get(0);
            }else{
                return null;}
        }catch (HibernateException| IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public Ingredient getIngredientByID(int id) {
        try{
            Session session = HibernateUtil.getSession();
            Query query=session.createQuery("FROM Ingredient WHERE id=:r_id",Ingredient.class);
            query.setParameter("r_id", id);
            List<Ingredient> IngredientList=query.list();
            if (IngredientList.size() == 1) {
                return IngredientList.get(0);
            }else{
                return null;}
        }catch (HibernateException| IOException e){
            e.printStackTrace();
        }
        return null;
    }

    //for some reason, this returns the opposite bool that is expected. Therefore, use to find if something does not exist
    public boolean ingredientNotExists(String name){
        try{
            Session session = HibernateUtil.getSession();
            Query query=session.createQuery("FROM Ingredient WHERE name=:name", Ingredient.class);
            query.setParameter("name", name);
            List<Ingredient> ingredientList=query.list();
            if (ingredientList.size() == 1) {
                System.out.println("ingredient exists is new: "+name);
                return true;
            }else{
                return false;}
        }catch (HibernateException| IOException e){
            e.printStackTrace();
        }
        return false;
    }
}
