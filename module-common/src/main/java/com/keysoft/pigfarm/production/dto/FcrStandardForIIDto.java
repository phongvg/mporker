package com.keysoft.pigfarm.production.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class FcrStandardForIIDto {
	private Long id;
	private Integer inValue;
	private Integer outValue;
	private String value;
}
