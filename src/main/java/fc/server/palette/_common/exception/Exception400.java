package fc.server.palette._common.exception;

import fc.server.palette._common.util.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;


// 유효성 검사 실패, 잘못된 파라미터 요청
@Getter
public class Exception400 extends RuntimeException {
    private final String key;
    private final String value;

    public Exception400(String key, String value) {
        super(key + " : " + value);
        this.key = key;
        this.value = value;
    }

    public ApiUtils.ApiResult<?> body() {
        return ApiUtils.error(getMessage(), HttpStatus.BAD_REQUEST);
    }

    public HttpStatus status() {
        return HttpStatus.BAD_REQUEST;
    }
}