package umc.spring.study.converter;

import umc.spring.study.domain.Member;
import umc.spring.study.domain.Snack;
import umc.spring.study.domain.SnackOrder;
import umc.spring.study.web.dto.OrderListResponseDTO;
import umc.spring.study.web.dto.SnackResponseDTO;

import java.time.LocalDateTime;

public class SnackConverter {
    public static SnackResponseDTO.SnackDTO toSnackDTO(Snack snack) {
        return SnackResponseDTO.SnackDTO.builder()
                .id(snack.getId())
                .name(snack.getName())
                .nutrient(snack.getNutrient())
                .img(snack.getImg())
                .build();
    }

    public static SnackOrder toSnackOrder(Member member, Snack snack) {
        return SnackOrder.builder()
                .member(member)
                .snack(snack)
                .status(true) // Assuming the order is always active
                .orderTime(LocalDateTime.now())
                .build();
    }

    public static OrderListResponseDTO.OrderListDTO toOrderListDTO(SnackOrder snackOrder) {
        return new OrderListResponseDTO.OrderListDTO(
                snackOrder.getSnack().getName(),
                snackOrder.getStatus(),
                snackOrder.getOrderTime().toString()
        );
    }
}
