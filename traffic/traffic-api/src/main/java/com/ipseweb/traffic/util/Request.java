package com.ipseweb.traffic.util;

import org.springframework.http.MediaType;
import org.springframework.web.client.RestClient;

public class Request {

    private static final RestClient restClient = RestClient.create();

    public static <T> T requestGet(String url, Class<T> responseType) {
        return restClient.get().uri(url).accept(MediaType.APPLICATION_JSON).retrieve().body(responseType);
    }
}
