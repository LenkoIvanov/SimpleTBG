public class Companion extends Player{

    Companion(String name){
        this.name = name;
        this.level = 0;
        this.health = 100;
    }

    public void npcAttack (int input, String name){
        if (input == 1) {
            level = level + 1;
            System.out.println(name + " has vanquished an enemy!");
        } else if (input == 0) {
            System.out.println(name + " has been defeated!");
            health -= 30;
            if (health <= 0) {
                System.out.println(name + " HAS DIED");
            }
        }
    }

    @Override
    public void Eat(int input) {
        if(input == 1){
            health = health + 10;
            System.out.println("Companion regains health.");
        }
        else if(input == 0){
            health = health - 10;
            System.out.println("Companion loses health.");
            if(health <= 0){
                System.out.println("COMPANION IS DEAD");
            }
        }
    }

    @Override
    public void Run(){
        System.out.println("Companion runs away.");
    }

    public void npcStats(String name){
        System.out.println("Companion " + name + ": ");
        System.out.println("Health: " + health);
        System.out.println("Level: " + level);
    }

}


