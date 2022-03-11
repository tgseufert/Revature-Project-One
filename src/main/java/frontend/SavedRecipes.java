package frontend;

import backend.dao.IngredientDAO;
import backend.dao.RecipeDAO;
import backend.dao.RecipeIngredientDAO;
import backend.model.Recipe;
import backend.model.RecipeIngredient;
import backend.model.Ingredient;
import backend.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/search")

public class SavedRecipes extends HttpServlet {
    RecipeDAO recipeDAO =new RecipeDAO();
    RecipeIngredientDAO recipeIngredientDAO = new RecipeIngredientDAO();
    IngredientDAO ingredientDAO=new IngredientDAO();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out =response.getWriter();
        String name =request.getParameter("saved recipes");
        Recipe recipe_input=recipeDAO.getRecipeByName(name);

        Session session = HibernateUtil.getSession();
        List<String> recipeIngredientList;
        Query query=session.createQuery("SELECT ri.quantity FROM RecipeIngredient ri INNER JOIN Ingredient i ON i.id=ri.recipe WHERE ri.recipe=:id");
        query.setParameter("id",recipe_input);
        recipeIngredientList=query.list();
        List<Ingredient> IngredientList;
        Query query2=session.createQuery("SELECT ri.ingredient FROM RecipeIngredient ri INNER JOIN Ingredient i ON i.id=ri.ingredient WHERE ri.recipe=:id");
        query2.setParameter("id",recipe_input);
        IngredientList=query2.list();
        //System.out.println(recipeIngredientList.get(1)+". ");



        if (recipe_input==null){
            //request.setAttribute("name","No recipe found by that name: "+name);
            request.setAttribute("status","No recipe found by that name:"+name);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/404.jsp");
            view.forward(request,response);
        } else{
            request.setAttribute("name",recipe_input.getName());
            request.setAttribute("instructions",recipe_input.getInstructions());
            request.setAttribute("ing1",IngredientList.get(0).getName()+":   " +recipeIngredientList.get(0));
            request.setAttribute("ing2",IngredientList.get(1).getName()+":   " +recipeIngredientList.get(1));
            request.setAttribute("ing3",IngredientList.get(2).getName()+":   "+recipeIngredientList.get(2));
            RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/saved.jsp");
            view.forward(request,response);
        }
    }
}
