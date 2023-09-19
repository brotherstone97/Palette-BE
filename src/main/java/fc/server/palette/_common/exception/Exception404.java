package fc.server.palette._common.exception;

import fc.server.palette._common.util.ApiUtils;
import lombok.Getter;
import org.springframework.http.HttpStatus;

// 찾을 수 없음
@Getter
public class Exception404 extends RuntimeException {
    public Exception404(String message) {
        super(message);
    }

    public ApiUtils.ApiResult<?> body() {
        return ApiUtils.error(getMessage(), HttpStatus.NOT_FOUND);
    }

    public HttpStatus status() {
        return HttpStatus.NOT_FOUND;
    }
}