package umc.spring.study.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ErrorReasonDTO {
    //에러를 나타내는 DTO는 이렇게 생겼다고 알려주는 클래스

    private HttpStatus httpStatus;

    private final boolean isSuccess;

    private final String code;

    private final String message;

    public boolean getIsSuccess() {
        return isSuccess;
    }
}