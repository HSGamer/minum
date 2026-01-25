package com.renomad.minum.templating;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TemplateValue {

    public List<Map<String, TemplateValue>> innerData;
    public String value;

    public TemplateValue(List<Map<String, TemplateValue>> innerData) {
        this.innerData = innerData;
    }

    public TemplateValue(String value) {
        this.value = value;
    }
}