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
import java.util.Scanner;


@WebServlet(name = "UpdateProductInCatalog", urlPatterns = "/UpdateProductInCatalog")
public class UpdateProductInCatalog extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    ProductService productService = new ProductServiceImpl();
    Scanner in = new Scanner(System.in);

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

        List<Product> productList = productService.showProduct();
        System.out.println("");
        System.out.format("%10s%20s%20s%20s%20s", "ID |", "Name Prod |", "Price |", "Manufacturer |", "Release Date ");
        for (Product product : productList) {
            System.out.println(" ");
            System.out.format("%10s%20s%20s%20s%20s", product.getId() + " |", product.getNameprod() +
                            " |", product.getPrice() + " |", product.getManufacturer() + " |",
                    product.getReleaseDate());

        }
        productService.updateProduct(prod);
        System.out.println("---Delete is performed!---");
        request.getSession().setAttribute("group", productList);
        request.getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productService.showProduct();
        System.out.format("%10s%20s%20s%20s%20s", "ID |", "Name Prod |", "Price |", "Manufacturer |", "Release Date ");
        for (Product p : productList) {
            System.out.println(" ");
            System.out.format("%10s%20s%20s%20s%20s", p.getId() + " |", p.getNameprod() +
                            " |", p.getPrice() + " |", p.getManufacturer() + " |",
                    p.getReleaseDate());
        }
        request.getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
    }
}