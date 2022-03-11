package frontend;

import backend.dao.IngredientDAO;
import backend.dao.RecipeDAO;
import backend.dao.RecipeIngredientDAO;
import backend.model.Ingredient;
import backend.model.Recipe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@WebServlet(value = "/create")
public class CreateRecipe extends HttpServlet {
//Class to create or update recipes.
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        RecipeDAO recipeDAO=new RecipeDAO();
        IngredientDAO ingredientDAO=new IngredientDAO();
        RecipeIngredientDAO recipeIngredientDAO=new RecipeIngredientDAO();
       //String[] ingName=new String[3];
        //String[] quantity=new String[3];

        String status="";

        PrintWriter out = response.getWriter();
        String name =request.getParameter("recipe name");
        String ingName0=request.getParameter("ingredient0");
        String ingName1 =request.getParameter("ingredient1");
        String  ingName2 =request.getParameter("ingredient2");
        String quantity0= request.getParameter("quantity0");
        String quantity1= request.getParameter("quantity1");
        String quantity2= request.getParameter("quantity2");
        String instructions =request.getParameter("add recipe");

        request.setAttribute("name",name);
       // request.setAttribute("ingredients",ingName);

        Recipe inputRecipe = new Recipe();
        inputRecipe.setName(name);
        inputRecipe.setInstructions(instructions);

        Ingredient ingredient0 = new Ingredient(ingName0);
        Ingredient ingredient1 = new Ingredient(ingName1);
        Ingredient ingredient2 = new Ingredient(ingName2);

        ingredientDAO.addIngredient(ingredient0);
        ingredientDAO.addIngredient(ingredient1);
        ingredientDAO.addIngredient(ingredient2);
//              Ingredient[] ingredients=new Ingredient[3];
//        for (int i=0;i<3;i++){
//            ingredients[i]=new Ingredient(ingName[i]);
//                ingredientDAO.addIngredient(ingredients[i]);
//            System.out.println(ingredients[i]);
//        }



        //check if the recipe exists, and update or adds it as applicable
        if(recipeDAO.recipeExists(name)){
            recipeDAO.updateRecipe(name,instructions);
            status="updated";
//            recipeIngredientDAO.deleteLink(inputRecipe);
//            recipeIngredientDAO.addLink(inputRecipe,ingredients[0],quantity[0]);
//            recipeIngredientDAO.addLink(inputRecipe,ingredients[1],quantity[1]);
//            recipeIngredientDAO.addLink(inputRecipe,ingredients[2],quantity[2]);

        }else{
            recipeDAO.addRecipe(inputRecipe);
            status="added";
            recipeIngredientDAO.addLink(inputRecipe,ingredient0,quantity0);
            recipeIngredientDAO.addLink(inputRecipe,ingredient1,quantity1);
            recipeIngredientDAO.addLink(inputRecipe,ingredient2,quantity2);


        }

        //status for create.jsp page to use
        request.setAttribute("status",status);


        //debug code, useful for if create.jsp fails to load
       /*
       String ingQuaList=null;
        for (int i=0;i<3;i++){
            ingQuaList = ingQuaList+ ingName[i]+" "+quantity[i]+" ";
        }
        out.println(name+"\n"+ingQuaList+"\n"+instructions);
        */

        //requests the create.jsp page if it can
      if (name==null){
        out.println("no recipe added");
    } else{
        RequestDispatcher view =request.getRequestDispatcher("/WEB-INF/create.jsp");
        view.forward(request,response);
    }
    }
}
