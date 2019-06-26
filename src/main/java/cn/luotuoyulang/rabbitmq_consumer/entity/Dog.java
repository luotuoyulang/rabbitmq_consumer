package cn.luotuoyulang.rabbitmq_consumer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author liuyuhu
 * @Description
 * @Package cn.luotuoyuang.redis.entity
 * CreaterName liuyuhu
 * @Email 17600520726@163.com
 * @Date 2019/6/22
 */
@AllArgsConstructor
@Data
@ToString
public class Dog implements Serializable {
    private Integer id;
    private String dogName;
}