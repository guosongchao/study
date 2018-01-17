package com.guosc.study;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.guosc.study.idea.iclazz.JSONObjectOperation;

import java.util.*;

/**
 * Created by DOOM on 2017/7/26.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>();
        JSONObject jsonObject = new JSONObject();
        JSONObject criteria = new JSONObject();
        criteria.put("valid", true);
        jsonObject.put("criteria", criteria);
        System.out.println(jsonObject.toJSONString());
        String s = "{\"criteria\":{\"valid\":true}}";
    }

    public static int[] twoSum(int[] numbers, int target) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i=0; i<numbers.length; i++){
            if(numbers[i] <= target)
                map.put(numbers[i], i);
        }
        int[] returnNumbers = new int[2];
        for(int one : map.keySet()){
            int two = target - one;
            if(two > one){
                break;
            }
            int oneIndex = map.get(one);
            if(!map.containsKey(two)){
                continue;
            }
            int twoIndex = map.get(two);
            if(oneIndex != twoIndex){
                returnNumbers[0] = oneIndex;
                returnNumbers[1] = twoIndex;
            }else{
                returnNumbers[0] = oneIndex;
                returnNumbers[1] = twoIndex + 1;
            }
        }
        return returnNumbers;
    }

    public static JSONObject operationQueryResult(String queryResult, JSONObjectOperation operation, String... operationStr) throws Exception{
        JSONObject queryResultJson = JSONObject.parseObject(queryResult);
        if("failure".equals(queryResultJson.getString("Result")) || queryResultJson.getIntValue("Count") < 1)
            return queryResultJson;
        JSONArray queryResultArray = queryResultJson.getJSONArray("Content");
        JSONArray returnArray = new JSONArray();
        for(int i=0; i<queryResultArray.size(); i++){
            returnArray.add(operation.operation(queryResultArray.getJSONObject(i), operationStr));
        }
        queryResultJson.put("Content", returnArray);
        queryResultJson.put("Count", returnArray.size());
        return queryResultJson;
    }
}
