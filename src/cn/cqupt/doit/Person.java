package cn.cqupt.doit;

public class Person implements Comparable<Person>{
    private  String  name;
    private  float  height,  weight;

    public Person(String name, float height, float weight) {
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
        System.out.println();
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }
    int method(Person o){
        int flag;
        if ((weight+height)/2<(o.getHeight()+o.getWeight())/2){
            flag=-1;
        }
        else {
            flag=1;
        }

        return flag;

    }

    @Override
    public String toString() {
        return "Person[" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ']';
    }
}
