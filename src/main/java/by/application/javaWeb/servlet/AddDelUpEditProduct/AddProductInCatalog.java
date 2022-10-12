package by.application.javaWeb.servlet.AddDelUpEditProduct;

import by.application.javaWeb.model.person.ListService;
import by.application.javaWeb.model.product.Product;
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

@WebServlet(name = "AddProductInCatalog", urlPatterns = "/AddProductInCatalog")
public class AddProductInCatalog extends HttpServlet {
    //private static final long serialVersionUID = 1L;
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
        System.out.println("AddProductInCatalog - doGet");
        request.getSession().setAttribute("group", productList);
        getServletContext().getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        String id = request.getParameter("id");

        String nameprod = request.getParameter("nameprod");
        String price = request.getParameter("price");
        String manufacturer = request.getParameter("manufacturer");
        String releaseDate = request.getParameter("releaseDate");
        String photo = request.getParameter("photo");
        byte[] ph = "photo".getBytes(StandardCharsets.UTF_8);

        Product product = new Product(nameprod, price, manufacturer, releaseDate, ph);
        List<Product> productList = productService.showProduct();

        if (("".equals(nameprod)) || ("".equals(price)) || ("".equals(manufacturer))
                || "".equals(releaseDate)) {
            request.setAttribute("errorMessage", "Fill in all the fields");
            request.getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
        } else {
            try {
                //productService.addProduct(product);
                System.out.format("%10s%20s%20s%20s%20s", "ID |", "Name Prod |", "Price |", "Manufacturer |", "Release Date ");
                for (Product p : productList) {
                    System.out.println(" ");
                    System.out.format("%10s%20s%20s%20s%20s", p.getId() + " |", p.getNameprod() +
                                    " |", p.getPrice() + " |", p.getManufacturer() + " |",
                            p.getReleaseDate());
                }
                ListService.addProduct(new Product(nameprod, price, manufacturer, releaseDate, ph));
                request.getSession().setAttribute("group", productList);
                if (productService.addProduct(product)) {
                    request.setAttribute("productIsAdd", "Product is Add in Catalog");
                    System.out.println("AddProductInCatalog - doPost (doGet(request, response))");
                    //метод doPost переопределяет после добавления значений на метод doGet
                    doGet(request, response);
                }
                // getServletContext().getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
            } catch (Exception ex) {
                System.out.println("");
                System.out.println("catch-Error Insert");
                getServletContext().getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
            }
        }
    }
}
