public class CoffeeShop {
  public static void main(String[] args) {
    
    System.out.println(Customer.YELLOW + Customer.bold + "Welcome to BeanBrew Coffee Shop" + Customer.reset + Customer.RESET);
    System.out.println();

    Customer customer1 = new Customer(Customer.GREEN + Customer.bold + "Joseph" + Customer.reset + Customer.RESET);
    customer1.setPoints(200);
    
    Customer customer2 = new Customer(Customer.GREEN + Customer.bold + "Peter" +  Customer.reset + Customer.RESET);
    
    Customer customer3 = new Customer();
    
    System.out.print("\n" + Customer.customers[1].getName() + Customer.GREEN + " purchased pastries and beverages." + Customer.RESET);
    customer2.addPoints(150);
    
    System.out.print("\n" + Customer.customers[1].getName() + Customer.GREEN +" ordered water." + Customer.RESET);
    customer2.addPoints(20);
    
    System.out.println();
    
    Customer.displayInfo();
    Customer.displayTotalCustomer();
    
    Customer.getAllowedRewardRedemption();
    
    System.out.println();

    customer1.redeemReward();
    customer2.redeemReward();
    customer3.redeemReward();
    
    System.out.println();
    
    Customer.displayInfo();
    Customer.displayTotalCustomer();
    
    System.out.println();
    
    Customer customer4 = new Customer(Customer.GREEN + Customer.bold + "Diane" + Customer.reset + Customer.RESET);
    
    System.out.print(Customer.customers[3].getName() + Customer.GREEN + " ordered hot beverage." + Customer.RESET);
    customer4.addPoints(50);
    
    System.out.println();
    Customer.displayInfo();
    Customer.displayTotalCustomer();
    
    System.out.println();
    Customer.getAllowedRewardRedemption();
  }
}
