package prototype;

public class PrototypePattern implements Cloneable {


    private String type;
    private String ram;
    private String HDD;

    public PrototypePattern(String type, String ram, String HDD){
        this.HDD=HDD;
        this.ram= ram;
        this.type= type;
    }


    @Override
    public Object clone() throws CloneNotSupportedException{
        return new PrototypePattern( this.HDD,this.ram,this.type);
    }


}
