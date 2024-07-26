package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.service.SnackService.SnackService;
import umc.spring.study.web.dto.OrderListResponseDTO;
import umc.spring.study.web.dto.SnackResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Snacks")
public class SnackRestController {
    private final SnackService snackService;

    @GetMapping("/")
    public ApiResponse<List<SnackResponseDTO.SnackDTO>> getAllSnacks() {
        List<SnackResponseDTO.SnackDTO> allSnacks = snackService.getAllSnacks();
        return ApiResponse.onSuccess(allSnacks);
    }

    @PostMapping("/order")
    public ApiResponse<String> Order(@RequestBody SnackResponseDTO.SnackOderRequestDTO request) {
        snackService.OrderSnack(request);
        return ApiResponse.onSuccess("success");
    }

    @GetMapping("/order/list")
    public ApiResponse<List<OrderListResponseDTO.OrderListDTO>> getList(@RequestParam Long userId){
        List<OrderListResponseDTO.OrderListDTO> orderList = snackService.getOrderList(userId);
        return ApiResponse.onSuccess(orderList);
    }

}
