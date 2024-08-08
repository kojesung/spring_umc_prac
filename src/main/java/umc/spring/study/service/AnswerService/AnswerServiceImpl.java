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
    }

    @Override
    @Transactional
    public MemberQuestion addMemberQuestion(AnswerDTO.AnswerSubmitRequestDTO request){
        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        Question question = questionRepository.findById(Math.toIntExact(request.getQuestionId()))
                .orElseThrow(() -> new IllegalArgumentException("Question not found"));
        Answer answer = AnswerConverter.toAnswer(request);

        // Answer를 먼저 저장
        Answer savedAnswer = answerRepository.save(answer);

        // Member의 questionCount가 요청의 questionId와 같은지 확인
        if (member.getQuestionCount() == Math.toIntExact(request.getQuestionId())) {
            member.incrementQuestionCount();
            memberRepository.save(member);
        }

        // 저장된 Answer를 사용하여 MemberQuestion 생성
        MemberQuestion memberQuestion = AnswerConverter.toMemberQuestion(request, member, question, savedAnswer);
        return memberQuestionRepository.save(memberQuestion);
    }

    @Override
    @Transactional
    public MemberQuestion updateMemberQuestion(AnswerDTO.AnswerSubmitRequestDTO request) {
        MemberQuestion memberQuestion = memberQuestionRepository.findByQuestionIdAndMemberId(request.getQuestionId(), request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("MemberQuestion not found"));

        Answer updatedAnswer = AnswerConverter.toAnswer(request);
        Answer savedAnswer = answerRepository.save(updatedAnswer);

        memberQuestion.updateAnswer(savedAnswer); // 명시적 메서드를 통해 Answer 업데이트
        memberQuestion.updateTimestamp(); // 타임스탬프 업데이트
        return memberQuestionRepository.save(memberQuestion);
    }

    @Override
    @Transactional
    public boolean confirmMemberQuestion(AnswerDTO.AnswerSubmitRequestDTO request){
        Long questionId = request.getQuestionId();
        Long memberId = request.getMemberId();
        return memberQuestionRepository.existsByQuestionIdAndMemberId(questionId, memberId);
    }
}
