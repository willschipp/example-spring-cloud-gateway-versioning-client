package com.example.endpoint;

import com.example.service.ServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client")
public class AccessEndpoint {

    @Autowired
    private ServiceInterface serviceInterface;

    @GetMapping("/service")
    public String getServiceResponse() {
        return serviceInterface.getVersion();
    }
}
