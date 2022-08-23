import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class iteratorMain {
  public static void main(String[] args) {

    List<String> list = new ArrayList<>(List.of("A", "B", "C"));
    Iterator<String> iterator = list.iterator();
    while (iterator.hasNext()) {
      String value = iterator.next();
      System.out.println(value);
    }
  }
}
