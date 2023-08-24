package com.keysoft.pigfarm.production.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.keysoft.pigfarm.common.BaseDto;
import com.keysoft.pigfarm.common.DatePatternEnum;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TaskDto extends BaseDto {

	private Long id;
	private String code;
	private TaskDto parent;
	private String title;
	private String description;
	private String status;
	private LocalDateTime startDate;
	private String startLocalDateTimeStr;
	
	public String getStartLocalDateTimeStr() {
		return startDate != null ? DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY__HH_MM.pattern).format(startDate) : "";
	}
	
	private LocalDateTime deadline;
	private String deadlineLocalDateTimeStr;
	
	public String getDeadlineLocalDateTimeStr() {
		return deadline != null ? DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY__HH_MM.pattern).format(deadline) : "";
	}
	
	private String frequency;
	private String request;
	private String createdBy;
	private String createdByReport;
	private String createdDate;
	private List<RevisionDto> revisions;

	private String subAssignee;
	private String assigneeUsername;
	private String assigneeFullname;
	private String assigneeEmail;
	private String assignees;
	private String assigneeReport;
	
	private String startDateStr;	// dd/MM/yyyy
	private String startDateToDisplay;
	public String getStartDateToDisplay() {
		return startDate != null ? DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY_2.pattern).format(startDate) : "";
	}
	private String startDateTimeStr;	// HH:mm
	private String startDateTimeToDisplay;
	public String getStartDateTimeToDisplay() {
		return startDate != null ? DateTimeFormatter.ofPattern(DatePatternEnum.HH_MM.pattern).format(startDate) : "";
	}
	private String deadlineStr;
	private String deadlineToDisplay;
	public String getDeadlineToDisplay() {
		return deadline != null ? DateTimeFormatter.ofPattern(DatePatternEnum.DD_MM_YYYY_2.pattern).format(deadline) : "";
	}
	private String deadlineTimeStr;
	private String deadlineTimeToDisplay;
	public String getDeadlineTimeToDisplay() {
		return deadline != null ? DateTimeFormatter.ofPattern(DatePatternEnum.HH_MM.pattern).format(deadline) : "";
	}

	/**
	 * Time to notification
	 */
	private Integer time1;
	private String unit1;
	private Integer time2;
	private String unit2;
	private Integer notificationTimes;

	// content revision
	private Map<String, Object> content;
	
	/**
	 * confirm task
	 */
	private String action;
	private String cause;
	
	/**
	 * To send mail
	 */
	private String mailTo;
	private String mailContent;
	
	/*
	 * For searching
	 */
	private String taskGroup;
	private String farmCode;
	private String keyword;
	private String searchFromDateStr;
	private LocalDateTime searchFromDate;
	private String searchToDateStr;
	private LocalDateTime searchToDate;
	private String username;
	private Boolean adminView;
	
	@JsonIgnore
	private List<MultipartFile> photos;
	private List<String> photoUrls;
	@ToString.Exclude
	private List<String> lstPhotoStr;
	@ToString.Exclude
	private List<TaskEvidenceDto> taskEvidences;
	// evidence
	private Boolean documentType;
	private List<TaskEvidenceDto> documentAttachments;
	private Boolean imageType;
	private List<String> imageAttachments;
	private Boolean videoType;
	private List<String> videoAttachments;

	private Boolean requestRejectFrequency;
	private String commentContent;
}
