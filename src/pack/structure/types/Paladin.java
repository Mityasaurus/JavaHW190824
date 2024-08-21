package pack.structure.types;

import pack.structure.specialties.Warrior;

public class Paladin extends Warrior {
    public Paladin(String name, int hp, int maxAttack, int armor) {
        super(name, hp, maxAttack, armor);
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Paladin";
    }

    //з шансом 10% може заблокувати весь дамаг якщо є хоча б 1 одиницю армору
    @Override
    public void takeDamage(int attack) {
        if(random.nextInt(10) == random.nextInt(10) && super.getArmor() > 0) {
            attack = super.getArmor();
        }

        super.takeDamage(attack);
    }
}
