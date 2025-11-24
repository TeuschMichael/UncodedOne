package characters;

public abstract class Character {

    private String name;

    public Character(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void move(){};

    public void skipTurn(){
        System.out.println( name + " did nothing");
    }

}
