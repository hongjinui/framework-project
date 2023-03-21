package spring.project.hello.common;

import lombok.Getter;

@Getter
public enum CustomApiCode {

    // 커스텀 에러 코드
    DATA_OK(1000, "성공")
    , ERROR(3000, "오류 발생")
    ;

    private int code;
    private String message;

    CustomApiCode(int code, String message){
        this.code = code;
        this.message = message;
    }

}