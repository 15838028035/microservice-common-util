microservice-common-util 发版日志

1.3.10 （2023-06-16)
 - 优化新增com.zhongkexinli.micro.serv.common.task
 ------------------
 
1.3.9 （2023-05-26)
 - 优化新增com.zhongkexinli.micro.serv.common.config.swagger
 ------------------
1.3.8 （2023-05-18)
 - 优化新增锁工具类com.zhongkexinli.micro.serv.common.lock.KeyedLock
 ------------------
1.3.7 （2023-04-27)
 - 优化新增方法com.zhongkexinli.micro.serv.common.bean.RestApiResult2
 - 优化新增方法com.zhongkexinli.micro.serv.common.bean.RestApiResultBuilder
 ------------------ 
 
1.3.4 （2022-08-24)
 - 优化新增方法com.zhongkexinli.micro.serv.common.util.FileUtil
 - 优化常用工具类com.zhongkexinli.micro.serv.common.util.HttpUtil, 新增参数输出
 ------------------ 
 
1.3.3 （2022-05-23)
  - 修复定时任务监控工具类com.zhongkexinli.micro.serv.common.thread.ThreadPoolTaskExecutorMonitor
 ------------------ 
1.3.2 （2022-05-20)
  - 添加定时任务监控工具类com.zhongkexinli.micro.serv.common.thread.ThreadPoolTaskExecutorMonitor
  - 添加定时任务监控工具类com.zhongkexinli.micro.serv.common.thread.ThreadPoolTaskExecutorExt
 ------------------ 
1.3.1 （2022-05-20)
  - 修复工具类com.zhongkexinli.micro.serv.common.thread.ThreadPoolMonitor打印显示完成的任务数量
 ------------------ 
 
1.3.0 （2022-05-12)
  - 优化多线程，支持链式调用:com.zhongkexinli.micro.serv.common.thread.ThreadBatchOptTemplate
  - 优化多线程，支持链式调用:com.zhongkexinli.micro.serv.common.thread.ThreadBatchOptLimitTemplate
 ------------------
 
1.2.9 （2022-05-11)
  - 修改bug多线程操作工具类com.zhongkexinli.micro.serv.common.thread.ThreadBatchOptTemplate
 ------------------
1.2.9 （2022-05-11)
  - 修改bug多线程操作工具类com.zhongkexinli.micro.serv.common.thread.ThreadBatchOptTemplate
 ------------------
 
1.2.7 （2022-05-10)
  - 新增多线程操作工具类com.zhongkexinli.micro.serv.common.thread.ThreadBatchOptLimitTemplate
 ------------------
1.2.6 （2022-05-07)
  - 新增多线程操作工具类com.zhongkexinli.micro.serv.common.thread.ThreadBatchOptTemplate
 ------------------
 
1.2.5 （2022-04-24)
  - 优化新增方法com.zhongkexinli.micro.serv.common.util.EnumerationAsStreamUtil
 ------------------ 
 
1.2.4 （2022-04-21)
  - 优化新增方法com.zhongkexinli.micro.serv.common.util.FileUtil
 ------------------ 
 
1.2.3 （2022-04-19)
  - 优化新增方法com.zhongkexinli.micro.serv.common.util.FileUtil
 ------------------ 
 
1.2.2 （2022-04-19)
  - 优化新增方法com.zhongkexinli.micro.serv.common.util.DateTimeUtil
 ------------------ 
 
1.2.1 （2022-04-14)
  - 修复工具类sonarlint告警
 ------------------ 
 
1.2.0 （2022-02-17)
  - 修复工具类com.zhongkexinli.micro.serv.common.thread.ThreadPoolMonitor线程名称信息
 ------------------ 
 
1.1.9 （2022-02-08)
  - 新增常用工具类com.zhongkexinli.micro.serv.common.util.HttpUtil
 ------------------ 
 
1.1.8 （2022-01-24)
  - 优化常用工具类com.zhongkexinli.micro.serv.common.util.ZipUtil
 ------------------ 
 
1.1.7 （2022-01-19)
  - 新增常用工具类com.zhongkexinli.micro.serv.common.thread.ThreadPoolMonitor
  - 新增常用工具类com.zhongkexinli.micro.serv.common.thread.ThreadPoolMDCFilter
 ------------------ 
 
1.1.6 （2022-01-13)
  - 新增常用工具类com.zhongkexinli.micro.serv.common.util.DateTimeUtil
  - 新增常用工具类com.zhongkexinli.micro.serv.common.util.ZipUtil
 ------------------ 
 
1.1.5 （2022-01-12)
  - 新增常用工具类com.zhongkexinli.micro.serv.common.util.HttpUtil
 ------------------  
1.1.4 （2022-01-12)
  - 常用工具类com.zhongkexinli.micro.serv.common.util.FileUtil新增方法
 ------------------  
1.1.3 （2021-06-23)
  - 优化sonar告警
  - 添加常用工具类com.zhongkexinli.micro.serv.common.util.BigDecimalUtil
------------------ 
1.1.2 （2021-03-04)
  - 优化删除多余的com.zhongkexinli.micro.serv.common.pagination工具类
------------------ 
1.1.1 （2021-02-25)
  -  新增com.zhongkexinli.micro.serv.common.util.ForEachUtils工具类
------------------  
1.1.0 （2021-02-19)
  -  优化com.zhongkexinli.micro.serv.common.bean.RestApiResultBuilder,添加traceId属性，用来记录跟踪请求的id
------------------

1.0.9 （2021-02-05)
  -  添加通用报表构建者com.zhongkexinli.micro.serv.common.msg.CommonReportDataResponseBuilder
------------------

1.0.7 （2020-03-27)
  - RestApiResult添加泛型支持
  - 优化升级Bootstrap-swagger-ui依赖版本
  - 添加BeanToMapUtil转换工具类
=======================
1.0.6 (2020-01-02)
------------------
1.0.5 (2019-09-09)
------------------
  - 优化重构代码，优化支持1.8 forEach写法.

1.0.4 (2019-08-17)
------------------

 
1.0.3-BETA (2019-05-06)
------------------
 - 代码风格优化，严格按照checkstyle.xml进行检验
 - 新增com.zhongkexinli.micro.serv.common.bean.RestApiResultBuilder,使用建造者模式构建RestApiResult对象
 ------------------
1.0.2 (2019-04-30)
------------------
 - 重构代码,删除com.zhongkexinli.micro.serv.common.bean.RestAPIResult2中泛型参数T
 ------------------
1.0.1 (2019-04-26)
------------------
 - sonar上bug,坏味道修復
 ------------------
1.0.0 (2019-04-23)
------------------
 - sonar上bug,回味的修复
 
0.0.9 (2019-04-20)
------------------
 - com.zhongkexinli.micro.serv.common.bean.RestAPIResult2删除messageFormat(String msg, String formatParam,T object)方法
 - com.zhongkexinli.micro.serv.common.bean.RestAPIResult2 存在sonar坏味道修复
 - sonar坏味道修复，删除无用的类

0.0.8 (2019-04-03)
------------------
 - com.zhongkexinli.micro.serv.common.bean.RestAPIResult2 新增方法respMsg(String msg,Object... arguments)

0.0.7 (2019-03-29)
------------------
- com.zhongkexinli.micro.serv.common.pagination.Query 新增链式调用方法putFilter


0.0.6 (2019-03-27)
------------------
- RestAPIResult2 新增链式调用方法


0.0.3 (2019-02-25)
------------------


0.0.2 (2019-02-01)
------------------
- 发布到nexus准备 (#8)
- 修复异常 (#4)


0.0.1 (2019-01-01)
------------------
- 初始发版
