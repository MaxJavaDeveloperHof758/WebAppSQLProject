import mysql.business.Product;
import mysql.business.ProductDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
    }
        protected void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
        try{
            String name=request.getParameter("name");
            int price= Integer.parseInt(request.getParameter("price"));
            Product product=new Product(name,price);
            ProductDB.insert(product);
            response.sendRedirect(request.getContextPath()+"/index");
        }catch (Exception ex){
            getServletContext().getRequestDispatcher("/create.jsp").forward(request,response);
        }
    }
}
