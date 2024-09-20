package com.ipseweb.traffic.config;

import org.jasypt.encryption.StringEncryptor;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JasyptConfig {
  
  @Value("${jasypt.encryptor.key}")
  String encryptorKey;
 
  @Bean("jasyptStringEncryptor")
  public StringEncryptor stringEncryptor(){
      PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
      SimpleStringPBEConfig config = new SimpleStringPBEConfig();
      config.setPassword(encryptorKey); // 암호화 키 값
      config.setAlgorithm("PBEWithMD5AndDES"); // 암호 알고리즘
      config.setKeyObtentionIterations("1000"); // PBE 해쉬 횟수
      config.setPoolSize("1");
      config.setProviderName("SunJCE");
      config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
      config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
      config.setStringOutputType("base64");
      encryptor.setConfig(config);
      return encryptor;
  }
}
