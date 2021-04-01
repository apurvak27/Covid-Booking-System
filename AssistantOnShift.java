//Creating a class of Assistants on Shift
public class AssistantOnShift{
	
	// Attributes of the Assistant on Shift Object 
    private String date;
    private String time;
    private String status;
    private Assistant assistant;
    
    // Assistant on Shift  Object with inputs of Assistant, Date and Booking System 
    public AssistantOnShift(Assistant add_assistant, String enter_date, BookingSystem book_system){
        this.assistant = add_assistant;
        this.date = enter_date;
        this.status = "FREE";
        AssistantOnShift assistantshift1 = new AssistantOnShift(add_assistant, enter_date, "07:00");
        book_system.addAssistantShift(assistantshift1);
        AssistantOnShift assistantshift2 = new AssistantOnShift(add_assistant, enter_date, "08:00");
        book_system.addAssistantShift(assistantshift2);
        AssistantOnShift assistantshift3 = new AssistantOnShift(add_assistant, enter_date, "09:00");
        book_system.addAssistantShift(assistantshift3);
    }
    
    //Assistant on Shift Object with inputs of Assistant, Date and Time 
    public AssistantOnShift(Assistant add_assistant, String enter_date, String add_time){
        this.assistant = add_assistant;
        this.date = enter_date;
        this.time = add_time;
        this.status = "FREE";
    }
    
    // Get Date Method 
    public String getAssistantShiftDate(){
        return this.date;
    }
    
    // Get Time Method 
    public String getAssistantShiftTime(){
        return this.time;
    }
    
    //Get Status Method 
    public String getStatus(){
        return this.status;
    }
    
    //Get Assistant Method 
    public Assistant getAssistant(){
        return this.assistant;
    }
    
    //Get Assistant Email Method 
    public String getAssistantEmail(){
        return this.assistant.getEmail();
    }
    
    // Method for Busy Assistant
    public void busy(){
        this.status = "BUSY";
    }
    
    // Method for Free Assistant 
    public void free(){
        this.status = "FREE";
    }
    
	// Format in the Structure of the Display 
    @Override
    public String toString() {
        return " | " + this.date + " " + this.time + " | " + this.status + " | " + this.assistant.getEmail() + " | ";
    }
}