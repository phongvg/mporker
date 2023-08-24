package com.keysoft.pigfarm.controller;

import com.keysoft.pigfarm.common.EntityResponseCodeEnum;
import com.keysoft.pigfarm.constant.ModelViewEnum;
import com.keysoft.pigfarm.integration.EntityResponse;
import com.keysoft.pigfarm.manager.CompanyManager;
import com.keysoft.pigfarm.manager.PlantManager;
import com.keysoft.pigfarm.production.dto.CompanyDto;
import com.keysoft.pigfarm.production.dto.PlantDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.Locale;

@Slf4j
@Controller
public class PlantController extends BaseController{
    @Autowired
    private PlantManager plantManager;
    @Autowired
    private CompanyManager companyManager;

    @GetMapping("/plant/list")
    public ModelAndView list() throws IOException {
        log.debug("ENTERING 'LIST plant' METHOD...");
        ModelAndView modelAndView = new ModelAndView(ModelViewEnum.VIEW_PLANT_LIST.mav);
        PlantDto criteria = PlantDto.builder()
                .page(appProperties.getDefaultPage())
                .size(appProperties.getDefaultPageSize())
                .build();
        modelAndView.addObject(ModelViewEnum.MODEL_PAGE.mav, plantManager.search(criteria));
        modelAndView.addObject(ModelViewEnum.MODEL_CRITERIA.mav, criteria);
        return modelAndView;
    }

    @PostMapping("/plant/list")
    public ModelAndView search(@Valid PlantDto criteria) {
        log.debug("ENTERING 'SEARCH LIST plant' METHOD...");
        ModelAndView modelAndView = new ModelAndView(ModelViewEnum.VIEW_PLANT_LIST.mav);
        if(criteria != null && criteria.getSize() == null){
            criteria.setSize(appProperties.getDefaultPageSize());
            criteria.setPage(appProperties.getDefaultPage());
        }
        modelAndView.addObject(ModelViewEnum.MODEL_PAGE.mav, plantManager.search(criteria));
        modelAndView.addObject(ModelViewEnum.MODEL_CRITERIA.mav, criteria);
        return modelAndView;
    }

    @ModelAttribute
    @GetMapping("/plant/form")
    public ModelAndView show(@RequestParam(value="id", required=false) Long id, HttpServletRequest request) throws Exception {
        log.debug("ENTERING 'SHOW FORM plant' METHOD...");
        ModelAndView modelAndView = new ModelAndView(ModelViewEnum.VIEW_PLANT_FORM.mav);
        PlantDto plantDto = new PlantDto();
        if(id != null) {
            plantDto = plantManager.get(id);
            if(plantDto == null) {
                addError(request, getText("data.notfound", request.getLocale()));
                return new ModelAndView(ModelViewEnum.REDIRECT_PLANT_LIST.mav);
            }
        }
        modelAndView.addObject("companies", companyManager.gets());
        modelAndView.addObject("plantDto", plantDto);
        return modelAndView;
    }

    @PostMapping("/plant/save")
    public String save(@Valid PlantDto plantDto, HttpServletRequest request, BindingResult bindingResult) {
        log.debug("ENTERING 'SAVE plant' METHOD...");
        Locale locale = request.getLocale();
        String view = ModelViewEnum.VIEW_PLANT_FORM.mav;
        if(plantDto.getId() != null) {
            view = "/plant/form?id=" + plantDto.getId();
        }
        if (bindingResult.hasErrors()) {
            addError(request, bindingResult.getAllErrors().toString());
            return view;
        }
        view = ModelViewEnum.REDIRECT_PLANT_LIST.mav;
        try {
            EntityResponse result = plantManager.save(plantDto);
            if(result.getCode().equals(EntityResponseCodeEnum.SUCCESS_200.val)) {
                addMessage(request, getText("plant.updated.success", locale));
            } else {
                addError(request, result.getMessage());
            }
        } catch (Exception e) {
            log.error("ERROR SAVE plant: EXCEPTION: {}", e);
            addError(request, e.getMessage());
        }
        return view;
    }
}
