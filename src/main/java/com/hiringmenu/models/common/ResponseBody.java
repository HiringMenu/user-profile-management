package com.hiringmenu.models.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResponseBody {
    private String status;
    private Object message;

    public ResponseBody(String status, Object message) {
        this.status = status;
        this.message = message;
    }
}
