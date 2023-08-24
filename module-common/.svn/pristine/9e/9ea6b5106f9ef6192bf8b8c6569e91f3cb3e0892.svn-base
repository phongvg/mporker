package com.keysoft.pigfarm.production.json;

import java.math.BigDecimal;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JsonSalesDetail {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@JsonProperty("WADAT_IST")
	private LocalDate postingDate;
	@JsonProperty("WERKS")
	private String plant;
	@JsonProperty("LGORT")
	private String farmCode;
	@JsonProperty("AUFNR")
	private String processOrderCode;
	@JsonProperty("CHARG")
	private String batch;
	@JsonProperty("MATNR")
	private String materialCode;
	@JsonProperty("LFIMG")
	private BigDecimal quantity;
	@JsonProperty("NTGEW")
	private BigDecimal weight;
	@JsonProperty("VRKME")
	private String unit;
	@JsonProperty("GEWEI")
	private String weightUnit;
	@JsonProperty("VTWEG")
	private BigDecimal distributionChannel;
	
}
