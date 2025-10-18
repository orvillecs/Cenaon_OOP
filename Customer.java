public class Customer {
  private String name;
  private int points;
  int rewards;
  
  public static final String bold = "\033[1m";
  public static final String reset = "\033[0m";
  public static final String GREEN = "\u001B[38;5;10m";
  public static final String YELLOW = "\u001B[33m";
  public static final String RESET = "\u001B[0m";
  
  static Customer[] customers = new Customer[4];
  static int totalCustomer = 0;
  
  public void setPoints(int points) {
    this.points = points;
  }

  int getPoints() {
    return this.points;
  }

  public Customer(String name, int points) {
    this.name = name;
    this.points = points;
    customers[totalCustomer] = this;
    totalCustomer++;
  }

  public Customer(String name) {
    this.name = name;
    this.points = 0;
    customers[totalCustomer] = this;
    totalCustomer++;
  }

  public Customer() {
    this.name = "Unknown";
    this.points = 0;
    customers[totalCustomer] = this;
    totalCustomer++;
  }
  
  public String getName() {
    return this.name;
  }

  public void addPoints(int pointsEarned) {
    points += pointsEarned;
    System.out.println(" Earned " + GREEN + bold + pointsEarned + reset + RESET + " points. Total points: " + GREEN + bold + points + RESET + reset);
  }

  public void redeemReward() {
    if (points >= 150) {
      System.out.println(GREEN + "\nCongratulations " + name + GREEN + "! You redeemed a free drink." + RESET);
      points -= 150;
      rewards++;
      System.out.println(YELLOW + "Remaining points: " + bold + points + reset + RESET);
    } else {
      System.out.println(bold + "\n" + name + reset + " does not have enough points to redeem a drink.");
    }
  }
  
  static void getAllowedRewardRedemption() {
    System.out.println();
    for (int i = 0; i < totalCustomer; i++) {
      Customer c = customers[i];
      int rewards = c.points / 150;
      System.out.println(GREEN + bold + c.name + reset + " can redeem " + GREEN + bold + rewards + reset + RESET + " reward(s)"  + RESET);
    }
  }
  
  static void displayTotalCustomer() {
      System.out.println(YELLOW + "Total Registered Customer: " + bold + totalCustomer + reset + RESET);
    }

  static void displayInfo() {
    System.out.println(YELLOW + "\n——— " + bold + "Customer Information" + reset + YELLOW + " ———" + RESET);
    for (int i = 0; i < totalCustomer; i++) {
      System.out.println(GREEN + "Name: " + bold +  customers[i].name + reset + RESET);
      System.out.println(GREEN + "Points: " + bold + customers[i].points + reset + RESET);
      System.out.println("————————————————————————————");
    }
  }
}
