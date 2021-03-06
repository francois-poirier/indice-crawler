package org.poc;

import java.io.IOException;

import javax.annotation.PostConstruct;

import org.poc.crawler.CrawlerConfig;
import org.poc.indice.IndiceEntry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.MessageEndpoint;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.scheduling.PollerMetadata;
import org.springframework.messaging.MessageChannel;
import org.springframework.scheduling.support.PeriodicTrigger;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class IndiceCrawlerApplication {

    private static Logger LOG = LoggerFactory.getLogger(IndiceCrawlerApplication.class);

    public static void main(String[] args) throws IOException {
        ApplicationContext ctx = SpringApplication.run(IndiceCrawlerApplication.class, args);
        System.in.read();
        Runtime.getRuntime().exit(SpringApplication.exit(ctx));
    }

    @Autowired
    private CrawlerConfig config;

    @PostConstruct
    public void postConstruct() {
        LOG.info("starting crawler with config={}", config);
    }

    @MessageEndpoint
    public static class Endpoint {
        @ServiceActivator(inputChannel = "channel4")
        public void log(IndiceEntry payload) {
            if ((payload!=null)&&(!payload.getCountry().equals(""))) {
                LOG.info("entry={}", payload);
            }
        }
    }


    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public MessageChannel channel1() {
        return new QueueChannel(10);
    }

    @Bean
    public MessageChannel channel2() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel channel3() {
        return new DirectChannel();
    }

    @Bean
    public MessageChannel channel4() {
        return new QueueChannel(10);
    }

    @Bean
    public PollerMetadata downloadTrigger() {
        PeriodicTrigger trigger = new PeriodicTrigger(config.getDownloadInterval());
        trigger.setFixedRate(true);
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(trigger);
        pollerMetadata.setMaxMessagesPerPoll(1);
        return pollerMetadata;
    }

    // <int:poller id="poller" default="true" fixed-rate="10"/>
    @Bean(name = PollerMetadata.DEFAULT_POLLER)
    public PollerMetadata poller() {
        PeriodicTrigger trigger = new PeriodicTrigger(10);
        trigger.setFixedRate(true);
        PollerMetadata pollerMetadata = new PollerMetadata();
        pollerMetadata.setTrigger(trigger);
        return pollerMetadata;
    }
}
