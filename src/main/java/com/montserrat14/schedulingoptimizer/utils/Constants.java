package com.montserrat14.schedulingoptimizer.utils;


public final class Constants {

    public final static String PAYLOAD= "{\n" +
            "  \"order\": {\n" +
            "    \"name\": \"Order Name\",\n" +
            "    \"description\": \"Order Description\",\n" +
            "    \"jobs\": [\n" +
            "      {\n" +
            "        \"name\": \"Job 1\",\n" +
            "        \"description\": \"Description for job 1\",\n" +
            "        \"operations\": [\n" +
            "          {\n" +
            "            \"resourceId\": \"\",\n" +
            "            \"estimatedTime\": \"\",\n" +
            "            \"index\": \"\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    ],\n" +
            "    \"objectives\": {\n" +
            "      \"totalTime\": true,\n" +
            "      \"cost\": false\n" +
            "    },\n" +
            "    \"duration\": \"\"\n" +
            "  },\n" +
            "  \"resource\": {\n" +
            "    \"type\": \"Employee\",\n" +
            "    \"resources\": [\n" +
            "      {\n" +
            "        \"id\": \"1\",\n" +
            "        \"name\": \"Empolyee 1\",\n" +
            "        \"quantity\": \"10\",\n" +
            "        \"cost\": \"1222\",\n" +
            "        \"description\": \"Employee Description\"\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    public final static String PAYLOAD_ORDER = "order";
    public final static String PAYLOAD_RESOURCE = "resource";

}
