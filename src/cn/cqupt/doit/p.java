package cn.cqupt.doit;

public class p {
    public static void main(String[] args) {
        Outer.Inner2 obj=new Outer.Inner2();
    }
}
class Outer{public class Inner1{ }public static class Inner2{ }}
