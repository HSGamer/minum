package com.renomad.minum.templating;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TemplateData {

    private List<Map<String, TemplateValue>> data;

    public TemplateData() {
        this.data = new ArrayList<>();
    }

    // these are all prototypes

    // TODO this is just a prototype
    public <E> void add(String keyToInnerTemplate,
                         List<Map<String,String>> innerTemplateValues) {
        for (Map<String, String> newMapData : innerTemplateValues) {
            Map<String, TemplateValue> conversionMap = new HashMap<>();
            for (Map.Entry<String, String> data : newMapData.entrySet()) {
                conversionMap.put(data.getKey(), new TemplateValue(data.getValue()));
            }
            data.get(0).get(keyToInnerTemplate).innerData.add(conversionMap);
        }
    }

    public void add(Map<String, String> newMapData) {
        Map<String, TemplateValue> conversionMap = new HashMap<>();
        for (Map.Entry<String,String> data : newMapData.entrySet()) {
            conversionMap.put(data.getKey(), new TemplateValue(data.getValue()));
        }
        data.add(conversionMap);
    }

    public void add(List<Map<String, String>> newMapDataList) {
        for (Map<String, String> newMapData : newMapDataList) {
            Map<String, TemplateValue> conversionMap = new HashMap<>();
            for (Map.Entry<String, String> data : newMapData.entrySet()) {
                conversionMap.put(data.getKey(), new TemplateValue(data.getValue()));
            }
            data.add(conversionMap);
        }
    }
}
