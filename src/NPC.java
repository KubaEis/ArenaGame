import java.util.ArrayList;

public class NPC {
    private String name;
    private int hp;
    private int maxHP;
    private Behavior chovani;

    public NPC(String name, int hp, int maxHP, Behavior chovani) {
        this.name = name;
        this.hp = hp;
        this.maxHP = maxHP;
        this.chovani = chovani;
    }

    public String getName() { return name; }
    public int getHP() { return hp; }
    public void setHP(int hp) { this.hp = hp; }
    public int getMaxHP() { return maxHP; }
    public Behavior getChovani() { return chovani; }
    public void setChovani(Behavior chovani) { this.chovani = chovani; }

    public void performAction(ArrayList<NPC> npcs) {
        chovani.act(this, npcs);
    }

    public void printInfo() {
        System.out.println("NPC: " + name + " | HP: " + hp + "/" + maxHP + " | Chování: " + chovani.getName());
    }
}