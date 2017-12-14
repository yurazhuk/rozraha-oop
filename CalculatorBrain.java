package sample;

import javafx.scene.input.Clipboard;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


class CalculatorBrain {

    private Double accumulator;
    private Double temp = null;
    private String operationAccumulator;
    private Double memory = 0.0;
    private ArrayList<String> integerArrayList = new ArrayList<>();
    private ArrayList<String> floatArrayList = new ArrayList<>();
    private ArrayList<String> doubleArrayList = new ArrayList<>();
    private char[] charsMassive = new char[11];


    void performOperation(String operation) {
        switch (operation) {
            case "AC":
            case "±":
            case "٪":
            case "Log":
            case "MR":
            case "Mc":
            case "M+":
                performUnaryOperation(operation);
                break;
            case "+":
            case "-":
            case "x":
            case "÷":
            case "min":
                temp = accumulator;
                operationAccumulator = operation;
                break;
            case "=":
                performBinaryOperation(operationAccumulator);
                break;
        }
    }

    private void performUnaryOperation (String operation) {
        switch (operation) {
            case "AC": accumulator = 0.0;
            break;
            case "±": accumulator = -accumulator;
            break;
            case "٪": accumulator = accumulator / 100.0;
            break;
            case "M+": memory = memory + accumulator;
                break;
            case "Mc": memory = 0.0;
                break;
            case "MR": accumulator = 0.0;
                    accumulator = memory;
                break;
            case "Log":
                if (accumulator > 0.0) {
                    accumulator = Math.log(accumulator);
                }
            break;
        }
    }

    private void performBinaryOperation(String operation) {
        System.out.print(temp);
        switch (operation) {
            case "÷": accumulator = temp / accumulator;
            break;
            case "x": accumulator = temp * accumulator;
            break;
            case "-": accumulator = temp - accumulator;
            break;
            case "+": accumulator = temp + accumulator;
            break;
            case "min": accumulator =  accumulator > temp ? accumulator : temp;
            break;
        }
    }

    void readFromFile() throws IOException {

        String resulting = "Result is = {";
        File inputFile = new File("/Users/lukemome/Desktop/untitled folder 3/input.txt");
        Scanner scanner = new Scanner(inputFile);
        int i = 0;
        while (scanner.hasNext()) {
            integerArrayList.add(scanner.next());
            doubleArrayList.add(scanner.next());
            floatArrayList.add((scanner.next()));
            charsMassive[i] = scanner.next().charAt(0);
            i++;
        }
        scanner.close();
        double[] doubleArray = new double[doubleArrayList.size()];
        for (int j = 1; j < doubleArrayList.size(); j++) {
            doubleArray[j] = Double.parseDouble(doubleArrayList.get(j));
        }
        Arrays.sort(doubleArray);

        for (double a : doubleArray) {
            resulting += a + ",";
        }
        resulting += "}";


        File outputFile = new File("/Users/lukemome/Desktop/untitled folder 3/output.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
        writer.write(resulting);
        writer.close();

        integerArrayList.clear();
        floatArrayList.clear();
        doubleArrayList.clear();
    }

    void setOperand(Double operand) {
        accumulator = operand;
    }

    Double getResult() {
        return accumulator;
}
}