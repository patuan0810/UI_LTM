/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ui_ltm;

/**
 *
 * @author Admin
 */
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AES_Client {
    private SecretKey key;
    private int KEY_SIZE = 128;
    private int T_LEN = 128;
    private Cipher encryptionCipher;

    public void init() throws NoSuchAlgorithmException {
        KeyGenerator generator = KeyGenerator.getInstance("AES");
        generator.init(KEY_SIZE);
        key = generator.generateKey();
    }

    public String encrypt(String message) throws Exception {
        byte[] messageInBytes = message.getBytes();
        encryptionCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        encryptionCipher.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = encryptionCipher.doFinal(messageInBytes);
        return encode(encryptedBytes);
    }

    public String decrypt(String encryptedMessage) throws Exception {
        byte[] messageInBytes = decode(encryptedMessage);
        Cipher decrypttionCipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        decrypttionCipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decryptedBytes = decrypttionCipher.doFinal(messageInBytes);
        return new String(decryptedBytes, "UTF8");
    }

    private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
    private static byte[] decode(String data) {
        return Base64.getDecoder().decode(data);
    }

    public String getKey() {
        return encode(key.getEncoded());
    }
}

