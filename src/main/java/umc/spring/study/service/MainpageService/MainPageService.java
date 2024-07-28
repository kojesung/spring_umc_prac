package umc.spring.study.service.MainpageService;

import umc.spring.study.web.dto.MainPageDTO;

public interface MainPageService {
    MainPageDTO.MainPageResponseDTO getMainPageInfo(Long userId);

}
