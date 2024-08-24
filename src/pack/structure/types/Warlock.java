package pack.structure.types;

import pack.structure.specialties.Mage;

public final class Warlock extends Mage {
    public Warlock(String name, int hp, int maxAttack, int mana) {
        super(name, hp, maxAttack, mana);
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Warlock";
    }

    //з шансом 33% може знизити отримуваний дамаг вполовину якщо є хоча б 1 одиниця мани
    @Override
    public void takeDamage(int attack) {
        if(super.getMana() > 0 && random.nextInt(3) == random.nextInt(3)){
            attack /= 2;
            System.out.println(super.getName() + " blocked " + attack + " damage");
        }
        super.takeDamage(attack);
    }
}
