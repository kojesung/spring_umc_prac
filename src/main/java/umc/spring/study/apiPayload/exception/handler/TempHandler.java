package umc.spring.study.apiPayload.exception.handler;

import umc.spring.study.apiPayload.code.BaseErrorCode;
import umc.spring.study.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
//해당 클래스는 GeneralException을 확장하는 클래스라는 것을 명시(TempHandler가 GeneralException을 상속받는다는 뜻
// -> 메서드를 물려받을 수 있음!)
    public TempHandler(BaseErrorCode errorCode){//Temp에 대한 Handler
        super(errorCode);
        //생성자를 통해 BaseErrorCode 타입의 오류를 받아 내부 필드에 저장함.
    }
//TempHandler는 이렇게 쓰는거야 라고 알려주는 곳
    //실제로는 TempQueryServiceImpl에서 사용됨
}
