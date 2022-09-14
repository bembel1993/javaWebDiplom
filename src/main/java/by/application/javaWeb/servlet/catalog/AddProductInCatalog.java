package by.application.javaWeb.servlet.catalog;

import by.application.javaWeb.model.ListService;
import by.application.javaWeb.model.Person;
import by.application.javaWeb.model.Product;
import by.application.javaWeb.model.User;
import by.application.javaWeb.service.PersonService;
import by.application.javaWeb.service.ProductService;
import by.application.javaWeb.service.serviceImpl.PersonServiceImpl;
import by.application.javaWeb.service.serviceImpl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AddProductInCatalog", urlPatterns = "/AddProductInCatalog")
public class AddProductInCatalog extends HttpServlet {
    ProductService productService = new ProductServiceImpl();
    private ListService todoService = new ListService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.showProduct();
        System.out.println("");
        System.out.format("%10s%20s%20s%20s%20s", "ID |", "Name Prod |", "Price |", "Manufacturer |", "Release Date ");
        for (Product p : productList) {
            System.out.println(" ");
            System.out.format("%10s%20s%20s%20s%20s", p.getId() + " |", p.getNameprod() +
                            " |", p.getPrice() + " |", p.getManufacturer() + " |",
                    p.getReleaseDate());
        }
        request.setAttribute("group", ListService.retrieveList());
        request.getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String nameprod = request.getParameter("nameprod");
        String price = request.getParameter("price");
        String manufacturer = request.getParameter("manufacturer");
        String releaseDate = request.getParameter("releaseDate");
        Product product = new Product(nameprod, price, manufacturer, releaseDate);
        List<Product> productList = productService.showProduct();
        if (("".equals(nameprod)) || ("".equals(price)) || ("".equals(manufacturer))
                || "".equals(releaseDate)) {
            request.setAttribute("errorMessage", "Fill in all the fields");
        } else {
            productService.addProduct(product);
            ListService.addPerson(new Product(nameprod, price, manufacturer, releaseDate));
            System.out.format("%10s%20s%20s%20s%20s", "ID |", "Name Prod |", "Price |", "Manufacturer |", "Release Date ");
            for (Product p : productList) {
                System.out.println(" ");
                System.out.format("%10s%20s%20s%20s%20s", p.getId() + " |", p.getNameprod() +
                                " |", p.getPrice() + " |", p.getManufacturer() + " |",
                        p.getReleaseDate());
            }
        }
        request.getSession().setAttribute("group", productList);
        request.getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);

    }
}
