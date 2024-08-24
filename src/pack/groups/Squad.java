package pack.groups;

import pack.structure.Types;
import pack.structure.base.Hero;
import pack.structure.types.*;

import java.util.Random;

public class Squad {
    private final Random random = new Random();
    private static int squadsCounter = 1;

    private final Hero[] heroes;

    public Squad(int size) {
        heroes = new Hero[size];
        init();
    }

    private void init(){
        Types type;
        for (int i = 0; i < heroes.length; i++) {
            type = Types.values()[random.nextInt(Types.values().length)];
            heroes[i] = switch (type){
                case PALADIN -> new Paladin("Paladin " + squadsCounter, 120, 20, 12);
                case BERSERK -> new Berserk("Berserk " + squadsCounter, 140, 30, 7);
                case WIZARD -> new Wizard("Wizard " + squadsCounter, 110, 20, 20);
                case WARLOCK -> new Warlock("Warlock " + squadsCounter, 130, 30, 12);
                case ELF -> new Elf("Elf " + squadsCounter, 120, 20, 10);
                case HUNTER -> new Hunter("Hunter " + squadsCounter, 120, 30, 10);
                default -> throw new IllegalStateException("Unexpected value: " + type);
            };
        }
        squadsCounter++;
    }

    public boolean anyAlive(){
        for (Hero hero : heroes) {
            if(hero.isAlive()) return true;
        }

        return false;
    }

    public Hero getHero(){
        if(!anyAlive()){
            throw new RuntimeException("getHero: no any alive");
        }
        Hero hero;

        while(true) {
            hero = heroes[random.nextInt(heroes.length)];
            if (hero.isAlive()) {
                return hero;
            }
        }
    }

    public String toShortInfo(){
        StringBuilder sb = new StringBuilder();

        for (Hero hero : heroes) {
            sb.append(hero.toShortInfo()).append("\n");
        }

        return sb.toString();
    }
}
