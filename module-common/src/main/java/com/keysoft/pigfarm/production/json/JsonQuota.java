package com.keysoft.pigfarm.production.json;


import java.time.LocalDate;
//import java.util.List;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL) 
public class JsonQuota {
	private Long id;
	private String processOrderCode;
	private boolean latest;
	private LocalDateTime createdDate;
	@JsonProperty("code")
  	private String materialCode;
	@JsonProperty("name")
  	private String materialName;
	@JsonProperty("quantity")
  	private Integer quantity;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonProperty("requestDate")
 	private LocalDate requestDate;
	@JsonProperty("batch")
 	private String batch ;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonProperty("manufacturedDate")
 	private LocalDate  manufacturedDate;	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
	@JsonProperty("expiredDate")
	private LocalDate  expiredDate;

}
