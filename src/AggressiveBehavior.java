import java.util.ArrayList;
import java.util.Random;

public class AggressiveBehavior implements Behavior {
    private Random rand = new Random();

    @Override
    public void act(NPC self, ArrayList<NPC> all) {
        if (all.size() <= 1) return; // Není na koho útočit

        int targetIndex;
        do {
            targetIndex = rand.nextInt(all.size());
        } while (all.get(targetIndex).equals(self));

        NPC target = all.get(targetIndex);
        int damage = rand.nextInt(3, 11);
        target.setHP(target.getHP() - damage);
        System.out.println(self.getName() + " (agresivní) ubral " + damage + " HP hráči " + target.getName());
    }

    @Override
    public String getName() { return "Agresivní"; }
}