package com.qa.api.util;

import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;

public class Utilities {
	
	/**
	 * To fetch the value for the key in the JSON object
	 * @param jsonObj
	 * @param key
	 */
	public static void parseJSONObject(JSONObject jsonObj , String key) {
				
		System.out.println("Key : {"+key+"} | Value : {"+jsonObj.get(key)+"}");
		
	}
	
	
	/**
	 * To search for the key in the json object
	 * @param jsonObj
	 * @param key
	 */
	public static void getKey(JSONObject jsonObj , String key) {
		
		//To check whether the passed key is present in the JSON object
		boolean keyExist = jsonObj.has(key);
		System.out.println("Checking for the Key : {"+key+"} is present: "+jsonObj.has(key));
		
		//If the key doesn't exist
		Iterator<?> it;
		String nextKey;
		
		if(!keyExist) {
			it = jsonObj.keys();
			while(it.hasNext()) {
				nextKey = (String) it.next();
				
				try {
					
					if(jsonObj.get(nextKey) instanceof JSONObject) {
						
						if(keyExist == false) {
							getKey(jsonObj.getJSONObject(nextKey), key);
						}
						
					}
					else if(jsonObj.get(nextKey) instanceof JSONArray) {
						JSONArray jsonArray = jsonObj.getJSONArray(nextKey);
						for(int i = 0 ; i < jsonArray.length() ; i++) {
							String jsonArrayString = jsonArray.get(i).toString();
							JSONObject innerJsonObj = new JSONObject(jsonArrayString);
							
							if(keyExist == false) {
								getKey(innerJsonObj, key);
							}
						}
					}
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		//If the key exists 
		else {
			parseJSONObject(jsonObj, key);
		}
	}
	
	
	public static void main(String[] args) {
		
		String jsonString = "{\r\n"
				+ "    \"page\": 1,\r\n"
				+ "    \"per_page\": 6,\r\n"
				+ "    \"total\": 12,\r\n"
				+ "    \"total_pages\": 2,\r\n"
				+ "    \"data\": [\r\n"
				+ "        {\r\n"
				+ "            \"id\": 1,\r\n"
				+ "            \"name\": \"cerulean\",\r\n"
				+ "            \"year\": 2000,\r\n"
				+ "            \"color\": \"#98B2D1\",\r\n"
				+ "            \"pantone_value\": \"15-4020\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 2,\r\n"
				+ "            \"name\": \"fuchsia rose\",\r\n"
				+ "            \"year\": 2001,\r\n"
				+ "            \"color\": \"#C74375\",\r\n"
				+ "            \"pantone_value\": \"17-2031\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 3,\r\n"
				+ "            \"name\": \"true red\",\r\n"
				+ "            \"year\": 2002,\r\n"
				+ "            \"color\": \"#BF1932\",\r\n"
				+ "            \"pantone_value\": \"19-1664\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 4,\r\n"
				+ "            \"name\": \"aqua sky\",\r\n"
				+ "            \"year\": 2003,\r\n"
				+ "            \"color\": \"#7BC4C4\",\r\n"
				+ "            \"pantone_value\": \"14-4811\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 5,\r\n"
				+ "            \"name\": \"tigerlily\",\r\n"
				+ "            \"year\": 2004,\r\n"
				+ "            \"color\": \"#E2583E\",\r\n"
				+ "            \"pantone_value\": \"17-1456\"\r\n"
				+ "        },\r\n"
				+ "        {\r\n"
				+ "            \"id\": 6,\r\n"
				+ "            \"name\": \"blue turquoise\",\r\n"
				+ "            \"year\": 2005,\r\n"
				+ "            \"color\": \"#53B0AE\",\r\n"
				+ "            \"pantone_value\": \"15-5217\"\r\n"
				+ "        }\r\n"
				+ "    ],\r\n"
				+ "    \"support\": {\r\n"
				+ "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
				+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
				+ "    }\r\n"
				+ "}";
		
		JSONObject inputJsonObj = new JSONObject(jsonString);	
		getKey(inputJsonObj, "name");
		
		}

}
