package frontend;

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

@WebServlet(value = "/delete")
public class DeleteRecipe extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RecipeDAO recipeDAO =new RecipeDAO();
        RecipeIngredientDAO recipeIngredientDAO =new RecipeIngredientDAO();

        PrintWriter out =response.getWriter();
        String name =request.getParameter("deletion recipe");
        Recipe recipe_input=recipeDAO.getRecipeByName(name);
        if (recipeDAO.recipeExists(name)){
            request.setAttribute("status",recipe_input.getName()+" was removed.");
            recipeIngredientDAO.deleteLink(recipe_input);
            recipeDAO.deleteRecipe(recipe_input);
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/deleted.jsp");
            view.forward(request,response);
        } else{
            request.setAttribute("status","There was an issue deleting that recipe.");
            RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/404.jsp");
            view.forward(request,response);
        }


    }
}

