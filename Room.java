// Creating a class for a Room 
public class Room{
	// Attributes of the Room Object 
    private String code;
    private int capacity;
    
    // Room Object with inputs of code and capacity 
    public Room(String enter_code, int enter_capacity){
    	// Ensure Code is not left empty 
        if (enter_code != null){
            code = enter_code;
            // Ensure the capacity is not 0
            if (enter_capacity > 0){
                capacity = enter_capacity;
            } else {
                System.out.println("The capacity of a room cannot be 0. ");
            }
        } else {
            System.out.println("Room code has not been entered, please enter it again");
        }
    }
    
    //Get Code Method 
    public String getCode(){
        return this.code;
    }
    
    //Get Capacity Method 
    public int getCapacity(){
        return this.capacity;
    }
    
	// Format in the Structure of the Display 
    @Override
    public String toString() {
        return " | " + this.code + " | capacity: " + this.capacity + " | ";
    }
}