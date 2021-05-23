package com.allin.exer;

import org.junit.Test;

/**
 * 获取一个字符串在另一个字符串中出现的次数。
 * 比如：获取“ ab”在 “abkkcadkabkebfkabkskab” 中出现的次数
 */
public class StringDemo1 {

    public int getCount(String mainStr , String subStr){
        int mainLength = mainStr.length();
        int subLength = subStr.length();
        int count = 0;
        int index = 0;
        if(mainLength >= subLength){

            //方式一：
//            while ((index = mainStr.indexOf(subStr)) != -1){
//                count++;
//                mainStr = mainStr.substring(index + subStr.length());
//            }
            //方式二：对方式一的改进
            while ((index = mainStr.indexOf(subStr,index)) != -1){
                count++;
                index += subLength;
            }

            return count;
        }else {
            return 0;
        }
        //问题：暴力破解？
//        for(int i = 0;i <= mainLength - subLength;i++){
//            for (int j = 0;j < mainLength;j++){
//                if(mainStr[j] != subStr[i + j]){
//                    break;
//                }
//            }
//        }
    }

    @Test
    public void testCount(){
        String mainStr = "abkkcadkabkebfkabkskab";
        String subStr = "ab";
        int count = getCount(mainStr, subStr);
        System.out.println(count);
    }

}
