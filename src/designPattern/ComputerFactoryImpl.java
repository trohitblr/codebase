package designPattern;

public class ComputerFactoryImpl implements ComputerFactory{
    @Override
    public void getComputer(String type, String ram, String HDD) {

        if(type.equals("PC")){
            Computer com =   new PC( type,  ram,  HDD);
            com.getCOmputer();
        }else if(type.equals("Server")){
            Computer com =   new Server( type,  ram,  HDD);
            com.getCOmputer();
        }else{
            System.out.println("No computer available for this type");
        }

    }
}
