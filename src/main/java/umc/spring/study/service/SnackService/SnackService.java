package umc.spring.study.service.SnackService;

import umc.spring.study.web.dto.SnackResponseDTO;

import java.util.List;

public interface SnackService {
    List<SnackResponseDTO.SnackDTO> getAllSnacks();
}
