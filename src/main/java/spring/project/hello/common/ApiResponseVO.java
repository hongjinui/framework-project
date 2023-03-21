package spring.project.hello.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiResponseVO {

    private int status;
    private int code;
    private String message;
    private String date;
    private Object data;
    private HttpStatus httpStatus;
}