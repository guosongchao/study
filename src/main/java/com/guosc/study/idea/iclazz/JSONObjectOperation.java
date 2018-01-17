package com.guosc.study.idea.iclazz;

import com.alibaba.fastjson.JSONObject;

/**
 * Created by DOOM on 2017/8/11.
 */
public interface JSONObjectOperation {
    public JSONObject operation(JSONObject jsonObject, String... str) throws Exception;
}
