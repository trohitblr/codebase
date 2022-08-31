package abstractFactory;

public class PCFactory implements ComputerFactory{

    private String type;
    private String ram;
    private String HDD;

    public PCFactory(String type, String ram, String HDD){
        this.HDD=HDD;
        this.ram= ram;
        this.type= type;
    }

        @Override
        public void getComputer() {
            Computer com =   new PC( type,  ram,  HDD);
            com.getCOmputer();
        }

}

