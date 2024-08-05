package umc.spring.study.service.AnswerService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.converter.AnswerConverter;
import umc.spring.study.domain.Answer;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Question;
import umc.spring.study.domain.mapping.MemberQuestion;
import umc.spring.study.repository.AnswerRepository;
import umc.spring.study.repository.MemberQuestionRepository;
import umc.spring.study.repository.MemberRepository;
import umc.spring.study.repository.QuestionRepository;
import umc.spring.study.web.dto.AnswerDTO;

@Service
@RequiredArgsConstructor
public class AnswerServiceImpl implements AnswerService{
    private final AnswerRepository answerRepository;
    private final MemberRepository memberRepository;
    private final QuestionRepository questionRepository;
    private final MemberQuestionRepository memberQuestionRepository;


    @Override
    @Transactional
    public Answer addAnswer(Answer answer) {
        return answerRepository.save(answer);
    };

    @Override
    @Transactional
    public MemberQuestion addMemberQuestion(AnswerDTO.AnswerSubmitRequestDTO request){
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(()-> new IllegalArgumentException("Member not found"));
        Question question = questionRepository.findById(Math.toIntExact(request.getQuestionId()))
                .orElseThrow(()->new IllegalArgumentException("Question not found"));
        Answer answer = AnswerConverter.toAnswer(request);

        // Answer를 먼저 저장
        Answer savedAnswer = answerRepository.save(answer);

        // 저장된 Answer를 사용하여 MemberQuestion 생성
        MemberQuestion memberQuestion = AnswerConverter.toMemberQuestion(request, member, question, savedAnswer);
        return memberQuestionRepository.save(memberQuestion);
    };
}
