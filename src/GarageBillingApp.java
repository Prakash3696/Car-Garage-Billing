import java.util.Scanner;

public class GarageBillingApp {
    public static void main(String[]args){
        GarageService garageService = new GarageService();
        Scanner sc= new Scanner(System.in);

        while(true)
        {
            System.out.println("---------Night Garage Service---------");
            System.out.println("1. addCustomer");
            System.out.println("2. Display services");
            System.out.println("3. Exit");
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                    System.out.println("Enter customer Name");
                    String name=sc.next();
                    System.out.println("Enter phone number");
                    String phone=sc.next();
                    System.out.println("Enter Car Number");
                    String carNum=sc.next();
                    System.out.println("Enter car Model");
                    String model=sc.next();
                    garageService.addCustomer(name,phone,carNum,model);
                    break;

                case 2:
                    System.out.println("enter car number");
                    String carNo=sc.next();
                    garageService.createInvoice(carNo);
                    break;

                case 3:
                    System.out.println("Exiting... Thank You!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
