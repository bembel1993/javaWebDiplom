package by.application.javaWeb.servlet;

import by.application.javaWeb.model.product.Product;
import by.application.javaWeb.service.ProductService;
import by.application.javaWeb.service.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WelcomeClassMenuAdmin", urlPatterns = "/WelcomeClassMenuAdmin")
public class WelcomeClassMenuAdmin extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameprod = request.getParameter("nameprod");
        String manufacturer = request.getParameter("manufacturer");
        List<Product> productList = productService.showProduct();

        for (Product p : productList) {
            System.out.println(p.getNameprod() + " " + p.getManufacturer());
            nameprod = p.getNameprod();
            manufacturer = p.getManufacturer();
        }
        request.setAttribute("nameprod", nameprod);
        request.setAttribute("manufacturer", manufacturer);
        request.getRequestDispatcher("WEB-INF/views/marketAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/marketAdmin.jsp").forward(request, response);
    }
}
