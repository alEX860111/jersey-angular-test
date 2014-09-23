package ngdemo.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.domain.Product;
import ngdemo.service.ProductService;

@Path("/products")
public class ProductRestService {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProduct() {
        ProductService productService = new ProductService();
        return productService.getProducts();
    }

}