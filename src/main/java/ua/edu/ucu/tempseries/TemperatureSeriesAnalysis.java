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
        errorGenerator();

        double sum = 0.0;
        for (double elem : temperatureSeries) {
            sum += elem;
        }
        return sum/temperatureSeries.length;
    }

    public double deviation() {
        errorGenerator();

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
        errorGenerator();

        double min = Integer.MAX_VALUE;
        for (double temperatureSery : temperatureSeries) {
            if (temperatureSery < min) {
                min = temperatureSery;
            }
        }
        return min;
    }

    public double max() {
        errorGenerator();

        double max = Integer.MIN_VALUE;
        for (double temperatureSery : temperatureSeries) {
            if (temperatureSery > max) {
                max = temperatureSery;
            }
        }
        return max;
    }

    public double findTempClosestToZero() {
        errorGenerator();

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
        errorGenerator();

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
        errorGenerator();
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
        errorGenerator();
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
        errorGenerator();
        final TempSummaryStatistics ST =
                new TempSummaryStatistics(average(), deviation(), min(), max());
        return ST;
    }

    public double addTemps(double... temps) {
        checkTemperatureList(temps);
        errorGenerator();

        double sum = 0;

        for (double el : temps) {
            if (arrSize >= temperatureSeries.length) {
                resize();
            }
            temperatureSeries[arrSize] = el;
            arrSize += 1;
        }

        for (int i = 0; i < arrSize; i++) {
            sum += temperatureSeries[i];
        }
        return sum;
    }

    public void resize() {
        int newLen = temperatureSeries.length * 2;
        double[] temp = temperatureSeries;
        this.temperatureSeries = new double[newLen];

        int i = 0;
        for (double elem : temp) {
            temperatureSeries[i] = elem;
            i++;
        }
    }

    public void errorGenerator() {
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
    }

    public void checkTemperatureList(double[] arr) {
        final double MINTEMP = -273.0;

        for (double elem: arr) {
            if (elem < MINTEMP) {
                throw new InputMismatchException();
            }
        }
    }
}
