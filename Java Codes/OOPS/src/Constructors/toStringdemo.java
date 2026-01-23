package Constructors;

class Student {
	String name;
	int age;

    Student (String name , int age){
        this.name=name;
        this.age=age;
    }
    // after using this the program will not give that weird code
    public String toString(){
        return "Name: "+name+" Age: "+age;
    }
}
public class toStringdemo {
    public static void main(String[] args) {
        Student student = new Student("Suvigya",2021489);
        System.out.println(student);// this will give hashcode  if u have not created the tostrig method in your class
        //
    }
}
