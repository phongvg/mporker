package com.keysoft.pigfarm.integration.sap;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class WbsJson {
	@JsonProperty("PSPNR")
	private String wbsId;
	@JsonProperty("POSID")
	private String wbsCode;
	@JsonProperty("POST1")
	private String wbsDesc;
	@JsonProperty("PBUKR")
	private String companyCode;
	@JsonProperty("WERKS")
	private String plantCode;
	@JsonProperty("LGORT")
	private String farmCode;
	@JsonProperty("LOEVM")
	private String wbsStatus;
}
