package com.negociosrdom.calculadorafinanciera;

public class Financiera {
    private double i;
    private double interes;
    private double p;
    private double s;
    private double t;
    private double dr; //Descuento Racional o Matematico
    private double pd; //valor presente / valor efectivo o liquido
    private double db; //Descuento Simple / Bancario
    private int YearFecha1;
    private int MesFecha1;
    private int DiaFecha1;
    private int YearFecha2;
    private int MesFecha2;
    private int DiaFecha2;
    private int dias;


    public int getYearFecha1() {
        return YearFecha1;
    }

    public void setYearFecha1(int yearFecha1) {
        YearFecha1 = yearFecha1;
    }

    public int getMesFecha1() {
        return MesFecha1;
    }

    public void setMesFecha1(int mesFecha1) {
        MesFecha1 = mesFecha1;
    }

    public int getDiaFecha1() {
        return DiaFecha1;
    }

    public void setDiaFecha1(int diaFecha1) {
        DiaFecha1 = diaFecha1;
    }

    public int getYearFecha2() {
        return YearFecha2;
    }

    public void setYearFecha2(int yearFecha2) {
        YearFecha2 = yearFecha2;
    }

    public int getMesFecha2() {
        return MesFecha2;
    }

    public void setMesFecha2(int mesFecha2) {
        MesFecha2 = mesFecha2;
    }

    public int getDiaFecha2() {
        return DiaFecha2;
    }

    public void setDiaFecha2(int diaFecha2) {
        DiaFecha2 = diaFecha2;
    }

    public void setI(double i) {
        this.i = i;
    }
    public void setInteres(double interes){this.interes = interes;}
    public void setP(double p) {this.p = p;}
    public void setS(double s) {
        this.s = s;
    }
    public void setT(double t) {
        this.t = t;
    }
    public void setDr(double dr_){dr = dr_;}
    public void setPd(double pd_){pd = pd_;}
    public void setDb(double db_){db = db_;}

    public double getI() {
        return i;
    }
    public double getP() {
        return p;
    }
    public double getS() {
        return s;
    }
    public double getT() {
        return t;
    }
    public double getInteres(){
        return interes;
    }
    public double getDr(){ return dr;}
    public double getPd() { return pd; }
    public double getDb() { return db; }

    public int getDias(){return dias;}

    public void calInteresSimple(){interes = p * i * t;}
    public void calCapital(){ p = interes / (i*t);}
    public void calTasa(){i = interes/(p*t);}
    public void calTiempo(){t = interes/(p*i);}
    public void calMonto(){s = p * (1+i*t);}

    public void calDescuentoRacional(){dr = (s*i*t) / (1+i*t);}
    public void calValorLiquidoDr(){pd = s/(1+i*t);}
    public void calMontoDr(){s = pd*(1+i*t);}
    public void calTiempoDr(){t = (s/(pd-1)) / i;}
    public void calTasaDr(){i = (s/(pd-1)) / t;}

    //descuento simple / bancario
    //db = S*i*t;  db = s - pd;
    //pd = S(1-it); pd = S - db;
    //s = db / (i*t);
    //t = db / (s*i);
    //i = D / (S*t);
    public void calDescuentoBancario(){db = s*i*t;}
    public void calValorLiquidoDescuentoBancario(){pd = s*(1-(i*t));}
    public void calMontoDescuentoBancario(){s = db / (i*t);}
    public void calTiempoDescuentoBancario(){t = db / (s*i);}
    public void calTasaDescuentoBancario(){i = db / (s*t);}

    public void calcularFecha()
    {
        dias = (Math.abs(YearFecha1 - YearFecha2)* 360)
                + (Math.abs(MesFecha1 - MesFecha2) * 30)
                + Math.abs(DiaFecha1 - DiaFecha2);
    }
}