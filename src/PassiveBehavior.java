import java.util.*;

public class PassiveBehavior implements Behavior {
    @Override
    public void act(NPC self, ArrayList<NPC> all) {
        self.setHP(self.getHP() + 3);
        System.out.println(self.getName() + " se vylecil o 3 hp");
    }


    public String  getName() {
        return "Pasivni chovani";
    }


    // ⭐ BONUS 2B: omez max HP (např. 100)
}