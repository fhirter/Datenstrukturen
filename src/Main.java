import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


// ### Übung Datenstrukturen ###
// Lernziele:
// - Einfache Programme schreiben, Objekte benutzen
// - Performance verschiedener Datenstrukturen kennenlernen
// Aufgabe:
// - Zeit messen für
// -- Einlesen der CSV mit ArrayList und LinkedList
// -- Daten aus der Liste auslesen: Sequentiell und Zufällig
// -- Daten entfernen an zufälligem Ort
public class Main {
    public static void main(String[] args) {
        final int iterations = 1;

        List<HashMap<String, String>> stationsArray = new ArrayList<>();

        StationsMonteCarlo monteCarloArray = new StationsMonteCarlo(iterations, stationsArray, 100000);
        HashMap<String, Long> array = monteCarloArray.run();

        List<HashMap<String, String>> stationsList = new LinkedList<>();
        StationsMonteCarlo monteCarloList = new StationsMonteCarlo(iterations, stationsList, 100000);
        HashMap<String, Long> list = monteCarloList.run();

        System.out.println(array);
        System.out.println(list);

    }




}
