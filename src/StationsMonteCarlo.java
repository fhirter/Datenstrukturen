import java.util.HashMap;
import java.util.List;

public class StationsMonteCarlo {
    private int iterations;
    private int dataSize;
    private List data;

    public StationsMonteCarlo(int iterations, List data, int dataSize) {
        this.iterations = iterations;
        this.data = data;
        this.dataSize = dataSize;
    }

    public long measureReadSequential() {
        MeasureTime time = new MeasureTime();
        for (int i = 0; i < iterations; i++) {
            time.start();
            for (int j = 0; j < data.size(); j++) {
                System.out.println(data.get(j));
            }
            time.stop();
            time.store();
        }
        return time.getMean();
    }

    public  long measureReadRandom() {
        int size = data.size();
        MeasureTime time = new MeasureTime();
        for (int i = 0; i < iterations; i++) {
            time.start();
            for (int j = 0; j < size; j++) {
                int index = (int) (Math.random() * size);
                System.out.println(data.get(index));
            }
            time.stop();
            time.store();
        }
        return time.getMean();
    }

    public long measureDeleteRandom() {
        int size = data.size();
        MeasureTime time = new MeasureTime();
        for (int i = 0; i < iterations; i++) {
            time.start();
            for (int j = 0; j < size; j++) {
                int index = (int) (Math.random() * size);
                data.remove(index);
                size = data.size();
            }
            time.stop();
            time.store();
        }
        return time.getMean();
    }

    public   long measureCreationTime() {
        DiDokReader didok = new DiDokReader();
        MeasureTime time = new MeasureTime();
        for (int i = 0; i < iterations; i++) {
            time.start();
            didok.read(dataSize, data);
            time.stop();
            time.store();
        }
        return time.getMean();
    }

    public HashMap<String, Long> run() {
        HashMap<String, Long> result = new HashMap<>();
        System.out.println("create");
        result.put("creation", measureCreationTime());
        System.out.println("read random");
        result.put("readRandom", measureReadRandom());
        System.out.println("read sequential");
        result.put("readSequential", measureReadSequential());
        System.out.println("delete random");
        result.put("deleteRandom", measureDeleteRandom());
        return result;
    }
}
