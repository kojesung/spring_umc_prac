package umc.spring.study.web.controller;

import lombok.Getter;
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

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/question")
public class MemberQuestionController {
    private final MemberQuestionServiceImpl memberQuestionServiceImpl;

    @GetMapping("/get")
    public ApiResponse<MemberQuestionDTO.QuestionAnswerResponseDTO> getQuestionAnswer(@RequestParam Long questionId, @RequestParam Long memberId) {
        MemberQuestionDTO.QuestionAnswerResponseDTO responseDTO = memberQuestionServiceImpl.getQuestionAnswer(questionId, memberId);
        return ApiResponse.onSuccess(responseDTO);
    }

    @GetMapping("/member")
    public ApiResponse<List<MemberQuestionDTO.QuestionMemberResponseDTO>> getQuestionMember(@RequestParam Long memberId){
        List<MemberQuestionDTO.QuestionMemberResponseDTO> responseDTO = memberQuestionServiceImpl.getQuestionMember(memberId);
        return ApiResponse.onSuccess(responseDTO);
    }
}
