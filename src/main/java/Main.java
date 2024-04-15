import org.apache.commons.io.IOUtils;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public String readRawDataToString() throws Exception{
        ClassLoader classLoader = getClass().getClassLoader();
        String result = IOUtils.toString(classLoader.getResourceAsStream("RawData.txt"));
        return result;
    }




    public static void main(String[] args) throws Exception{
        String output = (new Main()).readRawDataToString();
        //store result in the stringbuilder
        StringBuilder sb = new StringBuilder();

        //create arraylist store keys
        List<String> keys= new ArrayList<>();
        //create arraylist store values
        List<String> values = new ArrayList<>();
        //create delimeter
        String delims = "[*;##%^]+";
        //split string use delimeter
        String[] splitString = output.split(delims);
        //System.out.println(Arrays.toString(splitString));
        int errors = 0;
        List<String> updatedString = new ArrayList<>();
        //store expiraion dates for split again
        List<String> dates = new ArrayList<>();
        for(int i = 0; i<splitString.length;i++){

            String[] s = splitString[i].split(":");
            if(s.length>1){
                updatedString.add(splitString[i]);
            }
            else {
                errors++;
            }

        }
        //now I have updated new string
        //create list contains only name and price
        //System.out.println(errors);
        List<String> namePrice = new ArrayList<>();
        for(String s:updatedString){
            if(s.contains("type")||s.contains("expiration")){

            }
            else {
                namePrice.add(s);

            }
        }
        //count products with their prices
        int samePrice = 0;
        int differentPrice = 0;
        int countProduct = 0;
        for(int b = 0; b<namePrice.size();b++){

            String[] last = namePrice.get(b).split(":");

               Pattern pattern = Pattern.compile("Milk",Pattern.CASE_INSENSITIVE);
               Matcher matcher = pattern.matcher(last[1]);
               if(matcher.find()){
                   countProduct++;
               }


        }
        System.out.println(countProduct);
        System.out.println(namePrice);














    }
}
