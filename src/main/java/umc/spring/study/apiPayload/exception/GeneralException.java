package umc.spring.study.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{
    private BaseErrorCode code;
    //code라는 필드는 BaseErrorCode 클래스의 메서드인 getReason()과 getReasonHttpStatus()를 사용할 수 있게 됨
    //BaseErrorCode의 메서드는 왜 쓰는거냐? -> DTO로 바꿔야되니까

    public ErrorReasonDTO getErrorReason(){
        return this.code.getReason();
    }
    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }//ex)generalException.getReasonHttpStatus()이런식으로 사용됨
    //-> generalException과 관련된 상세 오류 정보가 반환되며 이것을 나중에 DTO로 변환해야 함
}//이게 먼소릴까요?
