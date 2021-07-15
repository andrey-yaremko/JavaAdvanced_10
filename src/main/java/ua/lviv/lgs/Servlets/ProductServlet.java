package ua.lviv.lgs.Servlets;

import ua.lviv.lgs.dao.service.ProductService;
import ua.lviv.lgs.dao.service.impl.ProductServiceImpl;
import ua.lviv.lgs.domain.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet extends HttpServlet {
    ProductService productService = ProductServiceImpl.getProductService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String price = request.getParameter("price");

        System.out.println(name);

        Product product  = new Product(name, description, getValidatedPrice(price));
        try {
            productService.create(product);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        response.setContentType("text/plain");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write("Success");
    }
    private double getValidatedPrice(String price) {
        if(price == null || price.isEmpty()) {
            return 0;
        }
        return Double.parseDouble(price);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String productId = request.getParameter("id");
        Product product = null;
        try {
            product = productService.read(Integer.parseInt(productId));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        request.setAttribute("product", product);
        request.getRequestDispatcher("singleProduct.jsp").forward(request, response);
    }
}

