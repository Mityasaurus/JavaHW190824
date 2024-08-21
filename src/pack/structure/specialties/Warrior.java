package pack.structure.specialties;

import pack.structure.base.Hero;

public class Warrior extends Hero {
    private int armor;

    public Warrior(String name, int hp, int maxAttack, int armor) {
        super(name, hp, maxAttack);
        this.armor = armor;
    }

    public int getArmor() {
        return armor;
    }

    public void setArmor(int armor) {
        this.armor = Math.max(armor, 0);
    }

    @Override
    public String toString() {
        return super.toString() + "\nClass: Warrior";
    }

    @Override
    public void takeDamage(int attack) {
        super.takeDamage(attack - armor);
        setArmor(armor - 1);
    }
}
