
package com.karolgruszczynski.assigment.spring.openweather.api;

import com.fasterxml.jackson.annotation.*;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@ToString
public class Clouds {

    @JsonProperty("all")
    private Integer all;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("all")
    public Integer getAll() {
        return all;
    }

    @JsonProperty("all")
    public void setAll(Integer all) {
        this.all = all;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
