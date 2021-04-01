//import scanner 
import java.util.Scanner;

// Main Method to call entire Application 
public class BookingApp{
    public static void main(String[] args) {
    	
    	// Initializing new Resources 
    	UniversityResources resources = new UniversityResources();
        
        //Adding the starting assistants
        Assistant a1 = new Assistant("Alice Dean", "alicedean@uok.ac.uk");
        Assistant a2 = new Assistant("Kathryn Tomlins", "kathryntomlins@uok.ac.uk");
        Assistant a3 = new Assistant("Ellie Lovell", "ellielovell@uok.ac.uk");
        resources.addAssistant(a1);
        resources.addAssistant(a2);
        resources.addAssistant(a3);
        
        //Adding the initial 3 rooms
        Room r1 = new Room("HA110",10);
        Room r2 = new Room("BG625",3);
        Room r3 = new Room("MO217",4);
        resources.addRoom(r1);
        resources.addRoom(r2);
        resources.addRoom(r3);
        
        //Initializing the Booking System object
        BookingSystem bookingsystem = new BookingSystem();
        
        //Initializing the Book-able rooms
        BookableRoom br1 = new BookableRoom(r1, "05/03/2021", "07:00");
        BookableRoom br2 = new BookableRoom(r1, "04/03/2021", "08:00");
        BookableRoom br3 = new BookableRoom(r1, "06/03/2021", "09:00");
        BookableRoom br4 = new BookableRoom(r2, "05/03/2021", "07:00");
        BookableRoom br5 = new BookableRoom(r2, "05/03/2021", "08:00");
        BookableRoom br6 = new BookableRoom(r2, "06/03/2021", "09:00");
        BookableRoom br7 = new BookableRoom(r3, "04/03/2021", "07:00");
        BookableRoom br8 = new BookableRoom(r3, "05/03/2021", "08:00");
        BookableRoom br9 = new BookableRoom(r3, "05/03/2021", "09:00");
        bookingsystem.addBookableRoom(br1);
        bookingsystem.addBookableRoom(br2);
        bookingsystem.addBookableRoom(br3);
        bookingsystem.addBookableRoom(br4);
        bookingsystem.addBookableRoom(br5);
        bookingsystem.addBookableRoom(br6);
        bookingsystem.addBookableRoom(br7);
        bookingsystem.addBookableRoom(br8);
        bookingsystem.addBookableRoom(br9);
        
        //Initializing the assistants on shift
        AssistantOnShift as1 = new AssistantOnShift(a1, "04/03/2021", bookingsystem);
        bookingsystem.addAssistantShift(as1);
        AssistantOnShift as2 = new AssistantOnShift(a1, "06/03/2021", bookingsystem);
        bookingsystem.addAssistantShift(as2);
        AssistantOnShift as3 = new AssistantOnShift(a2, "05/03/2021", bookingsystem);
        bookingsystem.addAssistantShift(as3);
        AssistantOnShift as4 = new AssistantOnShift(a3, "05/03/2021", bookingsystem);
        bookingsystem.addAssistantShift(as4);
        
        Booking booking1 = new Booking(as3, br2, "bethmaidment@uok.ac.uk");
        Booking booking2 = new Booking(as1, br1, "charlottezanelli@uok.ac.uk");
        bookingsystem.NewBooking(booking1);
        bookingsystem.NewBooking(booking2);
        booking2.conclude();
        
        show_messageMain(bookingsystem, resources);
        
    }
    
    //Calling the Main Method
    public static void show_messageMain(BookingSystem book_system, UniversityResources resources_){
        try (
		Scanner user_input = new Scanner(System.in)) {
			String show_messageScreen = "\nUniversity of Knowledge - COVID test\n\nManage Bookings\n\nPlease, enter the number to select your option:\n\nTo manage Bookable Rooms:\n\t1. List\n\t2. Add\n\t3. Remove\nTo manage Assistants on Shift:\n\t4. List\n\t5. Add\n\t6. Remove\nTo manage Bookings:\n\t7. List\n\t8. Add\n\t9. Remove\n\t10. Conclude\nAfter selecting one the options above, you will be presented other screens.\nIf you press 0, you will be able to return to this main menu.\nPress -1 (or ctrl+c) to quit this application.\n";
			
			boolean exit = true;
			
			while (exit == true){
			    System.out.println(show_messageScreen);
			    //User Selects Option
			    String next_input = user_input.nextLine();

			    if (next_input.equals("-1")){
			        exit = false;
			    } else if (next_input.equals("1")){ //1: List of Book-able Rooms
			        exit = book_system.listBookableRooms();
			    } else if (next_input.equals("2")){ //2: Add a Book-able Room
			        exit = book_system.addBookableRooms(resources_);
			    } else if (next_input.equals("3")){ //3: Remove a Bookable Room
			        exit = book_system.removeBookableRooms();
			    } else if (next_input.equals("4")){ //4: List Assistants 
			        exit = book_system.listAssistantsOnShift();    
			    } else if (next_input.equals("5")){ //5: Add Assistants on Shift
			        exit = book_system.addAssistantsOnShift(resources_, book_system);    
			    } else if (next_input.equals("6")){//6: Remove Assistants on Shift 
			        exit = book_system.removeAssistantOnShift();    
			    } else if (next_input.equals("7")){ //7: List Bookings 
			        exit = book_system.listBookings();
			    } else if (next_input.equals("8")){ //8: Add Bookings 
			        exit = book_system.addBooking(0);
			    } else if (next_input.equals("9")){ //9: Remove Bookings 
			        exit = book_system.removeBooking();
			    } else if (next_input.equals("10")){ //10: Conclude 
			        exit = book_system.concludeBooking();
			    }
			}
		}
    }
}