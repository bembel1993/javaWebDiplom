package by.application.javaWeb.servlet;

import by.application.javaWeb.model.product.Product;
import by.application.javaWeb.service.ProductService;
import by.application.javaWeb.service.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

@WebServlet(name = "WelcomeClassMenu", urlPatterns = "/WelcomeClassMenu")
public class WelcomeClassMenu extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameprod = request.getParameter("nameprod");
        String ph = request.getParameter("photo");
        byte[] photo = "ph".getBytes(StandardCharsets.UTF_8);
        List<Product> productList = productService.showProduct();

        for (Product p : productList) {
            System.out.println(p.getNameprod() + " " + p.getManufacturer());
            nameprod = p.getNameprod();
            photo = p.getPhoto();
        }
        request.setAttribute("nameprod", nameprod);
        request.setAttribute("photo", photo);
        getServletContext().getRequestDispatcher("/WEB-INF/views/market.jsp").forward(request, response);
    }

}
