package com.keysoft.pigfarm.production.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.keysoft.pigfarm.common.BaseDto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class SupportRequireDto extends BaseDto {
	private Long id;
	private String subject;
	private String description;
	private String requester;
	private String emailString;
	private String itemName;
	private String category;
	private String subCategory;
	private String udfField_902;
	private String udfField_1201;
	
	private LocalDateTime createdDate;
	private String username;
	private List<String> emailToNotify;
	
	private String displayCreatedDate;
  	public String getDisplayCreatedDate() {
  		if (createdDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(createdDate);  
  		} else {
  			return null;
  		}
  	}
}
