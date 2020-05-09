package com.habeebcycle.awscicdcodepipeline;

import com.habeebcycle.awscicdcodepipeline.model.AwsBean;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment=RANDOM_PORT)
class AwsCicdCodepipelineApplicationTests {

    @LocalServerPort
    int randomServerPort;

    private RestTemplate restTemplate = new RestTemplate();

    @BeforeEach
    void isUpAndRunning(){
        String status = restTemplate.getForObject("http://localhost:" + randomServerPort, String.class);
        assertEquals("UP", status);
    }

    @Test
    void testGetAwsBeanVersion1(){
        int version = 1 + (int)(Math.random() * 100);
        ResponseEntity<AwsBean> result = getAwsUrl(version, "/aws-bean/");

        //Verify request succeed
        assertTrue(result.hasBody());
        assertNotNull(result.getBody());
        assertEquals(version, result.getBody().getId());
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("0.0.1-SNAPSHOT", result.getBody().getVersion());
    }

    @Test
    void testGetAwsBeanVersion2(){
        int version = 1 + (int)(Math.random() * 100);
        ResponseEntity<AwsBean> result = getAwsUrl(version, "/aws-bean-2/");

        //Verify request succeed
        assertTrue(result.hasBody());
        assertNotNull(result.getBody());
        assertEquals(version, result.getBody().getId());
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("0.0.2-SNAPSHOT", result.getBody().getVersion());
    }

    @Test
    void testGetAwsBeanVersion3(){
        int version = 1 + (int)(Math.random() * 100);
        ResponseEntity<AwsBean> result = getAwsUrl(version, "/aws-bean-3/");

        //Verify request succeed
        assertTrue(result.hasBody());
        assertNotNull(result.getBody());
        assertEquals(version, result.getBody().getId());
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("0.0.3-SNAPSHOT", result.getBody().getVersion());
    }

    private ResponseEntity<AwsBean> getAwsUrl(int versionId, String path){
        String urlString = "http://localhost:" + randomServerPort + path + versionId;
        System.out.println(randomServerPort);
        return restTemplate.getForEntity(urlString, AwsBean.class);
    }

}
