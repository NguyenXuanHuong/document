//package com.huongproject.redisProject.config;
//
//import com.fasterxml.jackson.annotation.JsonAutoDetect;
//import com.fasterxml.jackson.annotation.JsonTypeInfo;
//import com.fasterxml.jackson.annotation.PropertyAccessor;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.jsontype.impl.LaissezFaireSubTypeValidator;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
//import org.springframework.cache.CacheManager;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.cache.RedisCacheConfiguration;
//import org.springframework.data.redis.cache.RedisCacheManager;
//import org.springframework.data.redis.connection.RedisClusterConfiguration;
//import org.springframework.data.redis.connection.RedisNode;
//import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
//import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
//import org.springframework.data.redis.serializer.RedisSerializationContext;
//
//import java.time.Duration;
//
//@Configuration
//@EnableRedisRepositories
//public class RedisConfig {
//
//    public static final int DEFAULT_TTL = 50;
//    public static final String CACHE_TOKEN_DEVICE_LOGIN_BZB = "tokenDeviceLoginBZB";
//
//    @Value(("${redis.host}"))
//    private String host;
//
//    @Value(("${redis.port}"))
//    private int port;
//
//    @Value("${redis.username}")
//    private String redisUsername;
//
//    @Value("${redis.password}")
//    private String redisPassword;
//
//    @Value("${redis.ssl_enabled}")
//    private boolean redisSslEnabled;
//
//    @Value("${redis.auth_enabled}")
//    private boolean redisAuthEnabled;
//
////    @Bean
////    public CacheManager cacheManager(){
////        return new RedisCacheManager();
////    }
//    @Bean
//    public LettuceConnectionFactory lettuceConnectionFactory() {
//        var redisConfig = new RedisClusterConfiguration();
//        redisConfig.addClusterNode(new RedisNode(host, port));
//        if (redisAuthEnabled) {
//            redisConfig.setUsername(redisUsername);
//            redisConfig.setPassword(redisPassword);
//        }
//        var clientConfig = LettuceClientConfiguration.builder()
//                .clientName("MS_PASS");
//        if (redisSslEnabled) {
//            clientConfig.useSsl();
//        }
//        return new LettuceConnectionFactory(redisConfig, clientConfig.build());
//    }
//
//    @Bean
//    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
//        return (builder) -> builder
//                .withCacheConfiguration(CACHE_TOKEN_DEVICE_LOGIN_BZB, this.cacheConfiguration());
//    }
//
//    @Bean
//    public RedisCacheConfiguration cacheConfiguration() {
//        return RedisCacheConfiguration.defaultCacheConfig()
//                .entryTtl(Duration.ofMinutes(DEFAULT_TTL))
//                .disableCachingNullValues()
//                .serializeValuesWith(RedisSerializationContext.SerializationPair
//                        .fromSerializer(jsonRedisSerializer()));
//    }
//
//
//    protected Jackson2JsonRedisSerializer<Object> jsonRedisSerializer() {
//        Jackson2JsonRedisSerializer<Object> jsonRedisSerializer = new Jackson2JsonRedisSerializer<Object>(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.activateDefaultTyping(LaissezFaireSubTypeValidator.instance,
//                ObjectMapper.DefaultTyping.NON_FINAL, JsonTypeInfo.As.WRAPPER_ARRAY);
//        jsonRedisSerializer.setObjectMapper(objectMapper);
//        return jsonRedisSerializer;
//    }
//
//}
