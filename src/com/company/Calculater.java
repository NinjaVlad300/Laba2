package com.company;

import org.apache.commons.math3.distribution.TDistribution;
import org.apache.commons.math3.stat.StatUtils;
import org.apache.commons.math3.stat.correlation.Covariance;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Calculater {

    public LinkedHashMap<String, Double[]> lhm = new LinkedHashMap<>();

    private void geometric(ArrayList <double[]> arr) {
        Double[] geometric = new Double[3];
        for (int i = 0; i < 3; i++) {
            geometric[i] = StatUtils.geometricMean(arr.get(i));
        }
        lhm.put("Среднее геометрическое", geometric);
    }

    private void mean(ArrayList <double[]> arr) {
        Double[] mean = new Double[3];
        for (int i = 0; i < 3; i++) {
            mean[i] = StatUtils.mean(arr.get(i));
        }
        lhm.put("Среднее арифметическое", mean);
    }

    private void variance(ArrayList <double[]> arr) {
        Double[] variance = new Double[3];
        for (int i = 0; i < 3; i++) {
            variance[i] = Math.sqrt(StatUtils.variance(arr.get(i)));
        }
        lhm.put("Стандартное отклонение", variance);
    }

    private void ssize(ArrayList <double[]> arr) {
        Double[] samplesize = new Double[3];
        for (int i = 0; i < 3; i++) {
            samplesize[i] = StatUtils.max(arr.get(i)) - StatUtils.min(arr.get(i));
        }
        lhm.put("Размах выборки", samplesize);
    }

    private void covariance(ArrayList <double[]> arr) {
        Double[] covariance = new Double[3];
        covariance[0] = new Covariance().covariance(arr.get(0), arr.get(1));
        covariance[1] = new Covariance().covariance(arr.get(0), arr.get(2));
        covariance[2] = new Covariance().covariance(arr.get(1), arr.get(2));
        lhm.put("Коэффициент ковариации", covariance);
    }

    private void size(ArrayList <double[]> arr) {
        Double[] size = new Double[3];
        for (int i = 0; i < 3; i++) {
            size[i] = (double) arr.get(i).length;
        }
        lhm.put("Количество элементов", size);
    }

    private void variation(ArrayList <double[]> arr) {
        Double[] variation = new Double[3];
        for (int i = 0; i < 3; i++) {
            variation[i] = Math.sqrt(StatUtils.variance(arr.get(i))) / Math.abs(StatUtils.mean(arr.get(i)));
        }
        lhm.put("Коэффициент вариации", variation);
    }

    private void intervalpl(ArrayList <double[]> arr) {
        Double[] intervalpl = new Double[3];
        for (int i = 0; i < 3; i++) {
            intervalpl[i] = StatUtils.mean(arr.get(i)) + (new TDistribution(arr.get(i).length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr.get(i)))) / Math.sqrt(arr.get(i).length);
        }
        lhm.put("+Доверительный интервал", intervalpl);
    }

    private void intervalm(ArrayList <double[]> arr) {
        Double[] intervalm = new Double[3];
        for (int i = 0; i < 3; i++) {
            intervalm[i] = StatUtils.mean(arr.get(i)) - (new TDistribution(arr.get(i).length - 1).inverseCumulativeProbability(0.95) * Math.sqrt(StatUtils.variance(arr.get(i)))) / Math.sqrt(arr.get(i).length);
        }
        lhm.put("-Доверительный интервал",intervalm);
    }

    private void dispersion(ArrayList <double[]> arr) {
        Double[] dispersion = new Double[3];
        for (int i = 0; i < 3; i++) {
            dispersion[i] = StatUtils.variance(arr.get(i));
        }
        lhm.put("Оценка дисперсии", dispersion);
    }

    private void max(ArrayList <double[]> arr) {
        Double[] max = new Double[3];
        for (int i = 0; i < 3; i++) {
            max[i] = StatUtils.max(arr.get(i));
        }
        lhm.put("Макс", max);
    }

    private void min(ArrayList <double[]> arr) {
        Double[] min = new Double[3];
        for (int i = 0; i < 3; i++) {
            min[i] = StatUtils.min(arr.get(i));
        }
        lhm.put("Мин", min);
    }

    public void calculater(ArrayList <double[]> arr) {
        geometric(arr);
        mean(arr);
        variance(arr);
        ssize(arr);
        covariance(arr);
        size(arr);
        variation(arr);
        intervalpl(arr);
        intervalm(arr);
        dispersion(arr);
        max(arr);
        min(arr);
    }
    public LinkedHashMap<String, Double[]> lhm(){
        return this.lhm;
    }
}
