package com.keysoft.pigfarm.production.json;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class JsonGoodsRequisition {
	@JsonProperty("stockcode")
	private String stockCode;
	
	@JsonProperty("farmcode")
	private String farmCode;
	
	@JsonProperty("farmcoder")
	private String toStockCode;
	
	@JsonProperty("farmcodei")
	private String fromStockCode;
	
	@JsonProperty("customer")
	private String customer;
	
	@JsonProperty("customert")
	private String customerName;
	
	@JsonProperty("vendor")
	private String vendor;
	
	@JsonProperty("vendort")
	private String vendorName;
	
	@JsonProperty("docode")
	private String doCode;
	
	@JsonProperty("prcode")
	private String prCode;
	
	@JsonProperty("pocode")
	private String poCode;
	
	@JsonProperty("costcenter")
	private String costCenter;
	
	@JsonProperty("reason")
	private String reason;
	
	@JsonProperty("plant")
	private String plant;
	
	@JsonProperty("planti")
	private String planti;  //sloc xuat
	
	@JsonProperty("plantr")
	private String plantr; //sloc nhan
	
	@JsonProperty("movementtype")
	private String movementType;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyyMMdd")
	@JsonProperty("postingdate")
	private LocalDate postingDate;
	
	@JsonProperty("status")
	private String status;
	
	@JsonProperty("prgroupcode")
	private String prGroupCode;

	@JsonProperty("prtype")
	private String prType;
	
	@JsonProperty("requisitioner")
	private String requisitioner;
	
	@JsonProperty("materials")
	private List<JsonMaterial> materials = new ArrayList<>();
	
	@JsonProperty("transcode")
	private String transCode;
	
	@JsonProperty("type")
	private String grType;
	
	@JsonIgnore
	private String type;
}
