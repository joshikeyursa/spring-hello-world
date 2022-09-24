package com.kjoshi.basicms.helloworld;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockserver.client.MockServerClient;
import org.mockserver.model.MediaType;
import org.mockserver.springtest.MockServerTest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockserver.model.HttpRequest.request;
import static org.mockserver.model.HttpResponse.response;

@MockServerTest("server.url=http://localhost:${mockServerPort}")
@ExtendWith(SpringExtension.class)
public class HelloWorldMockServerTest {
    @Value("${server.url}")
    private String serverUrl;

    private MockServerClient mockServerClient;
    @Test
    void unitTestCase(){
        mockServerClient.when(request().withMethod("GET").withPath("/customers/1"))
                .respond(response().withStatusCode(200)
                        .withContentType(MediaType.APPLICATION_JSON)
                        .withBody("{}"));
        WebTestClient webTestClient = WebTestClient.bindToServer().baseUrl(serverUrl).build();
    }
}
