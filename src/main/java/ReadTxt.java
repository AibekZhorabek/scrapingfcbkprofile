import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadTxt {
    public static ArrayList<String> reader(String path) throws FileNotFoundException {
        File file = new File(path);
        Scanner scan = new Scanner(file);
        ArrayList<String> arr = new ArrayList<>();
        while (scan.hasNextLine()){
            arr.add(scan.nextLine());
        }
        return arr;
    }
}
