package unknown;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.crypto.Mode;
import cn.hutool.crypto.Padding;
import cn.hutool.crypto.symmetric.AES;

import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;


/**
 * @Description
 * @CreateDate 2020/10/10 15:35
 * @Author wzg
 * @Version 1.0.0
 */
public class AesUti2 {

    final static AES AES = getAes();

    final static String regex = "^(?![A-Za-z]+$)(?![A-Z\\d]+$)(?![A-Z\\W]+$)(?![a-z\\d]+$)(?![a-z\\W]+$)(?![\\d\\W]+$)\\S{8,}$";

    /**
     * lqn 随机生成密码
     *
     * @return
     */
    public static String randomPassword() {
        return RandomUtil.randomString(RandomUtil.BASE_CHAR_NUMBER + RandomUtil.BASE_CHAR.toUpperCase(), 8);
    }

    /**
     * @return
     * @Description hutu 工具加密
     * @Author wzg
     * @Date 2020/10/12
     * @Param
     */
    public static String encryPassword(String password) {
        // 加密为16进制表示
        return AES.encryptHex(password);
    }

    /**
     * @return
     * @Description 解密
     * @Author wzg
     * @Date 2020/10/12
     * @Param
     */
    public static String decryPassword(String encryptHex) {
        // 解密
        return AES.decryptStr(encryptHex);
    }

    public static boolean checkPass(String password) {
        return password.matches(regex);
    }

    /***
     * 构建 AES对象
     *
     * @return
     */
    private static AES getAes() {
        //return SecureUtil.aes(ResourceConstant.SECRET_KEY.substring(0, 16).getBytes());

        return new AES(Mode.CFB, Padding.NoPadding,
                new SecretKeySpec("mqdqxygyqyklklsys24678".substring(0, 16).getBytes(), "AES"),
                new IvParameterSpec("mqdqxygyqyklklsys24678".substring(0, 16).getBytes()));
    }

    public static void main(String[] args) {
        System.out.println(AesUti2.encryPassword("abc@6789"));
        System.out.println(AesUti2.encryPassword("admin@666"));
        System.out.println(decryPassword("1om5KEap6aU8"));
        System.out.println(decryPassword("d68fb7011ad9eda0"));
    }


}
