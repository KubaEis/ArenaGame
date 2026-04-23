import java.util.*;

public interface Behavior {
    void act(NPC self, ArrayList<NPC> all);

    String getName();
}