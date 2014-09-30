package ngdemo.rest;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import ngdemo.domain.Product;
import ngdemo.service.IProductService;

@Path("/products")
public final class ProductRestService {

    private final IProductService service;

    @Inject
    public ProductRestService(IProductService service) {
        this.service = service;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Product> getProduct() {
        return this.service.getProducts();
    }

}