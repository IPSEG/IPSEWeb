package com.ipseweb.traffic.service.busstop;

import com.ipseweb.traffic.domain.BusStop;
import jakarta.persistence.EntityManager;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
class BusStopServiceTest {

    @Autowired
    EntityManager em;

    @Autowired
    BusStopService busStopService;

    @Test
    void findBusStops() {
        List<BusStop> busStops = busStopService.findBusStopsV1();
        Assertions.assertThat(busStops.size()).isGreaterThan(0);
    }
}