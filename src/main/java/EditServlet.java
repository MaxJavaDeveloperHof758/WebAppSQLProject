import mysql.business.Product;
import mysql.business.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try{
            int id= Integer.parseInt(request.getParameter("id"));
            Product product= ProductDB.selectOne(id);
            if(product!=null){
                request.setAttribute("product",product);
                getServletContext().getRequestDispatcher("/edit.jsp").forward(request,response);
            }else {
                getServletContext().getRequestDispatcher("/notfound.jsp").forward(request,response);
            }
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request,response);
        }
    }
    protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        try{
            int id= Integer.parseInt(request.getParameter("id"));
            String name=request.getParameter("name");
            int price= Integer.parseInt(request.getParameter("price"));
            Product product=new Product(id,name,price);
            ProductDB.update(product);
            response.sendRedirect(request.getContextPath()+"/index");
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/notfound.jsp").forward(request,response);
        }
    }
}
