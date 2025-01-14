import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/products")
public class ProductsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html");
        PrintWriter writer=response.getWriter();
        try {
            String url="jdbc:mysql://localhost:3306/productdb";
            String username="root";
            String password="Maks99hof758_";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try(Connection conn= DriverManager.getConnection(url,username,password)){
                writer.println("Connection to ProductDB is successful!");
            }
        }catch (Exception ex){
            writer.println("Connection failed...");
            writer.println(ex);
        }finally {
            writer.close();
        }
    }
}
