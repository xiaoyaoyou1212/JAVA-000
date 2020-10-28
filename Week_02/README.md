## 作业
#### GC作业

*注：分析日志见：src/main/java/com/huwei/week02/gc*

- SerialGC(串行GC)
**操作命令**
```
java -XX:+UseSerialGC -Xms512m -Xmx512m -Xloggc:gc.SerialGC.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps com.huwei.week02.gc.GCLogAnalysis
```
**结果：**生成对象次数9596个
**启动命令**
```
java -Xms1g -Xmx1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseSerialGC -jar gateway-server-0.0.1-SNAPSHOT.jar
```
**压测命令**
`sb -u http://localhost:8088/api/hello -c 20 -N 60`
**压测结果：**执行9254次

> 结论：单线程，年轻代使用拷贝-复制，老年代使用标记-清除-整理

- ParallelGC(并行GC)
**操作命令**
```
java -XX:+UseParallelGC -Xms512m -Xmx512m -Xloggc:gc.ParallelGC.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps com.huwei.week02.gc.GCLogAnalysis
```
**结果：**生成对象次数8482个
**启动命令**
```
java -Xms1g -Xmx1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseParallelGC -jar gateway-server-0.0.1-SNAPSHOT.jar
```
**压测命令**
`sb -u http://localhost:8088/api/hello -c 20 -N 60`
**压测结果：**执行9720次

> 结论：多线程，年轻代使用拷贝-复制，老年代使用标记-清除-整理

- ConcMarkSweepGC(CMS GC)
**操作命令**
```
java -XX:+UseConcMarkSweepGC -Xms512m -Xmx512m -Xloggc:gc.ConcMarkSweepGC.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps com.huwei.week02.gc.GCLogAnalysis
```
**结果：**生成对象次数10308个
**启动命令**
```
java -Xms1g -Xmx1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseConcMarkSweepGC -jar gateway-server-0.0.1-SNAPSHOT.jar
```
**压测命令**
`sb -u http://localhost:8088/api/hello -c 20 -N 60`
**压测结果：**执行9567次

> 结论：并发收集，低停顿，标记－清除算法

- G1GC(G1 GC)
**操作命令**
```
java -XX:+UseG1GC -Xms512m -Xmx512m -Xloggc:gc.G1GC.log -XX:+PrintGCDetails -XX:+PrintGCDateStamps com.huwei.week02.gc.GCLogAnalysis
```
**结果：**生成对象次数9797个
**启动命令**
```
java -Xms1g -Xmx1g -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+UseG1GC -jar gateway-server-0.0.1-SNAPSHOT.jar
```
**压测命令**
`sb -u http://localhost:8088/api/hello -c 20 -N 60`
**压测结果：**执行9116次

> 结论：之前的收集器进行收集的范围都是整个新生代或老年代，而Ｇ１将整个Java堆（包括新生代，老年代）划分为多个大小固定的独立区域，并且跟踪这些区域里面的垃圾堆积程度，在后台维护一个优先列表，每次根据允许的收集时间，优先回收垃圾最多的区域。

#### NIO作业

*注：作业见：src/main/java/com/huwei/week02/nio 目录中 HttpClientUtil*

## 学习笔记
### 常用GC
1. 串行GC
2. 并行GC
3. CMS GC
> 阶段 1：Initial Mark（初始标记）
阶段 2：Concurrent Mark（并发标记）
阶段 3：Concurrent Preclean（并发预清理）
阶段 4： Final Remark（最终标记）
阶段 5： Concurrent Sweep（并发清除）
阶段 6： Concurrent Reset（并发重置）
4. G1 GC
> Evacuation Pause: young（纯年轻代模式转移暂停）
Concurrent Marking（并发标记）
阶段 1: Initial Mark（初始标记）
阶段 2: Root Region Scan（Root区扫描）
阶段 3: Concurrent Mark（并发标记）
阶段 4: Remark（再次标记）
阶段 5: Cleanup（清理）
Evacuation Pause (mixed)（转移暂停: 混合模式）
Full GC (Allocation Failure)

### JVM线程堆栈
- VM 线程：单例的 VMThread 对象，负责执行 VM 操作;
- 定时任务线程：单例的 WatcherThread 对象， 模拟在VM 中执行定时操作的计时器中断；
- GC 线程：垃圾收集器中，用于支持并行和并发垃圾回收的线程;
- 编译器线程： 将字节码编译为本地机器代码;
- 信号分发线程：等待进程指示的信号，并将其分配给Java级别的信号处理方法。

### 内存分析
#### 内存大小分析
- 对象头和对象引用
> 在64位 JVM 中，对象头占据的空间是 12-byte(=96bit=64+32)，但是以8字节对齐，所以一个空类的实例至少占用16字节。
在32位 JVM 中，对象头占8个字节，以4的倍数对齐(32=4*8)。所以 new 出来很多简单对象，甚至是 new Object()，都会占用不少内容。
通常在32位 JVM，以及内存小于 -Xmx32G 的64位JVM 上(默认开启指针压缩)，一个引用占的内存默认是4个字节。因此，64位 JVM 一般需要多消耗堆内存。

- 包装类型
> Integer：占用16字节(8+4=12+补齐)，因为 int 部分占4个字节。 所以使用 Integer 比原生类型 int 要多消耗 300% 的内存。
Long：一般占用16个字节(8+8=16)，当然，对象的实际大小由底层平台的内存对齐确定，具体由特定 CPU平台的 JVM 实现决定。 看起来一个 Long 类型的对象，比起原生类型 long 多占用了8个字节（也多消耗了100%）。

- 多维数组
> 在二维数组 int[dim1][dim2] 中，每个嵌套的数组 int[dim2] 都是一个单独的 Object，会额外占用16字节的空间。当数组维度更大时，这种开销特别明显。
int[128][2] 实例占用3600字节。 而 int[256] 实例则只占用1040字节。里面的有效存储空间是一样的，3600 比起1040多了246%的额外开销。在极端情况下，byte[256][1]，额外开销的比例是19倍!

- String
> String 对象的空间随着内部字符数组的增长而增长。当然，String 类的对象有24个字节的额外开销。对于10字符以内的非空 String，增加的开销比起有效载荷（每个字符2字节 + 4 个字节的 length），多占用了100% 到 400% 的内存。

*注：对齐是绕不过去的问题。我们可能会认为，一个 X 类的实例占用17字节的空间。但是由于需要对齐(padding)，JVM 分配的内存是8字节的整数倍，所以占用的空间不是17字节,而是24字节。*

#### 内存泄露原因分析

#####  OutOfMemoryError: Java heap space

创建新的对象时，堆内存中的空间不足以存放新创建的对象

- 原因：
> 1.类似于将 XXL 号的对象，往 S 号的 Java heap space 里面塞；
2.超出预期的访问量/数据量；
3.内存泄露(Memory leak)。

- 解决方案：
> 增加堆内存的大小，程序就能正常运行。

##### OutOfMemoryError: PermGen space/OutOfMemoryError: Metaspace

- 原因：
> 加载到内存中的class 数量太多或体积太大，超过了 PermGen 区的大小。

- 解决办法：
> 增大 PermGen/Metaspace
-XX:MaxPermSize=512m
-XX:MaxMetaspaceSize=512m
高版本 JVM 也可以：
-XX:+CMSClassUnloadingEnabled

##### OutOfMemoryError: Unable to create new native thread

- 原因：
> 程序创建的线程数量已达到上限值的异常信息。

- 解决思路：
> 1.调整系统参数 ulimit -a，echo 120000 > /proc/sys/kernel/threads-max
2.降低 xss 等参数
3.调整代码，改变线程创建和使用方式

### JVM 问题分析调优经验
#### 高分配速率(High Allocation Rate)
分配速率(Allocation rate)表示单位时间内分配的内存量。通常使用 MB/sec 作为单位。上一次垃圾收集之后，与下一次 GC 开始之前的年轻代使用量，两者的差值除以时间,就是分配速率。

分配速率过高就会严重影响程序的性能，在 JVM 中可能会导致巨大的 GC 开销。

正常系统：分配速率较低 ~ 回收速率 -> 健康
内存泄漏：分配速率 持续大于 回收速率 -> OOM
性能劣化：分配速率较高 ~ 回收速率 -> 压健康

#### 过早提升(Premature Promotion)
提升速率（promotion rate）用于衡量单位时间内从年轻代提升到老年代的数据量。一般使用 MB/sec 作为单位, 和分配速率类似。

JVM 会将长时间存活的对象从年轻代提升到老年代。根据分代假设，可能存在一种情况，老年代中不仅有存活时间长的对象,，也可能有存活时间短的对象。这就是过早提升：对象存活时间还不够长的时候就被提升到了老年代。

major GC 不是为频繁回收而设计的，但 major GC 现在也要清理这些生命短暂的对象，就会导致 GC 暂停时间过长。这会严重影响系统的吞吐量。

一般来说过早提升的症状表现为以下形式：
1. 短时间内频繁地执行 full GC
2. 每次 full GC 后老年代的使用率都很低，在10-
20%或以下
3. 提升速率接近于分配速率


### GC 疑难情况问题分析
1. 查询业务日志，可以发现这类问题：请求压力大，波峰，遭遇降级，熔断等等， 基础服务、外部 API依赖 。

2. 查看系统资源和监控信息：硬件信息、操作系统平台、系统架构；排查 CPU 负载、内存不足，磁盘使用量、硬件故障、磁盘分区用满、IO 等待、IO 密集、丢数据、并发竞争等情况；排查网络：流量打满，响应超时，无响应，DNS 问题，网络抖动，防火墙问题，物理故障，网络参数调整、超时、连接数。

3. 查看性能指标，包括实时监控、历史数据。可以发现 假死，卡顿、响应变慢等现象；排查数据库， 并发连接数、慢查询、索引、磁盘空间使用量、内存使用量、网络带宽、死锁、TPS、查询数据量、redo日志、undo、 binlog 日志、代理、工具 BUG。可以考虑的优化包括： 集群、主备、只读实例、分片、分区；大数据，中间件，JVM 参数。

4. 排查系统日志， 比如重启、崩溃、Kill 。

5. APM，比如发现有些链路请求变慢等等。

6. 排查应用系统
> 排查配置文件：启动参数配置、Spring 配置、JVM 监控参数、数据库参数、Log 参数、APM 配置、内存问题，比如是否存在内存泄漏，内存溢出、批处理导致的内存放大、GC 问题等等；
GC 问题， 确定 GC 算法、确定 GC 的 KPI，GC 总耗时、GC 最大暂停时间、分析 GC 日志和监控指标： 内存分配速度，分代提升速度，内存使用率等数据。适当时修改内存配置；
排查线程, 理解线程状态、并发线程数，线程 Dump，锁资源、锁等待，死锁；
排查代码， 比如安全漏洞、低效代码、算法优化、存储优化、架构调整、重构、解决业务代码 BUG、第三方库、XSS、CORS、正则；
单元测试： 覆盖率、边界值、Mock 测试、集成测试。

7. 排除资源竞争、坏邻居效应

8. 疑难问题排查分析手段
> DUMP 线程\内存；
抽样分析\调整代码、异步化、削峰填谷。