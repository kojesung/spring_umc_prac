package umc.spring.study.converter;

import umc.spring.study.domain.mapping.MemberQuestion;
import umc.spring.study.web.dto.MemberQuestionDTO;

public class MemberQuestionConverter {
    public static MemberQuestionDTO.QuestionAnswerResponseDTO toQuestionAnswerResponseDTO(MemberQuestion memberQuestion) {
        return new MemberQuestionDTO.QuestionAnswerResponseDTO(
                memberQuestion.getQuestion().getContent(),
                memberQuestion.getAnswer().getAnswer(),
                memberQuestion.getCreatedAt().toString(),
                memberQuestion.getUpdatedAt().toString(),
                memberQuestion.getQuestion().getId()
        );
    }
}
