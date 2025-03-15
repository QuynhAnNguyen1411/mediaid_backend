package com.mediaid.mediaid.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

@Component
public class DecodeEncodeUtil {
    @Value("${secret_key}")
    String secret_key;

    public String encryptAES(String password) throws Exception {
        String bytes24key = String.format("%-24s", secret_key);
        SecretKeySpec key = new SecretKeySpec(bytes24key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cipher.doFinal(password.getBytes());
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
    public String decryptAES(String encryptedPassword) throws Exception {
        String bytes24key = String.format("%-24s", secret_key);
        SecretKeySpec key = new SecretKeySpec(bytes24key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedBytes = Base64.getDecoder().decode(encryptedPassword);
        return new String(cipher.doFinal(decodedBytes));
    }
}
