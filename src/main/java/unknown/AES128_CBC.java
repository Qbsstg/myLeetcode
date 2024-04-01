package unknown;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Formatter;

/**
 * @author: Qbss
 * @date: 2024/3/26
 * @desc:
 */
public class AES128_CBC {
    public static void main(String[] args) throws Exception {
        String key = "6E4380FD753579D1";
        String initVector = "6E4380FD753579D1"; // 16 bytes IV

        // String encrypted = encrypt(key, initVector, "Hello World");
        String encrypted = encrypt(key, initVector, "lockctrl=1,2023-03-21 15:13:05");
        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(key, initVector, encrypted);
        System.out.println("Decrypted: " + decrypted);
    }

    public static String encrypt(String key, String initVector, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");


            // nopadding
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] bytes = value.getBytes();
            byte[] bytes1 = new byte[32];
            System.arraycopy(bytes, 0, bytes1, 0, bytes.length);
            byte[] encrypted = cipher.doFinal(bytes1);
            return toHex(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes(StandardCharsets.UTF_8));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(toBinary(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    private static String toHex(byte[] bytes) {
        Formatter formatter = new Formatter();
        for (byte b : bytes) {
            formatter.format("%02x", b);
        }
        return formatter.toString();
    }

    private static byte[] toBinary(String s) {
        try {
            // return Hex.decodeHex(s.toCharArray());
            // 将二进制转为十六进制
            char[] charArray = s.toCharArray();
            byte[] byteArray = new byte[charArray.length / 2];
            for (int i = 0; i < byteArray.length; i++) {
                byteArray[i] = (byte) (Character.digit(charArray[i * 2], 16) << 4
                        | Character.digit(charArray[i * 2 + 1], 16));
            }
            return byteArray;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


}
