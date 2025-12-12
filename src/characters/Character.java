package characters;


import java.util.Random;

public abstract class Character {

    private String name;
    private int baseDamage;
    private String standardAttack;
    private int currentHP;
    private int maxHP;

    Random random = new Random();

    protected Character(String name, int baseDamage, String standardAttack, int currentHP, int maxHP) {
        this.name = name;
        this.baseDamage = baseDamage;
        if(this instanceof Skeleton) baseDamage = damageGenerator();
        this.standardAttack = standardAttack;
        this.currentHP = currentHP;
        this.maxHP = maxHP;

    }

    //constructor for skeleton now sets damage once and should set dmg random every attack
    protected Character(String name, String standardAttack, int currentHP, int maxHP) {
        this.name = name;
        this.baseDamage = damageGenerator();
        this.standardAttack = standardAttack;
        this.currentHP =currentHP;
        this.maxHP = maxHP;
    }

    public String getName() {
        return name;
    }

    public int getCurrentHP(){
        return currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public void doNothing(){
        System.out.println(this.name + " did nothing");
    }

    public void heal(int hP){
        int actualhP = hP;

        if (currentHP + hP > maxHP) {
             actualhP = maxHP - currentHP;
            currentHP = maxHP;
        } else {
        currentHP += actualhP;
        }

        System.out.println(name + "healed for " + actualhP);
        System.out.println(name + " now has " + currentHP + "/" + maxHP);
    }

    public void dealDamage(Character origin, Character target, Party targetParty){
        System.out.println(origin.name + " used " + origin.standardAttack + " on " + target.name);
        System.out.println(origin.standardAttack + " dealt " + origin.baseDamage + " to " + target.name);
        target.currentHP -= origin.baseDamage;

        if (target.currentHP < 0) target.currentHP = 0;
        System.out.println(target.name + " is now at " + target.currentHP + "/" + target.maxHP + "HP.");

        healthCheck(target, targetParty);
    }

    public void healthCheck(Character c, Party p){
        if(c.getCurrentHP() == 0) {
            System.out.println(c.getName() + " has been defeated!!");
            p.getPartyMemberList().remove(c);
        }
    }

    public int damageGenerator(){
        return random.nextInt(2);
    }

}
