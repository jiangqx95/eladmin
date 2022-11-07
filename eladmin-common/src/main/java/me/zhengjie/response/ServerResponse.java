package me.zhengjie.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import me.zhengjie.response.enums.ResultEnum;

import javax.annotation.Nullable;

/**
 * @ClassName: ServerResponse
 * @Description: 请求响应体
 * @Author: jiangqx
 * @Date: 2022/10/24 15:05
 * @Version 1.0
 */
@Data
@AllArgsConstructor
public class ServerResponse<T> {
    private Integer code;
    private String type;
    private String message;
    private T result;

    private ServerResponse() {
    }

    public static ServerResponse ok() {
        return new ServerResponse(ResultEnum.OK.getCode(), ResultEnum.OK.getType(), ResultEnum.OK.getMessage(), null);
    }

    public static <T> ServerResponse<T> ok(T result) {
        return new ServerResponse<>(ResultEnum.OK.getCode(), ResultEnum.OK.getType(), ResultEnum.OK.getMessage(), result);
    }

    public static ServerResponse error(@Nullable String message) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setMessage(message != null ? message : ResultEnum.ERROR.getMessage());
        return serverResponse;
    }

    public static ServerResponse error(@Nullable Integer code, @Nullable String message) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setCode(code != null ? code : ResultEnum.ERROR.getCode());
        serverResponse.setType(ResultEnum.ERROR.getType());
        serverResponse.setMessage(message != null ? message : ResultEnum.ERROR.getMessage());
        return serverResponse;
    }

    public static <T> ServerResponse<T> error(T result, @Nullable Integer code, @Nullable String message) {
        ServerResponse serverResponse = new ServerResponse();
        serverResponse.setCode(code != null ? code : ResultEnum.ERROR.getCode());
        serverResponse.setType(ResultEnum.ERROR.getType());
        serverResponse.setMessage(message != null ? message : ResultEnum.ERROR.getMessage());
        serverResponse.setResult(result);
        return serverResponse;
    }
}
