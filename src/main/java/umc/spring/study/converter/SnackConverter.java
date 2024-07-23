package umc.spring.study.converter;

import umc.spring.study.domain.Member;
import umc.spring.study.domain.Snack;
import umc.spring.study.domain.SnackOrder;
import umc.spring.study.web.dto.OrderListResponseDTO;
import umc.spring.study.web.dto.SnackResponseDTO;

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
                .build();
    }

    public static OrderListResponseDTO.OrderListDTO toOrderListDTO() {
        return null;//인자 설정해줘야 함
    }
}
