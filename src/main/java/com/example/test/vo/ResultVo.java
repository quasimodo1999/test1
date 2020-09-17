package com.example.test.vo;

import lombok.Data;

@Data
public class ResultVo {

    private String msg = "操作成功！！";

    private String code = "2000";

    private Object data;

    private Boolean success = true;
}
