package com.keysoft.pigfarm.production.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.keysoft.pigfarm.common.DatePatternEnum;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
public class RevisionDto {
	private Long id;
	private Map<String, Object> content;
	private String createdBy;
	private LocalDateTime createdDate;
	
	private String createdDateStr;
	public String getCreatedDateStr() {
		return createdDate != null ? DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY__HH_MM.pattern).format(createdDate) : "";
	}
}
