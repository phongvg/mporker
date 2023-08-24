package com.keysoft.pigfarm.integration;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class EntityResponse implements Serializable {
	private String code;
	private String message;
	
	private Object data;
}
