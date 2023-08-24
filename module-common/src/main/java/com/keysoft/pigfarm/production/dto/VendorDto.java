package com.keysoft.pigfarm.production.dto;

import com.keysoft.pigfarm.common.BaseDto;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.io.Serializable;

@Data
@SuperBuilder
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class VendorDto extends BaseDto implements Serializable {
    private Long id;
    private String code;
    private String name;
    private String street;
    private String district;
    private String city;
    private String taxNumber;
    private String companyCode;
}
