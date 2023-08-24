package com.keysoft.pigfarm.production.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.keysoft.pigfarm.common.BaseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * Generated by Speed Generator
 * 
 * @author <a href="mailto:ngtrungkien@gmail.com">Kien Nguyen</a>
 */
@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class CompanyDto extends BaseDto {
  	private Long id;
  	private String code;
  	private String name;
  	private String status;
  	private String address;
  	private String taxCode;
  	private String phone;
  	private String fax;
}