package by.application.javaWeb.servlet;

import by.application.javaWeb.model.Person;
import by.application.javaWeb.model.Product;
import by.application.javaWeb.service.PersonService;
import by.application.javaWeb.service.ProductService;
import by.application.javaWeb.service.serviceImpl.PersonServiceImpl;
import by.application.javaWeb.service.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "WelcomeClassMenu", urlPatterns = "/WelcomeClassMenu")
public class WelcomeClassMenu extends HttpServlet {
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
        request.getRequestDispatcher("WEB-INF/views/market.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameprod = request.getParameter("nameprod");
        String manufacturer = request.getParameter("manufacturer");
        List<Product> productList = productService.showProduct();
        request.setAttribute("nameprod", nameprod);
        request.setAttribute("manufacturer", manufacturer);
        request.getRequestDispatcher("/WEB-INF/views/market.jsp").forward(request, response);

    }
}
