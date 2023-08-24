package com.keysoft.pigfarm.master.dto;

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
public class SuperUserDto extends BaseDto{
  	private Long id;
  	private String realm;
  	private String client;
  	private String secret;
}