package com.conf;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({ESProperties.class})
public class TestConf {

    /**
     * 注解注入配置信息
     * */
    @Bean
    RestHighLevelClient restHighLevelClient(final ESProperties esProperties){
        return new RestHighLevelClient(RestClient.builder(new HttpHost(esProperties.getIp(), esProperties.getPort(), "http")));
    }
}
