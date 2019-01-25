# rabbitmq 消息100%可靠性投递的解决方案实现 ack手动确认方式

##### 代码实例及学习参考内容来自慕课网课程[RabbitMQ消息中间件极速入门与实战](https://www.imooc.com/learn/1042)部分代码自己进行了改造

## 特点：
1. RabbitMQ底层使用Erlang语言编写，传递效率高，延迟低
2. 开源、性能优秀、稳定性较高
3. 与SpringAMQP完美的整合、API丰富
4. 集群模式丰富、表达式配置、HA模式、镜像队列模式
5. 保证数据不丢失的情况下，做到高可用
6. AMQP全称：Advanced Message Queuing Protocol
7. AMQP翻译:高级消息队列协议

## AMQP核心概念
- Server：又称Broker，接收客户端的连接，实现AMQP实体服务
- Connection：连接，应用程序与Broker的网络连接
- Channel：网络信道，几乎所有的操作都在Channel中进行，包括定义Queue、定义Exchange、绑定Queue与Exchange、发布消息等。Channel是进行消息读写的通道。客户端可以建立多个Channel，每个Channel代表一个会话任务。
- Message：消息，服务器和应用程序之间传送的数据，由Properties和Body组成。Properties可以对消息进行修饰，比如消息的优先级、延迟等高级特性；Body就是消息体内容。
- Virtual host：虚拟地址，用于进行逻辑隔离，最上层的消息路由。一个Virtual host可以有若干个Exchange和Queue，同一个Virtual host里面不能有相同的Exchange和Queue
- Exchange：交换机，接收消息，根据路由键转发消息到绑定的队列
> RabbitMQ中有三种常用的交换机类型:<br/>
    direct: 如果路由键匹配，消息就投递到对应的队列<br/>
    fanout：投递消息给所有绑定在当前交换机上面的队列<br/>
    topic：允许实现有趣的消息通信场景，使得5不同源头的消息能够达到同一个队列。topic队列名称有两个特殊的关键字。<br/>
        * 可以替换一个单词<br/>
        # 可以替换所有的单词

- Binding：Exchange和Queue之间的虚拟连接，binding中可以包含routing key
- Routing key：一个路由规则，虚拟机可用它来确定如何路由一个特定消息
- Queue：也称为Message Queue，消息队列，保存消息并将它们转发给消费者，多个消费者可以订阅同一个Queue，这时Queue中的消息会被平均分摊给多个消费者进行处理，而不是每个消费者都收到所有的消息并处理。
- Prefetch count：如果有多个消费者同时订阅同一个Queue中的消息，Queue中的消息会被平摊给多个消费者。这时如果每个消息的处理时间不同，就有可能会导致某些消费者一直在忙，而另外一些消费者很快就处理完手头工作并一直空闲的情况。我们可以通过设置prefetchCount来限制Queue每次发送给每个消费者的消息数，比如我们设置prefetchCount=1，则Queue每次给每个消费者发送一条消息；消费者处理完这条消息后Queue会再给该消费者发送一条消息。


RabbitMq投递信息流程图

![RabbitMq投递信息流程图](https://github.com/niezhiliang/springboot-rabbitmq/blob/master/imgs/RabbitMQ1.jpg)

RabbitMq百分百推送流程图

![百分百推送流程图](https://github.com/niezhiliang/springboot-rabbitmq/blob/master/imgs/RabbitMQ2.jpg)

- Step 1： 首先把消息信息(业务数据）存储到数据库中，紧接着，我们再把这个消息记录也存储到一张消息记录表里（或者另外一个同源数据库的消息记录表）

- Step 2：发送消息到MQ Broker节点（采用confirm方式发送，会有异步的返回结果）

- Step 3、4：生产者端接受MQ Broker节点返回的Confirm确认消息结果，然后进行更新消息记录表里的消息状态。比如默认Status = 0 当收到消息确认成功后，更新为1即可！

- Step 5：但是在消息确认这个过程中可能由于网络闪断、MQ Broker端异常等原因导致 回送消息失败或者异常。这个时候就需要发送方（生产者）对消息进行可靠性投递了，保障消息不丢失，100%的投递成功！（有一种极限情况是闪断，Broker返回的成功确认消息，但是生产端由于网络闪断没收到，这个时候重新投递可能会造成消息重复，需要消费端去做幂等处理）所以我们需要有一个定时任务，（比如每5分钟拉取一下处于中间状态的消息，当然这个消息可以设置一个超时时间，比如超过1分钟 Status = 0 ，也就说明了1分钟这个时间窗口内，我们的消息没有被确认，那么会被定时任务拉取出来）

- Step 6：接下来我们把中间状态的消息进行重新投递 retry send，继续发送消息到MQ ，当然也可能有多种原因导致发送失败

- Step 7：我们可以采用设置最大努力尝试次数，比如投递了3次，还是失败，那么我们可以将最终状态设置为Status = 2 ，最后 交由人工解决处理此类问题（或者把消息转储到失败表中）。


##### 代码测试

- 1.将test.sql导入本地数据库,将服务端和消费端的rabbitmq配置文件账号密码进行相应的修改

- 2.首先启动消费服务端 `rabbitmq-customer`服务的`Application.java`

- 3.再启动rabbitmq服务端 `rabbitmq-publisher`服务的`Application.java`

- 4.浏览器调用投递信息的控制器 `127.0.0.1:8081/send`

- 5.在消费服务端的控制台可以看到信息处理的日志
