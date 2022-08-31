package abstractFactory;

public class ServerFactory implements ComputerFactory {
    private String type;
    private String ram;
    private String HDD;

    public ServerFactory(String type, String ram, String HDD){
        this.HDD=HDD;
        this.ram= ram;
        this.type= type;
    }


    @Override
    public void getComputer() {
        Computer com =   new Server( type,  ram,  HDD);
        com.getCOmputer();
    }
}
