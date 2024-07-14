package umc.spring.study.apiPayload.code;

public interface BaseErrorCode {
    public ErrorReasonDTO getReason();

    public ErrorReasonDTO getReasonHttpStatus();
}
//인터페이스로 생성한 메서드는 구체화 된 곳에서 반드시 전부 사용되어야 함
