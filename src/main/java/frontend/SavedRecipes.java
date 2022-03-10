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

@WebServlet(value = "/search")

public class SavedRecipes extends HttpServlet {
    RecipeDAO recipeDAO =new RecipeDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        PrintWriter out =response.getWriter();
        String name =request.getParameter("saved recipes");
        Recipe recipe_input=recipeDAO.getRecipeByName(name);
        request.setAttribute("name",recipe_input.getName());
        request.setAttribute("instructions",recipe_input.getInstructions());
        if (recipe_input==null){
            out.println("no recipe found:"+name);
        } else{
            RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/saved.jsp");
            view.forward(request,response);
        //out.println(recipe_input.getName()+":\n"+recipe_input.getInstructions());
        }
    }
}
