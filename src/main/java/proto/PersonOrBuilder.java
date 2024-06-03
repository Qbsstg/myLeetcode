// Generated by the protocol buffer compiler.  DO NOT EDIT!
// NO CHECKED-IN PROTOBUF GENCODE
// source: addressbook.proto
// Protobuf Java Version: 4.27.0
package proto;
public interface PersonOrBuilder extends
    // @@protoc_insertion_point(interface_extends:Person)
    com.google.protobuf.MessageOrBuilder {

  /**
   * <pre>
   * =1，=2 作为序列化后的二进制编码中的字段的唯一标签，也因此，1-15 比 16 会少一个字节，所以尽量使用 1-15 来指定常用字段。
   * </pre>
   *
   * <code>optional int32 id = 1;</code>
   * @return Whether the id field is set.
   */
  boolean hasId();
  /**
   * <pre>
   * =1，=2 作为序列化后的二进制编码中的字段的唯一标签，也因此，1-15 比 16 会少一个字节，所以尽量使用 1-15 来指定常用字段。
   * </pre>
   *
   * <code>optional int32 id = 1;</code>
   * @return The id.
   */
  int getId();

  /**
   * <code>optional string name = 2;</code>
   * @return Whether the name field is set.
   */
  boolean hasName();
  /**
   * <code>optional string name = 2;</code>
   * @return The name.
   */
  java.lang.String getName();
  /**
   * <code>optional string name = 2;</code>
   * @return The bytes for name.
   */
  com.google.protobuf.ByteString
      getNameBytes();

  /**
   * <code>optional string email = 3;</code>
   * @return Whether the email field is set.
   */
  boolean hasEmail();
  /**
   * <code>optional string email = 3;</code>
   * @return The email.
   */
  java.lang.String getEmail();
  /**
   * <code>optional string email = 3;</code>
   * @return The bytes for email.
   */
  com.google.protobuf.ByteString
      getEmailBytes();

  /**
   * <code>repeated .Person.PhoneNumber phones = 4;</code>
   */
  java.util.List<Person.PhoneNumber> 
      getPhonesList();
  /**
   * <code>repeated .Person.PhoneNumber phones = 4;</code>
   */
  Person.PhoneNumber getPhones(int index);
  /**
   * <code>repeated .Person.PhoneNumber phones = 4;</code>
   */
  int getPhonesCount();
  /**
   * <code>repeated .Person.PhoneNumber phones = 4;</code>
   */
  java.util.List<? extends Person.PhoneNumberOrBuilder> 
      getPhonesOrBuilderList();
  /**
   * <code>repeated .Person.PhoneNumber phones = 4;</code>
   */
  Person.PhoneNumberOrBuilder getPhonesOrBuilder(
      int index);
}
