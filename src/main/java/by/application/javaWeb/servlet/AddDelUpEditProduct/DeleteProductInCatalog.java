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
import java.util.List;

@WebServlet(name = "DeleteProductInCatalog", urlPatterns = "/DeleteProductInCatalog")
public class DeleteProductInCatalog extends HttpServlet {
    //private static final long serialVersionUID = 1L;
    ProductService productService = new ProductServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        List<Product> productList = productService.showProduct();
        System.out.println("");
        System.out.format("%10s%20s%20s%20s%20s", "ID |", "Name Prod |", "Price |", "Manufacturer |", "Release Date ");
        for (Product product : productList) {
            System.out.println(" ");
            System.out.format("%10s%20s%20s%20s%20s", product.getId() + " |", product.getNameprod() +
                            " |", product.getPrice() + " |", product.getManufacturer() + " |",
                    product.getReleaseDate());

        }
        if (productService.deleteProduct(Integer.parseInt(id))) {
            request.setAttribute("productIsDelete", "Product Delete from Catalog");
           // doGet(request, response);
        }
        System.out.println("---Delete is performed!---");
        request.getSession().setAttribute("id", id);
        request.getSession().setAttribute("group", productList);
        request.getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/views/catalogAdd.jsp").forward(request, response);
    }
}

