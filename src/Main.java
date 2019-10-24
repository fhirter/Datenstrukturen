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
        DiDokReader didok = new DiDokReader();
        MeasureTime time = new MeasureTime();
        List<HashMap<String, String>> stations = new ArrayList<>();

        didok.read(Integer.MAX_VALUE, stations);
    }

    public static void readSequential(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void readRandom(List list) {
        int size = list.size();
        for (int i = 0; i < list.size(); i++) {
            int index = (int) (Math.random()*size);
            System.out.println(list.get(index));
        }
    }

    public static void deleteRandom(List list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int index = (int) (Math.random()*size);
            list.remove(index);
            size = list.size();
        }
    }




}
