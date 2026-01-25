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
        assertEquals(myData.toString(), "TemplateData{data=[{a=TemplateValue{innerData=null, value='b'}, c=TemplateValue{innerData=null, value='d'}}]}");

        // ---------------------------------------------------------

        var myData2 = new TemplateData();

        // more complicated - providing a list of maps, which will render again for each
        // item in the list
        myData2.add(List.of(Map.of("a","b"), Map.of("c","d")));
        assertEquals(myData2.toString(), "TemplateData{data=[{a=TemplateValue{innerData=null, value='b'}}, {c=TemplateValue{innerData=null, value='d'}}]}");

        // ---------------------------------------------------------

        var myData3 = new TemplateData();

        // a complication - providing a list of key-value pairs for an inner
        // template, nested one-level down.
        myData3.add("a", List.of(Map.of("a","b","c","d"), Map.of("a","b","c","d")));
        assertEquals(myData3.toString(), "TemplateData{data" +
                "=[" +
                    "{" +
                        "a=" +
                        "TemplateValue{innerData=" +
                            "[" +
                                "{a=TemplateValue{innerData=null, value='b'}, c=TemplateValue{innerData=null, value='d'}}, " +
                                "{a=TemplateValue{innerData=null, value='b'}, c=TemplateValue{innerData=null, value='d'}}" +
                            "]" +
                        ", value='null'}" +
                    "}" +
                "]" +
                "}");

    }

}
