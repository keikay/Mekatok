package com.github.guokaia.mekatok.message.kafka;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * 开启 kafka 消息队列
 * @author <a href="mailto:guokai0727@gmail.com">GuoKai</a>
 * @date 2022/2/1
 */
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import({KafkaMessageQueueAutoConfiguration.class, KafkaMessageQueueHolder.class})
public @interface EnableKafkaMessageQueue {
}
