package org.poc.download;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.poc.IndiceCrawlerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IndiceCrawlerApplication.class)
public class DownloaderTests {

    private final static String CAC_40_STRING="CAC 40";
    @Autowired
    private Downloader downLoader;
    
    @Test
    public void testDefaultDownLoad() {
        ResponseEntity<String> resp=  downLoader.download();
        Assert.assertNotNull(resp);
        Assert.assertTrue(resp.toString().contains(CAC_40_STRING));
        
    }
}
