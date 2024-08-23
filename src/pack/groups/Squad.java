package pack.groups;

import pack.structure.Types;
import pack.structure.base.Hero;
import pack.structure.types.*;

import java.util.Random;

public class Squad {
    private final Random random = new Random();

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
                case PALADIN -> new Paladin("Paladin", 110, 30, 20);
                case BERSERK -> new Berserk("Berserk", 130, 50, 13);
//                case WIZARD -> new Wizard("Wizard", 1, 2, 3);
//                case WARLOCK -> new Warlock("Warlock", 1, 2, 3);
//                case ELF -> new Elf("Elf", 1, 2, 3);
//                case HUNTER -> new Hunter("Hunter", 1, 2, 3);
                default -> throw new IllegalStateException("Unexpected value: " + type);
            };
        }
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
}
