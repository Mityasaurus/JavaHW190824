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
        System.out.println("Squad 1:");
        System.out.print(s1.toShortInfo());
        System.out.println("Squad 2:");
        System.out.println(s2.toShortInfo());

        int step = 1;
        Hero h1, h2;

        while(s1.anyAlive() && s2.anyAlive()){
            System.out.println("Round: " + step);
            h1 = s1.getHero();
            h2 = s2.getHero();
            System.out.println("Fighting " + h1.toShortInfo() + " and " + h2.toShortInfo());
            System.out.println();
            //
            h2.takeDamage(h1.attack());
            //
            if(h2.isAlive() && h1.isAlive()){
                h1.takeDamage(h2.attack());
            }
            System.out.println();
            System.out.println("Heroes: " + h1.toShortInfo() + " and " + h2.toShortInfo());
            System.out.println("End of " + step + " round");
            System.out.println();
            System.out.println("-".repeat(50));
            System.out.println();
            //
            try{
                //1
                //Thread.sleep(1000);
                //2
                TimeUnit.SECONDS.sleep(1);
            } catch (Exception e){
                e.printStackTrace(System.err);
            }
            step++;
        }
        //WIN
        if(s1.anyAlive())
            System.out.println("1 Squad Won");
        else
            System.out.println("2 Squad Won");
        System.out.println();
        System.out.println("-".repeat(50));
        System.out.println("Squad 1:");
        System.out.print(s1.toShortInfo());
        System.out.println("Squad 2:");
        System.out.println(s2.toShortInfo());
    }
}
