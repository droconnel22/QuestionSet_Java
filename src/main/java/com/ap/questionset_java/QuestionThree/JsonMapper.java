package com.ap.questionset_java.QuestionThree;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.util.*;

public class JsonMapper {

    public static String Map(String input, String schema) throws Exception {

        if(input.isEmpty() || schema.isEmpty()) {
            throw new Exception("Invalid arguments");
        }

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> schemaMap = mapper.readValue(schema, new TypeReference<Map<String,String>>(){});
        Map<String, String> resultMap = new HashMap<String, String>();
        JsonNode jsonNode = mapper.readTree(input);

        for(Map.Entry<String, String> entry : schemaMap.entrySet()) {

            Queue<String> path =  new LinkedList<>(Arrays.asList(entry.getValue().split("\\.")));
            String currentKey = path.remove();
            while(jsonNode.has(currentKey) && path.size() > 0) {
                jsonNode = jsonNode.elements().next();
                currentKey = path.remove();
            }
            resultMap.put(entry.getKey(),jsonNode.get(currentKey).textValue());
        }


        return mapper.writeValueAsString(resultMap);
    }
}