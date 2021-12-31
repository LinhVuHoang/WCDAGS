package manager.food.food_manager.controller;

import manager.food.food_manager.entity.Food;
import manager.food.food_manager.model.Foodmodel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class DeleteFoodServlet  extends HttpServlet {
    private Foodmodel foodmodel= new Foodmodel();

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int id = Integer.parseInt(req.getParameter("id"));
            Food food = foodmodel.findById(id);
            if(food==null){
                resp.getWriter().println("Food is not found");
            }else {
                int status = -1;
                food.setStatus(status);
                foodmodel.update(id,food);
                resp.getWriter().println("OKIE!");
            }
        }catch (Exception e){
            e.printStackTrace();
            resp.getWriter().println("Bad request");
        }
    }
}
