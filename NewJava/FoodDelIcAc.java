public class FoodDelIcAc {
    class OrderDetails
    {
        void displayOrder()
        {
            System.out.println("\nRestaurant: Toit\nNo. of Items: 3\nItems:\n1. Farmhouse Pizza(9 in.) - 550.0\n2. Garlic Chicken - 325.0\n");
        }
    }
}
    
    interface Status
   {
    void preparing();
    void ontheway();
    void almostatdoor();
    void delivered();
   }
class FoodDelMain
{
   public static void main(String args[])
   {
    FoodDelIcAc obj=new FoodDelIcAc();
    FoodDelIcAc.OrderDetails orderDetl=obj.new OrderDetails();
    orderDetl.displayOrder();

    Status status=new Status()
    {
        public void preparing()
        {
            System.out.println("Order is being prepared.");
        }
        public void ontheway()
        {
            System.out.println("Order is on the way.");
        }
        public void almostatdoor()
        {
            System.out.println("Order is almost at the door.");
        }
        public void delivered()
        {
            System.out.println("Order has been delivered.");
        }
    };
    status.preparing();
    status.ontheway();
    status.almostatdoor();
    status.delivered();
   }
    
}
