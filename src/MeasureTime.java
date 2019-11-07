import java.util.LinkedList;
import java.util.List;

public class MeasureTime {
    private long start;
    private long stop;
    private List<Long> data;

    MeasureTime() {
        data = new LinkedList<>();
    }

    public void start() {
        start = System.currentTimeMillis();
    }

    public long stop() {
        stop = System.currentTimeMillis();
        return  stop - start;
    }

    public void store() {
        data.add(stop - start);
    }

    public long getMean() {
        long average =0;
        for (int i = 0; i < data.size(); i++) {
            average = (average*(i) + data.get(i))/(i+1);
        }
        return average;
    }
}