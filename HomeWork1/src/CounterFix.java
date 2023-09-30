import java.util.concurrent.atomic.AtomicInteger;

public class CounterFix {
    private AtomicInteger count = new AtomicInteger(0);
    public void increment(){
        count.addAndGet(1); // 1 - это число на которое хотитим увеличивать
    }
    public int getValue(){
        return count.get();
    }
}
