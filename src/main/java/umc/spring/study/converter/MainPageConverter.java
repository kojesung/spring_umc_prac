package umc.spring.study.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.study.domain.Member;
import umc.spring.study.domain.Pet;
import umc.spring.study.domain.Question;
import umc.spring.study.domain.mapping.MemberQuestion;
import umc.spring.study.repository.MemberQuestionRepository;
import umc.spring.study.repository.MemberRepository;
import umc.spring.study.repository.PetRepository;
import umc.spring.study.repository.QuestionRepository;
import umc.spring.study.web.dto.MainPageDTO.MainPageResponseDTO;

import java.time.LocalDate;

@Component
@RequiredArgsConstructor
public class MainPageConverter {

    private final MemberRepository memberRepository;
    private final PetRepository petRepository;
    private final QuestionRepository questionRepository;
    private final MemberQuestionRepository memberQuestionRepository;

    public MainPageResponseDTO toMainPageDTO(Long userId) {
        Member member = memberRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found"));
        //userId로 해당하는 Member엔티티 가져옴
        Pet pet = petRepository.findByMemberId(userId);
        //userId로 해당하는 Pet엔티티 가져옴, 근데 이 findByMemberId는 어디서 나오는거냐?(들어가봐)
        if (pet == null) {//조회했는데 pet이 null일 때,
            throw new IllegalArgumentException("Pet not found");
        }

        MemberQuestion memberQuestion = memberQuestionRepository.findTopByMemberIdOrderByCreatedAtDesc(userId)
                .orElseThrow(() -> new IllegalArgumentException("MemberQuestion not found"));
        //MemberQuestion매핑 테이블 중 해당 userId로 작성한 답변들 중에서 가장 최근 값을 포함하는 내용들이 담겨있음

        Question todayQuestion = questionRepository.findById(memberQuestion.getMember().getQuestionCount())
                //memberQuestion.getMember()를 했을 때 Member객체가 반환되는 이유는 ManyToOne으로 매핑되어있기 때문
                .orElseThrow(() -> new IllegalArgumentException("Question not found"));

        // 현재 날짜
        LocalDate today = LocalDate.now();
        // questionStatus는 오늘 날짜에 해당하는 질문이 있는지 여부로 판단
        boolean questionStatus = member.getMemberQuestionsList().stream()
                .anyMatch(mq -> mq.getCreatedAt().toLocalDate().equals(today));

        return MainPageResponseDTO.builder()
                .petName(pet.getName())
                .petCategory(pet.getPetType().name())
                .point(Long.valueOf(member.getPoint())) // Integer를 Long으로 변환
                .todayQuestion(todayQuestion.getContent())
                .questionStatus(questionStatus)
                .build();
    }
}
