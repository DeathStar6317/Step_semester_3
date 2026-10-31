
public class Character {
    private int health;
    private final int maxHealth;

    public Character(int maxHealth) {
        if (maxHealth < 0) {
            this.maxHealth = 0;
        } else {
            this.maxHealth = maxHealth;
        }

        this.health = this.maxHealth;
    }

    public void takeDamage(int amount) {
        if (amount <= 0) {
            System.out.println("Damage must be positive");
            return;
        }

        health -= amount;

        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        if (amount <= 0) {
            System.out.println("Healing amount must be positive");
            return;
        }

        health += amount;

        if (health > maxHealth) {
            health = maxHealth;
        }
    }

    public int getHealth() {
        return health;
    }

    public static void main(String[] args) {
        Character c = new Character(100);

        c.takeDamage(30);
        System.out.println("Health: " + c.getHealth());

        c.heal(50);
        System.out.println("Health: " + c.getHealth());

        c.takeDamage(150);
        System.out.println("Health: " + c.getHealth());
    }
}
