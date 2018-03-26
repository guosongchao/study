package com.guosc.study;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.guosc.study.idea.iclazz.JSONObjectOperation;

import java.util.*;
import java.util.concurrent.*;

/**
 * Created by DOOM on 2017/7/26.
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(100);


        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(10, 20, 5000L, TimeUnit.SECONDS, queue);



//        ThreadPoolExecutor threadPoolExecutor1 = new ThreadPoolExecutor(10, 20, 5000L, TimeUnit.SECONDS, queue, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(){
//                    public void run(){
//                        try {
//                            Thread.sleep(4000);
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                        }
//                        System.out.println("test....................................");
//                    }
//                };
//            }
//        }, new ThreadPoolExecutor.DiscardPolicy());

//        queue.add(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("add to queue...");
//            }
//        });


        for(int i=0; i<200; i++){
            threadPoolExecutor1.execute(new MyTask(i));
            System.out.println("线程池中线程数目："+threadPoolExecutor1.getPoolSize()+"，队列中等待执行的任务数目："+
                    threadPoolExecutor1.getQueue().size()+"，已执行玩别的任务数目："+threadPoolExecutor1.getCompletedTaskCount());
        }
        Thread.sleep(5000000);
//
//
//
//        Future future = threadPoolExecutor1.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("submit...");
//                try {
//                    Thread.sleep(4000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("submit end...");
//            }
//        });
//        do{
//            System.out.println("future:" + future.isDone());
//            Thread.sleep(1000);
//        }while(!future.isDone());


//        ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(10, 20, 5000L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadPoolExecutor.CallerRunsPolicy());
//        ThreadPoolExecutor threadPoolExecutor3 = new ThreadPoolExecutor(10, 20, 5000L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(100), new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(){
//                    public void run(){
//                        System.out.println("test");
//                    }
//                };
//            }
//        }, new ThreadPoolExecutor.AbortPolicy());






//        List<String> list = new ArrayList<String>();
//        JSONObject jsonObject = new JSONObject();
//        JSONObject criteria = new JSONObject();
//        criteria.put("valid", true);
//        jsonObject.put("criteria", criteria);
//        System.out.println(jsonObject.toJSONString());
//        String s = "{\"criteria\":{\"valid\":true}}";
    }

    static class MyTask implements Runnable{
        private int num ;
        public MyTask(int num){
            this.num = num;
        }

        public void run(){
            System.out.println("正在执行task "+num);
            try {
                Thread.currentThread().sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("task "+num+"执行完毕");
        }
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
