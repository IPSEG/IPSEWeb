package com.ipseweb.traffic.dto.station;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationArrivalInfoResponse {
    private String stationLineId;
    private String stationLineName;
    private String stationId;
    private String stationName;
    private String destination;
    private String arrivalTime;
    private String arrivalMessage;
    private String arrivalCode;
    private String nextStation;
}
