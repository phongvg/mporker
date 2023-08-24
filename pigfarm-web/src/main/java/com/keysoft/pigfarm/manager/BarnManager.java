package com.keysoft.pigfarm.manager;



import java.util.List;

import com.keysoft.pigfarm.integration.EntityResponse;
import com.keysoft.pigfarm.production.dto.FarmDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.keysoft.pigfarm.common.PageDto;
import com.keysoft.pigfarm.config.ServiceProperties;
import com.keysoft.pigfarm.constant.ApiEnum;
import com.keysoft.pigfarm.production.dto.BarnDto;
import com.keysoft.pigfarm.util.RestHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BarnManager {
	@Autowired
	private RestHelper restHelper;
	@Autowired
	private ServiceProperties serviceProperties;
	
	public PageDto gets(BarnDto criteria) {
		log.info("process=get-barns, criteria={}", criteria);
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_BARN_SEARCH.val), HttpMethod.POST ,criteria,PageDto.class );
		return (PageDto) response.getBody();
	}
	
	@SuppressWarnings("unchecked")
	public List<BarnDto> getsByFarmCode(String farmCode) {
		log.info("****************MANAGER::gets-by-farmCode********************");
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_BARNS_BY_FARMCODE.val), HttpMethod.GET, new ParameterizedTypeReference<List<BarnDto>>() {}, farmCode);
		return (List<BarnDto>) response.getBody();
	}
	
	public BarnDto get(String barnCode) {
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_BARN_BY_CODE_GET.val), HttpMethod.GET, BarnDto.class, barnCode);
		return (BarnDto) response.getBody();
	}
	public BarnDto get(Long id) {
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_BARN_BY_ID.val), HttpMethod.GET, BarnDto.class, id);
		return (BarnDto) response.getBody();
	}

	public EntityResponse save(BarnDto barnDto) {
		log.info("PROCESS: SAVE BARN, BARN: {}", barnDto);
		ResponseEntity<?> response = null;
		if (barnDto.getId() != null) {
			response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_BARN_UPDATE.val), HttpMethod.PUT, barnDto, EntityResponse.class, barnDto.getId());
		} else {
			response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_BARN_CREATE.val), HttpMethod.POST, barnDto, EntityResponse.class);
		}
		return (EntityResponse)response.getBody();
	}

	public List<BarnDto> gets() {
		log.info("PROCESS: GET ALL BARN");
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_BARN_GET_ALL.val), HttpMethod.GET, new ParameterizedTypeReference<List<BarnDto>>() {});
		return (List<BarnDto>) response.getBody();
	}

}
