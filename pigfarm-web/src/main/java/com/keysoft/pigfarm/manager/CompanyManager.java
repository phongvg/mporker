package com.keysoft.pigfarm.manager;

import com.keysoft.pigfarm.common.PageDto;
import com.keysoft.pigfarm.config.ServiceProperties;
import com.keysoft.pigfarm.constant.ApiEnum;
import com.keysoft.pigfarm.integration.EntityResponse;
import com.keysoft.pigfarm.production.dto.CompanyDto;
import com.keysoft.pigfarm.util.RestHelper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CompanyManager {
    @Autowired
    private RestHelper restHelper;
    @Autowired
    private ServiceProperties serviceProperties;

    public EntityResponse save(CompanyDto companyDto) {
        log.info("PROCESS: SAVE COMPANY, COMPANY: {}", companyDto);
        ResponseEntity<?> response = null;
        if (companyDto.getId() != null) {
            response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_COMPANY_UPDATE.val), HttpMethod.PUT, companyDto, EntityResponse.class, companyDto.getId());
        } else {
            response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_COMPANY_CREATE.val), HttpMethod.POST, companyDto, EntityResponse.class);
        }
        return (EntityResponse)response.getBody();
    }

    public CompanyDto get(Long id) {
        log.info("PROCESS: GET COMPANY, COMPANY_ID: {}", id);
        ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_COMPANY_GET.val), HttpMethod.GET, CompanyDto.class, id);
        return (CompanyDto)response.getBody();
    }

    public PageDto search(CompanyDto criteria) {
        log.info("process=search-company, criteria{}", criteria );
        ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_COMPANY_SEARCH.val), HttpMethod.POST, criteria , PageDto.class);
        return (PageDto) response.getBody();

    }

    public List<CompanyDto> gets(){
        log.info("process=gets-company");
        ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_COMPANY_GETS.val), HttpMethod.GET, new ParameterizedTypeReference<List<CompanyDto>>() {});
        return (List<CompanyDto>)response.getBody();
    }
}
