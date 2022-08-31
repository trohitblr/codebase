package designPattern;

public class Factory {

    public static void main(String [] args){

        ComputerFactory cf = new ComputerFactoryImpl();
        cf.getComputer("PC","2 GB","500 GB");
        cf.getComputer("Server","2 GB","1000 GB");
        cf.getComputer("Laptop","2 GB","500 GB");
    }
}
