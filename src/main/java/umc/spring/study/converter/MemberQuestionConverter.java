package umc.spring.study.converter;

import umc.spring.study.domain.mapping.MemberQuestion;
import umc.spring.study.web.dto.MemberQuestionDTO;

import java.util.List;
import java.util.stream.Collectors;

public class MemberQuestionConverter {
    public static MemberQuestionDTO.QuestionAnswerResponseDTO toQuestionAnswerResponseDTO(MemberQuestion memberQuestion) {
        return new MemberQuestionDTO.QuestionAnswerResponseDTO(
                memberQuestion.getQuestion().getContent(),
                memberQuestion.getAnswer().getId(),
                memberQuestion.getAnswer().getAnswer(),
                memberQuestion.getCreatedAt().toString(),
                memberQuestion.getUpdatedAt().toString(),
                memberQuestion.getQuestion().getId()
        );
    }
    public static List<MemberQuestionDTO.QuestionMemberResponseDTO> toQuestionMemberResponseDTO(List<MemberQuestion> memberQuestions) {
        return memberQuestions.stream()
                .map(memberQuestion -> new MemberQuestionDTO.QuestionMemberResponseDTO(
                        memberQuestion.getQuestion().getId(),
                        memberQuestion.getQuestion().getContent(),
                        memberQuestion.getAnswer().getId(),
                        memberQuestion.getCreatedAt(),
                        memberQuestion.getUpdatedAt()
                ))
                .collect(Collectors.toList());
    }
}
