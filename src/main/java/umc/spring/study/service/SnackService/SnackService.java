package umc.spring.study.service.SnackService;

import umc.spring.study.web.dto.OrderListResponseDTO;
import umc.spring.study.web.dto.SnackResponseDTO;

import java.util.List;

public interface SnackService {
    List<SnackResponseDTO.SnackDTO> getAllSnacks();

    void OrderSnack(SnackResponseDTO.SnackOderRequestDTO request);

    List<OrderListResponseDTO.OrderListDTO> getOrderList(Long userId);

}
