package ua.lviv.lgs.Servlets;

import ua.lviv.lgs.dao.service.BucketService;
import ua.lviv.lgs.dao.service.ProductService;
import ua.lviv.lgs.dao.service.UserService;
import ua.lviv.lgs.dao.service.impl.BucketServiceImpl;
import ua.lviv.lgs.dao.service.impl.ProductServiceImpl;
import ua.lviv.lgs.dao.service.impl.UserServiceImpl;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.domain.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "BucketController", value = "/BucketController")
public class BucketController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private BucketService basketService = BucketServiceImpl.getBucketService();
    private ProductService productService = ProductServiceImpl.getProductService();
    private UserService userAccountService = UserServiceImpl.getUserService();


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String productId = request.getParameter("productId");

        Product product = null;
        try {
            product = productService.read(Integer.parseInt(productId));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        HttpSession session = request.getSession();
            Integer userId = (Integer) session.getAttribute("userId");
        User user = null;
        try {
            user = userAccountService.read(userId);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        Bucket bucket = new Bucket();
        bucket.setId(UUID.randomUUID().toString());
        bucket.setProduct_id(product);
        bucket.setUser_id(user);
        bucket.setPurchase_date(new Date());

        try {
            basketService.create(bucket);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        response.setContentType("text/plain");
            response.setCharacterEncoding("UTF-8");
            response.getWriter().write("Success");
        }
    }
