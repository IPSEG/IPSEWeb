package com.ipseweb.traffic.repository.busstop;

import com.ipseweb.traffic.domain.BusStop;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Slf4j
@Transactional
@RequiredArgsConstructor
public class BusStopJpaRepository implements BusStopRepository{

    private final EntityManager em;

    @Override
    public BusStop findOne(String busStopId) {
        return em.find(BusStop.class, busStopId);
    }

    @Override
    public List<BusStop> findByName(String busStopName) {
        return em.createQuery("select  b from BusStop b where b.busStopName = :busStopName", BusStop.class)
                .setParameter("busStopName", busStopName)
                .getResultList();
    }

    @Override
    public List<BusStop> findAll() {
        return em.createQuery("select b from BusStop b", BusStop.class)
                .getResultList();
    }
}
