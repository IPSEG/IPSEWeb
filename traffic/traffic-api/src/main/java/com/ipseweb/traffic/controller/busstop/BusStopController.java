package com.ipseweb.traffic.controller.busstop;

import com.ipseweb.traffic.domain.BusStop;
import com.ipseweb.traffic.dto.busstop.OpenApiBusStopResponse;
import com.ipseweb.traffic.dto.error.OpenApiErrorCode;
import com.ipseweb.traffic.dto.error.Response;
import com.ipseweb.traffic.dto.error.SuccessCode;
import com.ipseweb.traffic.exception.ResponseEntityFactory;
import com.ipseweb.traffic.exception.TrafficException;
import com.ipseweb.traffic.service.busstop.BusStopService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "BusStop", description = "BusStop API")
@RestController
@RequiredArgsConstructor
@Slf4j
public class BusStopController {

    private final BusStopService busStopService;


    /**
     * v1. db에서 버스 정류장 정보 조회
     *
     * @return
     */
    @Operation(summary = "버스정류장 목록 조회", description = "v1, 버스 정류장 목록을 조회합니다.",
        responses = {
            @ApiResponse(description = "JPA 버스 정류장 조회",
            content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = BusStop.class)
            ))
        })
    @GetMapping("/api/busstops/v1")
    public ResponseEntity<Response<List<BusStop>>> busStopsV1() {
        List<BusStop> busStopsV1 = busStopService.findBusStopsV1();
        return ResponseEntityFactory.success(busStopsV1);
    }

    /**
     * v2. openAPI로 버스 정류장 정보 조회
     * @return
     */
    @Operation(summary = "버스 정류장 목록 조회", description = "v2. 버스 정류장 목록을 조회합니다.",
            responses = {
                @ApiResponse(description = "openAPI 버스 정류장 조회",
                        content = @Content(
                                mediaType = "application/json",
                                schema = @Schema(implementation = BusStop.class)
                        )
                )
            }
    )
    @GetMapping("/api/busstops/v2")
    public ResponseEntity<Response<List<OpenApiBusStopResponse>>> busStopsV2() throws TrafficException {
        List<OpenApiBusStopResponse> busStopsV2 = busStopService.findBusStopsV2();

        if (busStopsV2.isEmpty()) {
            log.error("BusStop list is empty.");
            new TrafficException(OpenApiErrorCode.BUSSTOP_EMPTY);
        }

        return ResponseEntityFactory.success(busStopsV2);
    }
}
