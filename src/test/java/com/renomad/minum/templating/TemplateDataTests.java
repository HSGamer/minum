package com.renomad.minum.templating;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.renomad.minum.testing.TestFramework.assertEquals;

public class TemplateDataTests {

    @Test
    public void testTemplateData_SimpleCase() {
//        List<Map<String, TemplateValue>> myData = new ArrayList<>();
//        myData.add(Map.of("foo", new TemplateValue("bar"), "baz", new TemplateValue("bar")));
//        myData.add(Map.of("foo", new TemplateValue(List.of(Map.of("biz", new TemplateValue("baz"))))));

        var myData = new TemplateData();

        myData.add(Map.of("a","b","c","d"));
        myData.add(List.of(Map.of("a","b"), Map.of("c","d")));
        myData.add("a", List.of(Map.of("a","b","c","d"), Map.of("a","b","c","d")));
    }

}
