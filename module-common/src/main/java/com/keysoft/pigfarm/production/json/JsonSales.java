package com.keysoft.pigfarm.production.json;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class JsonSales {
	@JsonProperty("item")
	private List<JsonSalesDetail> jsonSalesDetails;
}
