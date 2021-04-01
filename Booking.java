// Creating a class of Booking 
public class Booking{
	
	// Attributes of the Booking Object 
    private String date;
    private String time;
    private String status;
	private AssistantOnShift assistantOnShift;
    private BookableRoom bookableRoom;
    private String email_account;
    
	// Booking object with the inputs assistant shift, book-able room and email 
    public Booking(AssistantOnShift assistant_shift, BookableRoom book_new_room, String add_email){
        this.date = book_new_room.getDate();
        this.time = book_new_room.getTime();
        // Automatically changed to "SCHEDULED
        this.status = "SCHEDULED";
    	this.assistantOnShift = assistant_shift;
        assistant_shift.busy();
        this.bookableRoom = book_new_room;
        book_new_room.increaseOccupancy();
        this.email_account = add_email;

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
    
    //  Get Email Account Method 
    public String getEmailAccount(){
        return this.email_account;
    }
    
    
    // Method to reduce occupancy by 1 and change status of Assistant Shift to 'Free' 
    public void removeBooking(){
        this.assistantOnShift.free();
        this.bookableRoom.reduceOccupancy();
    }
    
    
    // Method to increase occupancy by 1 and change status of Assistant Shift to 'Busy' 
    public void addBooking() {
    	this.assistantOnShift.busy();
    	this.bookableRoom.increaseOccupancy();
    }

    // Method to Conclude the booking
    public void conclude(){
        this.status = "COMPLETED";
    }
    
	// Format in the Structure of the Display 
    @Override
    public String toString() {
        return " | " + this.date + " " + this.time + " | " + this.status + " | " + this.assistantOnShift.getAssistantEmail() + " | " + this.bookableRoom.getRoomCode() + " | " + this.email_account + " | ";
    }
}