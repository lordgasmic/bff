package com.lordgasmic.bff.foodlibrary;

import com.lordgasmic.bff.foodlibrary.models.GroceryAddRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "grocery-client", url = "${grocery-service.url}")
public interface GroceryClient {

    @PutMapping("/api/v1/grocery")
    void addGroceryItem(@RequestBody GroceryAddRequest request);
}
