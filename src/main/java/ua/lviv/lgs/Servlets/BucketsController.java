package ua.lviv.lgs.Servlets;

import com.google.gson.Gson;
import ua.lviv.lgs.dao.service.BucketService;
import ua.lviv.lgs.dao.service.ProductService;
import ua.lviv.lgs.dao.service.impl.BucketServiceImpl;
import ua.lviv.lgs.dao.service.impl.ProductServiceImpl;
import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.dto.BucketDto;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@WebServlet(name = "buckets", value = "/BucketsController")
public class BucketsController extends HttpServlet {
    private BucketService bucketService = BucketServiceImpl.getBucketService();
    private ProductService productService = ProductServiceImpl.getProductService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Bucket> buckets = null;
        try {
            buckets = bucketService.readAll();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        Map<Integer, Product> idToProduct = null;
        try {
            idToProduct = productService.readAllMap();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        List<BucketDto> listOfBasketDtos = map(buckets,idToProduct);

        String json = new Gson().toJson(listOfBasketDtos);
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json);
    }
    public List<BucketDto> map (List<Bucket> buckets,Map<Integer,Product> idToProduct){
        return buckets.stream().map(bucket->{
            BucketDto bucketDto = new BucketDto();
            bucketDto.bucketId = bucket.getId();
            bucketDto.purchaseDate = bucket.getPurchase_date();

            Product product = idToProduct.get(bucket.getProduct_id());
            bucketDto.name = product.getName();
            bucketDto.description = product.getDescription();
            bucketDto.price = product.getPrice();

            return bucketDto;
        }).collect(Collectors.toList());
    }

}
