package Inheritance;

class Dad {
    int money = 1000;

    void eat() {
        System.out.println("Dad: Eating Salad 🥗");
    }
}

class Kid extends Dad {
    int money = 50;

    // We Override the eat method
    void eat() {
        System.out.println("Kid: Eating Pizza 🍕");

        // NOW, we use super to force the Parent's version to run
        super.eat();
    }

    void showMoney() {
        System.out.println("My Money: " + money);       // 50 (Child's)
        System.out.println("Dad's Money: " + super.money); // 1000 (Parent's)
    }
}

public class concept_Super {
    public static void main(String[] args) {
        Kid k = new Kid();
        k.eat();
        System.out.println("---");
        k.showMoney();
    }
}

/*
*super is a keyword
* it totally depends on u like how u see super as
* if u are using parenthesis() then super (i.e super()) will call the parent constructor
* if u are using dot .  then it will acess the methods and the variables of the parent class
* as shown in the example
*
* IMPORTANT
*SUPER IS ALSO USED WHEN THE PARENT IS USING PRIVATE VARIBALE
*THEN IT IS NOT ACCESSABLE BY MAKING THE CHILD CONSTRUCTOR
*THEREFORE WE HAVE TO USE SUPER INORDER
*TO USE PARENT CONSTRUCTOR
* */