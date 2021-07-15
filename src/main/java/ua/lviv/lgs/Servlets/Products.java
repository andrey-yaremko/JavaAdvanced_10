package ua.lviv.lgs.Servlets;

import com.google.gson.Gson;
import ua.lviv.lgs.dao.service.ProductService;
import ua.lviv.lgs.dao.service.impl.ProductServiceImpl;
import ua.lviv.lgs.domain.Product;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "Products", value = "/Products")
public class Products extends HttpServlet {
    private ProductService productService = ProductServiceImpl.getProductService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = null;
        try {
            products = productService.readAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        String json  = new Gson().toJson(products);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
}
