public class MeasureTime {
    private long start;
    private long stop;

    public void start() {
        start = System.currentTimeMillis();
    }

    public long stop() {
        stop = System.currentTimeMillis();
        return  stop - start;
    }
}