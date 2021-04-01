//Creating a class of Bookable Rooms 
public class BookableRoom{
	
	// Attributes of the Bookable Room Object 
    private String date;
    private String time;
    private String status;
	private Room room;
    private int occupancy;
    
    // Assistant Object with the inputs room, date and time 
    public BookableRoom(Room add_room, String enter_date, String add_time){
        this.date = enter_date;
        this.time = add_time;
        this.room = add_room;
        // Set the occupancy as 0 
        this.occupancy = 0;
        // Set the status as Empty 
        this.status = "EMPTY";
    }
    
    //Get Date Method
    public String getDate(){
        return this.date;
    }
    
    //Get Time Method
    public String getTime(){
        return this.time;
    }
    
    //Get Status Method
    public String getStatus(){
        return this.status;
    }
    
    //Get Room Method
    public Room getRoom(){
        return this.room;
    }
    
    //Get Room Code Method
    public String getRoomCode(){
        return this.room.getCode();
    }
    
    // Method to increase the occupancy of a room
    public void increaseOccupancy(){
    	// If occupancy is 0 the room is available automatically 
        if (this.occupancy == 0){
            this.status = "AVAILABLE";
        }
        // Check with the capacity after adding new person
        this.occupancy = this.occupancy + 1;
        if (this.occupancy == this.room.getCapacity()){
            this.status = "FULL";
        }
    }
    
    // Method to reduce the occupancy of a room 
    public void reduceOccupancy(){
    	// Subtract the person from the room 
        this.occupancy = this.occupancy - 1;
        if (this.occupancy == 0){
        	// If occupancy is 0 the room is empty 
            this.status = "EMPTY";
        } else  {
            this.status = "AVAILABLE";
        }
    }
    
    
	// Format in the Structure of the Display 
    @Override
    public String toString() {
        return " | " + this.date + " " + this.time + " | " + this.status + " | " + this.room.getCode() + " | occupancy: " + this.occupancy + " | ";
    }
}
