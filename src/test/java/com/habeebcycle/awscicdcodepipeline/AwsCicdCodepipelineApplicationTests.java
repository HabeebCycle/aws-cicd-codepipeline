package com.habeebcycle.awscicdcodepipeline;

import com.habeebcycle.awscicdcodepipeline.model.AwsBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

    ResponseEntity<AwsBean> getAwsUrl(int versionId){
        String urlString = "http://localhost:" + randomServerPort + "/aws-bean/" + versionId;
        System.out.println(randomServerPort);
        return restTemplate.getForEntity(urlString, AwsBean.class);
    }

    @Test
    void testGetAwsBeanVersion1(){
        int version = 1;
        ResponseEntity<AwsBean> result = getAwsUrl(version);

        //Verify request succeed
        assertTrue(result.hasBody());
        assertNotNull(result.getBody());
        assertEquals(200, result.getStatusCodeValue());
        assertEquals("0.0.1-SNAPSHOT", result.getBody().getVersion());
    }

}
