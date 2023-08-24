package com.keysoft.pigfarm.helper;

import org.springframework.stereotype.Component;

import com.keysoft.pigfarm.common.SymbolEnum;

@Component
public class EventCodeHelper {
	private static final String PIG_CULLING = "pig_culling";
	private static final String PIG_DEAD = "pig_dead";
	private static final String WEIGHT_NOTE = "weight_note";
	private static final String FINISH_PRODUCT = "finish_product";
	
	public String getEventCodePigCulling(String processOrderCode) {
		return (new StringBuilder()).append(processOrderCode).append(SymbolEnum.DOT.val).append(PIG_CULLING).toString();
	}
	
	public String getEventCodePigDead(String processOrderCode) {
		return (new StringBuilder()).append(processOrderCode).append(SymbolEnum.DOT.val).append(PIG_DEAD).toString();
	}
	
	public String getEventCodeWeightNote(String processOrderCode)  {
		return (new StringBuilder()).append(processOrderCode).append(SymbolEnum.DOT.val).append(WEIGHT_NOTE).toString();
	}
	public String getEventCodePigProduction(String processOrderCode)  {
		return (new StringBuilder()).append(processOrderCode).append(SymbolEnum.DOT.val).append(FINISH_PRODUCT).toString();
	}
}
