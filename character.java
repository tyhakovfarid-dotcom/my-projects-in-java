import java.util.Random;

//ебать нахуй оно работает бляха

public class character {
    Random random = new Random();
    public boolean is_blocking;
    public String name;
    public int hp;
    public int min_damage;
    public int max_damage;
    public int balance;
    public double mult_dam;
    public character(String name, int hp, int min_damage, int max_damage, int balance, double mult_dam) {
        this.name = name;
        this.hp = hp;
        this.min_damage = min_damage;
        this.max_damage = max_damage;
        this.balance = balance;
        this.mult_dam = mult_dam;
    }
    public String attack(character target, boolean is_blocking) {
        String mish = "";
        int base_dam = random.nextInt(max_damage - min_damage + 1)+min_damage;
        int damage = (int) (base_dam*mult_dam);
        if (is_blocking) {
            damage = (int) (damage*0.25);
            mish = target.name + " заблокировал 75 процентов урона";

        }
        target.hp -= damage;
        if (target.hp < 0) {
            target.hp = 0;
        }
        String kish = this.name + " бьет " + target.name + " на " + damage + " урона! У " + target.name + " осталось " + target.hp + " HP.";
        return kish + " " + mish;
    }
}
