import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2_part1 {
  public static void main(String[] args) {
    final int LIMIT_RED = 12;
    final int LIMIT_GREEN = 13;
    final int LIMIT_BLUE = 14;
    try {
      File file = new File("./day2-input.txt");
      Scanner scanner = new Scanner(file);
      int sum = 0;
      // for each game
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String gameName = line.split(":")[0];
        String gameResult = line.split(":")[1];

        int gameID = Integer.parseInt(gameName.substring(5));
        List<String> gameRounds = Arrays.asList(gameResult.split(";"));

        // for each round
        boolean isRoundValid = true;
        for (String round : gameRounds) {
          List<String> draws = Arrays.asList(round.split(", "));

          // for each draw
          for (String draw : draws) {
            draw = draw.strip();
            int drawNumber = Integer.parseInt(draw.split(" ")[0]);
            String drawColor = draw.split(" ")[1];
            if (drawColor.equals("red") && drawNumber > LIMIT_RED) {
              isRoundValid = false;
              break;
            }
            if (drawColor.equals("green") && drawNumber > LIMIT_GREEN) {
              isRoundValid = false;
              break;
            }
            if (drawColor.equals("blue") && drawNumber > LIMIT_BLUE) {
              isRoundValid = false;
              break;
            }
          }
        }
        if (isRoundValid) sum += gameID;
      }
      System.out.println(sum);
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }
}
