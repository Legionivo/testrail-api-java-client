package io.github.legionivo.api.testrail.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

/**
 * TestRail template.
 */
@Data
public class Template {

    private int id;

    @JsonProperty(value = "is_default")
    @Getter(onMethod_ = {@JsonIgnore})
    private boolean isDefault;

    private String name;
}
