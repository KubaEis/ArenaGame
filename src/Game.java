import java.util.*;

public class Game {

    Scanner sc = new Scanner(System.in);
    ArrayList<NPC> npcs = new ArrayList<>();

    public void start() {
        RandomBehavior r = new RandomBehavior();
        AggressiveBehavior ag = new AggressiveBehavior();
        PassiveBehavior p = new PassiveBehavior();
        NPC npc1 = new NPC("franta",50,50,r);
        NPC npc2 = new NPC("Stepan",60,50,ag);
        NPC npc3 = new NPC("Honza",40,50,p);
        npcs.add(npc1);
        npcs.add(npc2);
        npcs.add(npc3);

        int choice;

        do {
            System.out.println("1 - další kolo");

            System.out.println("2 - vypiš NPC");

            // ⭐ BONUS 6:odkomentuj
            //System.out.println("3 - změň chování NPC");

            System.out.println("4 - konec");

            System.out.println("volba:");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                for(int i=0;i<npcs.size();i++){
                    npcs.get(i).performAction(npcs);
                }

                for(int i=0;i<npcs.size();i++){
                    if (npcs.get(i).getHP() < 1){
                        npcs.remove(i);
                    }
                }


                // ⭐ BONUS 7:
                // pokud zbyde 1 NPC → vypiš vítěze
            }

            // ⭐ BONUS 5:
            if (choice == 2) {
                for(int i=0;i<npcs.size();i++){
                    npcs.get(i).printInfo();

                }
            }

            // ⭐ BONUS 6:
            if (choice == 3) {
                // TODO vyber NPC (index)
                // TODO změň behavior
            }

        } while (choice != 4);
        System.out.println("Hra skončila.");
    }
}