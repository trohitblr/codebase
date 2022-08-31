package abstractFactory;

public class DriverClass {

public static void main(String [] args){

    ComputerFactory cf = new PCFactory("PC","2 GB","500 GB");

    new AbstractoryFactoryClass().buildComputer(cf);
}
}
