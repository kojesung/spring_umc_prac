package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.service.SnackService.SnackService;
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

    @PostMapping("/")
    public ApiResponse<String> Order(@RequestBody SnackResponseDTO.SnackOderRequestDTO request) {
        snackService.OrderSnack(request);
        return ApiResponse.onSuccess("success");
    }
}
