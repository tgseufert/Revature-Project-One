package backend.dao;

import backend.model.Recipe;
import backend.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class RecipeDAO {

    public void addRecipe(Recipe r){
        try {
            Session session=HibernateUtil.getSession();
            if (getRecipeByID(r.getId())==null){
                Transaction transaction=session.beginTransaction();
                session.persist(r);
                transaction.commit();
                System.out.println("added"+r.getName());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean recipeExists(String name){
        try{
            Session session = HibernateUtil.getSession();
            Query query=session.createQuery("FROM Recipe WHERE name=:name",Recipe.class);
            query.setParameter("name", name);
            List<Recipe> recipeList=query.list();
            if (recipeList.size() == 1) {
                return true;
            }else{
                return false;}
        }catch (HibernateException| IOException e){
            e.printStackTrace();
        }
        return false;
    }

    public void updateRecipe(String name, String instructions) throws IOException {
        Session session=HibernateUtil.getSession();
        Transaction transaction= session.beginTransaction();
        Recipe recipe =session.load(Recipe.class,getRecipeByName(name).getId());
        recipe.setInstructions(instructions);
        session.update(recipe);
        transaction.commit();
        System.out.println("updated"+name);
    }

    public Recipe getRecipeByName(String name){
        try{
            Session session = HibernateUtil.getSession();
            Query query=session.createQuery("FROM Recipe WHERE name=:name",Recipe.class);
            query.setParameter("name", name);
            List<Recipe> recipeList=query.list();
            if (recipeList.size() == 1) {
                 return recipeList.get(0);
                }else{
                    return null;}
            }catch (HibernateException| IOException e){
            e.printStackTrace();
         }
        return null;
        }

    public Recipe getRecipeByID(int id) {
        try{
            Session session = HibernateUtil.getSession();
            Query query=session.createQuery("FROM Recipe WHERE id=:r_id",Recipe.class);
            query.setParameter("r_id", id);
            List<Recipe> recipeList=query.list();
            if (recipeList.size() == 1) {
                return recipeList.get(0);
            }else{
                return null;}
        }catch (HibernateException| IOException e){
            e.printStackTrace();
        }
        return null;
    }

    public void deleteRecipe(Recipe recipe) throws IOException {
        Session session=HibernateUtil.getSession();
        Transaction transaction= session.beginTransaction();
        session.remove(recipe);
        transaction.commit();
//this doesn't work yet, fix it!
    }


}


