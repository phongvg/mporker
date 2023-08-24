package com.keysoft.pigfarm.master.dto;

import java.time.LocalDateTime;

import lombok.Data;

/**
 * Generated by Speed Generator
 * 
 * @author <a href="mailto:ngtrungkien@gmail.com">Kien Nguyen</a>
 */
@Data
public class TenantAccountDto {
  	private Long id;
  	private String tenantCode;
  	private String username;
  	private String realm;
  	private String client;
  	private String clientSecret;
  	private String status;
  	private String createdBy;
  	private LocalDateTime createdDate;
  	private String modifiedBy;
  	private LocalDateTime modifiedDate;
  
}