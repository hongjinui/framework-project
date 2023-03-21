package spring.project.hello.common;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;


public class ResponseData {

        public static ApiResponseVO apiResponse(HttpStatus httpStatus, Object data, CustomApiCode customApiCode){

            ApiResponseVO responseData = ApiResponseVO.builder()
                    .status(httpStatus.value())
                    .code(customApiCode.getCode())
                    .message(customApiCode.getMessage())
                    .data(data)
                    .date(LocalDateTime.now().toString())
                    .httpStatus(httpStatus)
                    .build();

            return responseData;
        }
}
