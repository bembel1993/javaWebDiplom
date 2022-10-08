package by.application.javaWeb.servlet.AddDelUpEditProduct;

import by.application.javaWeb.model.Product;
import by.application.javaWeb.service.ProductService;
import by.application.javaWeb.service.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "SearchProduct", urlPatterns = "/SearchProduct")
public class SearchProduct extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    List<Product> productList = productService.showProduct();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String nameprod = request.getParameter("nameprod");
        String price = request.getParameter("price");
        String manufacturer = request.getParameter("manufacturer");
        String releaseDate = request.getParameter("releaseDate");
        String photo = request.getParameter("photo");

        byte[] ph = "photo".getBytes(StandardCharsets.UTF_8);
        Product prod = new Product(nameprod, price, manufacturer, releaseDate, ph);
        System.out.println("");
        System.out.println("Find chose product");
        System.out.println(productService.findProductName(nameprod));
        productService.findProductName(nameprod);
        request.getSession().setAttribute("id", id);
        request.getSession().setAttribute("nameprod", nameprod);
        request.getSession().setAttribute("price", price);
        request.getSession().setAttribute("manufacturer", manufacturer);
        request.getSession().setAttribute("releaseDate", releaseDate);
        request.getSession().setAttribute("group", productList);
        getServletContext().getRequestDispatcher("/WEB-INF/views/searchProduct.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            List<Product> productList = productService.showProduct();
            String nameprod = request.getParameter("nameprod");
            productService.findProductName(nameprod);
            System.out.println(" ");
            System.out.println(productList);
            request.setAttribute("nameprod", nameprod);
            //  request.getRequestDispatcher("/WEB-INF/views/catalogEditForAdmin.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("");
            System.out.println("Catch search");
            System.out.println(ex);
            request.getRequestDispatcher("/WEB-INF/views/searchProduct.jsp").forward(request, response);
        }
    }
}

