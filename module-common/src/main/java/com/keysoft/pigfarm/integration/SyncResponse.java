package com.keysoft.pigfarm.integration;

import java.io.Serializable;

import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
public class SyncResponse implements Serializable {
	private String status;
	private String message;
}
