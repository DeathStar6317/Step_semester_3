package arrays.assignment_problems;

import java.util.Arrays;
import java.util.Scanner;

public class FantasyLeagueAutoDraftRankingEngine {
    static class Player implements Comparable<Player> {
        private String name;
        private int matchesPlayed;
        private double battingAverage;
        private boolean injured;

        public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
            this.name = name;
            this.matchesPlayed = matchesPlayed;
            this.battingAverage = battingAverage;
            this.injured = injured;
        }

        static boolean isDraftable(int matchesPlayed) {
            return matchesPlayed >= 10;
        }

        static boolean isDraftable(int matchesPlayed, boolean injured) {
            return matchesPlayed >= 5 && !injured;
        }

        double getFantasyPoints() {
            return battingAverage + matchesPlayed * 2;
        }

        @Override
        public int compareTo(Player other) {
            return Double.compare(other.getFantasyPoints(), this.getFantasyPoints());
        }

        String getName() {
            return name;
        }
    }

    static String draftAndRank(Player[] players) {
        Player[] draftable = new Player[players.length];
        int count = 0;

        for (Player player : players) {
            if (Player.isDraftable(player.matchesPlayed) ||
                Player.isDraftable(player.matchesPlayed, player.injured)) {
                draftable[count++] = player;
            }
        }

        Player[] result = Arrays.copyOf(draftable, count);

        Arrays.sort(result);

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < result.length; i++) {
            output.append(i + 1)
                  .append(". ")
                  .append(result[i].getName());

            if (i < result.length - 1) {
                output.append(" | ");
            }
        }

        return output.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of players: ");
        int n = sc.nextInt();
        sc.nextLine();

        Player[] players = new Player[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter player name: ");
            String name = sc.nextLine();

            System.out.print("Enter matches played: ");
            int matchesPlayed = sc.nextInt();

            System.out.print("Enter batting average: ");
            double battingAverage = sc.nextDouble();

            System.out.print("Is injured? (true/false): ");
            boolean injured = sc.nextBoolean();
            sc.nextLine();

            players[i] = new Player(name, matchesPlayed, battingAverage, injured);
        }

        System.out.println(draftAndRank(players));

        sc.close();
    }
}