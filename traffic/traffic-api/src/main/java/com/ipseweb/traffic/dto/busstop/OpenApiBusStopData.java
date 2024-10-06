package com.ipseweb.traffic.dto.busstop;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@RequiredArgsConstructor
public class OpenApiBusStopData {

    @JsonProperty("정류장번호")
    private String busStopId;

    @JsonProperty("정류장명")
    private String busStopName;

    @JsonProperty("정보수집일")
    private LocalDate informationCollectDate;

    @JsonProperty("관리도시명")
    private String city;

    @JsonProperty("도시명")
    private String detailCity;

    @JsonProperty("도시코드")
    private String cityCode;

    @JsonProperty("모바일단축번호")
    private String mobileCode;

    @JsonProperty("경도")
    private String longitude;

    @JsonProperty("위도")
    private String latitude;
}
