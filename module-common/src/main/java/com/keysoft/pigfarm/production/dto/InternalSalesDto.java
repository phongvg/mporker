package com.keysoft.pigfarm.production.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.Data;

@Data
public class InternalSalesDto {
	private Long id;
	private StockDto stock;
	private LocalDate postingDate;
	private String processOrderCode;
	private BigDecimal quantity;
	private LocalDateTime createdDate;
	
	private String stockCode;
}
