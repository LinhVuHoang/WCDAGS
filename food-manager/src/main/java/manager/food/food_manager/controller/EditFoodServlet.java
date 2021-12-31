package manager.food.food_manager.controller;

import manager.food.food_manager.entity.Food;
import manager.food.food_manager.model.Foodmodel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class EditFoodServlet extends HttpServlet {
    private Foodmodel foodmodel= new Foodmodel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(req.getParameter("id"));
            Food food = foodmodel.findById(id);
            if (food == null) {
                resp.getWriter().println("Food is not found");
            } else {
                req.setAttribute("food", food);
                req.getRequestDispatcher("/admin/food/edit.jsp").forward(req, resp);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            resp.getWriter().println("Bad request");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       try {

           req.setCharacterEncoding("UTF-8");
           int id = Integer.parseInt(req.getParameter("id"));
           Food food = foodmodel.findById(id);
           if (food == null) {
               resp.getWriter().println("Food is not found or has been deleted");
           } else {
               String name = req.getParameter("name");
               String description = req.getParameter("description");
               String thumbnail = req.getParameter("thumbnail");
               double price = Double.parseDouble(req.getParameter("price"));
               String daysell = req.getParameter("daysell");
               String datefix = req.getParameter("datefix");
               int category_id = Integer.parseInt(req.getParameter("category_id"));
               int status = Integer.parseInt(req.getParameter("status"));
               food.setName(name);
               food.setDescription(description);
               food.setThumbnail(thumbnail);
               food.setPrice(price);
               food.setDaysell(daysell);
               food.setDatefix(datefix);
               food.setCategory_id(category_id);
               food.setStatus(status);
               foodmodel.update(id, food);
               resp.sendRedirect("/admin/food/list");
           }
       }catch (Exception ex){
           resp.getWriter().println("Bad request");
       }
    }
}
