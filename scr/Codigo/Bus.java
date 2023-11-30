package Codigo;

public abstract class Bus {
    int id;
    public Bus(int id){
        this.id = id;
    }
    public int getid(){
        return id;
    }
    public abstract String tipoBus();
}
