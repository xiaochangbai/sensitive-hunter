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


**1) 在pom文件中引入依赖:**
```xml
    <dependency>
        <groupId>io.xiaochangbai.sensitive</groupId>
        <artifactId>sensitive-hunter-core</artifactId>
        <version>${last-version}</version>
    </dependency>
```

**2) 将对象注入到Spring容器中:**

```java
    @Bean
    public SWDispatcher sWDispatcher(){
        SensitiveWordConfig sensitiveWordConfig = SensitiveWordConfig.defaultConfig();
        return SensitiveWordDispatcher.newInstance(sensitiveWordConfig);
    }
```
**3) 在需要用到的使用即可:**

```java
    @Autowired
    private SWDispatcher sWDispatcher;

    @Test
    public void test(){
        String text = "我爱中华，中华爱我";
        //将语句中的敏感词替换成指定内容
        sWDispatcher.replace(text,'*');

        //查看语句中是否包含敏感词
        sWDispatcher.contains(text);
    }
```