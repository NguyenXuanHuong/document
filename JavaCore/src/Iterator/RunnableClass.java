package Iterator;

import java.util.List;

public class RunnableClass implements Runnable{

    private final List<String> testList;

    public RunnableClass(List<String> testList) {
        this.testList = testList;
    }

    @Override
    public void run() {
    System.out.println("start thread");
        this.testList.set(1, "Abc");
    }
}
