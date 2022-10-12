package by.application.javaWeb.servlet.AddDelUpEditProduct;

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


@WebServlet(name = "EditProductInCatalog", urlPatterns = "/EditProductInCatalog")
public class EditProductInCatalog extends HttpServlet {
    //private static final long serialVersionUID = 1L;
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
        System.out.println(productService.findProductById(Integer.parseInt(id)));
        productService.findProductById(Integer.parseInt(id));
        request.getSession().setAttribute("id", id);
        request.getSession().setAttribute("nameprod", nameprod);
        request.getSession().setAttribute("price", price);
        request.getSession().setAttribute("manufacturer", manufacturer);
        request.getSession().setAttribute("releaseDate", releaseDate);
        request.getSession().setAttribute("group", productList);
        getServletContext().getRequestDispatcher("/WEB-INF/views/catalogEditForAdmin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String idPost = request.getParameter("id");
            int id2 = Integer.parseInt(idPost);
            String nameprod = request.getParameter("nameprod");
            String price = request.getParameter("price");
            String manufacturer = request.getParameter("manufacturer");
            String releaseDate = request.getParameter("releaseDate");
            String photo = request.getParameter("photo");
            byte[] ph = "photo".getBytes(StandardCharsets.UTF_8);

            Product product = new Product(nameprod, price, manufacturer, releaseDate, ph);

            System.out.println("");

            if (("".equals(nameprod)) || ("".equals(price)) || ("".equals(manufacturer))
                    || "".equals(releaseDate)) {
                request.setAttribute("errorMessage", "Fill in all the fields");
                request.getRequestDispatcher("/WEB-INF/views/catalogEditForAdmin.jsp").forward(request, response);
            } else {
                boolean isUnique = false;
                for (Product p : productList) {
                    if (id2 == p.getId()) {
                        System.out.println(" ");
                        System.out.format("%10s%20s%20s%20s%20s", p.getId() + " |", p.getNameprod() +
                                        " |", p.getPrice() + " |", p.getManufacturer() + " |",
                                p.getReleaseDate());
                        System.out.println(" ");

                        isUnique = true;
                    }
                }
                if (isUnique == true) {
                    productService.updateProduct(product);
                    System.out.println("---Product is update---");
                    request.getSession().setAttribute("nameprod", nameprod);
                    request.getSession().setAttribute("price", price);
                    request.getSession().setAttribute("manufacturer", manufacturer);
                    request.getSession().setAttribute("releaseDate", releaseDate);
                    //List<Person> personList = personService.showPeople();
                    //request.setAttribute("group", productService);
                    request.getSession().setAttribute("group", productService);
                    request.getRequestDispatcher("/WEB-INF/views/catalogEditForAdmin.jsp").forward(request, response);
                } else {
                    request.setAttribute("errorMessage", "NOt update !!");
                    request.getRequestDispatcher("/WEB-INF/views/catalogEditForAdmin.jsp").forward(request, response);
                }
              //  request.getRequestDispatcher("/WEB-INF/views/catalogEditForAdmin.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            System.out.println("Catch of update");
            System.out.println(ex);
            request.getRequestDispatcher("/WEB-INF/views/catalogEditForAdmin.jsp").forward(request, response);
        }
    }
}