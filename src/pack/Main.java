package pack;

import pack.structure.types.Berserk;

public class Main {
    public static void main(String[] args) {
        //TEST
        Berserk berserk = new Berserk("Valera", 50, 10, 3);
        System.out.println(berserk);
        berserk.takeDamage(5);
        berserk.takeDamage(10);
        berserk.takeDamage(15);
        System.out.println(berserk);
        System.out.println(berserk.attack());
        System.out.println(berserk);
        //TEST
    }
}