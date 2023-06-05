package io.xiaochangbai.sensitive.common.utils;

class StringUtilTest {


    public static void main(String[] args) {
        System.out.println(StringUtil.isNotBlank(""));
        System.out.println(StringUtil.isNotBlank("     "));
        System.out.println(StringUtil.isNotBlank(" a"));
    }
  
}