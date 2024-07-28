package umc.spring.study.service.MainpageService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.converter.MainPageConverter;
import umc.spring.study.repository.MemberQuestionRepository;
import umc.spring.study.repository.MemberRepository;
import umc.spring.study.repository.PetRepository;
import umc.spring.study.web.dto.MainPageDTO;

@Service
@RequiredArgsConstructor
public class MainPageServiceImpl implements MainPageService {
    private final MemberQuestionRepository memberQuestionRepository;
    private final PetRepository petRepository;
    private final MemberRepository memberRepository;
    private final MainPageConverter mainPageConverter;

    @Override
    @Transactional
    public MainPageDTO.MainPageResponseDTO getMainPageInfo(Long userId) {
        return mainPageConverter.toMainPageDTO(userId);
        //유저 정보를 넣으면 MainPageConverter를 통해 원하는 DTO로 만들어줌
    }
}
