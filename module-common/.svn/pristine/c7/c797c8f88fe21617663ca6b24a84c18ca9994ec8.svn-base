package com.keysoft.pigfarm.production.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class InstockHistoryDto {
	private Long id;
  	private String transCode;
  	private LocalDate syncDate;
  	private Map<String, Object> content;
  	private boolean latest;
  	private boolean latestOfDay;
  	private LocalDateTime createdDate;
  	private String stockCode;
  	private String createdBy;
}
