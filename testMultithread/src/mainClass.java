import java.util.ArrayList;
import java.util.List;

public class mainClass {
    public static void main(String[] args) {

        List<String> input = List.of("1","2","3","4","5","6");
        MyRunnable myRunnable1 = new MyRunnable(input.subList(0,2));
        Thread thread1 = new Thread(myRunnable1);


        MyRunnable myRunnable2 = new MyRunnable(input.subList(2,4));
        Thread thread2 = new Thread(myRunnable2);


        MyRunnable myRunnable3 = new MyRunnable(input.subList(4,6));
        Thread thread3 = new Thread(myRunnable3);
        thread3.start();
        thread1.start();
        thread2.start();


        try{
            thread1.join();
            thread2.join();
            thread3.join();
        }catch (Exception e){
            e.printStackTrace();
        }
        List<String> result = new ArrayList<>();
        result.addAll(myRunnable1.getOutPutList());
        result.addAll(myRunnable2.getOutPutList());
        result.addAll(myRunnable3.getOutPutList());
        System.out.println(result);







    }
}
