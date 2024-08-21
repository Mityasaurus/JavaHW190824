package pack.structure.types;

import pack.structure.specialties.Archer;

public final class Hunter extends Archer {
    public Hunter(String name, int hp, int maxAttack, int arrows) {
        super(name, hp, maxAttack, arrows);
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Hunter";
    }

    //з шансом приблизно 15% може випустити стрілу з подвійним дамагом
    @Override
    public int attack() {
        int attack = super.attack();
        if(super.getArrows() > 0 && random.nextInt(7) == random.nextInt(7)){
            attack *= 2;
        }
        return attack;
    }
}
