package com.ipseweb.traffic.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClientException;

import java.util.function.Consumer;

@Slf4j
@Component
public class WebClientUtil {

    WebClient webClient;

    public WebClientUtil(WebClient webClient) {
        this.webClient = webClient;
    }

    public Object get(String url) {
        log.info("url: {}", url);

        Object response = null;

        try {
            response = webClient.get()
                    .uri(url)
                    .retrieve()
                    .bodyToMono(Object.class).block();
        } catch (WebClientException e) {
            log.error(e.getMessage());
        }

        log.info("response: {}", response);

        return response;
    }

    public Object get(String url, Consumer<HttpHeaders> headers) {
        log.info("url: {}", url);

        Object response = null;

        try {
            response = webClient.get()
                    .uri(url)
                    .headers(headers)
                    .retrieve()
                    .bodyToMono(String.class).block();
        } catch (WebClientException e) {
            log.error(e.getMessage());
        }

        log.info("response: {}", response);

        return response;
    }

    public String post() {return "";}
}
