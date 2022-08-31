package designPattern;

public class Server implements Computer{

    private String type;
    private String ram;
    private String HDD;


    public Server(String type, String ram, String HDD){
        this.HDD=HDD;
        this.ram= ram;
        this.type= type;
    }

    @Override
    public void getCOmputer() {
        System.out.println("Current System is :- "+type+ "-"+"ram:- "+ram+ "HDD - "+HDD );
    }
}
