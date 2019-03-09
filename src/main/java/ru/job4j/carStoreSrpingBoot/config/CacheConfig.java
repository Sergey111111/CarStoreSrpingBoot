package ru.job4j.carStoreSrpingBoot.config;

import org.cache2k.extra.spring.SpringCache2kCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.swing.*;

@Configuration
@EnableCaching
public class CacheConfig {

  @Bean
  public CacheManager cacheManager() {
    SpringCache2kCacheManager cacheManager = new SpringCache2kCacheManager();
    cacheManager.defaultSetup(builder ->
      builder.entryCapacity(2000))
      .addCaches(
        cache -> cache.name("carsCache")
      );

    return cacheManager;
  }

}
