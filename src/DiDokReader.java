import java.io.*;
import java.util.*;

public class DiDokReader {

    private List<HashMap<String, String>> stations;

    public void read(int size, List list) {
        stations = list;
        String[] keys;

        String line = "";
        String splitBy = ";";


        HashMap<String, String> station;

        try {
            //parsing a CSV file into BufferedReader
            BufferedReader br = new BufferedReader(new FileReader("resources/dienststellenfull.csv"));
            int i = 0;
            keys = null;
            while ((line = br.readLine()) != null && i < size) {

                char first = line.charAt(0);

                // ignore comments
                if(first == 35|| first == 65279) {
                    continue;
                }

                // get field names from first line
                if(i == 0) {
                    keys = line.split(splitBy);
                } else {
                    String[] values = line.split(splitBy);

                    station = new HashMap<>();
                    for (int j = 0; j < values.length; j++) {
                        station.put(keys[j], values[j]);
                    }

                    stations.add(station);
                }
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}