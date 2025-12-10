package characters;

public abstract class Character {

    private String name;

    public Character(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void doNothing(){
        System.out.println(this.name + " did nothing");
    }

}
