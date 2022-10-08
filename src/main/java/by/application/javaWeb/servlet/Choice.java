package by.application.javaWeb.servlet;

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

@WebServlet(name = "Choice", urlPatterns = "/Choice")
public class Choice extends HttpServlet {
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
        System.out.println("");
        System.out.println("Choice - doGet");
        request.setAttribute("nameprod", nameprod);
        request.setAttribute("photo", photo);
        getServletContext().getRequestDispatcher("/WEB-INF/views/market.jsp").forward(request, response);
        //request.getRequestDispatcher("/WEB-INF/views/market.jsp").forward(request, response);
    }

}
