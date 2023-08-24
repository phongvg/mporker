package com.keysoft.pigfarm.controller;

import com.keysoft.pigfarm.common.EntityResponseCodeEnum;
import com.keysoft.pigfarm.constant.ModelViewEnum;
import com.keysoft.pigfarm.integration.EntityResponse;
import com.keysoft.pigfarm.manager.CompanyManager;
import com.keysoft.pigfarm.production.dto.CompanyDto;
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
public class CompanyController extends BaseController {
    @Autowired
    private CompanyManager companyManager;

    @GetMapping("/company/list")
    public ModelAndView list() throws IOException {
        log.debug("ENTERING 'LIST COMPANY' METHOD...");
        ModelAndView modelAndView = new ModelAndView(ModelViewEnum.VIEW_COMPANY_LIST.mav);
        CompanyDto criteria = CompanyDto.builder()
                .page(appProperties.getDefaultPage())
                .size(appProperties.getDefaultPageSize())
                .build();
        modelAndView.addObject(ModelViewEnum.MODEL_PAGE.mav, companyManager.search(criteria));
        modelAndView.addObject(ModelViewEnum.MODEL_CRITERIA.mav, criteria);
        return modelAndView;
    }

    @PostMapping("/company/list")
    public ModelAndView search(@Valid CompanyDto criteria) {
        log.debug("ENTERING 'SEARCH LIST COMPANY' METHOD...");
        ModelAndView modelAndView = new ModelAndView(ModelViewEnum.VIEW_COMPANY_LIST.mav);
        if(criteria != null && criteria.getSize() == null){
            criteria.setSize(appProperties.getDefaultPageSize());
            criteria.setPage(appProperties.getDefaultPage());
        }
        modelAndView.addObject(ModelViewEnum.MODEL_PAGE.mav, companyManager.search(criteria));
        modelAndView.addObject(ModelViewEnum.MODEL_CRITERIA.mav, criteria);
        return modelAndView;
    }

    @ModelAttribute
    @GetMapping("/company/form")
    public ModelAndView show(@RequestParam(value="id", required=false) Long id, HttpServletRequest request) throws Exception {
        log.debug("ENTERING 'SHOW FORM COMPANY' METHOD...");
        ModelAndView modelAndView = new ModelAndView(ModelViewEnum.VIEW_COMPANY_FORM.mav);
        CompanyDto companyDto = new CompanyDto();
        if(id != null) {
            companyDto = companyManager.get(id);
            if(companyDto == null) {
                addError(request, getText("data.notfound", request.getLocale()));
                return new ModelAndView(ModelViewEnum.REDIRECT_COMPANY_LIST.mav);
            }
        }
        modelAndView.addObject("companyDto", companyDto);
        return modelAndView;
    }

    @PostMapping("/company/save")
    public String save(@Valid CompanyDto companyDto, HttpServletRequest request, BindingResult bindingResult) {
        log.debug("ENTERING 'SAVE COMPANY' METHOD...");
        Locale locale = request.getLocale();
        String view = ModelViewEnum.VIEW_COMPANY_FORM.mav;
        if(companyDto.getId() != null) {
            view = "/company/form?id=" + companyDto.getId();
        }
        if (bindingResult.hasErrors()) {
            addError(request, bindingResult.getAllErrors().toString());
            return view;
        }
        view = ModelViewEnum.REDIRECT_COMPANY_LIST.mav;
        try {
            EntityResponse result = companyManager.save(companyDto);
            if(result.getCode().equals(EntityResponseCodeEnum.SUCCESS_200.val)) {
                addMessage(request, getText("company.updated.success", locale));
            } else {
                addError(request, result.getMessage());
            }
        } catch (Exception e) {
            log.error("ERROR SAVE COMPANY: EXCEPTION: {}", e);
            addError(request, e.getMessage());
        }
        return view;
    }
}
