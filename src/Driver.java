
import ladder.*;

import java.util.Scanner;

public class Driver {

  public static void main(String[] args) {
    if (args.length == 0)
      startInteractive();

    if (args.length != 3)
      printUsage();

    String flag = args[0];
    String arg1 = args[1];
    String arg2 = args[2];

    if (flag.equalsIgnoreCase("g"))
      generateLadder(arg1, Integer.parseInt(arg2));
    else if (flag.equalsIgnoreCase("d"))
      discoverLadder(arg1, arg2);
    else
      printUsage();
  }

  private static void startInteractive() {
    System.out.println("Interactive Mode");
    System.out.println();

    Scanner in = new Scanner(System.in);
    String input = "FOOBAR";

    while (!input.equalsIgnoreCase("q")) {
    // if the user types 'q' or 'Q', we exit

      // print the menu
      System.out.println();
      System.out.println("Please make a selection");
      System.out.println("    g - Generate ladder");
      System.out.println("    d - Discover ladder");
      System.out.println("    q - Quit");
      System.out.println();
      System.out.print(">> ");

      input = in.nextLine();
      if ("g".equalsIgnoreCase(input)) {
        // generate mode
        System.out.println("Please enter a start word");
        System.out.print(">> ");
        String start = in.nextLine();
        System.out.println("Please enter a search depth");
        System.out.print(">> ");
        int depth = in.nextInt();
        generateLadder(start, depth);
      } else if ("d".equalsIgnoreCase(input)) {
        // discover mode
        System.out.println("Please enter a start word");
        System.out.print(">> ");
        String start = in.nextLine();
        System.out.println("Please enter a target word");
        System.out.print(">> ");
        String end = in.nextLine();
        discoverLadder(start, end);
      }
    }

    in.close();
    System.exit(0);
  }

  private static void generateLadder(String start, int depth) {
    System.out.println("Generating Ladder");
    System.out.println();

    Generator g = new Generator();
    Iterable<String> ladder = g.generateLadder(start, depth);
    for (String word : ladder)
      System.out.println(word);
  }

  private static void discoverLadder(String start, String end) {
    System.out.println("Discovering Ladder");
    System.out.println();

    Discoverer d = new Discoverer();
    Iterable<String> ladder = d.discoverLadder(start, end);
    for (String word : ladder)
      System.out.println(word);
  }

  private static void printUsage() {
    System.out.println("USAGE:");
    System.out.println("  java Driver g <word> <depth>");
    System.out.println("  java Driver d <word> <word>");
    System.exit(1);
  }

}
