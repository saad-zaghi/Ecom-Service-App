package com.billing.billingservice.feignclients;

import com.billing.billingservice.models.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "INVENTORY-SERVICE")
public interface ProductItemRestClient {
    @GetMapping(path = "/products")
    PagedModel<Product> findAllProducts();

    @GetMapping(path = "/products/{id}")
    Product findProductById(@PathVariable(name = "id") Long id);
}
