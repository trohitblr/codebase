public class Builder {

    private String type;
    private String ram;
    private String HDD;
    private boolean blueTooth;
    private boolean Speaker;


    public String getType() {
        return type;
    }

    public String getRam() {
        return ram;
    }

    public String getHDD() {
        return HDD;
    }

    public boolean isBlueTooth() {
        return blueTooth;
    }

    public boolean isSpeaker() {
        return Speaker;
    }

    public Builder(ComputerBuilder builder){
        this.HDD=builder.HDD;
        this.ram= builder.ram;
        this.type= builder.type;
        this.blueTooth=builder.blueTooth;
        this.Speaker=builder.Speaker;
    }

    @Override
    public String toString() {
        return "Builder{" +
                "type='" + type + '\'' +
                ", ram='" + ram + '\'' +
                ", HDD='" + HDD + '\'' +
                ", blueTooth=" + blueTooth +
                ", Speaker=" + Speaker +
                '}';
    }


    public static class ComputerBuilder{
        private String type;
        private String ram;
        private String HDD;
        private boolean blueTooth;
        private boolean Speaker;


        public ComputerBuilder(String type, String ram, String HDD){
            this.HDD=HDD;
            this.ram= ram;
            this.type= type;
        }


        public ComputerBuilder setSpeaker(boolean blueTooth){
            this.blueTooth= blueTooth;
            return this;
        }

        public ComputerBuilder setBluetooth(boolean Speaker){
            this.Speaker= Speaker;
            return this;
        }

        public Builder build(){
            return new Builder(this);
        }

    }





    public static void main(String [] args){

        Builder bb =   new Builder.ComputerBuilder("PC","2 Gb","500 GB").setBluetooth(true).build();

        System.out.println(bb);
        System.out.println( bb.getHDD());


    }

}
