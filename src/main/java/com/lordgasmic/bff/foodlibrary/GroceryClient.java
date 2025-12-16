package com.lordgasmic.bff.foodlibrary;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "grocery-client", url = "${grocery-service.url}")
public interface GroceryClient {
}
