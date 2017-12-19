package com.guosc.study.calculate;

public class Calculate {

    /**
     * 大位数计算--乘法
     * @param multiplicator 乘数
     * @param multiplicand  被乘数
     * @return
     */
    public static String scientificCalculate(long multiplicator, long multiplicand){
        //定义乘数数组-用于计算
        long[] multiplicators = new long[String.valueOf(multiplicator).length()];
        //定义被乘数数组--用于计算
        long[] multiplicands = new long[String.valueOf(multiplicand).length()];
        //定义乘数与被乘数每位相乘的结果
        long[][] tempProduct = new long[multiplicands.length][multiplicators.length];
        //给乘数数组赋值
        for(int i=multiplicators.length-1; i>-1; i--){
            multiplicators[i] = multiplicator % 10;
            multiplicator = multiplicator / 10;
        }
        //给被乘数数组赋值
        for(int i=multiplicands.length-1; i>-1; i--){
            multiplicands[i] = multiplicand % 10;
            multiplicand = multiplicand / 10;
        }
        //计算乘数与被乘数每位相乘的结果
        for(int i=0; i<tempProduct.length; i++){
            for(int j=0; j<tempProduct[i].length; j++){
                tempProduct[i][j] = multiplicators[j]*multiplicands[i];
            }
        }
        //记录乘积结果的每一位:每一位中均可能不小于10
        long[] product = new long[multiplicators.length + multiplicands.length + 1];
        long[] temp;
        for(int i=0; i<tempProduct.length; i++){
            temp = tempProduct[i];
            for(int j=temp.length-1; j>-1; j--){
                product[product.length-temp.length-i+j]+=temp[j] % 10;
                product[product.length-temp.length-1-i+j]+=temp[j] / 10;

            }
        }
        //处理上述乘积结果中的每一位中不小于10的数据
        for(int i=product.length-1; i>0; i--){
            product[i-1] += product[i] / 10;
            product[i] = product[i] % 10;
        }
        //组织乘积结果，乘积结果数组中前面位0的几位需要去掉
        String returnStr = "";
        boolean flag = true;
        for(int i=0; i<product.length; i++){
            if(flag && product[i]==0){

            }else{
                returnStr += product[i];
                flag = false;
            }
        }

        return returnStr;
    }

    public static void main(String[] args) {
        System.out.println(scientificCalculate(99, 99));
    }
}
