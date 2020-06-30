package physicscalculator;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Misc {
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public static double significantNumbers(double number, int theSignificants){
        String num = Double.toString(number);
        String newNum = "";
        int count = 0;
        String prev = "";
        double roundedNumAsDouble = 0;
        int roundedNumAsInt = 0;
        for (int i = 0; i < num.length(); i++){
            String current = Character.toString(num.charAt(i));
            if (count == theSignificants){
                prev = "0." + prev + current;
                roundedNumAsDouble = round(Double.parseDouble(prev), 1);
                roundedNumAsInt = Integer.parseInt(Character.toString((Double.toString(roundedNumAsDouble)).charAt(2)));
                num = "";
                for (int j = 0; j < newNum.length(); j++){
                    if (j == newNum.length()-1){
                        num += roundedNumAsInt;
                        break;
                    }
                    num += newNum.charAt(j);
                }
                break;
            }
            prev = Character.toString(num.charAt(i));
            if (num.charAt(i) == '0'){
                newNum += "0";
            } else if(num.charAt(i) == '.'){
                newNum += ".";
            } else {
                newNum += num.charAt(i);
                count++;
            }
        }
        return Double.parseDouble(num);
    }
}
