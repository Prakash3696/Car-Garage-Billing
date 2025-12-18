import org.w3c.dom.ls.LSOutput;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GarageService {
    private Map<String, Customer> customersMap;

    private List<Service> availableService;

    public GarageService() {
        this.customersMap = new HashMap<>();
        this.availableService = new ArrayList<>();
        loadService();
    }

    public void loadService()
    {
        availableService.add(new Service("car wash",500));
        availableService.add(new Service("Oil change",700));
        availableService.add(new Service("Wheel Alignment",300));
        availableService.add(new Service("Tyre Replacement",3000));
        availableService.add(new Service("Puncture",50));
    }
    public void addCustomer(String name, String phone,  String carNumber, String model)
    {
        Car car = new Car(carNumber, model);
        Customer customer = new Customer(name,phone,car);
        customersMap.put(carNumber,customer);
        System.out.println("Customer added Succesfully");
    }
public void createInvoice(String carNumber)
{
    if(!customersMap.containsKey(carNumber))
    {
        System.out.println("No customer found with carNumber: "+carNumber);
        return;
    }
    Scanner sc =new Scanner (System.in);

        Customer customer = customersMap.get(carNumber);
        System.out.println("Available Services");
        Invoice invoice = new Invoice(customer);
        for(int i=0;i<availableService.size();i++)


    {
        System.out.println((i+1)+". $"+availableService.get(i).getName()
                +" - $"+availableService.get(i).getPrice());
    }
    while (true)
    {
        System.out.println("Enter service number to add or 0 to finish");
        int choice = sc.nextInt();
        if (choice==0) break;
        if(choice>0 && choice<availableService.size())
        {
            invoice.addService(availableService.get(choice-1));
            System.out.println("Service Done");
        }
        else
        {
            System.out.println("Invalid choice");
        }

    }
    invoice.printInvoice();
    
}
}
