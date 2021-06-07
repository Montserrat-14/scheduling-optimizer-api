package com.montserrat14.schedulingoptimizer.utils;


public final class Constants {

    public final static String PAYLOAD= "{\n" +
            "  \"order\": {\n" +
            "    \"name\": \"Problem 1\",\n" +
            "    \"description\": \"Problem 1\",\n" +
            "    \"jobs\": [\n" +
            "      {\n" +
            "        \"name\": \"Job 0\",\n" +
            "        \"operations\": [\n" +
            "          {\n" +
            "            \"resourceId\": 0,\n" +
            "            \"estimatedTime\": 3,\n" +
            "            \"index\": 0\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceId\": 1,\n" +
            "            \"estimatedTime\": 2,\n" +
            "            \"index\": 1\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceId\": 2,\n" +
            "            \"estimatedTime\": 2,\n" +
            "            \"index\": 2\n" +
            "          }\n" +
            "        ],\n" +
            "        \"description\": \"Description Job 1\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Job 1\",\n" +
            "        \"operations\": [\n" +
            "          {\n" +
            "            \"resourceId\": 0,\n" +
            "            \"estimatedTime\": 2,\n" +
            "            \"index\": 0\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceId\": 2,\n" +
            "            \"estimatedTime\": 1,\n" +
            "            \"index\": 1\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceId\": 1,\n" +
            "            \"estimatedTime\": 4,\n" +
            "            \"index\": 2\n" +
            "          }\n" +
            "        ],\n" +
            "        \"description\": \"Description Job 2\"\n" +
            "      },\n" +
            "      {\n" +
            "        \"name\": \"Job 2\",\n" +
            "        \"operations\": [\n" +
            "          {\n" +
            "            \"resourceId\": 1,\n" +
            "            \"estimatedTime\": 4,\n" +
            "            \"index\": 0\n" +
            "          },\n" +
            "          {\n" +
            "            \"resourceId\": 2,\n" +
            "            \"estimatedTime\": 3,\n" +
            "            \"index\": 1\n" +
            "          }\n" +
            "        ],\n" +
            "        \"description\": \"Description Job 3\"\n" +
            "      }\n" +
            "    ],\n" +
            "    \"duration\": 8,\n" +
            "    \"objectives\": {\n" +
            "      \"totalTime\": true\n" +
            "    }\n" +
            "  },\n" +
            "  \"resource\": {\n" +
            "    \"type\": \"Machines\",\n" +
            "    \"resources\": [\n" +
            "      {\n" +
            "        \"id\": 0,\n" +
            "        \"name\": \"Machine A\",\n" +
            "        \"quantity\": 1,\n" +
            "        \"cost\": 10,\n" +
            "        \"description\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 1,\n" +
            "        \"name\": \"Machine B\",\n" +
            "        \"quantity\": 1,\n" +
            "        \"cost\": 10,\n" +
            "        \"description\": null\n" +
            "      },\n" +
            "      {\n" +
            "        \"id\": 2,\n" +
            "        \"name\": \"Machine C\",\n" +
            "        \"quantity\": 1,\n" +
            "        \"cost\": 10,\n" +
            "        \"description\": null\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    public final static String PAYLOAD_ORDER = "order";
    public final static String PAYLOAD_RESOURCE = "resource";

}
