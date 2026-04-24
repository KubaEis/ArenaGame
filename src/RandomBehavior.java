import java.util.*;

public class RandomBehavior implements Behavior {
    Random rand = new Random();
    @Override
    public void act(NPC self, ArrayList<NPC> all) {
        int mode = rand.nextInt(1,5);
        switch (mode) {
            case 1:
                if (all.size() <= 1) return; // Není na koho útočit

                int targetIndex;
                do {
                    targetIndex = rand.nextInt(all.size());
                } while (all.get(targetIndex).equals(self));

                NPC target = all.get(targetIndex);
                int damage = rand.nextInt(3, 11);
                target.setHP(target.getHP() - damage);
                System.out.println(self.getName() + " (agresivní) ubral " + damage + " HP hráči " + target.getName());
                break;
            case 2:
                self.setHP(self.getHP() + 3);
                System.out.println(self.getName() + " se vylecil o 3 hp");
                break;
            case 3:
                System.out.println("Nic se nestalo.");
                break;
            case 4:
                if (all.size() > 1) {
                    int targetIndexB;
                    do {
                        targetIndexB = rand.nextInt(all.size());
                    } while (all.get(targetIndexB).equals(self));

                    int damageB = (mode == 4) ? rand.nextInt(3, 26) : rand.nextInt(3, 11);
                    all.get(targetIndexB).setHP(all.get(targetIndexB).getHP() - damageB);
                    System.out.println(self.getName() + " ubral " + damageB + " HP hráči " + all.get(targetIndexB).getName() + (mode == 4 ? " (KRITICKÝ ZÁSAH)" : ""));
                } else {
                    System.out.println(self.getName() + " nemá na koho útočit.");
                }
                break;
        }
    }

    public String  getName() {
        return "Nahodne chovani";
    }
}