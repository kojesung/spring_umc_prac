package umc.spring.study.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.study.apiPayload.code.BaseCode;
import umc.spring.study.apiPayload.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess","code","message","result"})//JSON 직렬화 시 필드의 순서 지정
public class ApiResponse<T> {
//클래스 이름 옆에<T>는
    @JsonProperty("isSuccess")
    private final Boolean isSuccess;
    private final String code;
    private final String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T result;
//들어오는 순서대로 위에 필드 값에 매칭되며 json으로 저장됨
    public static <T> ApiResponse<T> onSuccess(T result){
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> of(BaseCode code, T result){
        return new ApiResponse<>(true, code.getReasonHttpStatus().getCode(), code.getReasonHttpStatus().getMessage(),result);
    }

    public static <T> ApiResponse<T> onFailure(String code, String message, T data){
        //static <T>는 해당 메서드가 제네릭 타입임을 명시
        return new ApiResponse<>(false, code, message, data);
        //ApiResponse객체를 만들어 반한하는데 <>로 생성자의 타입 매개변수를 추론할 수 있도록 도와줌
    }

}