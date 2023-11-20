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
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;

public class RSA_Client {
    private PublicKey publicKey;

    public RSA_Client(String publicKey) {
        try {
                this.publicKey = convertStringToPublicKeyRSA(publicKey);
            } catch (Exception e) {
                System.out.println("Error initializing public key: " + e.getMessage());
            }
    }

        public static PublicKey convertStringToPublicKeyRSA (String publicKeyString) throws Exception {
            byte[] publicKeyBytes = Base64.getDecoder().decode(publicKeyString);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(publicKeyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(keySpec);
        }
        public String encrypt (String message) throws Exception {
            byte[] messageToBytes = message.getBytes();
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] encryptedBytes = cipher.doFinal(messageToBytes);
            return encode(encryptedBytes);
        }

        private String encode(byte[] data) {
        return Base64.getEncoder().encodeToString(data);
    }
    }


