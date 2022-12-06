package me.zhengjie.response.enums;

import lombok.Getter;

/**
 * @ClassName: ResultEnum
 * @Description: 响应体参数枚举类
 * @Author: jiangqx
 * @Date: 2022/10/24 15:10
 * @Version 1.0
 */
@Getter
public enum ResultEnum {

    // code: 0 | -1 | 401 | ...
    // type: "success" | "error" | "warning"

    OK(1, true, "成功"),
    ERROR(-1, false, "失败"),
    WARING(0, false, "警告");

    private Integer code;
    private Boolean success;
    private String message;

    ResultEnum(Integer code, Boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
}
