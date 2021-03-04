
<p align="center">
<img src="https://github.com/15838028035/microservice-common-util/blob/master/src/main/resources/banner.svg" alt="microservice-common-util" align="middle" width="50%" height="50%" />
<p>

[![Build Status](https://travis-ci.org/15838028035/microservice-common-util.svg?branch=master)](https://travis-ci.org/15838028035/microservice-common-util)

[![Maven Central](https://img.shields.io/maven-central/v/cn.com.thinkit.cloud/microservice-common-util.svg)](https://mvnrepository.com/artifact/cn.com.thinkit.cloud/microservice-common-util)

[![Quality Gate](https://sonarqube.com/api/badges/gate?key=cn.com.thinkit.cloud%3Amicroservice-common-util)](https://sonarcloud.io/dashboard?id=15838028035_microservice-common-util)

# 项目简介
    常见常用日期、字符串、数字、文件、异常、分页、树等公共类库
    
# maven使用
```xml
    <dependency>
            <groupId>cn.com.thinkit.cloud</groupId>
            <artifactId>microservice-common-util</artifactId>
             <version>1.1.2-RELEASE</version>
    </dependency> 
  ```
### 版本说明
1. 本项目定为大约每1个月发布一次正式版，版本号格式为X.X.0（如1.0.1,1.0.2等），遇到重大问题需修复会及时提交新版本，欢迎大家随时提交Pull Request；
2. BUG修复和新特性一般会先发布成小版本作为临时测试版本（如1.0.2.B，即尾号不为0，并添加B，以区别于正式版）；

## SNAPSHOT版

本项目的BUG修复和新特性一般会先发布在*-SNAPSHOT版里供大家预览，如果要使用*-SNAPSHOT版，则需要在你的pom.xml中添加这段：

```xml
<repositories>
  <repository>
      <snapshots />
      <id>sonatype snapshots</id>
      <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
  </repository>
</repositories>
```

## 环境准备：

| 工具    | 版本或描述                |
| ----- | -------------------- |
| JDK   | 1.8                  |

## 模块介绍：
| microservice-common-util            | 公共工具类 |

## Api demo

com.zhongkexinli.micro.serv.common.bean.RestApiResultBuilder

``` java
 RestApiResult2<T> restApiResult = RestApiResultBuilder.builder()
             .respCode(1)
             .respData("dataA")
             .respMsg("okay")
             .build();
```

com.zhongkexinli.micro.serv.common.bean.RestApiResult

``` java
 RestApiResult2<T> restApiResult = new RestApiResult2()
             .respCode(1)
             .respData("dataA")
             .respMsg("okay");
```

com.zhongkexinli.micro.serv.common.pagination.Query

``` java
 new Query.putFilter("keyA","valueA")
      .putFilter("keyB","valueB");
        
```

# 代码贡献
 1. fork代码
 2. 建立分支
 3. 提交代码,pull request
 4. 更新代码

# 分支管理
 1. master分支，禁止在上面开发
 2. develop分支 开发分支
 3. bugfix分支  线上问题紧急修复分支

# 代码规范
 提交代码前，尽量使用工程中提供的checkstyle.xml对代码风格进行检查
 
# 6、问题反馈
微信号码:15838028035
 


     
