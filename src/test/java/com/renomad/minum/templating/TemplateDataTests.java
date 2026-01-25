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

        var myData = new TemplateData();

        // a basic simpler happy-path - data for a template with no nested templates
        myData.add(Map.of("a","b","c","d"));
        assertEquals(myData.toString(), "TemplateData{data=[" +
                "{" +
                    "a=TemplateValue{innerData=null, value='b', templateValueType=STRING}," +
                    " c=TemplateValue{innerData=null, value='d', templateValueType=STRING}" +
                "}" +
                "]}");

        // ---------------------------------------------------------

        var myData2 = new TemplateData();

        // more complicated - providing a list of maps, which will render again for each
        // item in the list
        myData2.add(List.of(Map.of("a","b"), Map.of("a","z")));
        assertEquals(myData2.toString(), "TemplateData{data=" +
                    "[" +
                        "{a=TemplateValue{innerData=null, value='b', templateValueType=STRING}}, " +
                        "{a=TemplateValue{innerData=null, value='z', templateValueType=STRING}}" +
                    "]" +
                "}");

        // ---------------------------------------------------------

        var myData3 = new TemplateData();

        // a complication - providing a list of key-value pairs for an inner
        // template, nested one-level down.
        myData3.add("F", List.of(Map.of("a","b","c","d"), Map.of("a","m","c","p")));
        assertEquals(myData3.toString(), "TemplateData{data=" +
                "[" +
                    "{F=" +
                        "TemplateValue{innerData=[" + // the inner template will be rendered twice, once for each map
                            "{a=TemplateValue{innerData=null, value='b', templateValueType=STRING}, c=TemplateValue{innerData=null, value='d', templateValueType=STRING}}, " +
                            "{a=TemplateValue{innerData=null, value='m', templateValueType=STRING}, c=TemplateValue{innerData=null, value='p', templateValueType=STRING}}" +
                        "], " +
                        "value='null', templateValueType=LIST_OF_MAPS}}" +
                "]}");

    }

}
