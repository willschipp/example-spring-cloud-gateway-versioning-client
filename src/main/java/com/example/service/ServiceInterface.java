package com.example.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient("remote-service")
public interface ServiceInterface {

    @GetMapping("/api/service/version")
    String getVersion();
}
