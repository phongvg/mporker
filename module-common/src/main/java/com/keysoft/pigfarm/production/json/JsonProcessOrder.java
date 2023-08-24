package com.keysoft.pigfarm.production.json;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keysoft.pigfarm.production.dto.QuotaDto;

import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class JsonProcessOrder {
	@JsonFormat(pattern="dd-MM-yyyy")
  	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate weekFromDate;
	
	@JsonFormat(pattern="dd-MM-yyyy")
  	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate weekToDate;
	private String status;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
  	@DateTimeFormat(iso= ISO.DATE_TIME)
	private LocalDateTime createdDate;
	
	private boolean latest;		
	@JsonProperty("processOrderCode")
	private String code ;
	@JsonProperty("pigType")
	private String pigType;
	@JsonProperty("quantity")
	private java.math.BigDecimal quantity;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@DateTimeFormat(iso = ISO.DATE)
	@JsonProperty("startDate")
	private LocalDate startDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@DateTimeFormat(iso = ISO.DATE)
	@JsonProperty("endDate")
	private LocalDate endDate;
	@JsonProperty("batch")
	private String batch;
	@JsonProperty("barnCode")
	private String barnCode ;
	@JsonProperty("materials")
	private List<JsonQuota> quotas ;
}
