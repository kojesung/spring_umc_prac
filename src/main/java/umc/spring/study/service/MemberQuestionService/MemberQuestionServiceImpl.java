package umc.spring.study.service.MemberQuestionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.spring.study.converter.MemberQuestionConverter;
import umc.spring.study.domain.mapping.MemberQuestion;
import umc.spring.study.repository.MemberQuestionRepository;
import umc.spring.study.web.dto.MemberQuestionDTO;
import umc.spring.study.web.dto.PagedResponseDTO;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberQuestionServiceImpl implements MemberQuestionService {
    private final MemberQuestionRepository memberQuestionRepository;

    public MemberQuestionDTO.QuestionAnswerResponseDTO getQuestionAnswer(Long questionId, Long memberId) {
        MemberQuestion memberQuestion = memberQuestionRepository.findByQuestionIdAndMemberId(questionId, memberId)
                .orElseThrow(() -> new IllegalArgumentException("주어진 질문 번호와 유저 번호로 답변을 조회할 수 없습니다."));

        return MemberQuestionConverter.toQuestionAnswerResponseDTO(memberQuestion);
    }

    public PagedResponseDTO<MemberQuestionDTO.QuestionMemberResponseDTO> getQuestionMember(Long memberId, Pageable pageable) {
        Page<MemberQuestion> memberQuestions = memberQuestionRepository.findByMemberIdOrderByQuestionIdAsc(memberId, pageable);
        return MemberQuestionConverter.toQuestionMemberResponseDTOPage(memberQuestions);
    }
}
