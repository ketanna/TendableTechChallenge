package com.tendable.Util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class JsonParser {

    /**
     * This method is to parse the data from .json file
     */
    public List<Map<String, Object>> getJsonData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<Map<String, Object>> map = mapper.readValue(new File(System.getProperty("user.dir") + "\\src\\main\\Resources\\marketingForm.json"), new TypeReference<List<Map<String, Object>>>(){});
        return map;
    }

}
