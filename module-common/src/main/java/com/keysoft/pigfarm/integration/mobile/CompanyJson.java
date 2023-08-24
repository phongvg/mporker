package com.keysoft.pigfarm.integration.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CompanyJson {
	@JsonProperty("code")
	private String code;
	
	@JsonProperty("name")
	private String name;
	
	@JsonProperty("status")
	private String status;
	
    @JsonProperty("address")
  	private String address;
    
    @JsonProperty("taxCode")
  	private String taxCode;
    
    @JsonProperty("phone")
  	private String phone;
    
    @JsonProperty("fax")
  	private String fax;
}
