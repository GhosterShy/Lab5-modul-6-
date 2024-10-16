
class  Computer{
    public  String CPU;
    public  String RAM;
    public  String Storage;
    public  String OS;
    public  String CoolingType;


    @Override
    public String toString() {
        return "Computer{" +
                "CPU='" + CPU + '\'' +
                ", RAM='" + RAM + '\'' +
                ", CoolingType='" + CoolingType + '\''+
                ", Storage='" + Storage + '\'' +
                ", OS='" + OS + '\'' +
                '}';
    }

    public void setCoolingType(String coolingType) {
        CoolingType = coolingType;
    }

    public String getCoolingType() {
        return CoolingType;
    }

    public String getCPU() {
        return CPU;
    }

    public String getRAM() {
        return RAM;
    }

    public String getStorage() {
        return Storage;
    }

    public String getOS() {
        return OS;
    }


    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public void setRAM(String RAM) {
        this.RAM = RAM;
    }

    public void setStorage(String storage) {
        Storage = storage;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }


}

interface  IComputerBuilder
{
    void  SetCPU();
    void  SetRAM();
    void  SetStorage();
    void  SetGPU();
    void SetOS();
    void  SetCoolingtype();


    Computer GetComputer();
}




class OfficeComputer implements IComputerBuilder
{
    private Computer _computer = new Computer();

    @Override
    public void SetCPU() {
        _computer.CPU = "Intel i3";
    }

    @Override
    public void SetRAM() {
        _computer.RAM = "8GB";
    }

    @Override
    public void SetStorage() {
        _computer.Storage = "1TB";
    }

    @Override
    public void SetGPU() {
    }

    @Override
    public void SetOS() {
        _computer.OS = "Windows 10";
    }

    @Override
    public void SetCoolingtype() {
        _computer.CoolingType = "WaterCooling";
    }

    @Override
    public Computer GetComputer() {
        return _computer;
    }
}


class  GamingComputerBuilder implements IComputerBuilder
{
    private  Computer _computer = new Computer();

    @Override
    public void SetCPU() {
        _computer.CPU = "Intel i9";
    }

    @Override
    public void SetRAM() {
        _computer.RAM = "32GB";
    }

    @Override
    public void SetStorage() {
        _computer.Storage = "1TB SSD";
    }

    @Override
    public void SetGPU() {

    }

    @Override
    public void SetOS() {
        _computer.OS = "Windows 11Pro";
    }

    @Override
    public void SetCoolingtype() {

    }

    @Override
    public Computer GetComputer() {
        return _computer;
    }
}

class ServerComputer implements IComputerBuilder
{
    private Computer _computer = new Computer();

    @Override
    public void SetCPU() {
        _computer.CPU = "Intel XEON";
    }

    @Override
    public void SetRAM() {
        _computer.RAM = "64GB";
    }

    @Override
    public void SetStorage() {
        _computer.Storage = "1TB";

    }

    @Override
    public void SetGPU() {

    }

    @Override
    public void SetOS() {
        _computer.OS = "Linux";
    }

    @Override
    public void SetCoolingtype() {
        _computer.CoolingType = "Cooler";
    }

    @Override
    public Computer GetComputer() {
        return _computer;
    }
}



class ComputerDirector
{
    private  IComputerBuilder _builder;

    public ComputerDirector(IComputerBuilder builder)
    {
        this._builder = builder;
    }

    public void  ConstructComputer()
    {
        _builder.SetCPU();
        _builder.SetRAM();
        _builder.SetStorage();
        _builder.SetOS();
        _builder.SetCoolingtype();;
    }

    public Computer GetComputer()
    {
        return _builder.GetComputer();
    }
}




public class Main2 {
    public static void main(String[] args) {
        System.out.println("Office Computer:");
        IComputerBuilder OfficeBuilder = new OfficeComputer();
        ComputerDirector director = new ComputerDirector(OfficeBuilder);
        director.ConstructComputer();
        Computer officeComputer = director.GetComputer();
        System.out.println(officeComputer);


        System.out.println("Gaming Computer:");
        IComputerBuilder GamingBuilder = new GamingComputerBuilder();
        ComputerDirector director1 = new ComputerDirector(GamingBuilder);
        director1.ConstructComputer();
        Computer GamingComputer = director1.GetComputer();
        System.out.println(GamingComputer);


        System.out.println("Server Computer");
        IComputerBuilder ServerBuilder = new ServerComputer();
        ComputerDirector director2 = new ComputerDirector(ServerBuilder);
        director2.ConstructComputer();
        Computer ServerComputer = director2.GetComputer();
        System.out.println(ServerComputer);







    }
}


