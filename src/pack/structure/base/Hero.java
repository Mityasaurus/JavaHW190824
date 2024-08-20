package pack.structure.base;

import java.util.Random;

public class Hero {
    private static final Random random;

    static {
        random = new Random();
    }

    private int maxAttack;
    private boolean alive;
    private int HP;

    {
        alive = true;
    }

    public Hero(int maxAttack) {
        setMaxAttack(maxAttack);
    }

    public int getMaxAttack() {
        return maxAttack;
    }
    public void setMaxAttack(int maxAttack) {
        if (maxAttack > 0) this.maxAttack = maxAttack;
    }

    public boolean isAlive() {
        return alive;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public int getHP() {
        return HP;
    }
    public void setHP(int HP) {
        if(this.HP == 0){
            return;
        }
       this.HP = Math.max(HP, 0);
        if(this.HP == 0){
            alive = false;
        }
    }

    public void takeDamage(int attack){
        setHP(this.HP - attack);
    }
}
