package com.keysoft.pigfarm.common;

public enum TaskActionEnum {
    ADDITIONAL("additional"),
    FORM("/task/form"),
    CONFIRM("/task/confirm"),
    COMMENT("comment"),
    REJECTED("rejected"),
    COPY("copy")
    ;

    public String action;

    private TaskActionEnum(String action) { this.action = action; }
}
