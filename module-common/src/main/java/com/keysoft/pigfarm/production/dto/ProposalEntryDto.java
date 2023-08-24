package com.keysoft.pigfarm.production.dto;

import java.math.BigDecimal;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class ProposalEntryDto {
	private Integer entryQuantity;
	private BigDecimal avgEntryWeight;
}
