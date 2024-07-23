package umc.spring.study.web.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class SnackResponseDTO {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SnackDTO{
        Long id;

        String name;

        String nutrient;

        String img;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SnackOderRequestDTO{
        Long memberId;
        Long snackId;
    }


}
