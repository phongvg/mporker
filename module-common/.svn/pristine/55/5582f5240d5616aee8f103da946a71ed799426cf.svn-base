package com.keysoft.pigfarm.helper;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keysoft.pigfarm.common.DatePatternEnum;
import com.keysoft.pigfarm.common.EventTypeEnum;
import com.keysoft.pigfarm.common.MapKeyEnum;
import com.keysoft.pigfarm.integration.mobile.ContentEventJson;
import com.keysoft.pigfarm.integration.mobile.ContentProposalJson;
import com.keysoft.pigfarm.integration.mobile.EventJson;
import com.keysoft.pigfarm.integration.mobile.GoodsIssueJson;
import com.keysoft.pigfarm.integration.mobile.GoodsReceiptJson;
import com.keysoft.pigfarm.integration.mobile.GoodsRequisitionJson;
import com.keysoft.pigfarm.integration.mobile.InstockJson;
import com.keysoft.pigfarm.integration.mobile.MaterialJson;
import com.keysoft.pigfarm.integration.mobile.MobileBarnPlanJson;
import com.keysoft.pigfarm.integration.mobile.MobileProcessOrderJson;
import com.keysoft.pigfarm.integration.mobile.MobileQuotaJson;
import com.keysoft.pigfarm.integration.mobile.PigEntryJson;
import com.keysoft.pigfarm.integration.mobile.PigJson;
import com.keysoft.pigfarm.integration.mobile.ProductionJson;
import com.keysoft.pigfarm.integration.mobile.ProposalJson;
import com.keysoft.pigfarm.integration.mobile.PurchaseRequisitionJson;
import com.keysoft.pigfarm.integration.mobile.WeightChartJson;
import com.keysoft.pigfarm.production.dto.BarnPlanDto;
import com.keysoft.pigfarm.production.dto.EventDto;
import com.keysoft.pigfarm.production.dto.GoodsIssueDto;
import com.keysoft.pigfarm.production.dto.GoodsReceiptDto;
import com.keysoft.pigfarm.production.dto.GoodsRequisitionDto;
import com.keysoft.pigfarm.production.dto.InstockDto;
import com.keysoft.pigfarm.production.dto.PigCullingDto;
import com.keysoft.pigfarm.production.dto.PigDto;
import com.keysoft.pigfarm.production.dto.PigEntryDto;
import com.keysoft.pigfarm.production.dto.ProcessOrderDto;
import com.keysoft.pigfarm.production.dto.ProductionDto;
import com.keysoft.pigfarm.production.dto.ProposalDto;
import com.keysoft.pigfarm.production.dto.PurchaseRequisitionDto;
import com.keysoft.pigfarm.production.dto.QuotaDto;
import com.keysoft.pigfarm.production.dto.WeightChartDto;
import com.keysoft.pigfarm.production.dto.WeightNoteDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ConvertJsonMobileHelper {
	private ConvertJsonMobileHelper() {
		throw new IllegalStateException("Convert Json Mobile class");
	}
	
	//convert EVENT to json send to Mobile
	public static EventJson convertEventSendToMobile(EventDto event) {
		log.info("PROCESS: CONVERT EVENT TO JSON SEND TO MOBILE");
		EventJson eventJson = new EventJson();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			BeanUtils.copyProperties(event, eventJson);
			ContentEventJson contentEventJson = new ContentEventJson();
			if(event.getType().equals(EventTypeEnum.WEIGHT_NOTE.val)) {
				String content = mapper.writeValueAsString(event.getContent().get(MapKeyEnum.WEIGHT_NOTE.key));
				WeightNoteDto weightNoteDto = mapper.readValue(content, WeightNoteDto.class);
				List<WeightChartDto> weightChartDtos = weightNoteDto.getWeightCharts();
				List<WeightChartJson> weightChartJsons = new ArrayList<>();
				BeanUtils.copyProperties(weightNoteDto, contentEventJson);
				if(!weightChartDtos.isEmpty()) {
					weightChartDtos.stream().forEach(item ->{
						WeightChartJson weightChartJson = new WeightChartJson();
						BeanUtils.copyProperties(item, weightChartJson);
						weightChartJsons.add(weightChartJson);
					});
				}
				contentEventJson.setWeightCharts(weightChartJsons);
			} else {
				String content = mapper.writeValueAsString(event.getContent().get(MapKeyEnum.PIG_EVENT.key));
				PigCullingDto pigCullingDto = mapper.readValue(content, PigCullingDto.class);
				BeanUtils.copyProperties(pigCullingDto, contentEventJson);
			}
			eventJson.setContentEventJson(contentEventJson);
			if(event.getCreatedDate() != null) {
				eventJson.setCreatedDate(DateTimeHelper.toDateTimeString(event.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
			}
			if(event.getModifiedDate() != null) {
				eventJson.setModifiedDate(DateTimeHelper.toDateTimeString(event.getModifiedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
			}
			if(event.getProduction() != null) {
				ProductionDto production = event.getProduction();
				eventJson.setProductionCode(production.getCode());
				
				ProductionJson productionJson = new ProductionJson();
				BeanUtils.copyProperties(production, productionJson);
				if(production.getCreatedDate() != null) {
					productionJson.setCreatedDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern).format(production.getCreatedDate()));
				}
				
				if(production.getModifiedDate() != null) {
					productionJson.setModifiedDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern).format(production.getModifiedDate()));
				}
				
				if(production.getFeedDate() != null) {
					productionJson.setFeedDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getFeedDate()));
				}
				
				if(production.getFeedWeekStartDate() != null) {
					productionJson.setFeedWeekStartDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getFeedWeekStartDate()));
				}
				
				if(production.getFeedWeekToDate() != null) {
					productionJson.setFeedWeekToDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getFeedWeekToDate()));
				}
				
				if(production.getRealStartDate() != null) {
					productionJson.setRealStartDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getRealStartDate()));
				}
				eventJson.setProductionJson(productionJson);
			}
			
		} catch (Exception e) {
			log.error("ERROR Exception: " + e.getMessage());
		}
		return eventJson;
	}
	
	// convert PIG to json send to Mobile
	/*
	 * Convert dữ liệu PIG -> JSON gửi xuống MOBILE
	 */
	public static PigJson convertPigSendToMobile(PigDto pig) {
		log.info("PROCESS: CONVERT PIG TO JSON SEND TO MOBILE");
		PigJson pigJson = new PigJson();
		BeanUtils.copyProperties(pig, pigJson);
		if(pig.getBirthDate() != null) {
			pigJson.setBirthDate(String.valueOf(pig.getBirthDate()));
		}
		if(pig.getCreatedDate() != null) {
			pigJson.setCreatedDate(DateTimeHelper.toDateTimeString(pig.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		if(pig.getModifiedDate() != null) {
			pigJson.setModifiedDate(DateTimeHelper.toDateTimeString(pig.getModifiedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		return pigJson;
	}
	
	/*
	 * Convert dữ liệu PROCESS_ORDER -> JSON gửi xuống MOBILE
	 */
	public static MobileProcessOrderJson convertProcessOrderSendToMobile(ProcessOrderDto processOrder) {
		log.info("PROCESS: CONVERT PROCESS_ORDER TO JSON SEND TO MOBILE");
		MobileProcessOrderJson processOrderJson = new MobileProcessOrderJson();
		BeanUtils.copyProperties(processOrder, processOrderJson);
		processOrderJson.setPigIdentifier(processOrder.getPig().getIdentifier());
		processOrderJson.setBarnCode(processOrder.getBarn().getCode());
		if(processOrder.getStartDate() != null) {
			processOrderJson.setStartDate(processOrder.getStartDate().toString());
		}
		if(processOrder.getEndDate() != null) {
			processOrderJson.setEndDate(processOrder.getEndDate().toString());
		}
		if(processOrder.getWeekFromDate() != null) {
			processOrderJson.setWeekFromDate(processOrder.getWeekFromDate().toString());
		}
		if(processOrder.getWeekToDate() != null) {
			processOrderJson.setWeekToDate(processOrder.getWeekToDate().toString());
		}
		if(processOrder.getCreatedDate() != null) {
			processOrderJson.setCreatedDate(DateTimeHelper.toDateTimeString(processOrder.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		if(processOrder.getRealEndDate() != null) {
			processOrderJson.setRealEndDate(processOrder.getRealEndDate().toString());
		}
		if(processOrder.getRealQuantity() != null) {
			processOrderJson.setRealQuantity(processOrder.getRealQuantity());
		}
		if(processOrder.getRealStartDate() != null) {
			processOrderJson.setRealStartDate(processOrder.getRealStartDate().toString());
		}
		
		if(processOrder.getClosedDate() != null) {
			processOrderJson.setClosedDate(processOrder.getClosedDate().toString());
		}
		
		// get list quota
		List<QuotaDto> quotas = processOrder.getQuotas();
		List<MobileQuotaJson> quotaJsons = new ArrayList<>();
		if(quotas != null && !quotas.isEmpty()) {
			quotas.stream().forEach(quota ->{
				MobileQuotaJson quotaJson = new MobileQuotaJson();
				BeanUtils.copyProperties(quota, quotaJson);
				if(quota.getRequestDate() != null) {
					quotaJson.setRequestDate(quota.getRequestDate().toString());
				}
				if(quota.getManufacturedDate() != null) {
					quotaJson.setManufacturedDate(quota.getManufacturedDate().toString());
				}
				if(quota.getExpiredDate() != null) {
					quotaJson.setExpiredDate(quota.getExpiredDate().toString());
				}
				if(quota.getCreatedDate() != null) {
					quotaJson.setCreatedDate(DateTimeHelper.toDateTimeString(quota.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
				}
				quotaJsons.add(quotaJson);
			});
		}
		processOrderJson.setQuotas(quotaJsons);
		return processOrderJson;
	}
	
	
	/*
	 * Convert dữ liệu BARN_PLAN -> JSON gửi xuống MOBILE
	 */
	public static MobileBarnPlanJson convertBarnPlanSendToMobile(BarnPlanDto barnPlan){
		log.info("PROCESS: CONVERT BARN_PLAN TO JSON SEND TO MOBILE");
		MobileBarnPlanJson barnPlanJson = new MobileBarnPlanJson();
		BeanUtils.copyProperties(barnPlan, barnPlanJson);
		if(barnPlan.getBarn() != null) {
			barnPlanJson.setBarnCode(barnPlan.getBarn().getCode());
		}
		if(barnPlan.getBarnEmptyDate() != null) {
			barnPlanJson.setBarnEmptyDate(barnPlan.getBarnEmptyDate().toString());
		}
		if(barnPlan.getRealBarnEmptyDate() != null) {
			barnPlanJson.setRealBarnEmptyDate(barnPlan.getRealBarnEmptyDate().toString());
		}
		if(barnPlan.getCreatedDate() != null) {
			barnPlanJson.setCreatedDate(DateTimeHelper.toDateTimeString(barnPlan.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		if(barnPlan.getModifiedDate() != null) {
			barnPlanJson.setModifiedDate(DateTimeHelper.toDateTimeString(barnPlan.getModifiedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		return barnPlanJson;
	}
	
	/*
	 * Convert dữ liệu PROPOSAL -> JSON gửi xuống MOBILE
	 */
	public static ProposalJson convertProposalSendToMobile(ProposalDto proposal) {
		log.info("PROCESS: CONVERT PROPOSAL TO JSON SEND TO MOBILE");
		ProposalJson proposalJson = new ProposalJson();
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		try {
			BeanUtils.copyProperties(proposal, proposalJson);
			String content = mapper.writeValueAsString(proposal.getContent().get(MapKeyEnum.WEIGHT_CHART.key));
			List<ContentProposalJson> contentProposalJsons = mapper.readValue(content, new TypeReference<List<ContentProposalJson>>() {});
			proposalJson.setContents(contentProposalJsons);
			
			if(proposal.getCreatedDate() != null) {
				proposalJson.setCreatedDate(DateTimeHelper.toDateTimeString(proposal.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
			}
			if(proposal.getModifiedDate() != null) {
				proposalJson.setModifiedDate(DateTimeHelper.toDateTimeString(proposal.getModifiedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
			}
			if(proposal.getRecordDate() != null) {
				proposalJson.setRecordDate(DateTimeHelper.toDateString(proposal.getRecordDate(), DatePatternEnum.YYYY_MM_DD.pattern));
			}
			if(proposal.getFarm() != null) {
				proposalJson.setFarmCode(proposal.getFarm().getCode());
			}
			
		} catch (Exception e) {
			log.error("ERROR CONVERT PROPOSAL: EXCEPTION: {}", e);
		}
		return proposalJson;
	}
	
	/*
	 * Convert dữ liệu PIG_ENTRY -> JSON gửi xuống MOBILE
	 */
	public static PigEntryJson convertPigEntrySendToMobile(PigEntryDto pigEntry) {
		log.info("PROCESS: CONVERT PIG_ENTRY TO JSON SEND TO MOBILE");
		PigEntryJson pigEntryJson = new PigEntryJson();
		BeanUtils.copyProperties(pigEntry, pigEntryJson);
		if(pigEntry.getEntryDate() != null) {
			pigEntryJson.setEntryDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(pigEntry.getEntryDate()));
		}
		if(pigEntry.getMatureDate() != null) {
			pigEntryJson.setMatureDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(pigEntry.getMatureDate()));
		}
		if(StringUtils.isNotBlank(pigEntry.getPigIdentifier())) {
			pigEntryJson.setPigIdentifier(pigEntry.getPigIdentifier());
		}
		return pigEntryJson;
	}
	
	/*
	 * Convert dữ liệu PRODUCTION -> JSON gửi xuống MOBILE
	 */
	public static ProductionJson convertProductionSendToMobile(ProductionDto production) {
		log.info("PROCESS: CONVERT PRODUCTION TO JSON SEND TO MOBILE");
		ProductionJson productionJson = new ProductionJson();
		BeanUtils.copyProperties(production, productionJson);
		if(production.getCreatedDate() != null) {
			productionJson.setCreatedDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern).format(production.getCreatedDate()));
		}
		
		if(production.getModifiedDate() != null) {
			productionJson.setModifiedDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern).format(production.getModifiedDate()));
		}
		
		if(production.getFeedDate() != null) {
			productionJson.setFeedDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getFeedDate()));
		}
		
		if(production.getFeedWeekStartDate() != null) {
			productionJson.setFeedWeekStartDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getFeedWeekStartDate()));
		}
		
		if(production.getFeedWeekToDate() != null) {
			productionJson.setFeedWeekToDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getFeedWeekToDate()));
		}
		
		if(production.getRealStartDate() != null) {
			productionJson.setRealStartDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getRealStartDate()));
		}
		return productionJson;
	}
	
	/*
	 * Convert dữ liệu INSTOCK -> JSON gửi xuống MOBILE
	 */
	public static InstockJson convertInstockSendToMobile(InstockDto instock) {
		log.info("PROCESS: CONVERT INSTOCK TO JSON SEND TO MOBILE");
		InstockJson instockJson = new InstockJson();
			BeanUtils.copyProperties(instock, instockJson);
			
			instockJson.setStockCode(instock.getStock().getCode());
			if(instock.getCreatedDate() != null) {
				instockJson.setCreatedDate(DateTimeHelper.toDateTimeString(instock.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
			}
			if(instock.getSyncDate() != null) {
				StringBuilder date = new StringBuilder();
				date.append(DateTimeHelper.toDateString(instock.getSyncDate(), DatePatternEnum.YYYY_MM_DD.pattern)).append(DatePatternEnum.DD_MM_YYYY__00_00_00.pattern);
				instockJson.setSyncDate(date.toString());
			}
			List<MaterialJson> materialJsons = new ArrayList<>();
			if(!CollectionUtils.isEmpty(instock.getMaterialDetails())) {
				instock.getMaterialDetails().stream().forEach(item -> {
					MaterialJson materialJson = new MaterialJson();
					BeanUtils.copyProperties(item, materialJson);
					if(item.getExpiredDate() != null)
						materialJson.setExpiredDate(DateTimeHelper.toDateString(item.getExpiredDate(), DatePatternEnum.YYYY_MM_DD.pattern));
					if(item.getManufacturedDate() != null)
						materialJson.setManufacturedDate(DateTimeHelper.toDateString(item.getManufacturedDate(), DatePatternEnum.YYYY_MM_DD.pattern));
					materialJsons.add(materialJson);
				});
			}
			instockJson.setContents(materialJsons);
		return instockJson;
	}
	
	/*
	 * Convert dữ liệu PURCHASE_REQUISITION -> JSON gửi xuống MOBILE
	 */
	public static PurchaseRequisitionJson convertPurchaseRequisitionSendToMobile(PurchaseRequisitionDto purchaseRequisition) {
		log.info("PROCESS: CONVERT PURCHASE_REQUISITION TO JSON SEND TO MOBILE");
		PurchaseRequisitionJson purchaseRequisitionJson = new PurchaseRequisitionJson();
		BeanUtils.copyProperties(purchaseRequisition, purchaseRequisitionJson);
		if(purchaseRequisition.getStock() != null) {
			purchaseRequisitionJson.setStockCode(purchaseRequisition.getStock().getCode());
		}
		if(purchaseRequisition.getCreatedDate() != null) {
			purchaseRequisitionJson.setCreatedDate(DateTimeHelper.toDateTimeString(purchaseRequisition.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		if(purchaseRequisition.getModifiedDate() != null) {
			purchaseRequisitionJson.setModifiedDate(DateTimeHelper.toDateTimeString(purchaseRequisition.getModifiedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		List<MaterialJson> materialJsons = new ArrayList<>();
		if(!CollectionUtils.isEmpty(purchaseRequisition.getMaterialDetails())) {
			purchaseRequisition.getMaterialDetails().stream().forEach(item -> {
				MaterialJson materialJson = new MaterialJson();
				BeanUtils.copyProperties(item, materialJson);
				if(item.getDeliveryDate() != null)
					materialJson.setDeliveryDate(DateTimeHelper.toDateString(item.getDeliveryDate(), DatePatternEnum.YYYY_MM_DD.pattern));
				materialJsons.add(materialJson);
			});
		}
		purchaseRequisitionJson.setContents(materialJsons);
		return purchaseRequisitionJson;
	}
	
	/*
	 * Convert dữ liệu GOODS_REQUISITION -> JSON gửi xuống MOBILE
	 */
	public static GoodsRequisitionJson convertGoodsRequisitionSendToMobile(GoodsRequisitionDto goodsRequisition) {
		log.info("PROCESS: CONVERT GOODS_REQUISITION TO JSON SEND TO MOBILE");
		GoodsRequisitionJson goodsRequisitionJson = new GoodsRequisitionJson();
		BeanUtils.copyProperties(goodsRequisition, goodsRequisitionJson);
		if(goodsRequisition.getStock() != null) {
			goodsRequisitionJson.setStockCode(goodsRequisition.getStock().getCode());
		}
		if(goodsRequisition.getPostingDate() != null) {
			goodsRequisitionJson.setCreatedDate(String.valueOf(goodsRequisition.getPostingDate()));
		}
		if(goodsRequisition.getCreatedDate() != null) {
			goodsRequisitionJson.setCreatedDate(DateTimeHelper.toDateTimeString(goodsRequisition.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		if(goodsRequisition.getModifiedDate() != null) {
			goodsRequisitionJson.setModifiedDate(DateTimeHelper.toDateTimeString(goodsRequisition.getModifiedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		List<MaterialJson> materialJsons = new ArrayList<>();
		if(!CollectionUtils.isEmpty(goodsRequisition.getMaterialDetails())) {
			goodsRequisition.getMaterialDetails().stream().forEach(item -> {
				MaterialJson materialJson = new MaterialJson();
				BeanUtils.copyProperties(item, materialJson);
				if(item.getDeliveryDate() != null)
					materialJson.setDeliveryDate(DateTimeHelper.toDateString(item.getDeliveryDate(), DatePatternEnum.YYYY_MM_DD.pattern));
				if(item.getExpiredDate() != null)
					materialJson.setExpiredDate(DateTimeHelper.toDateString(item.getExpiredDate(), DatePatternEnum.YYYY_MM_DD.pattern));
				if(item.getManufacturedDate() != null)
					materialJson.setManufacturedDate(DateTimeHelper.toDateString(item.getManufacturedDate(), DatePatternEnum.YYYY_MM_DD.pattern));
				materialJsons.add(materialJson);
			});
		}
		goodsRequisitionJson.setContents(materialJsons);
	return goodsRequisitionJson;
	}
	
	/*
	 * Convert dữ liệu GOODS_RECEIPT -> JSON gửi xuống MOBILE
	 */
	public static GoodsReceiptJson convertGoodsReceiptSendToMobile(GoodsReceiptDto goodsReceipt) {
		log.info("PROCESS: CONVERT GOODS_RECEIPT TO JSON SEND TO MOBILE");
		GoodsReceiptJson goodsReceiptJson = new GoodsReceiptJson();
		BeanUtils.copyProperties(goodsReceipt, goodsReceiptJson);
		if(goodsReceipt.getStock() != null) {
			goodsReceiptJson.setStockCode(goodsReceipt.getStock().getCode());
		}
		if(goodsReceipt.getPostingDate() != null) {
			goodsReceiptJson.setPostingDate(DateTimeHelper.toDateString(goodsReceipt.getPostingDate(), DatePatternEnum.YYYY_MM_DD.pattern));
		}
		if(goodsReceipt.getCreatedDate() != null) {
			goodsReceiptJson.setCreatedDate(DateTimeHelper.toDateTimeString(goodsReceipt.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		if(goodsReceipt.getModifiedDate() != null) {
			goodsReceiptJson.setModifiedDate(DateTimeHelper.toDateTimeString(goodsReceipt.getModifiedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		
		List<MaterialJson> materialJsons = new ArrayList<>();
		if(!CollectionUtils.isEmpty(goodsReceipt.getMaterialDetails())) {
			goodsReceipt.getMaterialDetails().stream().forEach(item -> {
				MaterialJson materialJson = new MaterialJson();
				BeanUtils.copyProperties(item, materialJson);
				if(item.getExpiredDate() != null)
					materialJson.setExpiredDate(DateTimeHelper.toDateString(item.getExpiredDate(), DatePatternEnum.YYYY_MM_DD.pattern));
				if(item.getManufacturedDate() != null)
					materialJson.setManufacturedDate(DateTimeHelper.toDateString(item.getManufacturedDate(), DatePatternEnum.YYYY_MM_DD.pattern));
				materialJsons.add(materialJson);
			});
		}
		goodsReceiptJson.setContents(materialJsons);
		
		if(goodsReceipt.getProduction() != null) {
			ProductionDto production = goodsReceipt.getProduction();
			goodsReceiptJson.setProductionCode(production.getCode());
			
			ProductionJson productionJson = new ProductionJson();
			BeanUtils.copyProperties(production, productionJson);
			if(production.getCreatedDate() != null) {
				productionJson.setCreatedDate(DateTimeHelper.toDateTimeString(production.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
			}
			
			if(production.getModifiedDate() != null) {
				productionJson.setModifiedDate(DateTimeHelper.toDateTimeString(production.getModifiedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
			}
			
			if(production.getFeedDate() != null) {
				productionJson.setFeedDate(DateTimeHelper.toDateString(production.getFeedDate(), DatePatternEnum.YYYY_MM_DD.pattern));
			}
			
			if(production.getFeedWeekStartDate() != null) {
				productionJson.setFeedWeekStartDate(DateTimeHelper.toDateString(production.getFeedWeekStartDate(), DatePatternEnum.YYYY_MM_DD.pattern));
			}
			
			if(production.getFeedWeekToDate() != null) {
				productionJson.setFeedWeekToDate(DateTimeHelper.toDateString(production.getFeedWeekToDate(), DatePatternEnum.YYYY_MM_DD.pattern));
			}
			
			if(production.getRealStartDate() != null) {
				productionJson.setRealStartDate(DateTimeHelper.toDateString(production.getRealStartDate(), DatePatternEnum.YYYY_MM_DD.pattern));
			}
			goodsReceiptJson.setProductionJson(productionJson);
			
		}
		return goodsReceiptJson;
	}
	
	/*
	 * Convert dữ liệu GOOOS_ISSUE -> JSON gửi xuống MOBILE
	 */
	public static  GoodsIssueJson convertGoodsIssueSendToMobile(GoodsIssueDto goodsIssue) {
		log.info("process=convertGoodsIssueSendToMobile");
		GoodsIssueJson goodsIssueJson = new GoodsIssueJson();
		BeanUtils.copyProperties(goodsIssue, goodsIssueJson);
		List<MaterialJson> materialJsons = new ArrayList<>();
		if(!CollectionUtils.isEmpty(goodsIssue.getMaterialDetails())) {
			goodsIssue.getMaterialDetails().stream().forEach(item -> {
				MaterialJson materialJson = new MaterialJson();
				BeanUtils.copyProperties(item, materialJson);
				if(item.getExpiredDate() != null)
					materialJson.setExpiredDate(DateTimeHelper.toDateString(item.getExpiredDate(), DatePatternEnum.YYYY_MM_DD.pattern));
				if(item.getManufacturedDate() != null)
					materialJson.setManufacturedDate(DateTimeHelper.toDateString(item.getManufacturedDate(), DatePatternEnum.YYYY_MM_DD.pattern));
				materialJsons.add(materialJson);
			});
		}
		goodsIssueJson.setContents(materialJsons);
		
		if(goodsIssue.getProduction() != null) {
			ProductionDto production = goodsIssue.getProduction();
			goodsIssueJson.setProductionCode(production.getCode());
			
			ProductionJson productionJson = new ProductionJson();
			BeanUtils.copyProperties(production, productionJson);
			if(production.getCreatedDate() != null) {
				productionJson.setCreatedDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern).format(production.getCreatedDate()));
			}
			
			if(production.getModifiedDate() != null) {
				productionJson.setModifiedDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern).format(production.getModifiedDate()));
			}
			
			if(production.getFeedDate() != null) {
				productionJson.setFeedDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getFeedDate()));
			}
			
			if(production.getFeedWeekStartDate() != null) {
				productionJson.setFeedWeekStartDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getFeedWeekStartDate()));
			}
			
			if(production.getFeedWeekToDate() != null) {
				productionJson.setFeedWeekToDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getFeedWeekToDate()));
			}
			
			if(production.getRealStartDate() != null) {
				productionJson.setRealStartDate(DateTimeFormatter.ofPattern(DatePatternEnum.YYYY_MM_DD.pattern).format(production.getRealStartDate()));
			}
			goodsIssueJson.setProductionJson(productionJson);
			
		}
		if(goodsIssue.getStock() != null) {
			goodsIssueJson.setStockCode(goodsIssue.getStock().getCode());
		}
		if(goodsIssue.getPostingDate() != null) {
			goodsIssueJson.setPostingDate(String.valueOf(goodsIssue.getPostingDate()));
		}
		if(goodsIssue.getCreatedDate() != null) {
			goodsIssueJson.setCreatedDate(DateTimeHelper.toDateTimeString(goodsIssue.getCreatedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		if(goodsIssue.getModifiedDate() != null) {
			goodsIssueJson.setModifiedDate(DateTimeHelper.toDateTimeString(goodsIssue.getModifiedDate(), DatePatternEnum.YYYY_MM_DD__HH_MM_SS.pattern));
		}
		return goodsIssueJson;
	}
}
