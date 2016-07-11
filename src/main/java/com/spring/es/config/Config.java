package com.spring.es.config;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.node.NodeBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import java.io.IOException;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author huangd7
 */
@Configuration
@EnableElasticsearchRepositories(basePackages = "com.spring.es.repo")
@ComponentScan(basePackages = {"com.spring.es.services"})
public class Config {

    @Value("${elasticsearch.home:/usr/local/Cellar/elasticsearch/2.3.1}")
    private String elasticsearchHome;

    private static Logger logger = LoggerFactory.getLogger(Config.class);

    @Bean
    public Client client() {
        try {
            Settings settings = Settings.settingsBuilder()
                    .put("cluster.name", "elasticsearch_huangd7").build();
            Client client = TransportClient.builder().settings(settings).build()
                    .addTransportAddress(new InetSocketTransportAddress(InetAddress.getByName("localhost"), 9300));

            return client;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }
}