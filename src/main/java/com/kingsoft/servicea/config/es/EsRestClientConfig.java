package com.kingsoft.servicea.config.es;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;

/**
 * @author Sheledon
 * @date 2022/4/12
 */
@Configuration
public class EsRestClientConfig extends AbstractElasticsearchConfiguration {

    @Value("${spring.elasticsearch.uris}")
    public String connectUris;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        final ClientConfiguration clientConfiguration =
                ClientConfiguration.builder()
                        .connectedTo(connectUris)
//                        .usingSsl()
//                        .withProxy("")
                        .build();
        return RestClients.create(clientConfiguration).rest();
    }
    @Bean("esRestTemplate")
    public ElasticsearchRestTemplate elasticsearchRestTemplate(){
        return new ElasticsearchRestTemplate(elasticsearchClient());
    }
}
