import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class mainClass {
    public static void main(String[] arg) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        testFunctionalInterface(mainClass::forEachMethod);

    }

    public static  void testFunctionalInterface(FunctionalInterface1 functionalInterface1){
        functionalInterface1.print();
        System.out.println("abc");
    }
    public static void forEachMethod(){
        System.out.println("abcd");
    }



}
