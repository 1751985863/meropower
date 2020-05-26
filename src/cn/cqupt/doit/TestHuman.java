package cn.cqupt.doit;

public class TestHuman {
    public static void main(String[] args) {
        Man  m  =  new  Man();
        m.setName("Dave");
        m.setAge(28);
        m.setSex("man");
        m.getInfo();
        m.speak();
        m.run();

        Human  h  =  new  Woman();
        h.setName("Jude");
        h.setAge(58);
        h.setSex("woman");
        h.getInfo();
        h.speak();
        h.run();
    }
}
class  Woman extends Human{
    @Override
    public void speak() {
        System.out.println("I am a woman.");
    }

    @Override
    public void run() {
        System.out.println("I am a beautiful woman.");

    }
}
class  Man extends Human{
    @Override
    public void speak() {
        System.out.println("I am a man.");
    }

    @Override
    public void run() {
        System.out.println("I am a strong man.");
    }
}
class Human{
    private  String  name;
    private  int  age;
    private  String  sex;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public  void  speak()  {
        System.out.println("I  am  a  human.");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
    public  void  run()  {
        System.out.println("I  can  run.");
    }
    public  void  getInfo()  {
        System.out.println("my name is:"  +  getName());
        System.out.println("my age is:"  +  getAge());
        System.out.println("my sex is:"  +  getSex());
    }
}