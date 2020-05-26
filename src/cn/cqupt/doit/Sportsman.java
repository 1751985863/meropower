package cn.cqupt.doit;

public class Sportsman implements Comparable<Sportsman>{
    private  String  name;
    private  float  highJump,  longJump,  sideHorse;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHighJump() {
        return highJump;
    }

    public void setHighJump(float highJump) {
        this.highJump = highJump;
    }

    public float getLongJump() {
        return longJump;
    }

    public void setLongJump(float longJump) {
        this.longJump = longJump;
    }

    public float getSideHorse() {
        return sideHorse;
    }

    public void setSideHorse(float sideHorse) {
        this.sideHorse = sideHorse;
    }

    @Override
    public int compareTo(Sportsman o) {
        int flag;
        if(this.highJump*0.2+this.longJump*0.3+this.sideHorse*0.5>=o.highJump*0.2+o.longJump*0.3+o.sideHorse*0.5){
            flag=-1;
        }
        else {
            flag=1;
        }
        return flag;
    }

    public Sportsman(String name, float a, float b, float c) {
        this.name = name;
        this.highJump = a;
        this.longJump = b;
        this.sideHorse = c;
    }
    public  void  speak(){
        System.out.println("I am "+name+",my highJump "+highJump+",my longJump "+longJump+",my sideHorse "+sideHorse);

    }
    public  String  toString(){
        return "Sportsman [name="+name+",highJump="+highJump+",longJump="+longJump+",sideHorse="+sideHorse+"]";

    }
}
