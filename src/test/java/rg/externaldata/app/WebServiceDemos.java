package rg.externaldata.app;

import org.externaldata.app.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = Application.class)
public class WebServiceDemos {

    private static final Logger logger = LoggerFactory.getLogger(WebServiceDemos.class);
    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void testLatstPrice() {
        String url = String.format("http://localhost:%1$s/sinaprice/%2$s/lastedPrice", port, "sh600008");

        logger.info("url path:{}", url);
        @SuppressWarnings("rawtypes")
        ResponseEntity<String> entity = this.testRestTemplate.getForEntity(url, String.class);
        logger.info("shanghai:{}", entity.getBody());

        url = String.format("http://localhost:%1$s/sinaprice/%2$s/lastedPrice", port, "sz000001");

        logger.info("url path:{}", url);
        entity = this.testRestTemplate.getForEntity(url, String.class);
        logger.info("shenzhen:{}", entity.getBody());
    }

    @Test
    public void testFundPrice() {
        String url = String.format("http://localhost:%1$s/fund/%2$s/lastedPrice", port, "519005");

        logger.info("url path:{}", url);
        @SuppressWarnings("rawtypes")
        ResponseEntity<String> entity = this.testRestTemplate.getForEntity(url, String.class);
        logger.info("519005:{}", entity.getBody());

    }

}
