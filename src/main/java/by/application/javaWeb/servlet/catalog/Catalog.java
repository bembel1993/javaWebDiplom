package by.application.javaWeb.servlet.catalog;

import by.application.javaWeb.model.ListService;
import by.application.javaWeb.model.Person;
import by.application.javaWeb.model.Product;
import by.application.javaWeb.service.ProductService;
import by.application.javaWeb.service.serviceImpl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Catalog", urlPatterns = "/Catalog")
public class Catalog extends HttpServlet {
    private ListService todoService = new ListService();
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.showProduct();
        System.out.println("");
        System.out.format("%10s%20s%20s%20s%20s", "ID |", "Name Prod |", "Price |", "Manufacturer |", "Release Date ");
        for (Product product : productList) {
            System.out.println(" ");
            System.out.format("%10s%20s%20s%20s%20s", product.getId() + " |", product.getNameprod() +
                            " |", product.getPrice() + " |", product.getManufacturer() + " |",
                    product.getReleaseDate());
        }
        System.out.println("");
        System.out.println(productList);
        request.setAttribute("group", productList);
        // request.setAttribute("group", productArrayList);
        //  request.setAttribute("group", ListService.retrieveList());
        request.getRequestDispatcher("/WEB-INF/views/catalog.jsp").forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.showProduct();
        System.out.println("");
        System.out.format("%10s%20s%20s%20s%20s", "ID |", "Name Prod |", "Price |", "Manufacturer |", "Release Date ");
        for (Product product : productList) {
            System.out.println(" ");
            System.out.format("%10s%20s%20s%20s%20s", product.getId() + " |", product.getNameprod() +
                            " |", product.getPrice() + " |", product.getManufacturer() + " |",
                    product.getReleaseDate());

        }
        System.out.println(" ");
        System.out.println(productList);
        request.setAttribute("group", productList);
        //  request.setAttribute("group", ListService.retrieveList());
        request.getRequestDispatcher("/WEB-INF/views/catalog.jsp").forward(request, response);
    }
}