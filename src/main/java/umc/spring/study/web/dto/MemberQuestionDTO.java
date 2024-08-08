package umc.spring.study.web.dto;

import lombok.*;

import java.time.LocalDateTime;

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
        Long answerId;
        String answer;
        String createdAt;
        String updatedAt;
        Long questionId;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class QuestionMemberResponseDTO{
        Long questionId;
        String questionContent;
        Long answerId;
        LocalDateTime createdAt;
        LocalDateTime updatedAt;
    }
}
