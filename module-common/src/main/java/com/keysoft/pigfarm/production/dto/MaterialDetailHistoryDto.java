package com.keysoft.pigfarm.production.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MaterialDetailHistoryDto {
  	private Long id;
	private String transCode;
	private String stockCode;
	private String recordType;
  	private String code;
  	private String name;
  	private String unsignedName;
  	private String suggestName;
  	private String groupCode;
  	private String groupName;
  	private String unit;
  	private String batch;
  	private String purchasingGroup;
  	private String industryStandardDescription;
  	private String fastCode;
  	private BigDecimal quantity;
  	private String orderUnit;
  	private LocalDate expiredDate;
  	private LocalDate deliveryDate;
  	private LocalDate manufacturedDate;
  	private String type;
  	private BigDecimal weight;
  	private String reason;
  	private String note;
  	private BigDecimal actuallyImported;
  	private BigDecimal actuallyExported;
  	private BigDecimal expectedQuantity;
  	private BigDecimal retained;
  	private String itemNum;
  	private BigDecimal grossWeight;
  	private String weightUnit;
  	private boolean requiredBatch;
  	private String description;
  	private String transCodeItem;
  	private String status;
  	private BigDecimal amountEarlyStage;
  	private BigDecimal amountFinalStage;
  	private BigDecimal amountGoodsReceipt;
  	private BigDecimal amountGoodsIssue;
  	private String pigType;
  	private LocalDateTime createdDate;
  	private String createdBy;
}
