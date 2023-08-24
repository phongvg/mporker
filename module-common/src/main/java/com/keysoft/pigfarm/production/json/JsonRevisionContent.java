package com.keysoft.pigfarm.production.json;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JsonRevisionContent {
    @JsonProperty
    private String action;
    @JsonProperty
    private String content;
}
