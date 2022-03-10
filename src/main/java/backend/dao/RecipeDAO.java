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
                session.save(r);
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


//
//        public List<Recipe> list() throws SQLException {
//            List<Recipe> recipeList = new ArrayList<>();
//
//            try (Connection connection=ConnectionUtil.getConnection()){
//                String sql = "SELECT * FROM recipe ORDER BY name";
//                Statement statement = connection.createStatement();
//                ResultSet result = statement.executeQuery(sql);
//
//                while (result.next()) {
//                    int id = result.getInt("id");
//                    String name = result.getString("name");
//                    String instructions =result.getString("instructions");
//                    Recipe recipe = new Recipe(id, name,instructions);
//
//                    recipeList.add(recipe);
//                }
//
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//                throw ex;
//            }
//
//            return recipeList;
//        }
//    }
}


