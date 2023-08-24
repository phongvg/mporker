package com.keysoft.pigfarm.common;

public enum FileExtensionDocumentEnum {
    DOC("doc"),
    DOCX("docx"),
    ODT("odt"),
    PDF("pdf"),
    TXT("txt"),
    XLSX("xlsx")
    ;

    public String val;

    private FileExtensionDocumentEnum(String val) {this.val = val;}
}
