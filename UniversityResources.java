// Import Array Lists 
import java.util.ArrayList;


//Creating a class of Resources 

public class UniversityResources{
	
	//Creating Array Lists to store the Rooms and Assistants 
	ArrayList<Room> rooms = new ArrayList<Room>();
    ArrayList<Assistant> assistants = new ArrayList<Assistant>();
    
    //Method to add Assistant to Array List
    public void addAssistant(Assistant add_assistant){
        assistants.add(add_assistant);
    }
    
    //Method to add Room to Array List 
    public void addRoom(Room add_room){
        rooms.add(add_room);
    }
    
    //Return new array of Assistants 
    public ArrayList<Assistant> getAssistants(){
        return this.assistants;
    }
    

    // Return new array of Rooms 
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }
    


    

    

}