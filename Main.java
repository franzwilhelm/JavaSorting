class Main {
  public static void main(String[] args) {
    int length = 50;
    try {
      length = Integer.parseInt(args[0]);
    } catch (Exception ignored) {}
    Sort s = new Sort(Sort.randomArray(length));

    System.out.println("___    __ __ _ ______ _        __ _  _ ___");
    System.out.println(" | |\\|(_ |_ |_) |  | / \\|\\|   (_ / \\|_) |");
    System.out.println("_|_| |__)|__| \\ | _|_\\_/| |   __)\\_/| \\ |\n");
    s.insertion();
    System.out.println(s + "\n");

    System.out.println(Color.BLUE + "  __  __ ___ ___  ___ ___   ___  ___  ___ _____ ");
    System.out.println(Color.RED  + " |  \\/  | __| _ \\/ __| __| / __|/ _ \\| _ \\_   _|");
    System.out.println(Color.BLUE + " | |\\/| | _||   / (_ | _|  \\__ \\ (_) |   / | |  ");
    System.out.println(Color.RED  + " |_|  |_|___|_|_\\\\___|___| |___/\\___/|_|_\\ |_|  \n");
    s.mergeSort();
    System.out.println(s + "\n");

    System.out.println(Color.RED    + "               (               )   (        )   (            ");
    System.out.println(Color.YELLOW + "   (           )\\ )   (     ( /(   )\\ )  ( /(   )\\ )  *   )  ");
    System.out.println(Color.RED    + " ( )\\      (  (()/(   )\\    )\\()) (()/(  )\\()) (()/(\\` )  /(  ");
    System.out.println(Color.YELLOW + " )((_)     )\\  /(_))(((_) |((_)\\   /(_))((_)\\   /(_))( )(_)) ");
    System.out.println(Color.RED    + "((_)_   _ ((_)(_))  )\\___ |_ ((_) (_))    ((_) (_)) (_(_())  " + Color.RESET);
    System.out.println(" / _ \\ | | | ||_ _|((/ __|| |/ /  / __|  / _ \\ | _ \\|_   _|  ");
    System.out.println("| (_) || |_| | | |  | (__   ' <   \\__ \\ | (_) ||   /  | |    ");
    System.out.println(" \\__\\_\\ \\___/ |___|  \\___| _|\\_\\  |___/  \\___/ |_|_\\  |_|    \n");
    s.quickSort();
    System.out.println(s + "\n");
    if (length == 50) System.out.println("TIP: You can specify array length as an argument");
  }
}
