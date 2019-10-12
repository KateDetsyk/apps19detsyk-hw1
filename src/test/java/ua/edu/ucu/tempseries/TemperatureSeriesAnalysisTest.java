package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    private TemperatureSeriesAnalysis seriesAnalysisWithOneElem;
    private TemperatureSeriesAnalysis seriesAnalysisWithEmptyArr;
    private TemperatureSeriesAnalysis seriesAnalysis;

    @Before
    public void setUp() throws Exception {
        double[] temperatureSeriesWithOneElem = {-1.0};
        seriesAnalysisWithOneElem = new TemperatureSeriesAnalysis(temperatureSeriesWithOneElem);

        double[] temperatureSeriesWithEmptyArr = {};
        seriesAnalysisWithEmptyArr = new TemperatureSeriesAnalysis(temperatureSeriesWithEmptyArr);

        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
    }

    @Test
    public void testAverageWithOneElementArray() {
        double expResult = -1.0;

        double actualResult = seriesAnalysisWithOneElem.average();

        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        seriesAnalysisWithEmptyArr.average();
    }

    @Test
    public void testAverage() {
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);        
    }

    @Test
    public void testDeviationWithOneElementArray(){
        double expResult = 0.0;

        double actualResult = seriesAnalysisWithOneElem.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray(){
        seriesAnalysisWithEmptyArr.deviation();
    }

    @Test
    public void testDeviation(){
        double expResult = 3.7416573867739413;

        double actualResult = seriesAnalysis.deviation();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMinWithOneElementArray(){
        double expResult = -1.0;

        double actualResult = seriesAnalysisWithOneElem.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray(){
        seriesAnalysisWithEmptyArr.min();
    }

    @Test
    public void testMin(){
        double expResult = -5.0;

        double actualResult = seriesAnalysis.min();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testMaxWithOneElementArray(){
        double expResult = -1.0;

        double actualResult = seriesAnalysisWithOneElem.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray(){
        seriesAnalysisWithEmptyArr.max();
    }

    @Test
    public void testMax(){
        double expResult = 5.0;

        double actualResult = seriesAnalysis.max();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToZeroWithOneElementArray(){
        double expResult = -1.0;

        double actualResult = seriesAnalysisWithOneElem.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToZeroWithEmptyArray(){
        seriesAnalysisWithEmptyArr.findTempClosestToZero();
    }

    @Test
    public void testFindTempClosestToZero(){
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToZero();
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempClosestToValueWithOneElementArray(){
        double expResult = -1.0;

        double actualResult = seriesAnalysisWithOneElem.findTempClosestToValue(0.5);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempClosestToValueWithEmptyArray(){
        seriesAnalysisWithEmptyArr.findTempClosestToValue(0.5);
    }

    @Test
    public void testFindTempClosestToValue(){
        double expResult = 1.0;

        double actualResult = seriesAnalysis.findTempClosestToValue(0.5);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsLessThenWithOneElementArray(){
        double[] expResult = {-1.0};

        double[] actualResult = seriesAnalysisWithOneElem.findTempsLessThen(0.5);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsLessThenWithEmptyArray(){
        seriesAnalysisWithEmptyArr.findTempsLessThen(0.5);
    }

    @Test
    public void testFindTempsLessThen(){
        double[] expResult = {-5.0};

        double[] actualResult = seriesAnalysis.findTempsLessThen(0.5);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testFindTempsGreaterThenWithOneElementArray(){
        double[] expResult = {};

        double[] actualResult = seriesAnalysisWithOneElem.findTempsGreaterThen(0.5);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempsGreaterThenWithEmptyArray(){
        seriesAnalysisWithEmptyArr.findTempsGreaterThen(0.5);
    }

    @Test
    public void testFindTempsGreaterThen(){
        double[] expResult = {3.0, 1.0, 5.0};

        double[] actualResult = seriesAnalysis.findTempsGreaterThen(0.5);
        assertArrayEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testAddTempsWithOneElementArray(){
        double expResult = 1.0;

        double actualResult = seriesAnalysisWithOneElem.addTemps(2.0);
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddTempsWithEmptyArray(){
        seriesAnalysisWithEmptyArr.addTemps(0.5);
    }

    @Test(expected = InputMismatchException.class)
    public void testAddTempsTooLowVal(){
        seriesAnalysis.addTemps(-400.0);
    }

    @Test
    public void testAddTemps(){
        double expResult = 4.3;

        double actualResult = seriesAnalysis.addTemps(0.1, 0.2);
        assertEquals(expResult, actualResult, 0.00001);
    }
}
