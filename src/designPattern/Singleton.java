package designPattern;

import java.io.Serializable;

public class Singleton implements Serializable {

    public static Singleton intance = null;

    private Singleton(){

    }


    protected Object readResolve(){
     return intance;
    }


    public static Singleton getInstance(){
        if(intance == null){
         synchronized (Singleton.class) {
             if(intance == null)
             intance = new Singleton();
         }
        }
        return intance;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }






}
