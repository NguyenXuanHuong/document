package ENUM;

public enum testEnum {
  // instance of Enum
  ENUM1,
  ENUM2;

  testEnum() {
  }

  // attribute of enum
  private String value;

  public String getValueAttr() {
    return this.value;
  }

  public void setValueAttr(String str) {
    this.value = str;
  }
}
