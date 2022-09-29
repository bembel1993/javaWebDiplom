package by.application.javaWeb.servlet.catalog;

import by.application.javaWeb.model.ListService;
import by.application.javaWeb.model.Person;
import by.application.javaWeb.model.Product;
import by.application.javaWeb.model.User;
import by.application.javaWeb.service.PersonService;
import by.application.javaWeb.service.ProductService;
import by.application.javaWeb.service.serviceImpl.PersonServiceImpl;
import by.application.javaWeb.service.serviceImpl.ProductServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddProductInCatalog", urlPatterns = "/AddProductInCatalog")
public class AddProductInCatalog extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    ProductService productService = new ProductServiceImpl();
    private ListService todoService = new ListService();

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
        //request.setAttribute("productList", productList);
        System.out.println("");
        System.out.println(productList);

        request.getSession().setAttribute("group", productList);
        request.getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameprod = request.getParameter("nameprod");
        String price = request.getParameter("price");
        String manufacturer = request.getParameter("manufacturer");
        String releaseDate = request.getParameter("releaseDate");
        String delete = request.getParameter("delete");
        String photo = request.getParameter("photo");
        byte[] ph = "photo".getBytes(StandardCharsets.UTF_8);

        Product product = new Product(nameprod, price, manufacturer, releaseDate, ph);
        List<Product> productList = productService.showProduct();
        if (("".equals(nameprod)) || ("".equals(price)) || ("".equals(manufacturer))
                || "".equals(releaseDate)) {
            request.setAttribute("errorMessage", "Fill in all the fields");
        } else {
            productService.addProduct(product);
            System.out.format("%10s%20s%20s%20s%20s", "ID |", "Name Prod |", "Price |", "Manufacturer |", "Release Date ");
            for (Product p : productList) {
                System.out.println(" ");
                System.out.format("%10s%20s%20s%20s%20s", p.getId() + " |", p.getNameprod() +
                                " |", p.getPrice() + " |", p.getManufacturer() + " |",
                        p.getReleaseDate());
            }
            ListService.addProduct(new Product(nameprod, price, manufacturer, releaseDate, ph));
            request.getSession().setAttribute("group", productList);
            request.getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
        }
        if (request.getParameter("delete") != null) {
            int id2 = Integer.parseInt(request.getParameter("id"));
            product.setId(id2);
            productService.deleteProduct(id2);
            request.getSession().setAttribute("group", productList);
            request.getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);

        }

    }

}
