package pack.structure.base;

import java.util.Random;

public class Hero {
    protected static final Random  random = new Random();

    private String name;
    private int hp;
    private int maxAttack;
    private boolean alive;

    {
        alive = true;
    }

    public Hero(String name, int hp, int maxAttack) {
        this.name = name;
        this.hp = hp;
        this.maxAttack = maxAttack;
    }

    public final String getName() {
        return name;
    }

    public final void setName(String name) {
        this.name = name;
    }

    public final int getHp() {
        return hp;
    }

    public final void setHp(int hp) {
        if(this.hp == 0){
            return;
        }

        this.hp = Math.max(hp, 0);

        if(this.hp == 0){
            alive = false;
        }
    }

    public final int getMaxAttack() {
        return maxAttack;
    }

    public final void setMaxAttack(int maxAttack) {
        this.maxAttack = maxAttack;
    }

    public final boolean isAlive() {
        return alive;
    }

    public final void setAlive(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        return name + ": { " + "hp: " + hp + "; Max attack: " + maxAttack + "; Alive: " + alive + " }";
    }

    public int attack(){
        return random.nextInt(maxAttack + 1);
    }

    public void takeDamage(int attack){
        setHp(this.hp - attack);
    }
}
