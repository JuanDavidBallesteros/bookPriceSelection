import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    private static List<Integer> prices;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        prices = new ArrayList<>();

        String line;
        do {
            line = br.readLine();
            line = br.readLine();
            String[] parts = line.split(" ");
            for (int i = 0; i < parts.length; i++) {
                prices.add(Integer.parseInt(parts[i]));
            }
            line = br.readLine();
            int amount = Integer.parseInt(line);

            String out = printResult(binarySearch(amount, prices));

            bw.write(out);

            line = br.readLine();
        } while (line != null);
        br.close();
        bw.close();
    }

    public static String printResult(String ms) throws IOException {

        return ms = ("Peter should buy books whose prices are " + ms + "\n\n");

    }

    public static String binarySearch(int amount, List<Integer> values) {

        Collections.sort(values);

        String out = "";
        int subtract = 1000001;

        for (int i = 0; i < (values.size()); i++) {
            int x = amount - values.get(i);

            int pos = -1;
            int start = 0;
            int last = values.size() - 1;

            while (start <= last && pos < 0) {

                int m = (start + last) / 2;

                if (values.get(m) == (x)) {
                    pos = m;

                    int temp = values.get(i) - x;

                    if (temp < 0) {
                        temp = temp * -1;
                    }

                    if (temp < subtract) {
                        subtract = temp;
                        if (values.get(i) <= x) {
                            out = values.get(i) + " and " + x;
                        } else {
                            out = x + " and " + values.get(i);
                        }
                    }

                } else if (x > values.get(m)) {
                    start = m + 1;
                } else if (x < values.get(m)) {
                    last = m - 1;
                }
            }
        }
        return out;
    }

    public static String result(int amount, List<Integer> values) {
        String ms = "no values";
        int subtract = 1000001;

        for (int i = 0; i < values.size(); i++) {

            int testValue = values.get(i);

            for (int j = i + 1; j < values.size(); j++) {

                if (testValue + values.get(j) == amount) {

                    int temp = testValue - values.get(j);

                    if (temp >= 0 && temp < subtract) {

                        ms = values.get(j) + " and " + testValue;
                        subtract = temp;

                    } else if (temp < 0 && temp * -1 < subtract) {

                        ms = testValue + " and " + values.get(j);
                        subtract = temp * -1;
                    }
                }
            }
        }

        return ms;

    }

}
