package characters;

public abstract class Character {

    private String name;
    private int currentHP;
    private int maxHP;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void doNothing(){
        System.out.println(this.name + " did nothing");
    }

    public void dealDamage(Character origin, Character target){
        if(origin instanceof Player){
            ((Player) origin).standardAttack(target);
        } else if(origin instanceof Skeleton) {
            ((Skeleton) origin).standardAttack(target);
        }
    }

}
