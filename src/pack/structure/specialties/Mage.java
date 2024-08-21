package pack.structure.specialties;

import pack.structure.base.Hero;

public abstract class Mage extends Hero {
    private int mana;

    public Mage(String name, int hp, int maxAttack, int mana) {
        super(name, hp, maxAttack);
        this.mana = mana;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = Math.max(mana, 0);
    }

    @Override
    public String toString() {
        return super.toString() + "\nClass: Mage";
    }

    @Override
    public int attack() {
        int attack = super.attack() + mana;
        setMana(mana - 1);
        return attack;
    }
}
