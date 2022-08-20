import java.util.ArrayList;
import java.util.List;

public class MyRunnable implements Runnable {

    private final List<String> inputList;
    private final List<String> outPutList = new ArrayList<>();

    public MyRunnable(List<String> inputList) {
        this.inputList = inputList;
    }

    public List<String> getOutPutList() {
        return outPutList;
    }

    public void run(){
        outPutList.addAll(inputList);
    }


}