package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.service.MemberQuestionService.MemberQuestionService;
import umc.spring.study.service.MemberQuestionService.MemberQuestionServiceImpl;
import umc.spring.study.web.dto.MemberQuestionDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question/get")
public class MemberQuestionController {
    private final MemberQuestionServiceImpl memberQuestionServiceImpl;

    @GetMapping
    public ApiResponse<MemberQuestionDTO.QuestionAnswerResponseDTO> getQuestionAnswer(@RequestParam Long questionId, @RequestParam Long memberId) {
        MemberQuestionDTO.QuestionAnswerResponseDTO responseDTO = memberQuestionServiceImpl.getQuestionAnswer(questionId, memberId);
        return ApiResponse.onSuccess(responseDTO);
    }
}
