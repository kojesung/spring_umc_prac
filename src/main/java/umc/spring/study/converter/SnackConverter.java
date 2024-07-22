package umc.spring.study.converter;

import umc.spring.study.domain.Snack;
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
}
