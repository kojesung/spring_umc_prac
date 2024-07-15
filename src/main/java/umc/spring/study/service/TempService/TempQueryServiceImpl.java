package umc.spring.study.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.study.apiPayload.code.status.ErrorStatus;
import umc.spring.study.apiPayload.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{
    //TempQueryServiceImpl은 TempQueryService 인터페이스를 구현하는 클래스이다 라는 뜻
    //@Service를 통해서 Spring의 빈이 되었기 때문에 이제 TempQueryService 타입이 필요할 때마다 TempQueryServiceImpl이 주입됨
    //그래서 TempQueryService tempQueryService로 초기화 된 필드에서
    //tempQueryService.CheckFlag(flag)로 호출하면 TempQueryServiceImpl의 CheckFlag메서드가 실행됨

    @Override
    public void CheckFlag(Integer flag){
        if(flag == 1){
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
        }//TempHandler에서 ErrorStatus.TEMP_EXCEPTION을 super로 보내주기때문에
        //이 값은 GeneralException의 code로 저장됨
    }

}
