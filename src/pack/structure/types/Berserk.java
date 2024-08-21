package pack.structure.types;

import pack.structure.specialties.Warrior;

public class Berserk extends Warrior {
    private boolean rage;

    {
        rage = false;
    }

    public Berserk(String name, int hp, int maxAttack, int armor, boolean rage) {
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
            str += "(Is on Rage)";
        }
        return str;
    }

    @Override
    public void takeDamage(int attack) {
        super.takeDamage(attack);
        if(super.getArmor() == 0){
            setRage(true);
        }
    }
}
