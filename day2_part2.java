// ADVENT OF CODE 2023 DAY 2 PART 2
// https://adventofcode.com/2023/day/2#part2

import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2_part2 {
  public static void main(String[] args) {
    // list of drawn colors for each game
    ArrayList<Integer> reds = new ArrayList<>();
    ArrayList<Integer> blues = new ArrayList<>();
    ArrayList<Integer> greens = new ArrayList<>();
    int sum = 0; // track the sum of "powers"
    try {
      // set the input so that it reads ./day2-input.txt as the input (file omitted from repo), instead of the command prompt
      File file = new File("./day2-input.txt");
      Scanner scanner = new Scanner(file);
      // for each game
      while (scanner.hasNextLine()) {
        // clear the lists
        blues.clear();
        reds.clear();
        greens.clear();
        String line = scanner.nextLine();
        String gameName = line.split(":")[0];
        String gameResult = line.split(":")[1];

        int gameID = Integer.parseInt(gameName.substring(5));
        List<String> gameRounds = Arrays.asList(gameResult.split(";"));

        // for each round
        for (String round : gameRounds) {
          List<String> draws = Arrays.asList(round.split(", "));

          // for each draw
          for (String draw : draws) {
            draw = draw.strip();
            int drawNumber = Integer.parseInt(draw.split(" ")[0]);
            String drawColor = draw.split(" ")[1];
            if (drawColor.equals("red")) {
              reds.add(drawNumber);
            }
            if (drawColor.equals("green")) {
              greens.add(drawNumber);
            }
            if (drawColor.equals("blue")) {
              blues.add(drawNumber);
            }
          }
        }
        int maxBlue = Collections.max(blues);
        int maxRed = Collections.max(reds);
        int maxGreen = Collections.max(greens);
        sum += (maxBlue*maxRed*maxGreen);
      }
      scanner.close();
      System.out.println(sum);
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }
}
