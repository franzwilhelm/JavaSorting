import java.util.Scanner;

class Main {

  public static void main(String[] args) {
    int length = 50;
    try {
      length = Integer.parseInt(args[0]);
    } catch (Exception ignored) {}
    Sort s = new Sort(Sort.randomArray(length));

    if (args.length == 2) {
      switch (args[1]) {
        case "i":
          s.insertion();
          System.out.println(s.arrayLog());
          break;
        case "m":
          s.mergeSort();
          System.out.println(s.arrayLog());
          break;
        case "q":
          s.quickSort();
          System.out.println(s.arrayLog());
          break;
        default: System.out.println("Invalid 2nd argument");
      }
      System.exit(0);
    }

    while (true) {
      System.out.println(
      "Welcome! Please pick an option\n" +
      "[1] Generate new array\n" +
      "[2] Insertion sort\n" +
      "[3] Merge sort\n" +
      "[4] Quick sort\n" +
      "[5] Visual log\n" +
      "[6] Array log\n" +
      "[7] Quit\n"
      );
      Scanner sc = new Scanner(System.in);
      switch (sc.nextLine()) {
        case "1":
        System.out.println("Choose array length");
        try {
          length = Integer.parseInt(sc.nextLine());
          if (length > 1000) {
            System.out.println("Sorry, max length is 1000");
          } else {
            s.newSource(Sort.randomArray(length));
          }
        } catch (Exception ignored) {
          System.out.println("Invalid input");
        }
        break;
        case "2": insertionSort(s); break;
        case "3": mergeSort(s); break;
        case "4": quickSort(s); break;
        case "5": System.out.println(s.visualLog()); break;
        case "6": System.out.println(s.arrayLog()); break;
        case "7": System.exit(0);
      }
    }
  }

  static void insertionSort(Sort s) {
    System.out.println("___    __ __ _ ______ _        __ _  _ ___");
    System.out.println(" | |\\|(_ |_ |_) |  | / \\|\\|   (_ / \\|_) |");
    System.out.println("_|_| |__)|__| \\ | _|_\\_/| |   __)\\_/| \\ |\n");
    System.out.println("Starting ...");
    s.insertion();
    System.out.println(s + "\n" + Color.RESET);
    System.out.println("Done");
  }

  static void mergeSort(Sort s) {
    System.out.println(Color.BLUE + "  __  __ ___ ___  ___ ___   ___  ___  ___ _____ ");
    System.out.println(Color.RED  + " |  \\/  | __| _ \\/ __| __| / __|/ _ \\| _ \\_   _|");
    System.out.println(Color.BLUE + " | |\\/| | _||   / (_ | _|  \\__ \\ (_) |   / | |  ");
    System.out.println(Color.RED  + " |_|  |_|___|_|_\\\\___|___| |___/\\___/|_|_\\ |_|  \n");
    System.out.println("Starting ...");
    s.mergeSort();
    System.out.println(s + "\n" + Color.RESET);
    System.out.println("Done");
  }

  static void quickSort(Sort s) {
    System.out.println(Color.RED    + "               (               )   (        )   (            ");
    System.out.println(Color.YELLOW + "   (           )\\ )   (     ( /(   )\\ )  ( /(   )\\ )  *   )  ");
    System.out.println(Color.RED    + " ( )\\      (  (()/(   )\\    )\\()) (()/(  )\\()) (()/(\\` )  /(  ");
    System.out.println(Color.YELLOW + " )((_)     )\\  /(_))(((_) |((_)\\   /(_))((_)\\   /(_))( )(_)) ");
    System.out.println(Color.RED    + "((_)_   _ ((_)(_))  )\\___ |_ ((_) (_))    ((_) (_)) (_(_())  " + Color.RESET);
    System.out.println(" / _ \\ | | | ||_ _|((/ __|| |/ /  / __|  / _ \\ | _ \\|_   _|  ");
    System.out.println("| (_) || |_| | | |  | (__   ' <   \\__ \\ | (_) ||   /  | |    ");
    System.out.println(" \\__\\_\\ \\___/ |___|  \\___| _|\\_\\  |___/  \\___/ |_|_\\  |_|    \n");
    System.out.println("Starting ...");
    s.quickSort();
    System.out.println(s + "\n" + Color.RESET);
    System.out.println("Done");
  }
}
