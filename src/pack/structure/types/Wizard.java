package pack.structure.types;

import pack.structure.specialties.Mage;

public final class Wizard extends Mage {
    public Wizard(String name, int hp, int maxAttack, int mana) {
        super(name, hp, maxAttack, mana);
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Wizard";
    }

    //з шансом приблизно 15% може нанести максимальний дамаг + мана у 2-кратному розмірі
    @Override
    public int attack() {
        int attack = super.attack();
        if(super.getMana() > 0 && random.nextInt(7) == random.nextInt(7)){
            attack = super.getMaxAttack() + super.getMana();
        }
        return attack;
    }
}
