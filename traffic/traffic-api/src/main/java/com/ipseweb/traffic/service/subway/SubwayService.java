package com.ipseweb.traffic.service.subway;

import com.ipseweb.traffic.util.WebClientUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class SubwayService {

    @Value("${spring.openapi.subway.apiKey}")
    private String apiKey;

    @Value("${spring.openapi.subway.url.arrivalInfo}")
    private String arrivalInfoUrl;

    WebClientUtil webClientUtil;

    public SubwayService(WebClientUtil webClientUtil) {
        this.webClientUtil = webClientUtil;
    }

    public void getStationArrivalInfo(String stationName) {
        String url = String.format(arrivalInfoUrl, apiKey, 0, 8, stationName);
        Object response = webClientUtil.get(url);
    }
}
