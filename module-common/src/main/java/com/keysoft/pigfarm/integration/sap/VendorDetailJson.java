package com.keysoft.pigfarm.integration.sap;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.jackson.JsonComponent;

@Data
@NoArgsConstructor
@JsonComponent
public class VendorDetailJson {
    @JsonProperty("LIFNR")
    private String vendorCode;

    @JsonProperty("NAME1")
    private String vendorName;

    @JsonProperty("STRAS")
    private String street;

    @JsonProperty("ORT01")
    private String city;

    @JsonProperty("ORT02")
    private String district;

    @JsonProperty("STCEG")
    private String taxNumber;

    @JsonProperty("BUKRS")
    private String companyCode;

    @JsonProperty("ADDRESS")
    private String address;
}
