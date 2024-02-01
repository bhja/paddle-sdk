package com.paddle.address;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
@NoArgsConstructor
public class AddressCreateParams {
    @JsonProperty("first_line")
    private String firstLine;
    @JsonProperty("second_line")
    private String secondLine;
    private String city;
    @JsonProperty("postal_code")
    private String postalCode;
    private String region;

    @JsonProperty("country_code")
    private String countryCode;

    @JsonProperty("custom_data")
    private Map<String, Object> customData;
}
