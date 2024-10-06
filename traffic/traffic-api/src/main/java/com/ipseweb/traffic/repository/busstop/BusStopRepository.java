package com.ipseweb.traffic.repository.busstop;


import com.ipseweb.traffic.domain.BusStop;

import java.util.List;

public interface BusStopRepository {

    BusStop findOne(String busStopId);

    List<BusStop> findByName(String busStopName);

    List<BusStop> findAll();
}
