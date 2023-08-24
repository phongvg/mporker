package com.keysoft.pigfarm.production.dto;

import java.time.LocalDate;
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
public class DocumentDto extends BaseDto {
	private Long id;
  	private String email;
  	private String ccEmail;
  	private String description;
  	private String content;
  	private LocalDate createdDate;
    private List<AttachmentDto> files;
    private FarmDto farm;
  	private String status;
  	private String username;
  	
  	private String farmCode;
  	private String farmName;
  	private LocalDate modifiedDate;
  	
  	private String displayCreatedDate;
  	public String getDisplayCreatedDate() {
  		if (createdDate != null) {
  			return DateTimeFormatter.ofPattern("dd-MM-yyyy").format(createdDate);  
  		} else {
  			return null;
  		}
  	}
  	
  	private String searchFromDateStr;
	private LocalDate searchFromDate;
	private String searchToDateStr;
	private LocalDate searchToDate;
	
	private List<String> filesToDelete;
}
