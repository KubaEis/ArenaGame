import java.security.spec.NamedParameterSpec;
import java.util.*;

public class NPC {
    private String name;
    private int hp;
    private int maxHP;
    private Behavior chovani;
    NPC(String name, int hp, int maxHP, Behavior chovani) {
        this.name = name;
        this.hp = 50;
        this.maxHP = 50;
        this.chovani = chovani;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHP() {
        return hp;
    }
    public void setHP(int hp) {
        this.hp = hp;
    }

    public void performAction(ArrayList<NPC> npcs){
        chovani.act(this,npcs);
    }


    /* ⭐ BONUS 4:
     metoda isAlive()
     vrací true/false */


    public void printInfo(){
        System.out.println("NPC name: " + this.name);
        System.out.println("HP: " + this.hp);
    }
}