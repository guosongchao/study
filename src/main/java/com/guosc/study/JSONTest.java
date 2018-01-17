package com.guosc.study;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by DOOM on 2017/9/1.
 */
public class JSONTest {
    public static void main(String[] args) {
        String woPlanStr = "{\n" +
                "    \"freq_times\": [\n" +
                "        {\n" +
                "            \"end_time\": {\n" +
                "                \"cycle\": \"w\", \n" +
                "                \"time_day\": \"1\", \n" +
                "                \"time_hour\": \"20\", \n" +
                "                \"time_minute\": \"15\"\n" +
                "            }, \n" +
                "            \"start_time\": {\n" +
                "                \"cycle\": \"w\", \n" +
                "                \"time_day\": \"1\", \n" +
                "                \"time_hour\": \"9\", \n" +
                "                \"time_minute\": \"15\"\n" +
                "            }\n" +
                "        }, \n" +
                "\t\t{\n" +
                "            \"end_time\": {\n" +
                "                \"cycle\": \"w\", \n" +
                "                \"time_day\": \"1\", \n" +
                "                \"time_hour\": \"20\", \n" +
                "                \"time_minute\": \"15\"\n" +
                "            }, \n" +
                "            \"start_time\": {\n" +
                "                \"cycle\": \"w\", \n" +
                "                \"time_day\": \"0\", \n" +
                "                \"time_hour\": \"9\", \n" +
                "                \"time_minute\": \"15\"\n" +
                "            }\n" +
                "        }, \n" +
                "\t\t{\n" +
                "            \"end_time\": {\n" +
                "                \"cycle\": \"w\", \n" +
                "                \"time_day\": \"1\", \n" +
                "                \"time_hour\": \"20\", \n" +
                "                \"time_minute\": \"15\"\n" +
                "            }, \n" +
                "            \"start_time\": {\n" +
                "                \"cycle\": \"w\", \n" +
                "                \"time_day\": \"1\", \n" +
                "                \"time_hour\": \"9\", \n" +
                "                \"time_minute\": \"10\"\n" +
                "            }\n" +
                "        }, \n" +
                "        {\n" +
                "            \"end_time\": {\n" +
                "                \"cycle\": \"w\", \n" +
                "                \"time_day\": \"1\", \n" +
                "                \"time_hour\": \"20\", \n" +
                "                \"time_minute\": \"15\"\n" +
                "            }, \n" +
                "            \"start_time\": {\n" +
                "                \"cycle\": \"w\", \n" +
                "                \"time_day\": \"1\", \n" +
                "                \"time_hour\": \"10\", \n" +
                "                \"time_minute\": \"15\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}";
        JSONObject woPlan = JSONObject.parseObject(woPlanStr);
        sortWoPlan(woPlan);
        System.out.println(woPlan.toJSONString());
    }

    public static void sortWoPlan(JSONObject woPlan){
        JSONArray array = woPlan.getJSONArray("freq_times");
        if(array != null){
            Collections.sort(array, new Comparator<Object>(){
                public int compare(Object str1, Object str2){
                    JSONObject obj1 = JSONObject.parseObject(str1.toString());
                    JSONObject obj2 = JSONObject.parseObject(str2.toString());
                    JSONObject startTime1 = obj1.getJSONObject("start_time");
                    JSONObject startTime2 = obj2.getJSONObject("start_time");
                    int timeDay1 = startTime1.getIntValue("time_day");
                    int timeDay2 = startTime2.getIntValue("time_day");
                    if(timeDay1 < timeDay2){
                        return -1;
                    }else if(timeDay1 == timeDay2){
                        int timeHour1 = startTime1.getIntValue("time_hour");
                        int timeHour2 = startTime2.getIntValue("time_hour");
                        if(timeHour1 < timeHour2){
                            return -1;
                        }else if(timeHour1 == timeHour2){
                            int timeMinute1 = startTime1.getIntValue("time_minute");
                            int timeMinute2 = startTime2.getIntValue("time_minute");
                            if(timeMinute1 < timeMinute2){
                                return -1;
                            }else if(timeMinute1 == timeMinute2){
                                return 0;
                            }else{
                                return 1;
                            }
                        }else{
                            return 1;
                        }
                    }else{
                        return 1;
                    }
                }
            });
        }
    }
}
