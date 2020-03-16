package org.wcci.apimastery;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class HttpRequestTest {
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void songsEndpointReturnsOK(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/songs", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void albumsEndpointReturnsOK(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/albums", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    public void artistsEndpointReturnsOK(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(
                "http://localhost:" + port + "/artists", String.class);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }


}
