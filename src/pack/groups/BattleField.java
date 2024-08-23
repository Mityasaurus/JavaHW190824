package pack.groups;

import pack.structure.base.Hero;

import java.util.concurrent.TimeUnit;

public class BattleField {
    private final Squad s1;
    private final Squad s2;

    public BattleField(int size) {
        s1 = new Squad(size);
        s2 = new Squad(size);
    }

    public void fight(){
        int step = 1;
        Hero h1, h2;

        while(s1.anyAlive() && s2.anyAlive()){
            System.out.println("Round: " + step++);
            h1 = s1.getHero();
            h2 = s2.getHero();
            //
            h2.takeDamage(h1.attack());
            System.out.println(h1);
            System.out.println();
            System.out.println(h2);
            System.out.println("-".repeat(20));
            //
            if(h2.isAlive() && h1.isAlive()){
                h1.takeDamage(h2.attack());
                System.out.println(h1);
                System.out.println();
                System.out.println(h2);
                System.out.println("-".repeat(20));
            }
            System.out.println("\n");
            //
            try{
                //1
                //Thread.sleep(1000);
                //2
//                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e){
                e.printStackTrace(System.err);
            }
        }
        //WIN
        if(s1.anyAlive())
            System.out.println("1 Squad Won");
        else
            System.out.println("2 Squad Won");
    }
}
