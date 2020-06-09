/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crypto;
import java.io.*;
import javax.crypto.*;
import java.security.*;

/**
 *
 * @author Lenovo
 */
public class DESEncryptDecrypt {
    public static void doEncryptDecrypt() {
        try {
            String data = " Dasar Symmetric Cryptography";
            byte[] plain = data.getBytes("UTF8");
            //membuat DES private key
            KeyGenerator keygen = KeyGenerator.getInstance("DES");
            keygen.init(56);
            //membuat DES cipher => print ke provider
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            Key key = keygen.generateKey();
            //proses encrypt
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] cipherText = cipher.doFinal(plain);
            //proses decripty
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] originText = cipher.doFinal(cipherText);
            System.out.println("Plain Text: " + data);
            System.out.println("Enkripsi: " + new String(cipherText, "UTF8"));
            System.out.println("Enkripsi Heksa : " + MyStringUtils.
                    getHexString(cipherText));
            System.out.println("Dekripsi : "+new String(originText, "UTF8"));
        } catch (UnsupportedEncodingException | InvalidKeyException |
                NoSuchAlgorithmException | BadPaddingException  |
                IllegalBlockSizeException | NoSuchPaddingException e) {
        }
    }

    public static void main(String[] args) {
        doEncryptDecrypt();
    }
}

