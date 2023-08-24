package com.keysoft.pigfarm.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.keysoft.pigfarm.manager.TenantManager;
import com.keysoft.pigfarm.master.dto.TenantDto;

import lombok.extern.slf4j.Slf4j;

/**
 * Generated by Speed Generator
 * 
 * @author <a href="mailto:ngtrungkien@gmail.com">Kien Nguyen</a>
 */
 @Slf4j
@Controller
public class TenantController extends BaseController {

	@Autowired
    private TenantManager tenantManager;

    @GetMapping("/tenant/list")
    public ModelAndView list(HttpServletRequest request) {
    	log.debug("entering 'list' method...");
    	
		ModelAndView modelAndView = new ModelAndView("tenant-list");
		TenantDto criteria = new TenantDto();
		criteria.setPage(appProperties.getDefaultPage());
		criteria.setSize(appProperties.getDefaultPageSize());
		modelAndView.addObject("page", tenantManager.search(criteria));
        return modelAndView;
    }
    
    @PostMapping("/tenant/list")
    public ModelAndView search(@Validated TenantDto criteria, BindingResult bindingResult) {
    	log.debug("entering 'search' method...");
		ModelAndView modelAndView = new ModelAndView("tenant-list");
		modelAndView.addObject("page", tenantManager.search(criteria));
		modelAndView.addObject("criteria",criteria);
        return modelAndView;
    }
    
	@GetMapping("/tenant/form*")
	public ModelAndView form(@RequestParam (name= "id", required = false) Long id) {
		log.debug("entering 'show' method");
		ModelAndView modelAndView = new ModelAndView("tenant-form");
		TenantDto tenantDto =  new TenantDto();
		if(id != null) {
			tenantDto =  tenantManager.get(id);
		}
		modelAndView.addObject("tenant", tenantDto);		
		return modelAndView;
	}
    
    
    @ModelAttribute
    @GetMapping("/tenant/edit/{id}")
    public ModelAndView show(@PathVariable ("id") @NonNull Long id) throws Exception {
    	log.debug("entering 'show' method...");
    
    	ModelAndView modelAndView = new ModelAndView("tenant-form");
        modelAndView.addObject(tenantManager.get(id));

        return modelAndView;
    }

    @PostMapping("/tenant/save")
    public String save(@Validated TenantDto tenantDto, BindingResult bindingResult, HttpServletRequest request, HttpServletResponse response) throws Exception {
        log.debug("entering 'save' method...");

        Locale locale = request.getLocale();
        String view = "tenant-form";
        
        if (bindingResult.hasErrors()) {
        	addError(request, bindingResult.getAllErrors().toString());
            return view;
        }

        tenantManager.save(tenantDto);
        
        if (tenantDto.getId() != null) {
            addMessage(request, getText("tenant.updated", locale));        	
        } else {
            addMessage(request, getText("tenant.created", locale));
        }
        
        view = "redirect:/tenant/list";

        return view;
    }
    
}