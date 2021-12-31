package manager.food.food_manager.controller;

import manager.food.food_manager.entity.Food;
import manager.food.food_manager.model.Foodmodel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetDetailFoodServlet extends HttpServlet {
    private Foodmodel foodmodel = new Foodmodel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {
           int id = Integer.parseInt(req.getParameter("id"));
           Food food = foodmodel.findById(id);
           if (food == null) {
               resp.getWriter().println("Food is not found");
           } else {
               req.setAttribute("food", food);
               req.getRequestDispatcher("/admin/food/detail.jsp").forward(req, resp);
           }
       }catch (Exception ex){
           ex.printStackTrace();
           resp.getWriter().println("Bad request");
       }
    }
}
