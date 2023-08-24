package com.keysoft.pigfarm.production.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MailDto {
	private String mailTo;
	private String subject;
	private String mailContent;
	private String mailCc;
	private String[] emailTo;
	private String[] emailCc;
}
