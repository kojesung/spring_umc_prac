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
import java.util.Optional;

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

        Pet pet = petRepository.findByMemberId(userId);
        if (pet == null) {
            throw new IllegalArgumentException("Pet not found");
        }

        Optional<MemberQuestion> optionalMemberQuestion = memberQuestionRepository.findTopByMemberIdOrderByCreatedAtDesc(userId);

        Question todayQuestion;
        boolean questionStatus = false;

        if (optionalMemberQuestion.isPresent()) {//optionalMemberQuestion에 값이 있으면(매핑 테이블안에 해당하는 유저가 있을 때)
            MemberQuestion memberQuestion = optionalMemberQuestion.get();
            todayQuestion = questionRepository.findById(Math.toIntExact(memberQuestion.getQuestion().getId()))
                    .orElse(null); // Question not found 시 null 반환

            LocalDate today = LocalDate.now();;
            questionStatus = member.getMemberQuestionsList().stream()
                    .anyMatch(mq -> mq.getCreatedAt().toLocalDate().equals(today));
        } else {//매핑 테이블안에 해당하는 유저가 없을 때
            todayQuestion = questionRepository.findById(1)
                    .orElseThrow(() -> new IllegalArgumentException("Default Question not found"));
        }

        return MainPageResponseDTO.builder()
                .petName(pet.getName())
                .petCategory(pet.getPetType().name())
                .point(Long.valueOf(member.getPoint())) // Integer를 Long으로 변환
                .todayQuestion(todayQuestion.getContent())
                .questionStatus(questionStatus)
                .build();
    }
}
