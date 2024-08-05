package umc.spring.study.web.dto;

import lombok.*;

import java.util.List;

public class MainPageDTO {

    @Getter
    @Setter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MainPageResponseDTO{
        String petName;

        String petCategory;

        Long point;

        String todayQuestion;

        Boolean questionStatus;
    }
}
