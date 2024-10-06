package com.ipseweb.traffic.jaspy;

import org.assertj.core.api.Assertions;
import org.jasypt.encryption.pbe.PooledPBEStringEncryptor;
import org.jasypt.encryption.pbe.config.SimpleStringPBEConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class JaspytTest {
    @Test
    @DisplayName("jaspyt 테스트")
    public void jaspytTest() throws Exception {

        PooledPBEStringEncryptor encryptor = new PooledPBEStringEncryptor();
        SimpleStringPBEConfig config = new SimpleStringPBEConfig();
        config.setPassword("test"); // 암호화 키 값
        config.setAlgorithm("PBEWithMD5AndDES"); // 암호 알고리즘
        config.setKeyObtentionIterations("1000"); // PBE 해쉬 횟수
        config.setPoolSize("1");
        config.setProviderName("SunJCE");
        config.setSaltGeneratorClassName("org.jasypt.salt.RandomSaltGenerator");
        config.setIvGeneratorClassName("org.jasypt.iv.NoIvGenerator");
        config.setStringOutputType("base64");
        encryptor.setConfig(config);


        String encryptData = encryptor.encrypt("HelloWorld");
        System.out.println("encryptData : " + encryptData);

        String decryptData = encryptor.decrypt(encryptData);
        System.out.println("decryptData : " + decryptData);


        Assertions.assertThat(decryptData).isEqualTo("HelloWorld");
    }
}
