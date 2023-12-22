import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class day2_part1 {
  public static void main(String[] args) {
    try {
      File file = new File("./day2-input.txt");
      Scanner scanner = new Scanner(file);
      int sum = 0;
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String gameName = line.split(":")[0];
        String gameResult = line.split(":")[1];

        int gameID = Integer.parseInt(gameName.substring(5));
        int numberOfBlues = 0;
        int numberOfReds = 0;
        int numberOfGreens = 0;

        List<String> gameRounds = Arrays.asList(gameResult.split(";"));
        for (String round : gameRounds) {
          System.out.println("Round:" + gameID);
          List<String> draws = Arrays.asList(round.split(", "));
          int index = 1;
          for (String draw : draws) {
            System.out.println("\t Draw" + index);
            index++;
            draw = draw.strip();
            int drawNumber = Integer.parseInt(draw.split(" ")[0]);
            String drawColor = draw.split(" ")[1];
            switch (drawColor) {
              case "red":
                numberOfReds = drawNumber;
                break;
              case "blue":
                numberOfBlues = drawNumber;
                break;
              case "green":
                numberOfGreens = drawNumber;
                break;
            }
            System.out.println("green: " + numberOfGreens + " red: " + numberOfReds + " blue: " +numberOfBlues);
            if (numberOfReds > 12 || numberOfGreens > 13 || numberOfBlues > 14) {
              System.out.println("=== invalid gameid: " + gameID);
              break;
            } else {
              sum += drawNumber;
              break;
            }
          }
        }
      }
      System.out.println(sum);
      scanner.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }
}
