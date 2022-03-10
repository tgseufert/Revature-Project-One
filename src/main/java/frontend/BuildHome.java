package frontend;

import backend.dao.IngredientDAO;
import backend.dao.RecipeDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/home")

public class BuildHome extends HttpServlet {
    RecipeDAO recipeDAO = new RecipeDAO();
    IngredientDAO ingredientDAO = new IngredientDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/home.jsp");
            view.forward(request,response);
    }
}
