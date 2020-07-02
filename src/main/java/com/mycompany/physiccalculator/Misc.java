package com.mycompany.physiccalculator;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Misc {
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    public static double significantNumbers(double number, int theSignificants){
        BigDecimal bd = new BigDecimal(number);
        bd = bd.round(new MathContext(theSignificants));
        double rounded = bd.doubleValue();
        return rounded;
    }
}
