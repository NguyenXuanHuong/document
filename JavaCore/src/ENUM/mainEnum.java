package ENUM;

public class mainEnum {
  public static void main(String[] args) {
    testEnum enum1 = testEnum.ENUM1;
    testEnum enum2 = testEnum.ENUM1;
    System.out.println(enum1 == enum2);
    enum1.setValueAttr("Abc");
    System.out.println(enum2.getValueAttr());
    String str = enum1.getValueAttr();
    System.out.println(enum1 instanceof testEnum);
  }
}
