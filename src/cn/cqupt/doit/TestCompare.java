package cn.cqupt.doit;

public class TestCompare {
}
class Student implements Comparable<Object>{
    private  String  name;
    private  float  height,  weight,  score;

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
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }
    public  void  speak()  {
        System.out.println("I am "+name+",my height "+height+",my weight "+weight+",my score "+score);
    }

    @Override
    public int compareTo(Object o) {
        Student s=(Student)o;


        int flag;
        if ((weight*0.3+height*0.2+score*0.5)<(s.getHeight()*0.2+s.getWeight()*0.3+s.getScore()*0.5)){
            flag=-1;
        }
        else {
            flag=1;
        }
        return flag;
    }

    public Student(String name, float height, float weight, float score) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student [name="+name+",height="+height+",weight="+weight+",score="+score+"]";
    }
}
