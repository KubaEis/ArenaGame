import java.util.*;

public class RandomBehavior implements Behavior {
    Random rand = new Random();
    @Override
    public void act(NPC self, ArrayList<NPC> all) {
        int mode = rand.nextInt(1,4);
        switch (mode) {
            case 1:
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
            case 2:
                self.setHP(self.getHP() + 3);
                System.out.println(self.getName() + " se vylecil o 3 hp");
            case 3:
                System.out.println("Nic se nestalo.");
        }
    }

    public String  getName() {
        return "Nahodne chovani";
    }


    // ⭐ BONUS 3: přidej 4. možnost (např. "silný útok")
}