package com.keysoft.pigfarm.helper;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import com.keysoft.pigfarm.production.dto.*;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keysoft.pigfarm.common.DatePatternEnum;
import com.keysoft.pigfarm.common.GoodsAttritionTypeEnum;
import com.keysoft.pigfarm.common.ProcessOrderStatusEnum;
import com.keysoft.pigfarm.common.SymbolEnum;
import com.keysoft.pigfarm.integration.sap.ImportJson;
import com.keysoft.pigfarm.integration.sap.InfoJson;
import com.keysoft.pigfarm.integration.sap.ItemJson;
import com.keysoft.pigfarm.integration.sap.MapKeyApiEnum;
import com.keysoft.pigfarm.integration.sap.PigfarmJson;
import com.keysoft.pigfarm.integration.sap.TableJson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertJsonSapHelper {
	private ConvertJsonSapHelper() {
		throw new IllegalStateException("Convert Json SAP class");
	}
	
	
	/*
	 * Convert dữ liệu PROCESS_ORDER -> JSON gửi lên SAP: Function CLOSED
	 */
	public static  PigfarmJson convertProcessOrderSendToSAPFunctionClosed(String processOrderCode) {
		log.info("PROCESS: CONVERT PROCESS_ORDER TO JSON SEND TO SAP - FUNCTION CLOSED");
		PigfarmJson pigfarmJson = new PigfarmJson();
		pigfarmJson.setProcessOrderCode(processOrderCode);
		pigfarmJson.setBapirfc(MapKeyApiEnum.ZFM_PP_8024.val);
		ImportJson importJson = new ImportJson();
		List<InfoJson> importInfoJsons = new ArrayList<>();
		
		InfoJson poInfoJson = new InfoJson();
		poInfoJson.setFieldname(MapKeyApiEnum.PROCESS_ORDER_CODE.val);
		poInfoJson.setValue(processOrderCode);
		importInfoJsons.add(poInfoJson);
		
		InfoJson infoJson = new InfoJson();
		infoJson.setFieldname(MapKeyApiEnum.FINCONF.val);
		infoJson.setValue(MapKeyApiEnum.FINCONF_VALUE.val);
		importInfoJsons.add(infoJson);
		
		InfoJson postingDateInfoJson = new InfoJson();
		postingDateInfoJson.setFieldname(MapKeyApiEnum.DATE.val);
		LocalDate today = LocalDate.now();
		postingDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(today));
		importInfoJsons.add(postingDateInfoJson);
		
		importJson.setInfoJsons(importInfoJsons);
		pigfarmJson.setImportJson(importJson);
		
		return pigfarmJson;
	}
	
	/*
	 * Convert dữ liệu PROCESS_ORDER -> JSON gửi lên SAP
	 */
	public static PigfarmJson convertProcessOrderSendToSAP(ProcessOrderDto processOrder) {
		log.info("PROCESS: CONVERT PROCESS_ORDER TO JSON SEND TO SAP");
		PigfarmJson processOrderJson = new PigfarmJson();
		processOrderJson.setBapirfc(MapKeyApiEnum.ZFM_PP8014.val);
		processOrderJson.setTransCode(processOrder.getTransCode());
		ImportJson importJson = new ImportJson();
		List<InfoJson> importInfoJsons = new ArrayList<>();
		
		InfoJson transCodeInfoJson = new InfoJson();
		transCodeInfoJson.setFieldname(MapKeyApiEnum.TRANS_CODE.val);
		transCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(processOrder.getTransCode())) {
			transCodeInfoJson.setValue(processOrder.getTransCode());
		}
		importInfoJsons.add(transCodeInfoJson);
		
		InfoJson pigTypeInfoJson = new InfoJson();
		pigTypeInfoJson.setFieldname(MapKeyApiEnum.PIG_TYPE.val);
		pigTypeInfoJson.setValue("");
		if(StringUtils.isNotBlank(processOrder.getPigType())) {
			pigTypeInfoJson.setValue(processOrder.getPigType());
		}
		importInfoJsons.add(pigTypeInfoJson);
		
		InfoJson processOrderInfoJson = new InfoJson();
		processOrderInfoJson.setFieldname(MapKeyApiEnum.PROCESS_ORDER_CODE.val);
		processOrderInfoJson.setValue("");
		if(StringUtils.isNotBlank(processOrder.getCode())) {
			processOrderInfoJson.setValue(processOrder.getCode());
		}
		importInfoJsons.add(processOrderInfoJson);
		
		InfoJson quantityInfoJson = new InfoJson();
		quantityInfoJson.setFieldname(MapKeyApiEnum.QUANTITY.val);
		quantityInfoJson.setValue("");
		if(processOrder.getRealQuantity() != null) {
			quantityInfoJson.setValue(String.valueOf(processOrder.getRealQuantity()));
		}
		importInfoJsons.add(quantityInfoJson);
		
		
		InfoJson barnCodeInfoJson = new InfoJson();
		barnCodeInfoJson.setFieldname(MapKeyApiEnum.BARN_CODE.val);
		barnCodeInfoJson.setValue("");
		InfoJson plantInfoJson = new InfoJson();
		plantInfoJson.setFieldname(MapKeyApiEnum.PLANT.val);
		plantInfoJson.setValue("");
		InfoJson farmInfoJson = new InfoJson();
		farmInfoJson.setFieldname(MapKeyApiEnum.FARM_CODE.val);
		farmInfoJson.setValue("");
		
		if(processOrder.getBarn() != null) {
			barnCodeInfoJson.setValue(processOrder.getBarn().getCode());
			String farmCode = processOrder.getBarn().getFarm().getCode();
			if(StringUtils.isNotBlank(farmCode)) {
				String[] arr = StringUtils.split(farmCode, SymbolEnum.DOT.val);
				if(arr.length >= 2) {
					plantInfoJson.setValue(arr[0]);
					farmInfoJson.setValue(arr[1]);
				}
			}
		}
		importInfoJsons.add(barnCodeInfoJson);
		importInfoJsons.add(plantInfoJson);
		importInfoJsons.add(farmInfoJson);
		
		InfoJson realStartDateInfoJson = new InfoJson();
		realStartDateInfoJson.setFieldname(MapKeyApiEnum.START_DATE.val);
		realStartDateInfoJson.setValue("");
		if(processOrder.getRealStartDate() != null) {
			realStartDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(processOrder.getRealStartDate()));
		}
		importInfoJsons.add(realStartDateInfoJson);
		
		InfoJson realEndDateInfoJson = new InfoJson();
		realEndDateInfoJson.setFieldname(MapKeyApiEnum.END_DATE.val);
		realEndDateInfoJson.setValue("");
		if(processOrder.getRealEndDate() != null) {
			realEndDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(processOrder.getRealEndDate()));
		}
		importInfoJsons.add(realEndDateInfoJson);
		
		importJson.setInfoJsons(importInfoJsons);
		processOrderJson.setImportJson(importJson);
		
		return processOrderJson;
	}
	
	/*
	 * Convert dữ liệu PIG_ENTRY -> JSON gửi lên SAP
	 */
	public static PigfarmJson convertPigEntrySendToSAP(ProcessOrderDto processOrder, PigEntryDto pigEntryDto) {
		log.info("PROCESS: CONVERT PIG_ENTRY TO JSON SEND TO SAP");
		PigfarmJson pigEntryJson = new PigfarmJson();
		pigEntryJson.setBapirfc(MapKeyApiEnum.ZFM_PP8014.val);
		pigEntryJson.setTransCode(pigEntryDto.getTransCode());
		ImportJson importJson = new ImportJson();
		List<InfoJson> importInfoJsons = new ArrayList<>();
		
		InfoJson transCodeInfoJson = new InfoJson();
		transCodeInfoJson.setFieldname(MapKeyApiEnum.TRANS_CODE.val);
		transCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(pigEntryDto.getTransCode())) {
			transCodeInfoJson.setValue(pigEntryDto.getTransCode());
		}
		importInfoJsons.add(transCodeInfoJson);
		
		InfoJson pigTypeInfoJson = new InfoJson();
		pigTypeInfoJson.setFieldname(MapKeyApiEnum.PIG_TYPE.val);
		pigTypeInfoJson.setValue("");
		if(StringUtils.isNotBlank(pigEntryDto.getMaterialCode())) {
			pigTypeInfoJson.setValue(pigEntryDto.getMaterialCode());
		}
		importInfoJsons.add(pigTypeInfoJson);
		
		InfoJson processOrderInfoJson = new InfoJson();
		processOrderInfoJson.setFieldname(MapKeyApiEnum.PROCESS_ORDER_CODE.val);
		processOrderInfoJson.setValue("");
		if(StringUtils.isNotBlank(processOrder.getCode())) {
			processOrderInfoJson.setValue(processOrder.getCode());
		}
		importInfoJsons.add(processOrderInfoJson);
		
		InfoJson quantityInfoJson = new InfoJson();
		quantityInfoJson.setFieldname(MapKeyApiEnum.QUANTITY.val);
		quantityInfoJson.setValue("");
		if(processOrder.getRealQuantity() != null) {
			quantityInfoJson.setValue(String.valueOf(processOrder.getRealQuantity()));
		}
		importInfoJsons.add(quantityInfoJson);
		
		
		InfoJson barnCodeInfoJson = new InfoJson();
		barnCodeInfoJson.setFieldname(MapKeyApiEnum.BARN_CODE.val);
		barnCodeInfoJson.setValue("");
		InfoJson plantInfoJson = new InfoJson();
		plantInfoJson.setFieldname(MapKeyApiEnum.PLANT.val);
		plantInfoJson.setValue("");
		InfoJson farmInfoJson = new InfoJson();
		farmInfoJson.setFieldname(MapKeyApiEnum.FARM_CODE.val);
		farmInfoJson.setValue("");
		
		if(processOrder.getBarn() != null) {
			barnCodeInfoJson.setValue(processOrder.getBarn().getCode());
			String farmCode = processOrder.getBarn().getFarm().getCode();
			if(StringUtils.isNotBlank(farmCode)) {
				String[] arr = StringUtils.split(farmCode, SymbolEnum.DOT.val);
				if(arr.length >= 2) {
					plantInfoJson.setValue(arr[0]);
					farmInfoJson.setValue(arr[1]);
				}
			}
		}
		importInfoJsons.add(barnCodeInfoJson);
		importInfoJsons.add(plantInfoJson);
		importInfoJsons.add(farmInfoJson);
		
		InfoJson realStartDateInfoJson = new InfoJson();
		realStartDateInfoJson.setFieldname(MapKeyApiEnum.START_DATE.val);
		realStartDateInfoJson.setValue("");
		if(processOrder.getRealStartDate() != null) {
			realStartDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(processOrder.getRealStartDate()));
		}
		importInfoJsons.add(realStartDateInfoJson);
		
		InfoJson realEndDateInfoJson = new InfoJson();
		realEndDateInfoJson.setFieldname(MapKeyApiEnum.END_DATE.val);
		realEndDateInfoJson.setValue("");
		if(processOrder.getRealEndDate() != null) {
			realEndDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(processOrder.getRealEndDate()));
		}
		importInfoJsons.add(realEndDateInfoJson);
		
		InfoJson entryDateInfoJson = new InfoJson();
		entryDateInfoJson.setFieldname(MapKeyApiEnum.POSTING_DATE.val);
		entryDateInfoJson.setValue("");
		if(pigEntryDto.getEntryDate() != null) {
			entryDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(pigEntryDto.getEntryDate()));
		}
		importInfoJsons.add(entryDateInfoJson);
		
		importJson.setInfoJsons(importInfoJsons);
		pigEntryJson.setImportJson(importJson);
		
		return pigEntryJson;
	}
	
	/*
	 * Convert dữ liệu PROCESS_ORDER -> JSON gửi lên SAP  - Function CLOSED
	 */
	public static  PigfarmJson convertProcessOrderSendToSAPFunctionClosed(ProcessOrderDto processOrder) {
		log.info("PROCESS: CONVERT PROCESS_ORDER TO JSON SEND TO SAP FUNCTION CLOSED");
		PigfarmJson pigfarmJson = new PigfarmJson();
		pigfarmJson.setProcessOrderCode(processOrder.getCode());
		pigfarmJson.setTransCode(processOrder.getTransCode());
		pigfarmJson.setBapirfc(MapKeyApiEnum.ZFM_PP_8024.val);
		ImportJson importJson = new ImportJson();
		List<InfoJson> importInfoJsons = new ArrayList<>();
		
		InfoJson poInfoJson = new InfoJson();
		poInfoJson.setFieldname(MapKeyApiEnum.PROCESS_ORDER_CODE.val);
		poInfoJson.setValue(processOrder.getCode());
		importInfoJsons.add(poInfoJson);
		
		InfoJson infoJson = new InfoJson();
		infoJson.setFieldname(MapKeyApiEnum.FINCONF.val);
		infoJson.setValue(MapKeyApiEnum.FINCONF_VALUE.val);
		importInfoJsons.add(infoJson);
		
		InfoJson postingDateInfoJson = new InfoJson();
		postingDateInfoJson.setFieldname(MapKeyApiEnum.DATE.val);
		if(processOrder.getRealEndDate() != null) {
			postingDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(processOrder.getRealEndDate()));
		} else {
			LocalDate today = LocalDate.now();
			postingDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(today));
		}
		importInfoJsons.add(postingDateInfoJson);
		importJson.setInfoJsons(importInfoJsons);
		pigfarmJson.setImportJson(importJson);
		return pigfarmJson;
	}
	
	/*
	 * Convert dữ liệu BARN_PLAN -> JSON gửi lên SAP
	 */
	public static PigfarmJson convertBarnPlanSendToSAP(BarnPlanDto barnPlan) {
		log.info("PROCESS: CONVERT BARN_PLAN TO JSON SEND TO SAP");
		PigfarmJson barnPlanJson = new PigfarmJson();
			barnPlanJson.setBapirfc(MapKeyApiEnum.ZFM_PP_8006.val);
			TableJson tableJson = new TableJson();
			tableJson.setName(MapKeyApiEnum.ITEMS.val);
			List<ItemJson> itemJsons = new ArrayList<>();
			AtomicInteger index = new AtomicInteger();
			
			ItemJson itemJson = new ItemJson();
			List<InfoJson> itemInfoJsons = new ArrayList<>();  
			itemJson.setRowId(String.valueOf(index.getAndIncrement()));
			
			InfoJson transCodeInfoJson = new InfoJson();
			transCodeInfoJson.setFieldname(MapKeyApiEnum.TRANS_CODE.val);
			transCodeInfoJson.setValue("");
			if(StringUtils.isNotBlank(barnPlan.getTransCode())) {
				transCodeInfoJson.setValue(barnPlan.getTransCode());
			}
			itemInfoJsons.add(transCodeInfoJson);
			
			InfoJson barnCodeInfoJson = new InfoJson();
			barnCodeInfoJson.setFieldname(MapKeyApiEnum.BARN_CODE.val);
			barnCodeInfoJson.setValue("");
			if(barnPlan.getBarn() != null) {
				barnCodeInfoJson.setValue(barnPlan.getBarn().getCode());
			}
			itemInfoJsons.add(barnCodeInfoJson);
			
			InfoJson realBarnEmptyDateInfoJson = new InfoJson();
			realBarnEmptyDateInfoJson.setFieldname(MapKeyApiEnum.BARN_EMPTY_DATE.val);
			realBarnEmptyDateInfoJson.setValue("");
			if(barnPlan.getRealBarnEmptyDate() != null) {
				realBarnEmptyDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(barnPlan.getRealBarnEmptyDate()));
			}
			itemInfoJsons.add(realBarnEmptyDateInfoJson);
			
			InfoJson pigTypeInfoJson = new InfoJson();
			pigTypeInfoJson.setFieldname(MapKeyApiEnum.PIG_TYPE.val);
			pigTypeInfoJson.setValue("");
			if(StringUtils.isNotBlank(barnPlan.getPigType())) {
				pigTypeInfoJson.setValue(barnPlan.getPigType());
			}
			itemInfoJsons.add(pigTypeInfoJson);
			
			InfoJson realBarnVolumnInfoJson = new InfoJson();
			realBarnVolumnInfoJson.setFieldname(MapKeyApiEnum.BARN_VOLUMN.val);
			realBarnVolumnInfoJson.setValue("");
			if(barnPlan.getRealBarnVolumn() != null) {
				realBarnVolumnInfoJson.setValue(String.valueOf(barnPlan.getRealBarnVolumn()));
			}
			itemInfoJsons.add(realBarnVolumnInfoJson);
			
			itemJson.setInfoJsons(itemInfoJsons);
			itemJsons.add(itemJson);
			tableJson.setItemJsons(itemJsons);
			barnPlanJson.setTableJson(tableJson);
		return barnPlanJson;
	}
	
	/*
	 * Convert dữ liệu FINISH_PRODUCTION -> JSON gửi lên SAP
	 */
	public static PigfarmJson convertFinishProductionSendToSap(GoodsReceiptDto goodsReceipt){
		log.info("PROCESS: CONVERT FINISH_PRODUCTION TO JSON SEND TO SAP");
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PigfarmJson pigfarmJson = new PigfarmJson();
		pigfarmJson.setTransCode(goodsReceipt.getTransCode());
		pigfarmJson.setBapirfc(MapKeyApiEnum.ZFM_NTPFSHOPFLOOR_IF.val);
		ImportJson importJson = new ImportJson();
		List<InfoJson> importInfoJsons = new ArrayList<>();
		TableJson tableJson = new TableJson();
		
		InfoJson transCodeInfoJson = new InfoJson();
		transCodeInfoJson.setFieldname(MapKeyApiEnum.TRANS_CODE.val);
		transCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsReceipt.getTransCode())) {
			transCodeInfoJson.setValue(goodsReceipt.getTransCode());
		}
		importInfoJsons.add(transCodeInfoJson);
		
		InfoJson processOrderInfoJson = new InfoJson();
		processOrderInfoJson.setFieldname(MapKeyApiEnum.PROCESS_ORDER_CODE.val);
		processOrderInfoJson.setValue("");
		InfoJson batchInfoJson = new InfoJson();
		batchInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_BATCH.val);
		batchInfoJson.setValue("");
		if(goodsReceipt.getProduction() != null) {
			processOrderInfoJson.setValue(goodsReceipt.getProduction().getProcessOrderCode());
		}
		importInfoJsons.add(processOrderInfoJson);
		importInfoJsons.add(batchInfoJson);
		
		InfoJson plantInfoJson = new InfoJson();
		plantInfoJson.setFieldname(MapKeyApiEnum.PLANT.val);
		plantInfoJson.setValue("");
		InfoJson farmCodeInfoJson = new InfoJson();
		farmCodeInfoJson.setFieldname(MapKeyApiEnum.FARM_CODE.val);
		farmCodeInfoJson.setValue("");
		if(goodsReceipt.getStock() != null) {
			String code = goodsReceipt.getStock().getCode();
			String[] arr = StringUtils.split(code, SymbolEnum.DOT.val);
			if(arr.length >= 2) {
				plantInfoJson.setValue(arr[0]);
				farmCodeInfoJson.setValue(arr[1]);
			} 
		}
		importInfoJsons.add(plantInfoJson);
		importInfoJsons.add(farmCodeInfoJson);
		
		
		InfoJson createdByInfoJson = new InfoJson();
		createdByInfoJson.setFieldname(MapKeyApiEnum.CREATED_BY.val);
		createdByInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsReceipt.getCreatedBy())) {
			createdByInfoJson.setValue(goodsReceipt.getCreatedBy());
		}
		importInfoJsons.add(createdByInfoJson);
		
		InfoJson postingDateInfoJson = new InfoJson();
		postingDateInfoJson.setFieldname(MapKeyApiEnum.POSTING_DATE.val);
		postingDateInfoJson.setValue("");
		if(goodsReceipt.getPostingDate() != null) {
			postingDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(goodsReceipt.getPostingDate()));
		}
		importInfoJsons.add(postingDateInfoJson);
		
		importJson.setInfoJsons(importInfoJsons);
		pigfarmJson.setImportJson(importJson);
		
		if(!CollectionUtils.isEmpty(goodsReceipt.getMaterialDetails())) {
			MaterialDetailDto materialDto = goodsReceipt.getMaterialDetails().get(0);
			if(StringUtils.isNotBlank(materialDto.getBatch())) {
				batchInfoJson.setValue(materialDto.getBatch()); 
			}
			tableJson.setName(MapKeyApiEnum.MATERIALS.val);
			List<ItemJson> itemJsons = new ArrayList<>();
			List<InfoJson> itemInfoJsons = new ArrayList<>();
			ItemJson itemJson = new ItemJson();
			itemJson.setRowId("0");
			
			InfoJson codeInfoJson = new InfoJson();
			codeInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_CODE.val);
			codeInfoJson.setValue("");
			if(StringUtils.isNotBlank(materialDto.getCode())) {
				codeInfoJson.setValue(materialDto.getCode());
			}
			itemInfoJsons.add(codeInfoJson);
			
			InfoJson unitInfoJson = new InfoJson();
			unitInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_UNIT.val);
			unitInfoJson.setValue("");
			if(StringUtils.isNotBlank(materialDto.getUnit())) {
				unitInfoJson.setValue(materialDto.getUnit());
			}
			itemInfoJsons.add(unitInfoJson);
			
			InfoJson quantityInfoJson = new InfoJson();
			quantityInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_QUANTITY.val);
			quantityInfoJson.setValue("");
			if(materialDto.getActuallyImported() != null) {
				quantityInfoJson.setValue(String.valueOf(materialDto.getActuallyImported().intValue()));
			}
			itemInfoJsons.add(quantityInfoJson);
			itemJson.setInfoJsons(itemInfoJsons);
			itemJsons.add(itemJson);
			tableJson.setItemJsons(itemJsons);
		}
		pigfarmJson.setTableJson(tableJson);
		return pigfarmJson;
	}
	
	/*
	 * Convert dữ liệu PURCHASE_REQUISITION -> JSON gửi lên SAP
	 */
	public static PigfarmJson convertPurchaseRequisitionToJson(PurchaseRequisitionDto purchaseRequisition){
		log.info("PROCESS: CONVERT PURCHASE_REQUISITION TO JSON SEND TO SAP");
		PigfarmJson pigfarmJson = new PigfarmJson();
		pigfarmJson.setBapirfc(MapKeyApiEnum.ZFM_PRFSHOPFLOOR_IF.val);
		ImportJson importJson = new ImportJson();
		List<InfoJson> importInfoJsons = new ArrayList<>();
		TableJson tableJson = new TableJson();
		
		InfoJson transCodeInfoJson = new InfoJson();
		transCodeInfoJson.setFieldname(MapKeyApiEnum.TRANS_CODE.val);
		transCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(purchaseRequisition.getTransCode())) {
			transCodeInfoJson.setValue(purchaseRequisition.getTransCode());
		}
		importInfoJsons.add(transCodeInfoJson);
		
		InfoJson requisitionerInfoJson = new InfoJson();
		requisitionerInfoJson.setFieldname(MapKeyApiEnum.REQUISITIONER.val);
		requisitionerInfoJson.setValue("");
		if(StringUtils.isNotBlank(purchaseRequisition.getRequisitioner())) {
			requisitionerInfoJson.setValue(purchaseRequisition.getRequisitioner());
		}
		importInfoJsons.add(requisitionerInfoJson);
		
		InfoJson prGroupCodeInfoJson = new InfoJson();
		prGroupCodeInfoJson.setFieldname(MapKeyApiEnum.PR_GROUP_CODE.val);
		prGroupCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(purchaseRequisition.getPrGroupCode())) {
			prGroupCodeInfoJson.setValue(purchaseRequisition.getPrGroupCode());
		}
		importInfoJsons.add(prGroupCodeInfoJson);
		
		InfoJson prTypeInfoJson = new InfoJson();
		prTypeInfoJson.setFieldname(MapKeyApiEnum.PR_TYPE.val);
		prTypeInfoJson.setValue("");
		if(StringUtils.isNotBlank(purchaseRequisition.getPrType())) {
			prTypeInfoJson.setValue(purchaseRequisition.getPrType());
		}
		importInfoJsons.add(prTypeInfoJson);
		
		InfoJson plantInfoJson = new InfoJson();
		plantInfoJson.setFieldname(MapKeyApiEnum.PLANT.val);
		plantInfoJson.setValue("");
		InfoJson farmInfoJson = new InfoJson();
		farmInfoJson.setFieldname(MapKeyApiEnum.FARM_CODE.val);
		farmInfoJson.setValue("");
		if(StringUtils.isNotBlank(purchaseRequisition.getStock().getCode())) {
			String[] arr = StringUtils.split(purchaseRequisition.getStock().getCode(), SymbolEnum.DOT.val);
			if(arr.length >= 2) {
				farmInfoJson.setValue(arr[1]);
				plantInfoJson.setValue(arr[0]);
			}
		}
		importInfoJsons.add(plantInfoJson);
		importInfoJsons.add(farmInfoJson);
		
		importJson.setInfoJsons(importInfoJsons);
		pigfarmJson.setImportJson(importJson);
		
		if(!CollectionUtils.isEmpty(purchaseRequisition.getMaterialDetails())) {
			tableJson.setName(MapKeyApiEnum.MATERIALS.val);
			List<ItemJson> itemJsons = new ArrayList<>();
			AtomicInteger index = new AtomicInteger();
			purchaseRequisition.getMaterialDetails().stream().forEach(material ->{
				List<InfoJson> itemInfoJsons = new ArrayList<>();
				ItemJson itemJson = new ItemJson();
				itemJson.setRowId(String.valueOf(index.getAndIncrement()));
				
				InfoJson codeInfoJson = new InfoJson();
				codeInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_CODE.val);
				codeInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getCode())) {
					codeInfoJson.setValue(material.getCode());
				}
				itemInfoJsons.add(codeInfoJson);
				
				InfoJson nameInfoJson = new InfoJson();
				nameInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_NAME.val);
				nameInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getName())) {
					nameInfoJson.setValue(material.getName());
				}
				itemInfoJsons.add(nameInfoJson);
				
				InfoJson groupNameInfoJson = new InfoJson();
				groupNameInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_GROUP_NAME.val);
				groupNameInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getGroupName())) {
					groupNameInfoJson.setValue(material.getGroupName());
				}
				itemInfoJsons.add(groupNameInfoJson);
				
				InfoJson groupCodeInfoJson = new InfoJson();
				groupCodeInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_GROUP_CODE.val);
				groupCodeInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getGroupCode())) {
					groupCodeInfoJson.setValue(material.getGroupCode());
				}
				itemInfoJsons.add(groupCodeInfoJson);
				
				InfoJson unitInfoJson = new InfoJson();
				unitInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_UNIT.val);
				unitInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getUnit())) {
					unitInfoJson.setValue(material.getUnit());
				}
				itemInfoJsons.add(unitInfoJson);
				
				InfoJson orderUnitInfoJson = new InfoJson();
				orderUnitInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_ORDER_UNIT.val);
				orderUnitInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getOrderUnit())) {
					orderUnitInfoJson.setValue(material.getOrderUnit());
				}
				itemInfoJsons.add(orderUnitInfoJson);
				
				InfoJson quantityInfoJson = new InfoJson();
				quantityInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_QUANTITY.val);
				quantityInfoJson.setValue("");
				if(material.getQuantity() != null) {
					quantityInfoJson.setValue(String.valueOf(material.getQuantity()));
				}
				itemInfoJsons.add(quantityInfoJson);
				
				InfoJson totalRetainedInfoJson = new InfoJson();
				totalRetainedInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_TOTAL_RETAINED.val);
				totalRetainedInfoJson.setValue("");
				if(material.getRetained() != null) {
					totalRetainedInfoJson.setValue(String.valueOf(material.getRetained()));
				}
				itemInfoJsons.add(totalRetainedInfoJson);
				
				InfoJson amountEarlyStageInfoJson = new InfoJson();
				amountEarlyStageInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_AMOUNT_EARLY_STAGE.val);
				amountEarlyStageInfoJson.setValue("");
				if(material.getAmountEarlyStage() != null) {
					amountEarlyStageInfoJson.setValue(String.valueOf(material.getAmountEarlyStage()));
				}
				itemInfoJsons.add(amountEarlyStageInfoJson);
				
				InfoJson amountFinalStageInfoJson = new InfoJson();
				amountFinalStageInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_AMOUNT_FINAL_STAGE.val);
				amountFinalStageInfoJson.setValue("");
				if(material.getAmountFinalStage() != null) {
					amountFinalStageInfoJson.setValue(String.valueOf(material.getAmountFinalStage()));
				}
				itemInfoJsons.add(amountFinalStageInfoJson);
				
				InfoJson amountGoodsIssueInfoJson = new InfoJson();
				amountGoodsIssueInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_AMOUNT_GOODSISSUE.val);
				amountGoodsIssueInfoJson.setValue("");
				if(material.getAmountGoodsIssue() != null) {
					amountGoodsIssueInfoJson.setValue(String.valueOf(material.getAmountGoodsIssue()));
				}
				itemInfoJsons.add(amountGoodsIssueInfoJson);
				
				InfoJson amountGoodsReceiptInfoJson = new InfoJson();
				amountGoodsReceiptInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_AMOUNT_GOODSRECEIPT.val);
				amountGoodsReceiptInfoJson.setValue("");
				if(material.getAmountGoodsReceipt() != null) {
					amountGoodsReceiptInfoJson.setValue(String.valueOf(material.getAmountGoodsReceipt()));
				}
				itemInfoJsons.add(amountGoodsReceiptInfoJson);
				
				InfoJson itemTextInfoJson = new InfoJson();
				itemTextInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_ITEMTEXT.val);
				itemTextInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getNote())) {
					itemTextInfoJson.setValue(material.getNote());
				}
				itemInfoJsons.add(itemTextInfoJson);
				
				InfoJson deliveryDateInfoJson = new InfoJson();
				deliveryDateInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_DELIVERY_DATE.val);
				deliveryDateInfoJson.setValue("");
				if(material.getDeliveryDate() != null) {
					deliveryDateInfoJson.setValue(DateTimeHelper.toDateString(material.getDeliveryDate(), DatePatternEnum.YYYYMMDD.pattern));
				}
				itemInfoJsons.add(deliveryDateInfoJson);
				
				itemJson.setInfoJsons(itemInfoJsons);
				itemJsons.add(itemJson);
			});
			tableJson.setItemJsons(itemJsons);
		}
		pigfarmJson.setTableJson(tableJson);
		return pigfarmJson;
	}
	
	/*
	 * Convert dữ liệu GOODS_RECEIPT -> JSON gửi lên SAP
	 */
	public static PigfarmJson convertGoodsReceiptToJson(GoodsReceiptDto goodsReceipt){
		log.info("PROCESS: CONVERT GOODS_RECEIPT TO JSON SEND TO SAP");
		PigfarmJson pigfarmJson = new PigfarmJson();
		pigfarmJson.setBapirfc(MapKeyApiEnum.ZFM_GIGRFSHOPFLOOR_IF.val);
		ImportJson importJson = new ImportJson();
		List<InfoJson> importInfoJsons = new ArrayList<>();
		TableJson tableJson = new TableJson();
		
		InfoJson transCodeInfoJson = new InfoJson();
		transCodeInfoJson.setFieldname(MapKeyApiEnum.TRANS_CODE.val);
		transCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsReceipt.getTransCode())) {
			transCodeInfoJson.setValue(goodsReceipt.getTransCode());
		}
		importInfoJsons.add(transCodeInfoJson);
		
		InfoJson transTypeInfoJson = new InfoJson();
		transTypeInfoJson.setFieldname(MapKeyApiEnum.TRANS_TYPE.val);
		transTypeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsReceipt.getTransType())) {
			transTypeInfoJson.setValue(goodsReceipt.getTransType());
		}
		importInfoJsons.add(transTypeInfoJson);
		
		InfoJson deleteInfoJson = new InfoJson();
		deleteInfoJson.setFieldname(MapKeyApiEnum.DELETE.val);
		deleteInfoJson.setValue("");
		
		if(goodsReceipt.isMarkDel()) {
			deleteInfoJson.setValue("X");
		}
		importInfoJsons.add(deleteInfoJson);
		
		InfoJson plantGRInfoJson = new InfoJson();
		plantGRInfoJson.setFieldname(MapKeyApiEnum.PLANT_GR.val);
		plantGRInfoJson.setValue("");
		InfoJson farmGRInfoJson = new InfoJson();
		farmGRInfoJson.setFieldname(MapKeyApiEnum.FARM_CODE_GR.val);
		farmGRInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsReceipt.getToStockCode())) {
			String[] arr = StringUtils.split(goodsReceipt.getToStockCode(), SymbolEnum.DOT.val);
			if(arr.length >= 2) {
				plantGRInfoJson.setValue(arr[0]);
				farmGRInfoJson.setValue(arr[1]);
			} 
		}
		importInfoJsons.add(plantGRInfoJson);
		importInfoJsons.add(farmGRInfoJson);
		
		
		InfoJson plantGIInfoJson = new InfoJson();
		plantGIInfoJson.setFieldname(MapKeyApiEnum.PLANT_GI.val);
		plantGIInfoJson.setValue("");
		InfoJson farmGIInfoJson = new InfoJson();
		farmGIInfoJson.setFieldname(MapKeyApiEnum.FARM_CODE_GI.val);
		farmGIInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsReceipt.getFromStockCode())) {
			String[] arr = StringUtils.split(goodsReceipt.getStock().getCode(), SymbolEnum.DOT.val);
			if(arr.length >= 2) {
				plantGIInfoJson.setValue(arr[0]);
				farmGIInfoJson.setValue(arr[1]);
			} 
		}
		importInfoJsons.add(plantGIInfoJson);
		importInfoJsons.add(farmGIInfoJson);
		
		InfoJson postingDateInfoJson = new InfoJson();
		postingDateInfoJson.setFieldname(MapKeyApiEnum.POSTING_DATE.val);
		postingDateInfoJson.setValue("");
		if(goodsReceipt.getPostingDate() != null) {
			postingDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(goodsReceipt.getPostingDate()));
		}
		importInfoJsons.add(postingDateInfoJson);
		
		InfoJson poCodeInfoJson = new InfoJson();
		poCodeInfoJson.setFieldname(MapKeyApiEnum.PO_CODE.val);
		poCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsReceipt.getPoCode())) {
			poCodeInfoJson.setValue(goodsReceipt.getPoCode());
		}
		importInfoJsons.add(poCodeInfoJson);
		
		InfoJson licensePlateInfoJson = new InfoJson();
		licensePlateInfoJson.setFieldname(MapKeyApiEnum.LICENSE_PLATE.val);
		licensePlateInfoJson.setValue("");
		importInfoJsons.add(licensePlateInfoJson);
		
		InfoJson doCodeInfoJson = new InfoJson();
		doCodeInfoJson.setFieldname(MapKeyApiEnum.DO_CODE.val);
		doCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsReceipt.getDoCode())) {
			doCodeInfoJson.setValue(goodsReceipt.getDoCode());
		}
		importInfoJsons.add(doCodeInfoJson);
		
		InfoJson prCodeInfoJson = new InfoJson();
		prCodeInfoJson.setFieldname(MapKeyApiEnum.PR_CODE.val);
		prCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsReceipt.getPrCode())) {
			prCodeInfoJson.setValue(goodsReceipt.getPrCode());
		}
		importInfoJsons.add(prCodeInfoJson);
		
		InfoJson movementTypeInfoJson = new InfoJson();
		movementTypeInfoJson.setFieldname(MapKeyApiEnum.MOVEMENT_TYPE.val);
		movementTypeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsReceipt.getMovementType())) {
			movementTypeInfoJson.setValue(goodsReceipt.getMovementType());
		}
		importInfoJsons.add(movementTypeInfoJson);
		
		importJson.setInfoJsons(importInfoJsons);
		pigfarmJson.setImportJson(importJson);
		
		if(!CollectionUtils.isEmpty(goodsReceipt.getMaterialDetails())) {
			tableJson.setName(MapKeyApiEnum.MATERIALS.val);
			List<ItemJson> itemJsons = new ArrayList<>();
			AtomicInteger index = new AtomicInteger();
			goodsReceipt.getMaterialDetails().stream().forEach(material ->{
				material.setRowId(String.valueOf(index.getAndIncrement()));
				
				ItemJson itemJson = new ItemJson();
				List<InfoJson> itemInfoJsons = new ArrayList<>(); 
				itemJson.setRowId(material.getRowId());
				
				InfoJson codeInfoJson = new InfoJson();
				codeInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_CODE.val);
				codeInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getCode())) {
					codeInfoJson.setValue(material.getCode());
				}
				itemInfoJsons.add(codeInfoJson);
				
				InfoJson nameInfoJson = new InfoJson();
				nameInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_NAME.val);
				nameInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getName())) {
					nameInfoJson.setValue(material.getName());
				}
				itemInfoJsons.add(nameInfoJson);
				
				InfoJson groupNameInfoJson = new InfoJson();
				groupNameInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_GROUP_NAME.val);
				groupNameInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getGroupName())) {
					groupNameInfoJson.setValue(material.getGroupName());
				}
				itemInfoJsons.add(groupNameInfoJson);
				
				InfoJson groupCodeInfoJson = new InfoJson();
				groupCodeInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_GROUP_CODE.val);
				groupCodeInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getGroupCode())) {
					groupCodeInfoJson.setValue(material.getGroupCode());
				}
				itemInfoJsons.add(groupCodeInfoJson);
				
				InfoJson unitInfoJson = new InfoJson();
				unitInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_UNIT.val);
				unitInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getUnit())) {
					unitInfoJson.setValue(material.getUnit());
				}
				itemInfoJsons.add(unitInfoJson);
				
				InfoJson quantityInfoJson = new InfoJson();
				quantityInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_QUANTITY.val);
				quantityInfoJson.setValue("");
				if(material.getActuallyImported() != null) {
					quantityInfoJson.setValue(String.valueOf(material.getActuallyImported()));
				}
				itemInfoJsons.add(quantityInfoJson);
				
				InfoJson weightUnitInfoJson = new InfoJson();
				weightUnitInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_WEIGHT_UNIT.val);
				weightUnitInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getWeightUnit())) {
					weightUnitInfoJson.setValue(material.getWeightUnit());
				}
				itemInfoJsons.add(weightUnitInfoJson);
				
				InfoJson grossWeightInfoJson = new InfoJson();
				grossWeightInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_GROSS_WEIGHT.val);
				grossWeightInfoJson.setValue("");
				if(material.getGrossWeight() != null) {
					BigDecimal grossWeight = material.getGrossWeight().setScale(2);
					grossWeightInfoJson.setValue(String.valueOf(grossWeight));
				}
				itemInfoJsons.add(grossWeightInfoJson);
				
				InfoJson batchInfoJson = new InfoJson();
				batchInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_BATCH.val);
				batchInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getBatch())) {
					batchInfoJson.setValue(String.valueOf(material.getBatch()));
				}
				itemInfoJsons.add(batchInfoJson);
				
				InfoJson expiredDateInfoJson = new InfoJson();
				expiredDateInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_EXPIRED_DATE.val);
				expiredDateInfoJson.setValue("");
				if(material.getExpiredDate() != null) {
					expiredDateInfoJson.setValue(DateTimeHelper.toDateString(material.getExpiredDate(), DatePatternEnum.YYYYMMDD.pattern));
				}
				itemInfoJsons.add(expiredDateInfoJson);
				
				InfoJson manufacturedDateInfoJson = new InfoJson();
				manufacturedDateInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_MANUFACTURED_DATE.val);
				manufacturedDateInfoJson.setValue("");
				if(material.getManufacturedDate() != null) {
					manufacturedDateInfoJson.setValue(DateTimeHelper.toDateString(material.getManufacturedDate(), DatePatternEnum.YYYYMMDD.pattern));
				}
				itemInfoJsons.add(manufacturedDateInfoJson);
				
				InfoJson itemNumInfoJson = new InfoJson();
				itemNumInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_ITEM_NUM.val);
				itemNumInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getItemNum())) {
					itemNumInfoJson.setValue(material.getItemNum());
				}
				itemInfoJsons.add(itemNumInfoJson);
				
				InfoJson noteInfoJson = new InfoJson();
				noteInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_ITEMTEXT.val);
				noteInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getNote())) {
					noteInfoJson.setValue(material.getNote());
				}
				itemInfoJsons.add(noteInfoJson);
				
				InfoJson typeInfoJson = new InfoJson();
				typeInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_STORAGE_TYPE.val);
				typeInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getType())) {
					typeInfoJson.setValue(material.getType());
				}
				itemInfoJsons.add(typeInfoJson);
				
				itemJson.setInfoJsons(itemInfoJsons);
				itemJsons.add(itemJson);
			});
			tableJson.setItemJsons(itemJsons);
		}
		pigfarmJson.setTableJson(tableJson);
		
		return pigfarmJson;
	}
	
	/*
	 * Convert dữ liệu GOODS_ISSUE -> JSON gửi lên SAP
	 */
	public static PigfarmJson convertGoodsIssueToJson(GoodsIssueDto goodsIssue){
		log.info("PROCESS: CONVERT GOODS_ISSUE TO JSON SEND TO SAP");
		PigfarmJson pigfarmJson = new PigfarmJson();
		pigfarmJson.setBapirfc(MapKeyApiEnum.ZFM_GIGRFSHOPFLOOR_IF.val);
		ImportJson importJson = new ImportJson();
		List<InfoJson> importInfoJsons = new ArrayList<>();
		TableJson tableJson = new TableJson();
		
		InfoJson transCodeInfoJson = new InfoJson();
		transCodeInfoJson.setFieldname(MapKeyApiEnum.TRANS_CODE.val);
		transCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getTransCode())) {
			transCodeInfoJson.setValue(goodsIssue.getTransCode());
		}
		importInfoJsons.add(transCodeInfoJson);
		
		InfoJson transTypeInfoJson = new InfoJson();
		transTypeInfoJson.setFieldname(MapKeyApiEnum.TRANS_TYPE.val);
		transTypeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getTransType())) {
			transTypeInfoJson.setValue(goodsIssue.getTransType());
		}
		importInfoJsons.add(transTypeInfoJson);
		
		InfoJson deleteInfoJson = new InfoJson();
		deleteInfoJson.setFieldname(MapKeyApiEnum.DELETE.val);
		deleteInfoJson.setValue("");
		if(goodsIssue.getMarkDel()) {
			deleteInfoJson.setValue("X");
		}
		importInfoJsons.add(deleteInfoJson);
		
		InfoJson plantGRInfoJson = new InfoJson();
		plantGRInfoJson.setFieldname(MapKeyApiEnum.PLANT_GR.val);
		plantGRInfoJson.setValue("");
		InfoJson farmGRInfoJson = new InfoJson();
		farmGRInfoJson.setFieldname(MapKeyApiEnum.FARM_CODE_GR.val);
		farmGRInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getToStockCode())) {
			String[] arr = StringUtils.split(goodsIssue.getToStockCode(), SymbolEnum.DOT.val);
			if(arr.length >= 2) {
				plantGRInfoJson.setValue(arr[0]);
				farmGRInfoJson.setValue(arr[1]);
			} 
		}
		importInfoJsons.add(plantGRInfoJson);
		importInfoJsons.add(farmGRInfoJson);
		
		
		InfoJson plantGIInfoJson = new InfoJson();
		plantGIInfoJson.setFieldname(MapKeyApiEnum.PLANT_GI.val);
		plantGIInfoJson.setValue("");
		InfoJson farmGIInfoJson = new InfoJson();
		farmGIInfoJson.setFieldname(MapKeyApiEnum.FARM_CODE_GI.val);
		farmGIInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getFromStockCode())) {
			String[] arr = StringUtils.split(goodsIssue.getStock().getCode(), SymbolEnum.DOT.val);
			if(arr.length >= 2) {
				plantGIInfoJson.setValue(arr[0]);
				farmGIInfoJson.setValue(arr[1]);
			} 
		}
		importInfoJsons.add(plantGIInfoJson);
		importInfoJsons.add(farmGIInfoJson);
		
		InfoJson postingDateInfoJson = new InfoJson();
		postingDateInfoJson.setFieldname(MapKeyApiEnum.POSTING_DATE.val);
		postingDateInfoJson.setValue("");
		if(goodsIssue.getPostingDate() != null) {
			postingDateInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(goodsIssue.getPostingDate()));
		}
		importInfoJsons.add(postingDateInfoJson);
		
		InfoJson poCodeInfoJson = new InfoJson();
		poCodeInfoJson.setFieldname(MapKeyApiEnum.PO_CODE.val);
		poCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getPoCode())) {
			poCodeInfoJson.setValue(goodsIssue.getPoCode());
		}
		importInfoJsons.add(poCodeInfoJson);
		
		InfoJson licensePlateInfoJson = new InfoJson();
		licensePlateInfoJson.setFieldname(MapKeyApiEnum.LICENSE_PLATE.val);
		licensePlateInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getLicensePlate())) {
			licensePlateInfoJson.setValue(goodsIssue.getLicensePlate());
		}
		importInfoJsons.add(licensePlateInfoJson);
		
		InfoJson doCodeInfoJson = new InfoJson();
		doCodeInfoJson.setFieldname(MapKeyApiEnum.DO_CODE.val);
		doCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getDoCode())) {
			doCodeInfoJson.setValue(goodsIssue.getDoCode());
		}
		importInfoJsons.add(doCodeInfoJson);
		
		InfoJson prCodeInfoJson = new InfoJson();
		prCodeInfoJson.setFieldname(MapKeyApiEnum.PR_CODE.val);
		prCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getPrCode())) {
			prCodeInfoJson.setValue(goodsIssue.getPrCode());
		}
		importInfoJsons.add(prCodeInfoJson);
		
		InfoJson movementTypeInfoJson = new InfoJson();
		movementTypeInfoJson.setFieldname(MapKeyApiEnum.MOVEMENT_TYPE.val);
		movementTypeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getMovementType())) {
			movementTypeInfoJson.setValue(goodsIssue.getMovementType());
		}
		importInfoJsons.add(movementTypeInfoJson);
		
		importJson.setInfoJsons(importInfoJsons);
		pigfarmJson.setImportJson(importJson);
		
		if(!CollectionUtils.isEmpty(goodsIssue.getMaterialDetails())) {
			tableJson.setName(MapKeyApiEnum.MATERIALS.val);
			List<ItemJson> itemJsons = new ArrayList<>();
			AtomicInteger index = new AtomicInteger();
			goodsIssue.getMaterialDetails().stream().forEach(material ->{
				material.setRowId(String.valueOf(index.getAndIncrement()));
				ItemJson itemJson = new ItemJson();
				List<InfoJson> itemInfoJsons = new ArrayList<>(); 
				itemJson.setRowId(material.getRowId());
				
				InfoJson codeInfoJson = new InfoJson();
				codeInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_CODE.val);
				codeInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getCode())) {
					codeInfoJson.setValue(material.getCode());
				}
				itemInfoJsons.add(codeInfoJson);
				
				InfoJson nameInfoJson = new InfoJson();
				nameInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_NAME.val);
				nameInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getName())) {
					nameInfoJson.setValue(material.getName());
				}
				itemInfoJsons.add(nameInfoJson);
				
				InfoJson groupNameInfoJson = new InfoJson();
				groupNameInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_GROUP_NAME.val);
				groupNameInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getGroupName())) {
					groupNameInfoJson.setValue(material.getGroupName());
				}
				itemInfoJsons.add(groupNameInfoJson);
				
				InfoJson groupCodeInfoJson = new InfoJson();
				groupCodeInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_GROUP_CODE.val);
				groupCodeInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getGroupCode())) {
					groupCodeInfoJson.setValue(material.getGroupCode());
				}
				itemInfoJsons.add(groupCodeInfoJson);
				
				InfoJson unitInfoJson = new InfoJson();
				unitInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_UNIT.val);
				unitInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getUnit())) {
					unitInfoJson.setValue(material.getUnit());
				}
				itemInfoJsons.add(unitInfoJson);
				
				InfoJson quantityInfoJson = new InfoJson();
				quantityInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_QUANTITY.val);
				quantityInfoJson.setValue("");
				if(material.getActuallyExported() != null) {
					quantityInfoJson.setValue(String.valueOf(material.getActuallyExported()));
				}
				itemInfoJsons.add(quantityInfoJson);
				
				InfoJson weightUnitInfoJson = new InfoJson();
				weightUnitInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_WEIGHT_UNIT.val);
				weightUnitInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getWeightUnit())) {
					weightUnitInfoJson.setValue(material.getWeightUnit());
				}
				itemInfoJsons.add(weightUnitInfoJson);
				
				InfoJson grossWeightInfoJson = new InfoJson();
				grossWeightInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_GROSS_WEIGHT.val);
				grossWeightInfoJson.setValue("");
				if(material.getGrossWeight() != null) {
					BigDecimal grossWeight = material.getGrossWeight().setScale(2);
					grossWeightInfoJson.setValue(String.valueOf(grossWeight));
				}
				itemInfoJsons.add(grossWeightInfoJson);
				
				InfoJson batchInfoJson = new InfoJson();
				batchInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_BATCH.val);
				batchInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getBatch())) {
					batchInfoJson.setValue(String.valueOf(material.getBatch()));
				}
				itemInfoJsons.add(batchInfoJson);
				
				InfoJson expiredDateInfoJson = new InfoJson();
				expiredDateInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_EXPIRED_DATE.val);
				expiredDateInfoJson.setValue("");
				if(material.getExpiredDate() != null) {
					expiredDateInfoJson.setValue(DateTimeHelper.toDateString(material.getExpiredDate(), DatePatternEnum.YYYYMMDD.pattern));
				}
				itemInfoJsons.add(expiredDateInfoJson);
				
				InfoJson manufacturedDateInfoJson = new InfoJson();
				manufacturedDateInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_MANUFACTURED_DATE.val);
				manufacturedDateInfoJson.setValue("");
				if(material.getManufacturedDate() != null) {
					manufacturedDateInfoJson.setValue(DateTimeHelper.toDateString(material.getManufacturedDate(), DatePatternEnum.YYYYMMDD.pattern));
				}
				itemInfoJsons.add(manufacturedDateInfoJson);
				
				InfoJson itemNumInfoJson = new InfoJson();
				itemNumInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_ITEM_NUM.val);
				itemNumInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getItemNum())) {
					itemNumInfoJson.setValue(material.getItemNum());
				}
				itemInfoJsons.add(itemNumInfoJson);
				
				InfoJson noteInfoJson = new InfoJson();
				noteInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_ITEMTEXT.val);
				noteInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getNote())) {
					noteInfoJson.setValue(material.getNote());
				}
				itemInfoJsons.add(noteInfoJson);
				
				InfoJson typeInfoJson = new InfoJson();
				typeInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_STORAGE_TYPE.val);
				typeInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getType())) {
					typeInfoJson.setValue(material.getType());
				}
				itemInfoJsons.add(typeInfoJson);
				
				itemJson.setInfoJsons(itemInfoJsons);
				itemJsons.add(itemJson);
			});
			tableJson.setItemJsons(itemJsons);
		}
		pigfarmJson.setTableJson(tableJson);
		
		return pigfarmJson;
	}

	public static PigfarmJson convertGeneralLedgerSendToSAP(GeneralLedgerDto generalLedger) throws Exception {
		log.info("process: CONVERT GENERAL_LEDGER TO JSON SEND TO SAP");
		PigfarmJson pigfarmJson = new PigfarmJson();
		pigfarmJson.setBapirfc(MapKeyApiEnum.ZFM_GLAPP_IF.val);

		String transCode = generalLedger.getTransCode();
		pigfarmJson.setTransCode(transCode);
		ImportJson importJson = new ImportJson();
		List<InfoJson> importInfoJsons = new ArrayList<>();
		String plantCode = "";
		String farmCode = "";
		if (generalLedger.getFarm() != null) {
			String code = generalLedger.getFarm().getCode();
			String[] codeArr = StringUtils.split(code, SymbolEnum.DOT.val);
			if (codeArr.length > 1) {
				plantCode = codeArr[0];
				farmCode = codeArr[1];
			}
		}

		InfoJson transCodeInfoJson = new InfoJson();
		transCodeInfoJson.setFieldname(MapKeyApiEnum.TRANS_CODE.val);
		transCodeInfoJson.setValue(transCode);
		importInfoJsons.add(transCodeInfoJson);

		InfoJson appInfoJson = new InfoJson();
		appInfoJson.setFieldname(MapKeyApiEnum.APP.val);
		appInfoJson.setValue("PORKER");
		importInfoJsons.add(appInfoJson);

		InfoJson plantInfoJson = new InfoJson();
		plantInfoJson.setFieldname(MapKeyApiEnum.PLANT.val);
		plantInfoJson.setValue(plantCode);
		importInfoJsons.add(plantInfoJson);

		InfoJson farmCodeInfoJson = new InfoJson();
		farmCodeInfoJson.setFieldname(MapKeyApiEnum.FARM_CODE.val);
		farmCodeInfoJson.setValue(farmCode);
		importInfoJsons.add(farmCodeInfoJson);

		InfoJson docCodeInfoJson = new InfoJson();
		docCodeInfoJson.setFieldname(MapKeyApiEnum.DOC_CODE_GL.val);
		docCodeInfoJson.setValue(generalLedger.getDocCode());
		importInfoJsons.add(docCodeInfoJson);

		InfoJson docSymbolInfoJson = new InfoJson();
		docSymbolInfoJson.setFieldname(MapKeyApiEnum.DOC_SYMBOL_GL.val);
		docSymbolInfoJson.setValue(generalLedger.getDocSymbol());
		importInfoJsons.add(docSymbolInfoJson);

		InfoJson docNumInfoJson = new InfoJson();
		docNumInfoJson.setFieldname(MapKeyApiEnum.DOC_NUM_GL.val);
		docNumInfoJson.setValue(generalLedger.getDocNum());
		importInfoJsons.add(docNumInfoJson);

		InfoJson postingDateInfoJson = new InfoJson();
		postingDateInfoJson.setFieldname(MapKeyApiEnum.POSTING_DATE.val);
		postingDateInfoJson.setValue(generalLedger.getPostingDateToSync());
		importInfoJsons.add(postingDateInfoJson);

		InfoJson docDateInfoJson = new InfoJson();
		docDateInfoJson.setFieldname(MapKeyApiEnum.DOC_DATE_GL.val);
		docDateInfoJson.setValue(generalLedger.getDocDateToSync());
		importInfoJsons.add(docDateInfoJson);

		InfoJson amountInfoJson = new InfoJson();
		amountInfoJson.setFieldname(MapKeyApiEnum.AMOUNT.val);
		amountInfoJson.setValue(generalLedger.getAmount().toString());
		importInfoJsons.add(amountInfoJson);

		InfoJson vendorCodeJson = new InfoJson();
		vendorCodeJson.setFieldname(MapKeyApiEnum.VENDOR_CODE.val);
		if (generalLedger.getVendor() != null) vendorCodeJson.setValue(generalLedger.getVendor().getCode());
		else vendorCodeJson.setValue("");
		importInfoJsons.add(vendorCodeJson);

		InfoJson vendorNameJson = new InfoJson();
		vendorNameJson.setFieldname(MapKeyApiEnum.VENDOR_NAME.val);
		vendorNameJson.setValue(generalLedger.getVendorName());
		importInfoJsons.add(vendorNameJson);

		InfoJson vendorTaxJson = new InfoJson();
		vendorTaxJson.setFieldname(MapKeyApiEnum.VENDOR_TAX.val);
		vendorTaxJson.setValue(generalLedger.getVendorTax());
		importInfoJsons.add(vendorTaxJson);

		InfoJson vendorAddrJson = new InfoJson();
		vendorAddrJson.setFieldname(MapKeyApiEnum.VENDOR_ADD.val);
		vendorAddrJson.setValue(generalLedger.getAddress());
		importInfoJsons.add(vendorAddrJson);

		InfoJson descriptionInfoJson = new InfoJson();
		descriptionInfoJson.setFieldname(MapKeyApiEnum.DESCRIPTION.val);
		descriptionInfoJson.setValue(generalLedger.getDescription());
		importInfoJsons.add(descriptionInfoJson);

		importJson.setInfoJsons(importInfoJsons);
		pigfarmJson.setImportJson(importJson);

		return pigfarmJson;
	}
	
	/*
	 * Convert dữ liệu GOODS_ATTRITION -> JSON gửi lên SAP
	 */
	public static  PigfarmJson convertGoodsAttritionToJson(GoodsIssueDto goodsIssue){
		log.info("PROCESS: CONVERT GOODS_ATTRITION TO JSON SEND TO SAP");
		PigfarmJson pigfarmJson = new PigfarmJson();
		pigfarmJson.setBapirfc(MapKeyApiEnum.ZFM_XTHFSHOPFLOOR_IF.val);
		ImportJson importJson = new ImportJson();
		List<InfoJson> importInfoJsons = new ArrayList<>();
		TableJson tableJson = new TableJson();
		
		InfoJson transCodeInfoJson = new InfoJson();
		transCodeInfoJson.setFieldname(MapKeyApiEnum.TRANS_CODE.val);
		transCodeInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getTransCode())) {
			transCodeInfoJson.setValue(goodsIssue.getTransCode());
		}
		importInfoJsons.add(transCodeInfoJson);
		
		InfoJson processOrderCodeInfoJson = new InfoJson();
		processOrderCodeInfoJson.setFieldname(MapKeyApiEnum.PROCESS_ORDER_CODE.val);
		processOrderCodeInfoJson.setValue("");
		if(goodsIssue.getProcessOrderCode() != null) {
			processOrderCodeInfoJson.setValue(goodsIssue.getProcessOrderCode());
		}
		importInfoJsons.add(processOrderCodeInfoJson);
		
		InfoJson processOrderStatusInfoJson = new InfoJson();
		processOrderStatusInfoJson.setFieldname(MapKeyApiEnum.FINCONF.val);
		processOrderStatusInfoJson.setValue("");
		if(goodsIssue.getProcessOrderStatus().equals(ProcessOrderStatusEnum.CLOSED.status)) {
			processOrderStatusInfoJson.setValue(MapKeyApiEnum.FINCONF_VALUE.val);
		}
		importInfoJsons.add(processOrderStatusInfoJson);
		
		
		InfoJson plantInfoJson = new InfoJson();
		plantInfoJson.setFieldname(MapKeyApiEnum.PLANT.val);
		plantInfoJson.setValue("");
		InfoJson farmCodeInfoJson = new InfoJson();
		farmCodeInfoJson.setFieldname(MapKeyApiEnum.FARM_CODE.val);
		farmCodeInfoJson.setValue("");
		if(goodsIssue.getStock() != null) {
			String code = goodsIssue.getStock().getCode();
			String[] arr = StringUtils.split(code, SymbolEnum.DOT.val);
			if(arr.length >= 2) {
				plantInfoJson.setValue(arr[0]);
				farmCodeInfoJson.setValue(arr[1]);
			}
		}
		importInfoJsons.add(plantInfoJson);
		importInfoJsons.add(farmCodeInfoJson);
		
		InfoJson createdByInfoJson = new InfoJson();
		createdByInfoJson.setFieldname(MapKeyApiEnum.CREATED_BY.val);
		createdByInfoJson.setValue("");
		if(StringUtils.isNotBlank(goodsIssue.getCreatedBy())) {
			createdByInfoJson.setValue(goodsIssue.getCreatedBy());
		}
		importInfoJsons.add(createdByInfoJson);
		
//		InfoJson insertInfoJson = new InfoJson();
//		insertInfoJson.setFieldname(MapKeyApiEnum.INSERT.val);
//		insertInfoJson.setValue("");
//		if(goodsIssue.getCheckInsertTool()) {
//			insertInfoJson.setValue("X");
//		}
//		importInfoJsons.add(insertInfoJson);
		
		InfoJson postingInfoJson = new InfoJson();
		postingInfoJson.setFieldname(MapKeyApiEnum.POSTING_DATE.val);
		postingInfoJson.setValue("");
		if(goodsIssue.getPostingDate() != null) {
			postingInfoJson.setValue(DateTimeFormatter.ofPattern(DatePatternEnum.YYYYMMDD.pattern).format(goodsIssue.getPostingDate()));
		}
		importInfoJsons.add(postingInfoJson);
		
		//set type de  phan biet (F : trai heo thit, S trai heo giong nai)
		InfoJson infoJson = new InfoJson();
		infoJson.setFieldname(MapKeyApiEnum.GA_TYPE.val);
		infoJson.setValue(GoodsAttritionTypeEnum.FINISH_FARM.val);
		importInfoJsons.add(infoJson);
		
		
		importJson.setInfoJsons(importInfoJsons);
		pigfarmJson.setImportJson(importJson);
		
		if(!CollectionUtils.isEmpty(goodsIssue.getMaterialDetails())) {
			tableJson.setName(MapKeyApiEnum.MATERIALS.val);
			List<ItemJson> itemJsons = new ArrayList<>();
			AtomicInteger index = new AtomicInteger();
			goodsIssue.getMaterialDetails().stream().forEach(material ->{
				ItemJson itemJson = new ItemJson();
				List<InfoJson> itemInfoJsons = new ArrayList<>(); 
				itemJson.setRowId(String.valueOf(index.getAndIncrement()));
				
				InfoJson codeInfoJson = new InfoJson();
				codeInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_CODE.val);
				codeInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getCode())) {
					codeInfoJson.setValue(material.getCode());
				}
				itemInfoJsons.add(codeInfoJson);
				
				InfoJson unitInfoJson = new InfoJson();
				unitInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_UNIT.val);
				unitInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getUnit())) {
					unitInfoJson.setValue(material.getUnit());
				}
				itemInfoJsons.add(unitInfoJson);
				
				InfoJson quantityInfoJson = new InfoJson();
				quantityInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_QUANTITY.val);
				quantityInfoJson.setValue("");
				if(material.getActuallyExported() != null) {
					quantityInfoJson.setValue(String.valueOf(material.getActuallyExported()));
				}
				itemInfoJsons.add(quantityInfoJson);
				
				InfoJson batchInfoJson = new InfoJson();
				batchInfoJson.setFieldname(MapKeyApiEnum.MATERIAL_BATCH.val);
				batchInfoJson.setValue("");
				if(material.getBatch() != null) {
					batchInfoJson.setValue(String.valueOf(material.getBatch()));
				}
				itemInfoJsons.add(batchInfoJson);
				
				InfoJson transCodeItemInfoJson = new InfoJson();
				transCodeItemInfoJson.setFieldname(MapKeyApiEnum.TRANS_CODE.val);
				transCodeItemInfoJson.setValue("");
				if(StringUtils.isNotBlank(material.getTransCodeItem())) {
					transCodeItemInfoJson.setValue(material.getTransCodeItem());
				}
				itemInfoJsons.add(transCodeItemInfoJson);
				
				itemJson.setInfoJsons(itemInfoJsons);
				itemJsons.add(itemJson);
			});
			tableJson.setItemJsons(itemJsons);
		}
		pigfarmJson.setTableJson(tableJson);
		
		return pigfarmJson;
	}
}
