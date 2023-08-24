package com.keysoft.pigfarm.integration.sap;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.keysoft.pigfarm.production.json.JsonMaterial;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class StockJson {
	@JsonProperty("stockcode")
	private String stockCode;
	
	@JsonProperty("farmcode")
	private String farmCode;
	
	@JsonProperty("plant")
	private String plant;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@JsonProperty("postingdate")
	private LocalDate postingDate;
	
	@JsonProperty("materials")
	private List<JsonMaterial> materials = new ArrayList<>();
}
