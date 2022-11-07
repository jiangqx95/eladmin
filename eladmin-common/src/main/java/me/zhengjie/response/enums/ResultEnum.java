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

    OK(0, "success", "成功"),
    ERROR(-1, "error", "失败"),
    WARING(0, "waring", "警告");

    private Integer code;
    private String type;
    private String message;

    ResultEnum(Integer code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }
}
