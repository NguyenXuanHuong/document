package com.example.TestRedisHash;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;
import java.io.Serializable;
import org.springframework.data.annotation.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
@RedisHash(value = "redisTest")
public class RedisHashTest implements Serializable {
    @Id
    private String redisTestId;
}
