package umc.spring.study.web.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class TempResponse {
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempTestDTO {
        String testString;
    }
//static class로 선언된 TempTestDTO는 TempResponse의 인스턴스 없이도 독립적으로 사용될 수 있음을 명시
//    NonStaticResponse 객체 생성
//    NonStaticResponse response = new NonStaticResponse();
//    NonStaticTestDTO 객체 생성 (외부 클래스의 인스턴스를 통해서만 생성 가능)
//    NonStaticResponse.NonStaticTestDTO dto = response.new NonStaticTestDTO("Example String");

    // Builder 패턴을 사용하여 TempTestDTO 객체 생성-----------독립적으로 사용할 때
//    TempResponse.TempTestDTO dto = TempResponse.TempTestDTO.builder()
//            .testString("Example String")
//            .build();

    //DTO클래스는 여기저기서 많이 사용되니까 static class로 만들어서 매번 class파일을 만들지 않고 범용적으로 DTO 사용 가능
    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class TempExceptionDTO{
        Integer flag;
    }
}
