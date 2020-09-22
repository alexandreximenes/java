package com.tests.restassured;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonPropertyOrder({"placeName", "longitude", "state", "stateAbbreviation", "latitude" })
public class Place {

    @JsonProperty("post code")
    private String placeName;
    @JsonProperty("longitude")
    private String longitude;
    @JsonProperty("state")
    private String state;
    @JsonProperty("state abbreviation")
    private String stateAbbreviation;
    @JsonProperty("latitude")
    private String latitude;
}
