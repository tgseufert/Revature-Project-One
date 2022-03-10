package frontend;

import backend.dao.RecipeDAO;
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

        PrintWriter out =response.getWriter();
        String name =request.getParameter("deletion recipe");
        if (recipeDAO.recipeExists(name)){
        Recipe recipe_input=recipeDAO.getRecipeByName(name);
        request.setAttribute("status",recipe_input.getName()+" was removed.");
        out.println(recipe_input.getName()+" was removed.");
        recipeDAO.deleteRecipe(recipe_input);
        } else{
            request.setAttribute("status","There was an issue deleting that recipe.");
        }

        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/deleted.jsp");
        view.forward(request,response);
    }
}

