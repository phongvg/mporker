package com.keysoft.pigfarm.integration.sap;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PigfarmJson {
	@JsonProperty("bapirfc")
	private String bapirfc;
	@JsonProperty("import")
	private ImportJson importJson;
	@JsonProperty("export")
	private ExportJson exportJson;
	@JsonProperty("tables")
	private TableJson tableJson;

	private String transCode;
	@JsonIgnore
	private String type;
	@JsonIgnore
	private String processOrderCode;
	@JsonIgnore
	private List<String> materialTransCodes;
}
