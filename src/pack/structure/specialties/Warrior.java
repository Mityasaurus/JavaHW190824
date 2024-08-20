package pack.structure.specialties;

import pack.structure.base.Hero;

public class Warrior extends Hero {
    private int armor;

    public Warrior(int maxAttack) {
        super(maxAttack);
    }

    @Override
    public void takeDamage(int attack) {
        super.takeDamage(attack - armor);
    }
}
