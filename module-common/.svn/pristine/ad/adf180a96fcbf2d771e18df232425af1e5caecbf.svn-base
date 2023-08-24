package com.keysoft.pigfarm.production.dto;

import java.time.LocalDateTime;
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
public class NotificationDto extends BaseDto {
	private Long id;
  	private String farmCode;
	  private String taskCode;
  	private String type;
  	private String eventId;
  	private String message;
  	private String status;
  	private LocalDateTime createdDate;
  	
  	private String timeDiff;
	  private List<String> types;
}
