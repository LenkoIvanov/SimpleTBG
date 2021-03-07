public class Player  {
    protected String name;
    protected String playerClass;
    protected int health;
    protected int level;
    protected int lootCount;

        Player(){ // default constructor (added for successful inheritance)
        }

        Player(String name, String playerClass) {   //constructor with parameters
            this.level = 0;
            this.health = 100;
            this.name = name;
            this.playerClass = playerClass;
            this.lootCount = 0;
        }

        public void DisplayBasicInfo (String name, String playerClass){
            System.out.println("Your name is " + name);
            System.out.println("Your class is " + playerClass);
        }
        public void DisplayAdvancedInfo ( int health, int level, int lootCount){
            System.out.println("Your health is " + health);
            System.out.println("Your level is " + level);
            System.out.println("The loot you've got numbers " + lootCount);
        }

        public void attackEnemy (int input){
            if (input == 1) {
                level = level + 1;
                lootCount = lootCount + 1;
                System.out.println("You have vanquished your enemy!");

            } else if (input == 0) {
                System.out.println("You have been defeated!");
                health -= 30;
                if (health <= 0) {
                    System.out.println("YOU DIED");
                    System.exit(0);
                }
            }
        }

        public void Sleep (int input){
            if (input == 1) {
                health = 100;
                System.out.println("Well rested bonus.");
            } else if (input == 0) {
                System.out.println("Nightmares. No bonuses.");
            }
        }

        public void Eat (int input){
            if (input == 1) {
                health += 10;
                System.out.println("The food satiates you.");
            } else if (input == 0) {
                health -= 10;
                System.out.println("Rotten food. Damage taken.");
                if (health <= 0) {
                    System.out.println("YOU DIED");
                    System.exit(0);
                }
            }
        }

        public void Run () {
            System.out.println("You flee the battle. Loot lost.");
            lootCount--;
            if (lootCount <= 0) {
                lootCount = 0;
                System.out.println("You don't have any loot.");
            }
        }
}
