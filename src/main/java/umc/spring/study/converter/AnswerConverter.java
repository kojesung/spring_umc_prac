package umc.spring.study.converter;

import umc.spring.study.domain.Answer;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Question;
import umc.spring.study.domain.mapping.MemberQuestion;
import umc.spring.study.web.dto.AnswerDTO;

public class AnswerConverter {
    public static Answer toAnswer(AnswerDTO.AnswerSubmitRequestDTO request) {
        return Answer.builder()
                .answer(request.getAnswerContent())
                .build();
    }

    public static MemberQuestion toMemberQuestion(AnswerDTO.AnswerSubmitRequestDTO request, Member member, Question question, Answer answer) {
        return MemberQuestion.builder()
                .member(member)
                .answer(answer)
                .question(question)
                .build();
    }
}
