# Sensitive Hunter

**[Sensitive Hunter 敏感的猎人](https://github.com/xiaochangbai/sensitive-hunter) 全网最强的敏感词处理工具包.**


### 在线体验

> [IChat](http://43.138.164.74)：利用Sensitive Hunter来过滤聊天的过程中出现的一些敏感词语



### 特性

* 基于 DFA 算法构建，数据占用空间小，检索更快
* 系统内置敏感词库收录接近16W+，且不断优化更新
* 数据压缩，支持从海量压缩文件中读取数据词典
* 使用简单快捷，支持高度定制化
----------


### 快速开始
```java
    //构建api对象
    SensitiveWordDispatcher sensitiveWordBs = SensitiveWordDispatcher
            .newInstance(SensitiveWordConfig.defaultConfig());
    //判断是否包含敏感词
    Assert.assertTrue(sensitiveWordBs.contains("好好学习，天天向上"));
    
    //替换敏感词
    sensitiveWordBs.replace("高考加油噢！",'*');
```
