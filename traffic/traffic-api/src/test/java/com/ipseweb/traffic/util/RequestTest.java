package com.ipseweb.traffic.util;

import com.ipseweb.traffic.dto.busstop.OpenApiBusStopResponse;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class RequestTest {

    @Test
    @DisplayName("request테스트")
    public void requestTest() throws Exception {
        int page = 1;
        int perPage = 1;
        String key = "ldBxM3pP5Yn7M4b7Rva1vIySjE8KSyi5WfIlUsMwAWOfCnvq9o2r2jqoe12wQXw8SLWkZe8DlR2RGvgXIt2IRQ==";
        String url = String.format("https://api.odcloud.kr/api/15067528/v1/uddi:eb02ec03-6edd-4cb0-88b8-eda22ca55e80?page=%d&perPage=%d&serviceKey=%s",
                page, perPage, key);
        OpenApiBusStopResponse openApiBusStopResponse = Request.requestGet(url, OpenApiBusStopResponse.class);

        System.out.println("openApibusStopReponse : " + openApiBusStopResponse);
    }

}