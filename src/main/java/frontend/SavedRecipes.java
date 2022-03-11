package frontend;

import backend.dao.IngredientDAO;
import backend.dao.RecipeDAO;
import backend.dao.RecipeIngredientDAO;
import backend.model.Recipe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(value = "/search")

public class SavedRecipes extends HttpServlet {
    RecipeDAO recipeDAO =new RecipeDAO();
    RecipeIngredientDAO recipeIngredientDAO = new RecipeIngredientDAO();
    IngredientDAO ingredientDAO=new IngredientDAO();


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out =response.getWriter();
        String name =request.getParameter("saved recipes");
        Recipe recipe_input=recipeDAO.getRecipeByName(name);


        if (recipe_input==null){
            //request.setAttribute("name","No recipe found by that name: "+name);
            request.setAttribute("status","No recipe found by that name:"+name);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/404.jsp");
            view.forward(request,response);
        } else{
            request.setAttribute("name",recipe_input.getName());
            request.setAttribute("instructions",recipe_input.getInstructions());
            request.setAttribute("ing1","nada");
            request.setAttribute("ing2","nada");
            request.setAttribute("ing3","nada");
            RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/saved.jsp");
            view.forward(request,response);
        }
    }
}
