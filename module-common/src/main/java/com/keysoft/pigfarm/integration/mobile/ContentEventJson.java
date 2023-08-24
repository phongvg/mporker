package com.keysoft.pigfarm.integration.mobile;

import java.math.BigDecimal;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ContentEventJson {
	@JsonProperty("reason")
	private String reason;
	
	@JsonProperty("code")
	private String materialCode;
	
	@JsonProperty("quantity")
	private BigDecimal quantity;
	
	@JsonProperty("weight")
	private BigDecimal weight;
	
	@JsonProperty("postingDate")
	private String postingDate;
	
	@JsonProperty("averageWeight")
	private BigDecimal averageWeight;

	@JsonProperty("weightCharts")
	private List<WeightChartJson> weightCharts;
}
