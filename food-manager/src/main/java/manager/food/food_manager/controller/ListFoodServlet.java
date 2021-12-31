package manager.food.food_manager.controller;

import manager.food.food_manager.entity.Category;
import manager.food.food_manager.entity.Food;
import manager.food.food_manager.model.Categorymodel;
import manager.food.food_manager.model.Foodmodel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class ListFoodServlet extends HttpServlet {
    private Foodmodel foodmodel = new Foodmodel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Food> listFood = foodmodel.findAll();
        req.setAttribute("list",listFood);
        req.getRequestDispatcher("/admin/food/list.jsp").forward(req,resp);
    }
}
