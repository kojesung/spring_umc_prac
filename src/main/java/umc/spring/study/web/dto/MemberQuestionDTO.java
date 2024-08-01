package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class MemberQuestionDTO {
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionAnswerRequestDTO{
        Long questionId;
        Long memberId;
    }

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionAnswerResponseDTO{
        String question;
        String answer;
        String createdAt;
        String updatedAt;
        Long questionId;
    }
}
