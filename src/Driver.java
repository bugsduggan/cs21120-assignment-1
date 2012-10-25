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

    System.exit(0);
  }

  private static void generateLadder(String start, int depth) {
    System.out.println("Generating Ladder");

    System.exit(0);
  }

  private static void discoverLadder(String start, String end) {
    System.out.println("Discovering Ladder");

    System.exit(0);
  }

  private static void printUsage() {
    System.out.println("USAGE:");
    System.out.println("  java Driver g <word> <depth>");
    System.out.println("  java Driver d <word> <word>");
    System.exit(1);
  }

}
