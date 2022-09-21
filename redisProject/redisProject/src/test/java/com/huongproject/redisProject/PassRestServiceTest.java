package com.huongproject.redisProject;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = RedisProjectApplication.class)
@AutoConfigureMockMvc
public class PassRestServiceTest {


    @MockBean
    private CacheManager cacheManager;

    @BeforeEach
    public void setup() {
        Cache cache = Mockito.mock(Cache.class);
        Mockito.doNothing().when(cache.get(Mockito.anyString()));
        Mockito.doNothing().when(cache).put(Mockito.anyString(), Mockito.any());
        Mockito.when(cacheManager.getCache(Mockito.anyString())).thenReturn(cache);
    }
}

