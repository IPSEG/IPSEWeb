package com.ipseweb.traffic.dto.busstop;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class OpenApiBusStopResponse {


    private int currentCount;

    private int matchCount;

    private int page;

    private int perPage;

    private int totalCount;

    private List<OpenApiBusStopData> data;
}
