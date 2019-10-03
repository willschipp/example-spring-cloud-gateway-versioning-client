package com.example.endpoint;

import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.urlPathMatching;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class AccessEndpointIT {

    @Rule
    public WireMockRule wireMockRule = new WireMockRule(9000);

    @Autowired
    MockMvc mockMvc;

    @Test
    public void getServiceResponse() throws Exception {
        //stub the response
        wireMockRule.stubFor(WireMock.get(urlPathMatching("/api/service/version"))
                .willReturn(aResponse()
                        .withStatus(200)
                        .withBody("1.0")));
        //invoke
        mockMvc.perform(get("/client/service"))
                .andExpect(status().isOk())
                .andExpect(content().string("1.0"));
    }
}