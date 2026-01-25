package com.renomad.minum.templating;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TemplateValue {

    public List<Map<String, TemplateValue>> innerData;
    public String value;

    public TemplateValue(List<Map<String, TemplateValue>> innerData) {
        this.innerData = innerData;
    }

    public TemplateValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        TemplateValue that = (TemplateValue) o;
        return Objects.equals(innerData, that.innerData) && Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(innerData, value);
    }

    @Override
    public String toString() {
        return "TemplateValue{" +
                "innerData=" + innerData +
                ", value='" + value + '\'' +
                '}';
    }
}