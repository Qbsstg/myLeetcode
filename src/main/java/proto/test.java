package proto;

import com.google.gson.Gson;
import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Arrays;

/**
 * @author: Qbss
 * @date: 2024/6/3
 * @desc:
 */
public class test {

    @SneakyThrows
    public static void main(String[] args) {
        AddressBook addressBook = AddressBook.newBuilder()
                .addPeople(Person.newBuilder()
                        .setId(1)
                        .setName("qbss")
                        .setEmail("231@113.com")
                        .addPhones(Person.PhoneNumber.newBuilder()
                                .setNumber("111111111")
                                .setType(Person.PhoneType.HOME))).build();

        System.out.println(addressBook);

        // 序列化为字节数组
        byte[] byteArray = addressBook.toByteArray();

        AddressBook book = AddressBook.parseFrom(byteArray);

        System.out.println("序列化字节数组：" + Arrays.toString(byteArray));
        System.out.println("反序列化：" + book);

        String json = new Gson().toJson(addressBook);
        System.out.println("json序列化后" + json);

    }
}
