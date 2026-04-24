import java.util.*;

public class PassiveBehavior implements Behavior {
    @Override
    public void act(NPC self, ArrayList<NPC> all) {
        if (self.getHP()+3 > self.getMaxHP()){
            self.setHP(self.getMaxHP());
            System.out.println(self.getName() + " vylecilvsechny svoje zivoty");
        }else{
            self.setHP(self.getHP() + 3);
            System.out.println(self.getName() + " se vylecil o 3 hp");
        }

    }


    public String  getName() {
        return "Pasivni chovani";
    }
}