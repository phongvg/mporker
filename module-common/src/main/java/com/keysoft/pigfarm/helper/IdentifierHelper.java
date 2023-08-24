package com.keysoft.pigfarm.helper;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import com.keysoft.pigfarm.common.DatePatternEnum;
import com.keysoft.pigfarm.common.SymbolEnum;

@Component
public class IdentifierHelper {
	private static final String PIG = "PIG";
	private static final String SOW = "SOW";
	private static final String MLP = "MLP";	// male pig
	private static final String SLP = "SLP";	// suckling pig
	private static final String RSP = "RSP";	// reserve pig
	
	public String getPigIdentifier(String group) {
		return (new StringBuilder()).append(PIG).append(SymbolEnum.DOT.val).append(group).append(SymbolEnum.DOT.val).append(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDDHHMMSS.pattern).format(LocalDateTime.now())).append(SymbolEnum.DOT.val).append(RandomStringUtils.randomNumeric(4)).toString();
	}
	
	public String getSowIdentifier(String earTag) {
		return (new StringBuilder()).append(SOW).append(SymbolEnum.DOT.val).append(earTag).append(SymbolEnum.DOT.val).append(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDDHHMMSS.pattern).format(LocalDateTime.now())).append(SymbolEnum.DOT.val).append(RandomStringUtils.randomNumeric(4)).toString();
	}
	
	public String getSucklingPigIdentifier(String group) {
		return (new StringBuilder()).append(SLP).append(SymbolEnum.DOT.val).append(group).append(SymbolEnum.DOT.val).append(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDDHHMMSS.pattern).format(LocalDateTime.now())).append(SymbolEnum.DOT.val).append(RandomStringUtils.randomNumeric(4)).toString();
	}
	
	public String getReservePigIdentifier(String group) {
		return (new StringBuilder()).append(RSP).append(SymbolEnum.DOT.val).append(group).append(SymbolEnum.DOT.val).append(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDDHHMMSS.pattern).format(LocalDateTime.now())).append(SymbolEnum.DOT.val).append(RandomStringUtils.randomNumeric(4)).toString();
	}
	
	public String getMalePigIdentifier(String earTag) {
		return (new StringBuilder()).append(MLP).append(SymbolEnum.DOT.val).append(earTag).append(SymbolEnum.DOT.val).append(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDDHHMMSS.pattern).format(LocalDateTime.now())).append(SymbolEnum.DOT.val).append(RandomStringUtils.randomNumeric(4)).toString();
	}
}
