package umc.spring.study.web.dto;

import lombok.*;
import umc.spring.study.domain.Member;

public class AnswerDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class AnswerSubmitRequestDTO{
        private Long questionId;

        private String answerContent;

        private Long memberId;
    }

    public static class AnswerResponseDTO{

    }
}
