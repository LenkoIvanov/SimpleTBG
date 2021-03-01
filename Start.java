import java.util.*;


public class Start {
public static final Scanner INPUT = new Scanner(System.in);
public static int ROLL;
    public static void main(String[] args){
        System.out.println("Welcome to Text Based Adventure Game V. 1.0!");

        System.out.println("Enter the name of your character: ");
        String name = INPUT.next();

        String playerClass = "";
        System.out.println("Choose a class: ");
        System.out.println("Barbarian \n" + "Knight \n" + "Assassin \n" + "Thief \n" + "Magician \n");
        int classNum = INPUT.nextInt();
        while(true) {
            if (classNum == 1) {
                playerClass = "Barbarian";
                break;
            } else if (classNum == 2) {
                playerClass = "Knight";
                break;
            } else if (classNum == 3) {
                playerClass = "Assassin";
                break;
            } else if (classNum == 4) {
                playerClass = "Thief";
                break;
            } else if (classNum == 5) {
                playerClass = "Magician";
                break;
            } else {
                System.out.println("Wrong input. Try again!");
                classNum = INPUT.nextInt();
            }
        }

        Player player1 = new Player(name, playerClass);

        System.out.println("Choose a basic action: ");
        System.out.println("1 - display basic info \n" + "2 - display advanced info \n");
        int basicActionAccess = INPUT.nextInt();

        while(true){
            if(basicActionAccess == 1){
                player1.DisplayBasicInfo(player1.name, player1.playerClass);
                break;
            }else if(basicActionAccess == 2){
                player1.DisplayAdvancedInfo(player1.health, player1.level, player1.lootCount);
                break;
            }else{
                System.out.println("Wrong input. Try again!");
                basicActionAccess = INPUT.nextInt();
            }
        }

        System.out.println("You embark on your first quest. While walking trough the woods, " +
                "you get ambushed by two thieves. " +
                "Slay them!");
        //int rollInput;

        for(int enemyCount = 2; enemyCount > 0;){
            System.out.println("0 or 1?");
            ROLL = INPUT.nextInt();
            player1.attackEnemy(ROLL);
            if(ROLL == 1){
                enemyCount--;
            }
        }

        System.out.println("The battle is over...");
        player1.DisplayAdvancedInfo(player1.health, player1.level, player1.lootCount);

        System.out.println("Now that your quest is over, you get to participate in various activities.");
        System.out.println("0 - Exit the quest loop \n" + "1 - Display basic stats \n" + "2 - Display advanced stats \n" +
                "3 - Attack \n" + "4 - Eat \n" + "5 - Sleep \n" + "6 - Run from battle \n");
        int  actionInput = INPUT.nextInt();

        while(true){
            if(actionInput == 0){
                System.out.println("You choose to rest from questing for a while.");
                break;
            }
            else if(actionInput == 1){
                player1.DisplayBasicInfo(player1.name, player1.playerClass);
            }
            else if(actionInput == 2){
                player1.DisplayAdvancedInfo(player1.health, player1.level, player1.lootCount);
            }
            else if(actionInput == 3){
                System.out.println("1 or 0?");
                ROLL = INPUT.nextInt();
                player1.attackEnemy(ROLL);
            }
            else if(actionInput == 4){
                System.out.println("1 or 0?");
                ROLL = INPUT.nextInt();
                player1.Eat(ROLL);
            }
            else if(actionInput == 5){
                System.out.println("1 or 0?");
                ROLL = INPUT.nextInt();
                player1.Sleep(ROLL);
            }
            else if(actionInput == 6){
                player1.Run();
            }
            else{
                System.out.println("Wrong input! Try again!");
                actionInput = INPUT.nextInt();
            }
            System.out.println("Next action?");
            actionInput = INPUT.nextInt();
        }

        System.out.println("After questing, you set your mind on finding a partner. " +
                "You visit the local tavern to find a suitable candidate.");
        System.out.println("You spot a rather interesting fellow." +
                "You walk over to them and ask them for their name.");
        String companionName = INPUT.next();
        System.out.println("You make them an offer that they cannot refuse " +
                "and you agree to become partners.");
        Companion npc1 = new Companion(companionName);

        System.out.println("On your first quest you enter a den of killers. " +
                "Slaughter as many as possible!");
        System.out.println("1 - Attack " + "2 - NPC Attack " +"3 - Run");
        actionInput = INPUT.nextInt();
        int enemyCount = 10;

        while(enemyCount > 0){
            if(actionInput == 1){
                ROLL = INPUT.nextInt();
                player1.attackEnemy(ROLL);
            }
            else if(actionInput == 2){
                ROLL = INPUT.nextInt();
                npc1.npcAttack(ROLL, companionName);
                if(npc1.health <= 0){
                    npc1 = null;  //object is deleted
                }
            }
            else if(actionInput == 3){
                player1.Run();
                if(npc1 != null) {
                    npc1.Run();
                }
                break;
            }
            enemyCount--;
            actionInput = INPUT.nextInt();
        }

        System.out.println("The battle is over.");
        if(npc1 != null){                       // check if object exists
            System.out.println("You and your companion feast after the battle.");
            ROLL = INPUT.nextInt();
            player1.Eat(ROLL);
            ROLL = INPUT.nextInt();
            npc1.Eat(ROLL);
            if(npc1.health <= 0){
                npc1 = null;
            }
        }
        else if(npc1 == null){
            System.out.println("You dine alone.");
            ROLL = INPUT.nextInt();
            player1.Eat(ROLL);
        }

        System.out.println("While exploring a forest near you town you stumble upon a locked chest." +
                "You break the lock and take a look inside.");
        System.out.println("You find the following items inside: an ornate sword, a bag of coins " +
                "a sturdy old metal shield, a new suit of armour and some gems.");
        System.out.println("You sort them in your bag.");
        String[] treasure = {"Sword", "Shield", "Coins", "Armour", "Gems"};

        for(int i = 0; i < treasure.length; i++){
            for(int j = i + 1; j < treasure.length; j++){
                if(treasure[j].compareTo(treasure[i]) < 0){
                    String temp = treasure[i];
                    treasure[i] = treasure[j];
                    treasure[j] = temp;
                }
            }
            }
        for(int i = 0; i < treasure.length; i++){
            System.out.println(treasure[i]);
        }

        System.out.println("After bringing the treasure back to the tavern, you decide to " +
                "take a break from adventuring.");
        System.out.println("THE END");
    }
}
