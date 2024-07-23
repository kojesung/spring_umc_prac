package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class OrderListResponseDTO {
    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class OrderListDTO {
        String snackName;

        Boolean status;

        String orderTime;
    }
}
