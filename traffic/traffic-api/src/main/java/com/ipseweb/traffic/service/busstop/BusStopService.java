package com.ipseweb.traffic.service.busstop;


import com.ipseweb.traffic.domain.BusStop;
import com.ipseweb.traffic.dto.busstop.OpenApiBusStopResponse;
import com.ipseweb.traffic.repository.busstop.BusStopRepository;
import com.ipseweb.traffic.util.Request;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BusStopService {

    private final BusStopRepository busStopRepository;

    @Value("${spring.openapi.busStop.apiKey}")
    private String apiKey;

    @Value("${spring.openapi.busStop.url.busStopInfo}")
    private String busStopInfoUrl;



    public List<BusStop> findBusStopsV1() {
        return busStopRepository.findAll();
    }

    public List<OpenApiBusStopResponse> findBusStopsV2() {
        String url = String.format(busStopInfoUrl, 1, 10, apiKey);
        OpenApiBusStopResponse openApiBusStopData = Request.requestGet(url, OpenApiBusStopResponse.class);

        List<OpenApiBusStopResponse> list = new ArrayList<>();
        list.add(openApiBusStopData);

        return list;
    }
}
