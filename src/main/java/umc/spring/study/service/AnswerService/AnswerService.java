package umc.spring.study.service.AnswerService;

import org.springframework.transaction.annotation.Transactional;
import umc.spring.study.domain.Answer;
import umc.spring.study.domain.mapping.MemberQuestion;
import umc.spring.study.web.dto.AnswerDTO;

public interface AnswerService {
    @Transactional
    Answer addAnswer(Answer answer);

    @Transactional
    MemberQuestion addMemberQuestion(AnswerDTO.AnswerSubmitRequestDTO request);
}
