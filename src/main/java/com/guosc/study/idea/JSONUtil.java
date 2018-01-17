package com.guosc.study.idea;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.guosc.study.idea.iclazz.JSONObjectOperation;

import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by DOOM on 2017/8/11.
 */
public class JSONUtil {

    public static JSONObject sortWorkOrderFromEngine(JSONObject resultJson, int order){
//        JSONObject resultJson = JSONObject.parseObject(queryResult);
        if("success".equals(resultJson.getString("Result"))){
            JSONArray array = resultJson.getJSONArray("Content");
            Collections.sort(array, new Comparator<Object>(){
                public int compare(Object str1, Object str2){
                    JSONObject obj1 = JSONObject.parseObject(str1.toString());
                    JSONObject obj2 = JSONObject.parseObject(str2.toString());
                    return obj1.getJSONObject("work_order").getJSONObject("wo_body").getString("publish_time").compareTo(obj2.getJSONObject("work_order").getJSONObject("wo_body").getString("publish_time")) * order;
                }
            });
        }
        return resultJson;
    }

    /**
     * filter info
     */
    public static JSONObjectOperation filter = (jsonObject, filters) -> {
        JSONObject returnJson = new JSONObject();
        for(String filter : filters){
            returnJson.put(filter, jsonObject.get(filter));
        }
        return returnJson;
    };

    /**
     * String to JSONObject/JSONArray
     */
    public static JSONObjectOperation processStringToJson = (jsonObject, marjors) ->{
        if(jsonObject != null){
            String content;
            for(String marjor : marjors){
                content = jsonObject.getString(marjor);
                if(content != null){
                    if(content.startsWith("{"))
                        jsonObject.put(marjor, JSONObject.parseObject(content));
                    else if(content.startsWith("["))
                        jsonObject.put(marjor, JSONArray.parseArray(content));
                }
            }
        }
        return jsonObject;
    };

    /**
     * tranfer infoValue of date type
     */
    public static JSONObjectOperation tranferTimeFormat = (jsonObject, marjors) ->{
        SimpleDateFormat fsdf = new SimpleDateFormat("yyyyMMddHHmmss");
        SimpleDateFormat tsdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        for(String marjor : marjors){
            if(jsonObject.containsKey(marjor))
                jsonObject.put(marjor, tsdf.format(fsdf.parse(jsonObject.getString(marjor))));
        }
        return jsonObject;
    };

    /**
     * process result : tranfer info of date type、 filter info、 process string to json
     * @param queryResult query result
     * @param tranferTimeFormat operation of tranfer info of date type
     * @param processStringToJson operation of process string to json
     * @param filter operation of filter info
     * @param dataInfo parameter of tranfer info of date type
     * @param jsonInfo parameter of process string to json
     * @param filters parameter of filter info
     * @return
     * @throws Exception
     */
    public static JSONObject processQueryResult(String queryResult, JSONObjectOperation tranferTimeFormat, String dataInfo, JSONObjectOperation processStringToJson, String[] jsonInfo, JSONObjectOperation filter, String... filters) throws Exception{
        JSONObject queryResultJson = JSONObject.parseObject(queryResult);
        if("failure".equals(queryResultJson.getString("Result")) || queryResultJson.getIntValue("Count") < 1)
            return queryResultJson;
        JSONArray queryResultArray = queryResultJson.getJSONArray("Content");
        JSONArray returnArray = new JSONArray();
        JSONObject item;
        for(int i=0; i<queryResultArray.size(); i++){
            item = queryResultArray.getJSONObject(i);
            if(tranferTimeFormat != null)
                item = tranferTimeFormat.operation(item, dataInfo);
            if(processStringToJson != null)
                item = processStringToJson.operation(item, jsonInfo);
            if(filter != null)
                item = filter.operation(item, filters);
            returnArray.add(item);
        }
        queryResultJson.put("Content", returnArray);
        queryResultJson.put("Count", returnArray.size());
        return queryResultJson;
    }

    /**
     * get first record from query result
     * @param queryResult query result
     * @param tranferTimeFormat operation of tranfer info of date type
     * @param processStringToJson operation of process string to json
     * @param filter operation of filter info
     * @param dataInfo parameter of tranfer info of date type
     * @param jsonInfo parameter of process string to json
     * @param filters parameter of filter info
     * @return
     * @throws Exception
     */
    public static JSONObject getFirstRecordfromResult(String queryResult, JSONObjectOperation tranferTimeFormat, JSONObjectOperation processStringToJson, JSONObjectOperation filter, String[] dataInfo, String[] jsonInfo, String... filters) throws Exception{
        JSONObject queryResultJson = JSONObject.parseObject(queryResult);
        if("failure".equals(queryResultJson.getString("Result")) || queryResultJson.getIntValue("Count") < 1)
            return queryResultJson;
        JSONArray queryResultArray = queryResultJson.getJSONArray("Content");
        JSONObject item = queryResultArray.getJSONObject(0);
        if(tranferTimeFormat != null)
            item = tranferTimeFormat.operation(item, dataInfo);
        if(processStringToJson != null)
            item = processStringToJson.operation(item, jsonInfo);
        if(filter != null)
            item = filter.operation(item, filters);
        queryResultJson.put("Item", item);
        queryResultJson.remove("Content");
        queryResultJson.remove("Count");
        return queryResultJson;
    }

}
