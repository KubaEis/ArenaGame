import java.util.*;

public class AggressiveBehavior implements Behavior {
    Random rand = new Random();
    @Override
    public void act(NPC self, ArrayList<NPC> all) {
        int randomNPC = rand.nextInt(all.size());
        int damage = rand.nextInt(3,11);
        boolean jeSelf = true;
        while(jeSelf) {
            if (!all.get(randomNPC).equals(self)) {
                jeSelf = false;
                all.get(randomNPC).setHP(all.get(randomNPC).getHP() - damage);
                System.out.println(self.getName() + " ubral hraci " + all.get(randomNPC).getName() + " "+damage+" zivotu");
            }
        }
    }
    public String  getName() {
        return "Agresivni chovani";
    }
}