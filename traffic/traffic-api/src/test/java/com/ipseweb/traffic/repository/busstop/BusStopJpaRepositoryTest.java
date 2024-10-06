package com.ipseweb.traffic.repository.busstop;

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
class BusStopJpaRepositoryTest {

    @Autowired
    EntityManager em;

    @Autowired
    BusStopRepository busStopRepository;

    @Test
    void findOne() {
        BusStop busStop = busStopRepository.findOne("ADB354000076");

        Assertions.assertThat(busStop).isNotNull();
        Assertions.assertThat(busStop.getBusStopName()).isEqualTo("신덕1리");
    }

    @Test
    void findByName() {
        List<BusStop> busStop = busStopRepository.findByName("신덕1리");

        Assertions.assertThat(busStop).isNotNull();
        Assertions.assertThat(busStop.get(0).getBusStopId()).isEqualTo("ADB354000076");
    }

    @Test
    public void findAll() throws Exception {
        List<BusStop> all = busStopRepository.findAll();
        Assertions.assertThat(all.size()).isEqualTo(10);

    }
}