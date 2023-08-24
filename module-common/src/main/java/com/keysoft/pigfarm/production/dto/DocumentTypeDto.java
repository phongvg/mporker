package com.keysoft.pigfarm.production.dto;

import java.util.Set;

import com.keysoft.pigfarm.common.BaseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class DocumentTypeDto extends BaseDto {
  	private Long id;
  	private String code;
  	private String name;
  	private String description;
  	private String status;
  	
  	private Set<String> existingCodes;
}
