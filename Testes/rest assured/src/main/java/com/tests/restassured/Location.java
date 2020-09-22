package com.tests.restassured;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@JsonPropertyOrder({"postCode", "country", "countryAbbreviation", "places"})
public class Location {

    @JsonProperty("post code")
    private String postCode;
    @JsonProperty("country")
    private String country;
    @JsonProperty("country abbreviation")
    private String countryAbbreviation;
    @JsonProperty("places")
    private List<Place> places;

    public Location() {
        this.postCode = "1050";

        Place place = new Place();
        List<Place> places = new ArrayList<>();
        places.add(place);

        this.places = places;
    }
}
