package pack.structure.types;

import pack.structure.specialties.Archer;

//ельф має на 30% більше стріл
public final class Elf extends Archer {
    public Elf(String name, int hp, int maxAttack, int arrows) {
        super(name, hp, maxAttack, arrows);
        super.setArrows((int) (arrows * 1.33));
    }

    @Override
    public String toString() {
        return super.toString() + "\nType: Elf";
    }

    //якщо стріла наносить мінімальний або максимальний дамаг, вона не витрачається
    @Override
    public int attack() {
        int attack = super.attack();
        if(attack == super.getMaxAttack() * 2 || attack == 0){
            super.setArrows(super.getArrows() + 1);
            System.out.println(super.getName() + " got an arrow back");
        }
        return attack;
    }
}
