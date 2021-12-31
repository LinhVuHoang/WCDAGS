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

public class CreateFoodServlet extends HttpServlet {
    private Foodmodel foodmodel = new Foodmodel();
    private Categorymodel categorymodel = new Categorymodel();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Category> listcategory = categorymodel.findAll();
        req.setAttribute("listcategory",listcategory);
        req.getRequestDispatcher("/admin/food/form.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try{
                req.setCharacterEncoding("UTF-8");
                String name =req.getParameter("name");
                String description = req.getParameter("description");
                String thumbnail = req.getParameter("thumbnail");
                double price = Double.parseDouble(req.getParameter("price"));
                String daysell = req.getParameter("daysell");
                String datefix = req.getParameter("datefix");
                int category_id = Integer.parseInt(req.getParameter("category_id"));
                int status = Integer.parseInt(req.getParameter("status"));
                Food f = new Food(name,description,thumbnail,price,daysell,datefix,category_id,status);
                if(!f.isValid()){
                    //nếu có lỗi phải trả lại giao diện và giá trị nhập vào
                    req.setAttribute("food",f);
                    req.setAttribute("errors",f.getErrors());
                    req.getRequestDispatcher("/admin/food/form.jsp").forward(req,resp);
                    return;
                }
                if(foodmodel.save(f)){
                    resp.getWriter().println("Thêm mới thành công");
                    resp.sendRedirect("/admin/food/list");
                }
            }catch (Exception ex){
                resp.getWriter().println("Error");
            }
    }
}
