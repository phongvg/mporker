package com.keysoft.pigfarm.manager;

import java.util.List;

import com.keysoft.pigfarm.common.PageDto;
import com.keysoft.pigfarm.integration.EntityResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.keysoft.pigfarm.config.ServiceProperties;
import com.keysoft.pigfarm.constant.ApiEnum;
import com.keysoft.pigfarm.production.dto.PlantDto;
import com.keysoft.pigfarm.util.RestHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PlantManager {
	@Autowired
	private RestHelper restHelper;
	@Autowired
	private ServiceProperties serviceProperties;
	
	@SuppressWarnings("unchecked")
	public List<PlantDto> gets() {
		log.info("process=gets-plant");
		ResponseEntity<?> response = restHelper.send(
				serviceProperties.getPaths().get(ApiEnum.PATH_PLANT_GETS.val)
				, HttpMethod.GET
				, new ParameterizedTypeReference<List<PlantDto>>() {});
		return (List<PlantDto>) response.getBody();
	}
	
	@SuppressWarnings("unchecked")
	public List<PlantDto> getAll() {
		log.info("process=gets-plant");
		ResponseEntity<?> response = restHelper.send(
				serviceProperties.getPaths().get(ApiEnum.PATH_PLANT_GET_ALL.val)
				, HttpMethod.GET
				, new ParameterizedTypeReference<List<PlantDto>>() {});
		return (List<PlantDto>) response.getBody();
	}

	public EntityResponse save(PlantDto plantDto) {
		log.info("PROCESS: SAVE PLANT, PLANT: {}", plantDto);
		ResponseEntity<?> response = null;
		if (plantDto.getId() != null) {
			response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_PLANT_UPDATE.val), HttpMethod.PUT, plantDto, EntityResponse.class, plantDto.getId());
		} else {
			response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_PLANT_CREATE.val), HttpMethod.POST, plantDto, EntityResponse.class);
		}
		return (EntityResponse)response.getBody();
	}

	public PlantDto get(Long id) {
		log.info("PROCESS: GET PLANT, PLANT_ID: {}", id);
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_PLANT_GET.val), HttpMethod.GET, PlantDto.class, id);
		return (PlantDto)response.getBody();
	}

	public PageDto search(PlantDto criteria) {
		log.info("process=search-plant, criteria{}", criteria );
		ResponseEntity<?> response = restHelper.send(serviceProperties.getPaths().get(ApiEnum.PATH_PLANT_SEARCH.val), HttpMethod.POST, criteria , PageDto.class);
		return (PageDto) response.getBody();

	}
}
