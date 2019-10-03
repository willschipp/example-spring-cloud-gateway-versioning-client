package com.example.service;

import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ServiceInterfaceIT {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(9000);

    @Autowired
    ServiceInterface serviceInterface;

    @Test
    public void getVersion() {
        //stub the response
        wireMockRule.stubFor(get(urlPathMatching("/api/service/version"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("1.0")));
        //now invoke the service
        String response = serviceInterface.getVersion();
        assertEquals("1.0",response);
    }
}