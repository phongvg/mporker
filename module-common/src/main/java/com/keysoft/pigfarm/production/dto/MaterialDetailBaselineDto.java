package com.keysoft.pigfarm.production.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class MaterialDetailBaselineDto {
	private Long id;
	private String transCode;
	private String recordType;
  	private String code;
  	private String name;
  	private String groupCode;
  	private String groupName;
  	private String unit;
  	private String batch;
  	private String purchasingGroup;
  	private String industryStandardDescription;
  	private String status;
  	private String unsignedName;
  	private String stockCode;
  	private String suggestName;
  	private String fastCode;
  	
  	private BigDecimal quantity;
 	private String orderUnit;
	private String expiredDateStr;
	private String deliveryDateStr;
	private String manufacturedDateStr;
	
	private LocalDate expiredDate;
	private LocalDate deliveryDate;
	private LocalDate manufacturedDate;
	
	private String pigType;
	private String type;
	private BigDecimal weight;
	private String reason;
	private String note;
	private BigDecimal actuallyImported;
	private BigDecimal actuallyExported;
	private BigDecimal retained;	
	private BigDecimal expectedQuantity;
	private String itemNum;
	private BigDecimal grossWeight;
	private String weightUnit;
	private boolean requiredBatch;
	
	private BigDecimal totalRetainedQuantity;
	private boolean selected;
	
	private Integer postingDay;
	private Map<Integer, String> actuallyExporteds;
	
	private Set<String> units;
	private Set<String> batchs;
	private String description;
	private String transCodeItem;
	private String rowId;
  	private BigDecimal amountEarlyStage;
  	private BigDecimal amountFinalStage;
  	private BigDecimal amountGoodsReceipt;
  	private BigDecimal amountGoodsIssue;
  	
  	// for report
  	private String stage;
  	private String purchasingGroups;
  	private String recordTypeName;
  	private String fromStockCode;
  	private String toStockCode;
  	private LocalDate postingDate;
  	private String poCode;
}
