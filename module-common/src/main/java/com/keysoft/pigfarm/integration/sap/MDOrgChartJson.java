package com.keysoft.pigfarm.integration.sap;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MDOrgChartJson {
	@JsonProperty("item")
	private List<OrgJson> orgJsons;
}
