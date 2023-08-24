package com.keysoft.pigfarm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import com.keysoft.pigfarm.common.*;
import com.keysoft.pigfarm.integration.EntityResponse;
import com.keysoft.pigfarm.manager.PlantManager;
import com.keysoft.pigfarm.production.dto.DocumentTypeDto;
import com.keysoft.pigfarm.production.dto.GoodsIssueDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.keysoft.pigfarm.constant.ModelViewEnum;
import com.keysoft.pigfarm.manager.FarmManager;
import com.keysoft.pigfarm.production.dto.FarmDto;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class FarmController extends BaseController {
	@Autowired
	private FarmManager farmManager;
	@Autowired
	private PlantManager plantManager;
	
	@GetMapping("/farm/list")
	public ModelAndView list(HttpServletRequest request) throws IOException {
		log.debug("ENTERING 'LIST FARM' METHOD...");
		ModelAndView modelAndView = new ModelAndView(ModelViewEnum.VIEW_FARM_LIST.mav);
		FarmDto criteria = FarmDto.builder()
									.porkerFarm(true)
									.page(appProperties.getDefaultPage())
									.size(appProperties.getDefaultPageSize())
									.build();
		modelAndView.addObject(ModelViewEnum.MODEL_PAGE.mav, farmManager.search(criteria));
		return modelAndView;
	}
	
	@PostMapping("/farm/list")
	public ModelAndView search(@Valid FarmDto criteria, BindingResult bindingResult ) {
		log.debug("ENTERING 'SEARCH LIST FARM' METHOD...");
		ModelAndView modelAndView = new ModelAndView(ModelViewEnum.VIEW_FARM_LIST.mav);
		modelAndView.addObject("searchName", criteria.getName());
		modelAndView.addObject("searchCode", criteria.getCode());
		modelAndView.addObject(ModelViewEnum.MODEL_PAGE.mav, farmManager.search(criteria));	
		return modelAndView;
	}

	@ModelAttribute
	@GetMapping("/farm/form")
	public ModelAndView show(@RequestParam (value="id", required=false) Long id, HttpServletRequest request) throws Exception {
		log.debug("ENTERING 'SHOW FORM FARM' METHOD...");
		ModelAndView modelAndView = new ModelAndView(ModelViewEnum.VIEW_FARM_FORM.mav);
		FarmDto farmDto = new FarmDto();
		if(id != null) {
			farmDto = farmManager.get(id);
			if(farmDto == null) {
				addError(request, getText("data.notfound", request.getLocale()));
				return new ModelAndView(ModelViewEnum.REDIRECT_FARM_LIST.mav);
			}
		}
		modelAndView.addObject("plants", plantManager.getAll());
		modelAndView.addObject("farmDto", farmDto);
		return modelAndView;
	}

	@PostMapping("/farm/save")
	public String save(@Valid FarmDto farmDto, HttpServletRequest request, BindingResult bindingResult) {
		log.debug("ENTERING 'SAVE FARM' METHOD...");
		Locale locale = request.getLocale();
		String view = ModelViewEnum.VIEW_FARM_FORM.mav;
		if(farmDto.getId() != null) {
			view = "/farm/form?id=" + farmDto.getId();
		}
		if (bindingResult.hasErrors()) {
			addError(request, bindingResult.getAllErrors().toString());
			return view;
		}
		view = ModelViewEnum.REDIRECT_FARM_LIST.mav;
		try {
			EntityResponse result = farmManager.save(farmDto);
			if(result.getCode().equals(EntityResponseCodeEnum.SUCCESS_200.val)) {
				addMessage(request, getText("farm.updated.success", locale));
			} else {
				addError(request, result.getMessage());
			}
		} catch (Exception e) {
			log.error("ERROR SAVE FARM: EXCEPTION: {}", e);
			addError(request, e.getMessage());
		}
		return view;
	}

	@GetMapping("/checkFarmCode")
	public @ResponseBody Boolean checkFarmCode(@RequestParam(value="id", required= false) Long id, @RequestParam String code) {
		log.debug("entering check farm code");
		return farmManager.checkFarmCode(code, id);
	}
	
}
