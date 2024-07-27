package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import umc.spring.study.domain.enums.SnackOrderStatus;

public class OrderListResponseDTO {
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderListDTO {
        String snackName;

        SnackOrderStatus status;

        String orderTime;
    }
}
