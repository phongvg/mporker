package com.keysoft.pigfarm.common.util;

import java.util.List;

import lombok.Data;

@Data
public class FancyTree {
	private String title;
	private String key;
	private boolean folder;
	private boolean selected;
	private List<?> children;
}