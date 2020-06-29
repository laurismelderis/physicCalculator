package physicscalculator;

import javax.swing.DefaultListModel;
import javax.swing.JTextField;

public class Formulas {
    JTextField []paramName = null;
    DefaultListModel []paramModels = null;
    int paramLength = 0;
    
    public Formulas(JTextField []paramName, DefaultListModel []paramModels){
        this.paramName = paramName;
        this.paramModels = paramModels;
        paramLength = paramModels.length;
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
    public String getFormulas(){
        
        String formula = "";
        formula += "\\text{Arithmetic mean} \\\\";
        for (int i = 0; i < paramLength;i++){
            double data[] = new double[paramModels[i].getSize()];
            for(int j = 0; j < data.length; j++){
                data[j] = Double.parseDouble(paramModels[i].get(j).toString());
            }
            formula += "\\overline{" + paramName[i].getText() + "} = " + arithmeticMean(data) + " \\\\ ";
        }
        
        formula += "\\text{Mean squared error} \\\\";
        for (int i = 0; i < paramLength;i++){
            double data[] = new double[paramModels[i].getSize()];
            for(int j = 0; j < data.length; j++){
                data[j] = Double.parseDouble(paramModels[i].get(j).toString());
            }
            formula += "s_" + paramName[i].getText() + " = " + meanSquaredError(data, arithmeticMean(data)) + " \\\\ ";
        }
        return formula;
    }
}
