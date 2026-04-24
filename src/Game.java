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


            System.out.println("3 - změň chování NPC");

            System.out.println("4 - konec");

            System.out.println("volba:");
            choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {

                for(int i=0;i<npcs.size();i++){
                    npcs.get(i).performAction(npcs);
                }

                npcs.removeIf(npc -> npc.getHP() <= 0);

                int pocet = 0;
                for(int i=0;i<npcs.size();i++){
                    pocet++;
                }
                if (pocet == 1){
                    System.out.println("Vyhral hrac: "+npcs.get(0).getName());
                }
            }
            if (choice == 2) {
                for(int i=0;i<npcs.size();i++){
                    npcs.get(i).printInfo();

                }
            }

            if (choice == 3) {
                // 1. Kontrola, jestli máme vůbec nějaká NPC
                if (npcs.isEmpty()) {
                    System.out.println("V seznamu nejsou žádná NPC, která by šla měnit.");
                } else {
                    System.out.println("Zadej index NPC (0 až " + (npcs.size() - 1) + "):");

                    int index = sc.nextInt();
                    sc.nextLine();

                    if (index >= 0 && index < npcs.size()) {
                        System.out.println("Měníš chování pro: " + npcs.get(index).getName());
                        System.out.println("1) Agresive behaviour");
                        System.out.println("2) Passive behaviour");
                        System.out.println("3) Random behaviour");
                        System.out.print("vyber:");

                        int behaviorChoice = sc.nextInt();
                        sc.nextLine();

                        switch (behaviorChoice) {
                            case 1:
                                npcs.get(index).setChovani(ag);
                                System.out.println("Chování změněno na agresivní.");
                                break;
                            case 2:
                                npcs.get(index).setChovani(p);
                                System.out.println("Chování změněno na pasivní.");
                                break;
                            case 3:
                                npcs.get(index).setChovani(r);
                                System.out.println("Chování změněno na náhodné.");
                                break;
                            default:
                                System.out.println("Neplatná volba chování.");
                                break;
                        }
                    } else {
                        System.out.println("Chyba: NPC s indexem " + index + " neexistuje!");
                    }
                }
            }

        } while (choice != 4);
        System.out.println("Hra skončila.");
    }
}