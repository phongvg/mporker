package com.keysoft.pigfarm.production.dto;

import com.keysoft.pigfarm.common.BaseDto;
import com.keysoft.pigfarm.common.DatePatternEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class GeneralLedgerDto extends BaseDto {

    private Long id;
    private String transCode;
    private VendorDto vendor;
    private FarmDto farm;
    private String docCode;
    private String docNum;
    private String docSymbol;

    private String displayDocDate;
    public String getDisplayDocDate() {
        return docDate != null ? DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY_2.pattern).format(docDate) : "";
    }
    private String docDateStr;
    private LocalDate docDate;
    private String docDateToSync;
    public String getDocDateToSync() {
        return docDate != null ? DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(docDate) : "";
    }

    private String displayPostingDate;
    public String getDisplayPostingDate() {
        return postingDate != null ? DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY_2.pattern).format(postingDate) : "";
    }
    private String postingDateStr;
    private LocalDate postingDate;
    private String postingDateToSync;
    public String getPostingDateToSync() {
        return postingDate != null ? DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(postingDate) : "";
    }
    private BigDecimal amount;
    private String displayAmount;
    public String getDisplayAmount() {
        return amount != null ? amount.toString(): "";
    }
    private String address;
    private String vendorTax;
    private String vendorName;
    private String description;
    private String fiDoc;
    private String createdBy;
    private LocalDateTime createdDate;
    private String status;

    // searching
    private String username;
    private String searchFromDateStr;
    private LocalDate searchFromDate;
    private String searchToDateStr;
    private LocalDate searchToDate;
    private String searchFarmCode;

    // param to sync
    private Boolean checkAll;
    private String transCodeToSync;
}
