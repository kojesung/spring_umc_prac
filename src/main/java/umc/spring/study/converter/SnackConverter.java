package umc.spring.study.converter;

import umc.spring.study.domain.Member;
import umc.spring.study.domain.Snack;
import umc.spring.study.domain.SnackOrder;
import umc.spring.study.domain.enums.SnackOrderStatus;
import umc.spring.study.web.dto.OrderListResponseDTO;
import umc.spring.study.web.dto.SnackResponseDTO;

import java.time.Duration;
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
                .status(SnackOrderStatus.BEFORE) // Assuming the order is always active
                .orderTime(LocalDateTime.now())
                .build();
    }

    public static OrderListResponseDTO.OrderListDTO toOrderListDTO(SnackOrder snackOrder) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime orderTime = snackOrder.getOrderTime();

        Duration duration = Duration.between(orderTime, now);

        SnackOrderStatus status;
        if (duration.toDays() < 1) {
            status = SnackOrderStatus.BEFORE;//주문한지 하루 전이면 배송전으로 표시
        } else if (duration.toDays() < 7) {
            status = SnackOrderStatus.GOING;//주문한지 일주일 이내면 배송중으로 표시
        } else {
            status = SnackOrderStatus.AFTER;//주문 일주일 이후면 배송완료로 표시
        }

        return new OrderListResponseDTO.OrderListDTO(
                snackOrder.getSnack().getName(),
                status,
                orderTime.toString()
        );
    }
}
