import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Main {

    private static List<String> lines;
    private static List<Integer> prices;

    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        prices = new ArrayList<>();
        lines = new ArrayList<>();

        String line = br.readLine();
        Boolean out = false;

        while (line != null && !out) {         
            lines.add(line);
            line = br.readLine();     
            if(line.equals("")) {
                out = true;
            }
        }

        String[] parts = lines.get(1).split(" ");
        for(int i = 0 ; i < parts.length ; i++){
            prices.add(Integer.parseInt(parts[i]));
        }

        br.close();


        
        bw.write(result(Integer.parseInt(lines.get(2)), prices));
        bw.close();
    }

    public static String result (int amount, List<Integer> values){
        String ms = "no values";
        int subtract = 1000001;

        for (int i = 0; i < values.size() ; i++){

            int testValue = values.get(i);
            
            for(int j = i+1; j < values.size(); j++){

                if(testValue + values.get(j) == amount){

                    int temp =  testValue - values.get(j);

                    if( temp >= 0 && temp < subtract ){ 
                        
                        ms = values.get(j) + " , " + testValue;
                        subtract = temp;
                        System.out.println(subtract + " = " + values.get(j) + " - " + testValue);

                    } else if( temp  < 0 &&  temp*-1  < subtract ){

                        ms =  testValue + " , " + values.get(j) ;
                        subtract =  temp*-1;
                        System.out.println(subtract + " = " + testValue+ " - " + values.get(j));
                    }
                }
            } 
        }
            
        return ms;

    }
}
