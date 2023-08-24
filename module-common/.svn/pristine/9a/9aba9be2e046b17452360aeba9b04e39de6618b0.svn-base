package com.keysoft.pigfarm.production.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import com.keysoft.pigfarm.common.BaseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProposalDto extends BaseDto {
	private Long id;
  	private String processOrderCode;
  	private String transCode;
    private String status;
    private String pigType;
  	private LocalDate recordDate;
    private FarmDto farm;
  	private Map<String, Object> content;
  	private Integer entryQuantity;
  	private BigDecimal avgEntryWeight;
  	private Integer pigRetained;
  	private String reason;
  	private LocalDate estimateDate;							//ngày dự kiến bán
  	private Integer totalProposal;							//tổng đề xuất bán
  	private BigDecimal avgProposalWeight;					//khối lượng đề xuất trung bình
  	private String createdBy;
  	private LocalDateTime createdDate;
  	private String modifiedBy;
  	private LocalDateTime modifiedDate;
  	private List<ContentProposalDto> contentProposals;
  	
  	private String displayRecordDate;
  	public String getDisplayRecordDate() {
  		if (recordDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(recordDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	private String displayEstimateDate;
  	public String getDisplayEstimateDate() {
  		if (estimateDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(estimateDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	private String estimateDateStr;
  	private String username;
  	
}
