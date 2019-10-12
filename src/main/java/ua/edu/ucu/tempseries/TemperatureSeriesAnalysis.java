package ua.edu.ucu.tempseries;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis {

    private double[] temperatureSeries;
    private int arrSize;

    public TemperatureSeriesAnalysis() { }

    public TemperatureSeriesAnalysis(double[] temperatureSeries) {
        this.temperatureSeries = temperatureSeries;
        this.arrSize = temperatureSeries.length;
    }

    public double average() {
        error_generator();

        double sum = 0.0;
        for (double elem : temperatureSeries) {
            sum += elem;
        }
        return sum/temperatureSeries.length;
    }

    public double deviation() {
        error_generator();

        double sum = 0.0, deviation = 0.0;
        int len = temperatureSeries.length;

        for (double elem : temperatureSeries) {
            sum += elem;
        }
        double mean = sum/len;
        for (double elem: temperatureSeries) {
            double x = elem - mean;
            deviation += x*x;
        }
        return Math.sqrt(deviation/len);
    }

    public double min() {
        error_generator();

        double min = Integer.MAX_VALUE;
        for (double temperatureSery : temperatureSeries) {
            if (temperatureSery < min) {
                min = temperatureSery;
            }
        }
        return min;
    }

    public double max() {
        error_generator();

        double max = Integer.MIN_VALUE;
        for (double temperatureSery : temperatureSeries) {
            if (temperatureSery > max) {
                max = temperatureSery;
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        error_generator();

        double value = Integer.MAX_VALUE, temp = temperatureSeries[0];
        for (double elem : temperatureSeries) {
            if (Math.abs(0 - elem) < value) {
                value = Math.abs(0 - elem);
                temp = elem;
            }
        }
        return temp;
    }

    public double findTempClosestToValue(double tempValue) {
        error_generator();

        double value = Integer.MAX_VALUE, temp = temperatureSeries[0];
        for (double elem : temperatureSeries) {
            if (Math.abs(tempValue - elem) < value) {
                value = Math.abs(0 - elem);
                temp = elem;
            }
        }
        return temp;
    }

    public double[] findTempsLessThen(double tempValue) {
        error_generator();
        double[] helperarr = new double[temperatureSeries.length];
        double[] arr = {};
        int index = 0;
        for (double elem : temperatureSeries) {
            if (elem < tempValue) {
                arr = new double[index+1];
                helperarr[index] = elem;
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = helperarr[i];
        }
        return arr;
    }

    public double[] findTempsGreaterThen(double tempValue) {
        error_generator();
        double[] helperarr = new double[temperatureSeries.length];
        double[] arr = {};
        int index = 0;
        for (double elem : temperatureSeries) {
            if (elem > tempValue) {
                arr = new double[index+1];
                helperarr[index] = elem;
                index++;
            }
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = helperarr[i];
        }
        return arr;
    }

    public TempSummaryStatistics summaryStatistics() {
        error_generator();
        final TempSummaryStatistics st = new TempSummaryStatistics(average(), deviation(), min(), max());
        return st;
    }

    public double addTemps(double... temps) {
        check_temperature_list(temps);
        error_generator();

        double sum = 0;

        for (double el : temps) {
            if (arrSize >= temperatureSeries.length) {
                resize();
            }
            temperatureSeries[arrSize] = el;
            arrSize += 1;
        }

        for (int i=0; i < arrSize; i++) {
            sum += temperatureSeries[i];
        }
        return sum;
    }

    public void resize(){
        int newLen = temperatureSeries.length * 2;
        double[] temp = temperatureSeries;
        this.temperatureSeries = new double[newLen];

        int i = 0;
        for (double elem : temp) {
            temperatureSeries[i] = elem;
            i++;
        }
    }

    public void error_generator(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void check_temperature_list(double[] arr){
        double min_temp = -273.0;
        for (double elem: arr) {
            if (elem < min_temp) {
                throw new InputMismatchException();
            }
        }
    }
}
