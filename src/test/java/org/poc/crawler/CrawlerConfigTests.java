package org.poc.crawler;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.poc.IndiceCrawlerApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = IndiceCrawlerApplication.class)
public class CrawlerConfigTests {

    @Autowired
    private CrawlerConfig crawlerConfig;
    
    
    @Test
    public void testGetDefaultUrl() {
        Assert.assertEquals(crawlerConfig.getUrl(), CrawlerConfig.DEFAULT_URL);
    }
    
    @Test
    public void testGetDefaultInterval() {
        Assert.assertEquals(crawlerConfig.getDownloadInterval(),CrawlerConfig.DEFAULT_DOWNLOAD_INTERVAL);
    }
}