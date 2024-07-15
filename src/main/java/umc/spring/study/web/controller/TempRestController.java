package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.TempConverter;
import umc.spring.study.service.TempService.TempQueryService;
import umc.spring.study.web.dto.TempResponse;

@RestController
@RequestMapping("/temp")
@RequiredArgsConstructor//final로 선언된 모든 필드에 대해 생성자를 자동으로 생성해줌 -> 의존성 주입 가능
public class TempRestController {

    private final TempQueryService tempQueryService;
    //의존성 주입을 위해서 생성자를 통해 초기화되어야 함

    @GetMapping("/test")
    public ApiResponse<TempResponse.TempTestDTO> testAPI() {

        return ApiResponse.onSuccess(TempConverter.toTempTestDTO());
    }

    @GetMapping("/exception")
    public ApiResponse<TempResponse.TempExceptionDTO> exceptionAPI(@RequestParam Integer flag) {
        tempQueryService.CheckFlag(flag);//여기서 CheckFlag를 호출하면 TempQueryServiceImpl이 호출됨
        return ApiResponse.onSuccess(TempConverter.toTempExceptionDTO(flag));
    }

}