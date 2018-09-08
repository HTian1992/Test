package com.conf;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author htian
 * @since 2018/5/7
 */
@ConfigurationProperties(prefix = "lzh.conf.es")
public class ESProperties {
    //host地址
    public String ip;

    //端口
    public int port;

    //请求url
//    public String url; //= "http://"+ip+":"+port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
