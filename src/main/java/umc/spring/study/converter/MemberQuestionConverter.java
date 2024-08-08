package umc.spring.study.converter;

import org.springframework.data.domain.Page;
import umc.spring.study.domain.mapping.MemberQuestion;
import umc.spring.study.web.dto.MemberQuestionDTO;
import umc.spring.study.web.dto.PagedResponseDTO;

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

    public static MemberQuestionDTO.QuestionMemberResponseDTO toQuestionMemberResponseDTO(MemberQuestion memberQuestion) {
        return new MemberQuestionDTO.QuestionMemberResponseDTO(
                memberQuestion.getQuestion().getId(),
                memberQuestion.getQuestion().getContent(),
                memberQuestion.getAnswer().getId(),
                memberQuestion.getCreatedAt(),
                memberQuestion.getUpdatedAt()
        );
    }

    public static PagedResponseDTO<MemberQuestionDTO.QuestionMemberResponseDTO> toQuestionMemberResponseDTOPage(Page<MemberQuestion> memberQuestions) {
        return PagedResponseDTO.<MemberQuestionDTO.QuestionMemberResponseDTO>builder()
                .content(memberQuestions.map(MemberQuestionConverter::toQuestionMemberResponseDTO).getContent())//MemberQuestionConverter클래스의 toQuestionMemberResponseDTO로 변환한다는 뜻
                .totalPages(memberQuestions.getTotalPages())
                .totalElements(memberQuestions.getTotalElements())
                .first(memberQuestions.isFirst())
                .last(memberQuestions.isLast())
                .size(memberQuestions.getSize())
                .numberOfElements(memberQuestions.getNumberOfElements())
                .empty(memberQuestions.isEmpty())
                .build();
    }
}
