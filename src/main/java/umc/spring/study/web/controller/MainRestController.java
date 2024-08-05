package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.service.MainpageService.MainPageService;
import umc.spring.study.service.MainpageService.MainPageServiceImpl;
import umc.spring.study.web.dto.MainPageDTO;
import umc.spring.study.web.dto.OrderListResponseDTO;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/MainPage")
public class MainRestController {
    private final MainPageService mainPageService;

    @GetMapping("/")//Parameter의 userId값으로 조회
    public ApiResponse<MainPageDTO.MainPageResponseDTO> getMainPage(@RequestParam Long userId) {
        MainPageDTO.MainPageResponseDTO mainPageInfo = mainPageService.getMainPageInfo(userId);
        //MainPageService의 getMainPageInfo로 정보 가져옴
        return ApiResponse.onSuccess(mainPageInfo);
    }
}
