package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.AnswerConverter;
import umc.spring.study.domain.Answer;
import umc.spring.study.domain.mapping.MemberQuestion;
import umc.spring.study.service.AnswerService.AnswerService;
import umc.spring.study.service.AnswerService.AnswerServiceImpl;
import umc.spring.study.web.dto.AnswerDTO;

@RestController
@RequiredArgsConstructor
@RequestMapping("/answer")
public class AnswerRestController {

    private final AnswerServiceImpl answerServiceImpl;

    @PostMapping("/submit")
    public ApiResponse<String> submitAnswer(@RequestBody @Valid AnswerDTO.AnswerSubmitRequestDTO request) {
        Answer answer = AnswerConverter.toAnswer(request);
        //answerServiceImpl.addAnswer(answer);
        /*
        addAnswer메서드를 사용하려면 반환 값을 받아서 그 값을 저장하고 저장한 값을 통해서 request 보내는 작업이 필요함
        위에서 addAnswer메서드를 통해 저장한 answer는 request에 있는 answer기 때문에 저장된 answer가 아님,
        따라서 저장된 answer가 아닌 answer를 addMemberQuestion을 통해서 저장하려고 했기 때문에 Answer테이블에 없다는 에러가 발생하게 됨
         */

        answerServiceImpl.addMemberQuestion(request);
        return ApiResponse.onSuccess("제출 성공");
    };


}
