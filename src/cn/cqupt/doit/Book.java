package cn.cqupt.doit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Book implements Comparable {
    @Override
    public int compareTo(Object o) {
        return 0;
    }
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }
    /**/

    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("input several Book,in the end #");
        String temp=input.nextLine();
        String[] message;
        String name;
        double price;
        List<Book> list=new ArrayList<>();
        while (temp.charAt(0)!='#'){
            message = temp.split(",");
            name=message[0];
            price = Double.parseDouble(message[1]);
            Book book = new Book(name, price);
            temp=input.nextLine();
            list.add(book);

        }
        System.out.println("input a new Book:");
        temp=input.nextLine();
        message = temp.split(",");
        name=message[0];
        price = Double.parseDouble(message[1]);
        Book newbook=null;
        for (Book book : list) {
            if (book.getPrice()==price){
                newbook=book;
            }
        }
        System.out.println("new book:<"+name+">as same books");
        if (newbook!=null){
            System.out.println(newbook.getName()+","+newbook.getPrice());
        }


    }

}
