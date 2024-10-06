//package com.ipseweb.traffic.repository;
//
//import com.ipseweb.traffic.domain.StationArrivalInfo;
//import com.ipseweb.traffic.dto.station.StationArrivalInfoResponse;
//import org.springframework.data.jpa.repository.JpaRepository;
//
//import java.util.List;
//
//public interface StationArrivalRepository extends JpaRepository<StationArrivalInfo, String> {
//
//    public List<StationArrivalInfoResponse> findAllByStationName(String stationId);
//
//    public List<StationArrivalInfoResponse> findAllByStationId(String arrivalDate);
//}
