package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
* iterator is a interface => only used for iterating
*  a service accept a Collection as input
*  if not using iterator (using foreach + get(index)) => it would work with List but in the future if you want to use Set
*  instead then it would not work
*
* all interface extends Collections support Iterator => no need to worry about changing structure of Collection (from list to set)
*
* nothing related multithread here*/
public class iteratorMain {
  public static void main(String[] args) {

    List<String> list = new ArrayList<>(List.of("A", "B", "C"));
    Iterator<String> iterator = list.iterator();

    while (iterator.hasNext()) {
      String value = iterator.next();
      System.out.println(value);
    }

    // this will throw error
//    for (String str : list) {
//      if (str.equals("ABC")){
//        list.remove(str);
//      }
//
//    }

    // using this instead
    while (iterator.hasNext()){
      if (iterator.next().equals("abc")){
        iterator.remove();
      }
    }
  }
}
