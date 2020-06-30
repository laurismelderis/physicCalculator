package physicscalculator;

import java.text.DecimalFormat;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;

public class Formulas {
    private JTextField paramName[] = null;
    private DefaultListModel paramModels[] = null;
    public double measureMistakes[] = null;
    private double studentsCoefficientBeta = 0;
    private int paramLength = 0;
    public double arithmeticMean[] = null;
    public double meanSquaredError[] = null;
    public double studentsCoefficient[] = null;
    public double studentsCoefficientInf = 0;
    public double absoluteError[] = null;
    public double systematicError[] = null;
    public double finalAbsoluteError[] = null;
    public double relativeError[] = null;
    
    public Formulas(JTextField []paramName, DefaultListModel []paramModels, double studentsCoefficientBeta, double []measureMistakes){
        this.paramName = paramName;
        this.paramModels = paramModels;
        this.studentsCoefficientBeta = studentsCoefficientBeta;
        paramLength = paramModels.length;
        
        arithmeticMean = new double[paramLength];
        meanSquaredError = new double[paramLength];
        studentsCoefficient = new double[paramLength];
        absoluteError = new double[paramLength];
        systematicError = new double[paramLength];
        finalAbsoluteError = new double[paramLength];
        relativeError = new double[paramLength];
        this.measureMistakes = measureMistakes;
        
        studentsCoefficientInf = studentsCoefficient(studentsCoefficientBeta, 26);
        
        for (int i = 0; i < this.paramLength; i++){
            double data[] = new double[paramModels[i].getSize()];
            for(int j = 0; j < data.length; j++){
                data[j] = Double.parseDouble(paramModels[i].get(j).toString());
            }
            arithmeticMean[i] = arithmeticMean(data);
            meanSquaredError[i] = meanSquaredError(data, arithmeticMean[i]);
            studentsCoefficient[i] = studentsCoefficient(this.studentsCoefficientBeta, data.length, this.paramModels[i]);
            absoluteError[i] = absoluteError(meanSquaredError[i], studentsCoefficient[i]);
            systematicError[i] = systematicError(this.measureMistakes[i], this.paramLength, this.studentsCoefficientInf);
            finalAbsoluteError[i] = finalAbsoluteError(absoluteError[i], systematicError[i]);
            relativeError[i] = relativeError(finalAbsoluteError[i], arithmeticMean[i]);
        }
    }
    
    private double arithmeticMean(double []data){
        double answer = 0;
        for (int i = 0; i < data.length; i++){
            answer += data[i];
        }
        return answer/data.length;
    }
    private double meanSquaredError(double []data, double arithmeticMean){
        double answer = 0;
        if (data.length == 1){
            return data[0];
        }
        for (int i = 0; i < data.length; i++){
            answer += Math.pow((data[i] - arithmeticMean), 2);
        }
        double counter = answer;
        answer = Math.sqrt(counter/(data.length*(data.length-1)));
        return answer;
    }
    private double studentsCoefficient(double beta, int n){
        if (beta == 0.70){
            return 1.04;
        } else if (beta == 0.95){
            return 1.96;
        } else if (beta == 0.99){
            return beta = 2.58;
        } else {
            return 0;
        }
    }
    private double studentsCoefficient(double beta, int n, DefaultListModel model){
        double beta070[] = {1.96, 1.39, 1.25, 1.19,
                            1.16, 1.13, 1.12, 1.11,
                            1.10, 1.09, 1.09, 1.08,
                            1.08, 1.08, 1.07, 1.07,
                            1.07, 1.07, 1.06, 1.06,
                            1.06, 1.06, 1.06, 1.06, 1.04};
        double beta095[] = {12.71, 4.30, 3.18, 2.78,
                            2.57, 2.45, 2.36, 2.31,
                            2.26, 2.23, 2.20, 2.18,
                            2.16, 2.15, 2.13, 2.12,
                            2.11, 2.10, 2.09, 2.09,
                            2.08, 2.07, 2.07, 2.06, 1.96};
        double beta099[] = {63.66, 9.92, 5.84, 4.60,
                            4.03, 3.71, 3.50, 3.36,
                            3.25, 3.17, 3.11, 3.05,
                            3.01, 2.98, 2.95, 2.92,
                            2.90, 2.88, 2.86, 2.84,
                            2.83, 2.82, 2.81, 2.80, 2.58};
        if (n < 2){
            return Double.parseDouble(model.get(0).toString());
        }
        
        if (beta == 0.7){
            if (n > 25){
                return beta070[24];
            } else {
                return beta070[n-2];
            }
        } else if (beta == 0.95){
            if (n > 25){
                return beta095[24];
            } else {
                return beta095[n-2];
            }
        } else if (beta == 0.99){
            if (n > 25){
                return beta099[24];
            } else {
                return beta099[n-2];
            }
        }
        return 0;
    }
    
    private double absoluteError(double meanSquaredError, double studentsCoefficient){
        return Misc.significantNumbers((meanSquaredError * studentsCoefficient), 2);
    }
    
    private double systematicError(double measureMistake, int paramLength, double studentsCoefficientInf){
        return Misc.significantNumbers(((measureMistake/3)*studentsCoefficientInf), 2);
    }
    
    private double finalAbsoluteError(double absoluteError, double systematicError){
        if (absoluteError/systematicError < 3 || systematicError/absoluteError < 3){
            return Misc.significantNumbers((Math.sqrt(Math.pow(absoluteError, 2) + Math.pow(systematicError, 2))), 2);
        } else if (absoluteError > systematicError){
            return absoluteError;
        } else if (absoluteError < systematicError){
            return systematicError;
        } else {
            return 0;
        }
    }
    
    private double relativeError(double finalAbsoluteError, double meanArithmetic){
        DecimalFormat f = new DecimalFormat("##.00");
        return Double.parseDouble(f.format((finalAbsoluteError/meanArithmetic)*100));
    }
    public String getFormulas(){
        String formula = "";
        // Arithmetic mean
        formula += "\\text{Arithmetic mean } \\overline{x} = \\frac{1}{n} \\sum_{i=1}^{n} x_i  \\\\";
        for (int i = 0; i < paramLength; i++){
            formula += "\\overline{" + paramName[i].getText() + "} = " + arithmeticMean[i] + " \\\\ ";
        }
        
        // Mean squared error
        formula += "\\text{Mean squared error } s_x = \\sqrt{\\frac{\\sum_{i=1}^{n}( \\, x_i - \\overline{x} ) \\, ^2}"
                + "{n (\\, n - 1 ) \\,}} \\\\";
        for (int i = 0; i < paramLength; i++){
            formula += "s_{" + paramName[i].getText() + "} = " + meanSquaredError[i] + " \\\\ ";
        }
        
        //Students coefficient
        for (int i = 0; i < paramLength; i++){
            formula += "\\text{Students coefficient for " + paramName[i].getText() + " }t_{" + 
                    studentsCoefficientBeta + "} ("+paramModels[i].getSize()+") = " + 
                    studentsCoefficient[i] + "\\\\";
        }
        formula += "\\text{Students coefficient } t_{" + 
                    studentsCoefficientBeta + "} (\\infty) = " + 
                    studentsCoefficientInf + "\\\\";
        
        //Absolute error
        formula += "\\text{Absolute error } \\Delta x_s = s_xt_\\beta (n) \\\\";
        for (int i = 0; i < paramLength; i++){
            formula += "\\Delta " + paramName[i].getText() + "_{s} = " +
                    absoluteError[i] + " \\\\ ";
        }
        
        //Systematic error
        formula += "\\text{Systematic error } \\Delta x_\\delta = \\frac{\\delta x}{3} t_\\beta (\\infty)\\\\";
        for (int i = 0; i < paramLength; i++){
            formula += "\\Delta " + paramName[i].getText() + "_{\\delta} = " +
                    systematicError[i] + " \\\\ ";
        }
        
        //Final absolute error
        formula += "\\text{Final absolute error } \\Delta x = \\sqrt{(\\Delta x_s)^2 + (\\Delta x_\\delta)^2} \\\\";
        for (int i = 0; i < paramLength; i++){
            formula += "\\Delta " + paramName[i].getText() + " = " + finalAbsoluteError[i] + "\\\\";
        }
        
        //Relative error
        formula += "\\text{Relative error } \\varepsilon_x = \\frac{\\Delta x}{\\overline{x}}100\\% \\\\";
        for (int i = 0; i < paramLength; i++){
            formula += "\\varepsilon _{"+paramName[i].getText()+"} = " + relativeError[i] + "\\%\\\\";
        }
        return formula;
    }
}
