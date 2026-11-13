import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;

public class Main {

    Random random = new Random();
    Scanner scanner = new Scanner(System.in);
    ArrayList arrayList = new ArrayList<>();

    character player = new character("герой", 0, 25, 40, 10, 1.0);

    public character battle() {

        player.hp = random.nextInt(300 - 250 + 1) + 250;

        character monster = new character("монстр", 0, 20, 35, 0, 1.0);

        monster.hp = random.nextInt(300 - 200 + 1) + 200;

        while (true) {
            boolean player_blocked = false;
            System.out.println("""
                        выберите действие:
                        1. удар
                        2. блок
                    """);
            int action = 0;

            try {
                action = scanner.nextInt();
            }
            catch (java.util.InputMismatchException e) {
                System.out.println("Введи цифру, а не букву!");
                scanner.nextLine();
            }
            if (action == 1) {
                System.out.println(player.attack(monster, false));
                if (monster.hp <= 0) { System.out.println("Победа!"); break; }
            }
            else if (action == 2) {
                System.out.println("вы заблокировали удар");
                player_blocked = true;
            }
            else {
                System.out.println("вы замешкались и пропустили удар");
            }
            System.out.println(monster.attack(player, player_blocked));
            if (player.hp <= 0) { System.out.println("Смерть!"); break; }

        }
        return player;
    }

    public static void main(String[] args) {
        Main game = new Main();
        game.battle();
    }
}
