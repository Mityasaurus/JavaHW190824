package pack.structure.types;

import pack.structure.specialties.Warrior;

public final class Berserk extends Warrior {
    private boolean rage;

    {
        rage = false;
    }

    public Berserk(String name, int hp, int maxAttack, int armor) {
        super(name, hp, maxAttack, armor);
    }

    public boolean isRage() {
        return rage;
    }

    public void setRage(boolean rage) {
        this.rage = rage;
    }

    @Override
    public String toString() {
        String str = super.toString() + "\nType: Berserk";
        if(rage){
            str += "(On Rage)";
        }
        return str;
    }

    //коли повністю збивають армор впадає у рейдж
    //наступна атака нанесе максимальний дамаг у 3-кратному розмірі
    @Override
    public void takeDamage(int attack) {
        super.takeDamage(attack);
        if(super.getArmor() == 0){
            setRage(true);
            System.out.println(super.getName() + " went into rage");
        }
    }

    @Override
    public int attack() {
        int attack = super.attack();
        if(isRage()){
            setRage(false);
            attack = super.getMaxAttack() * 3;
            System.out.println(super.getName() + " attacked on rage");
        }
        return attack;
    }
}
