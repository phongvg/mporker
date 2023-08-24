package com.keysoft.pigfarm.common;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.keysoft.pigfarm.production.json.JsonRevisionContent;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;

class tesst {

	@Test
	void test() {
		
//		LocalDateTime toDateTime = LocalDate.now().plusDays(1).atStartOfDay().minusSeconds(1);
//		System.out.print(toDateTime);
		
		LocalDate a = LocalDate.of(2023, 03, 04);
		LocalDate b = LocalDate.of(2023, 03, 04);
		System.out.print(a.isBefore(b));
		System.out.println(LocalDateTime.now().getLong(ChronoField.NANO_OF_SECOND));
	}

	@Test
	void testJsonContent() throws JsonProcessingException {
		String revisionContent = "{\"action\": \"comment\", \"content\": \"Xe hàng gì vậy, chúng tôi không nhận được thông tin gì cả\"}";
		ObjectMapper mapper = new ObjectMapper();
		JsonRevisionContent jsonRevisionContent = mapper.readValue(revisionContent, JsonRevisionContent.class);
		System.out.println(jsonRevisionContent);
	}

	@Test
	void getValueIndexOfMap() {
		Map<String, String> map = new HashMap<>();
		map.put("name 1", "NVH");
		map.put("name 2", "DVH");
		map.put("name 3", "CAF");

		List keys = new ArrayList(map.keySet());
		for (int i = 0; i < keys.size(); i++) {
			try {
				Object obj = keys.get(5);
				System.out.println("key: " + obj);
			} catch (IndexOutOfBoundsException ex) {
				System.out.println("Exception");
			}
		}

		List values = new ArrayList(map.values());
		for (int i = 0; i < values.size(); i++) {
			Object obj = values.get(i);
			System.out.println("value: " + obj);
		}
	}

}
