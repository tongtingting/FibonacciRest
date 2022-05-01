package de.robertz.fibonaccirest;

import de.robertz.fibonaccirest.controller.FibonacciController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class FibonacciRestApplicationTests {

    @Autowired
    private FibonacciController fibonacciController;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void contextLoads() {
        Assertions.assertThat(fibonacciController).isNotNull();
    }

    @Test
    void calcFibRequest() {
        String baseURL = "http://localhost:" + port + "/fibonacci/";
        Assertions.assertThat(restTemplate.getForObject(baseURL + 3, Long.class)).isEqualTo(2);
        Assertions.assertThat(restTemplate.getForObject(baseURL + 10, Long.class)).isEqualTo(55);
    }

}
