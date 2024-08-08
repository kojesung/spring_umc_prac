package umc.spring.study.web.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.service.MemberQuestionService.MemberQuestionServiceImpl;
import umc.spring.study.web.dto.MemberQuestionDTO;
import umc.spring.study.web.dto.PagedResponseDTO;

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
    public ApiResponse<PagedResponseDTO<MemberQuestionDTO.QuestionMemberResponseDTO>> getQuestionMember(
            @RequestParam Long memberId,
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "20") int size) {
        Pageable pageable = PageRequest.of(page, size);
        PagedResponseDTO<MemberQuestionDTO.QuestionMemberResponseDTO> responseDTO = memberQuestionServiceImpl.getQuestionMember(memberId, pageable);
        return ApiResponse.onSuccess(responseDTO);
    }
}
