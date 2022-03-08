package edu.eci.cvds.Servlet.model;

import java.util.ArrayList;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ApplicationScoped;
import java.util.*;

@ManagedBean(name = "calculadoraBean")
@ApplicationScoped
public class BackingBean {
    public ArrayList<Float> datos=new ArrayList <Float>();
    public float media;
    public float moda;
    public float desvEst;
    public float varianza;

    public BackingBean(){}

    public float calculateMean(ArrayList<Float>datos){
        float sumatoria=0;
        for (int i=0;i<datos.size();i++){
            sumatoria+=datos.get(i);
        }
        media=sumatoria/datos.size();
        return media;
    }
    public float calculateStandardDeviation(ArrayList<Float>datos){
        desvEst=(float)Math.sqrt(getVarianza());
        return desvEst;
    }
    public float  calculateVariance(ArrayList<Float>dato){
        float sumatoria=0;
        for (int i=0;i<datos.size();i++){
            sumatoria+=Math.pow(2,datos.get(i)-getMedia());
        }
        varianza=sumatoria/datos.size();
        return varianza;
    }

    public float[] getDato(){
        int n = datos.size();
        float [] vector= new float[n];
        for (int x=0;x<n;x++){ vector[x]=datos.get(x);}
        return vector;
    }

    public static float[] ordenarArray(float[] n) {
        float aux;
        for (int i = 0; i < n.length - 1; i++) {
            for (int x = i + 1; x < n.length; x++) {
                if (n[x] < n[i]) {
                    aux = n[i];
                    n[i] = n[x];
                    n[x] = aux;
                }
            }
        }
        return n;
    }

    public float calculateMode(ArrayList<Float>dato){
        moda=0;
        int conta=0;
        int mayor=0;
        float [] d=getDato();
        d= ordenarArray(d);
        for (int i=0;i<d.length;i++){
            if (i>0 && d[i-1]==d[i]){conta+=1;}
            if (i>0 && d[i-1]!=d[i]){conta=0;}
            if (conta>mayor){moda=d[i];}
        }
        return moda;
    }
    public void restart(){
        datos=new ArrayList<Float>();
        media=0;
        moda=0;
        desvEst=0;
        varianza=0;
    }

    public void setDatos(ArrayList<Float> datos) {
        this.datos = datos;
    }

    public float getMedia() {
        return media;
    }

    public void setMedia(float media) {
        this.media = media;
    }

    public float getModa() {
        return moda;
    }

    public void setModa(float moda) {
        this.moda = moda;
    }

    public float getDesvEst() {
        return desvEst;
    }

    public void setDesvEst(float desvEst) {
        this.desvEst = desvEst;
    }

    public float getVarianza() {
        return varianza;
    }

    public void setVarianza(float varianza) {
        this.varianza = varianza;
    }
}