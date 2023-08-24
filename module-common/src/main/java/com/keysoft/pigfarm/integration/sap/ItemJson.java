package com.keysoft.pigfarm.integration.sap;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
public class ItemJson {
	@JsonProperty("rowid")
	private String rowId;
	@JsonProperty("info")
	private List<InfoJson> infoJsons;
}
