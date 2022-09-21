package com.huongproject.redisProject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash("second-vcd-entity")
public class SecondEntity {

    private Long id;
    private String secondName;
}
