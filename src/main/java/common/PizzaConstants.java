package common;



public class PizzaConstants
{
  public interface Pizza
  {
    public static final String PIZZA_SMALL = "Small";
    public static final String PIZZA_MEDIUM = "Medium";
    public static final String PIZZA_LARGE = "Large";
    public static final String PIZZA_STATUS_ACTIVE = "Active";
    public static final String PIZZA_STATUS_INACTIVE = "InActive";
    
  }
  
  public interface UserRole
  {
    public static final String ROLE_BPO = "Bpo";
    public static final String ROLE_CONSUMER= "Consumer";
    public static final String ROLE_ADMIN = "Admin";
    
  }
  public interface DeliveryChoice
  {
    public static final String HOME_DELIVERY = "Home Delivery";
    public static final String PICK_UP= "Pick Up";
    
  }
  
  public interface Order
  {
    public static final String STATUS_COMPLETED = "Completed";
    public static final String STATUS_PLACED= "Placed";
    
  }
}
