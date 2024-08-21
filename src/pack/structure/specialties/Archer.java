package pack.structure.specialties;

import pack.structure.base.Hero;

public class Archer extends Hero {
    private int arrows;

    public Archer(String name, int hp, int maxAttack, int arrows) {
        super(name, hp, maxAttack);
        this.arrows = arrows;
    }

    public int getArrows() {
        return arrows;
    }

    public void setArrows(int arrows) {
        this.arrows = Math.max(arrows, 0);
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Archer";
    }

    @Override
    public int attack() {
        if(arrows == 0) return 0;
        int attack = super.attack() * 2;
        setArrows(arrows - 1);
        return attack;
    }
}
