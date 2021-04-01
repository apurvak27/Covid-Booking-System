//import Array List and Scanner 
import java.util.ArrayList;
import java.util.Scanner;


//Creating a class of the Booking System
public class BookingSystem{
	//Creating new arrays for Bookings, Book-able rooms and Assistants on shifts 
    ArrayList<Booking> bookings = new ArrayList<Booking>();
    
	ArrayList<BookableRoom> bookableRooms = new ArrayList<BookableRoom>();
	
    ArrayList<AssistantOnShift> assistantsOnShift = new ArrayList<AssistantOnShift>();
    
    // Booking System Object with the User Input 
	private Scanner user_input;
	
	//Method returning the list of Assistants 
    public ArrayList<AssistantOnShift> getAssistantsOnShift(){
        return assistantsOnShift;
    }
    
    //Method to Add Assistants on Shift to the Array 
    public void addAssistantShift(AssistantOnShift assistant_new_shift){
        assistantsOnShift.add(assistant_new_shift);
    }
    
    //Method to Add Book-able Rooms to the Array
    public void addBookableRoom(BookableRoom book_room){
        bookableRooms.add(book_room);
    }
    
    //Method to Add Booking to the Array 
    public void NewBooking(Booking add_booking){
        bookings.add(add_booking);
    }
    
    
    //Method to List Bookings 
    
    // Using a boolean to enables users to select options 
    public boolean listBookings(){
    	// Using the scanner to enable users to enter values
        user_input = new Scanner(System.in);
        
        String show_message = "\nUniversity of Knowledge - COVID test\n\nSelect which booking to list:\n1. All\n2. Only bookings status:SCHEDULED\n3. Only bookings status:COMPLETED\n0. Back to main menu.\n-1. Quit application.\n\n";
        System.out.println(show_message);
        String show_new_message;
        
        while (true){
            String next_input = user_input.nextLine();
           
            if (next_input.equals("-1")){
                return false;
                // exits from the main page 
                
            } else if (next_input.equals("0")){ 
                return true;
                // users are taken to the main menu
                
            } else if (next_input.equals("2")){ 
            	// If Users select 2 they are taken to the Book-able rooms and their capacity, which shows the scheduled rooms 
            	// Sequential ID begins at 11 
                int i = 11;
                show_new_message = "";
                // looping through the booking to pick out the Scheduled Bookings and adding to the System
                for (Booking add_booking : bookings){
                    if (add_booking.getStatus().equals("SCHEDULED")){
                        show_new_message = show_new_message + "\n\t" + i + ". " + add_booking;
                    }
                    i++;
                    }
                show_new_message = show_new_message + "\n0. Back to main menu.\n-1. Quit application.\n\n";
                System.out.println(show_new_message);
                // Makes the User Changes 
                
                while (true){
                    // Users input the next line 
                    String final_input = user_input.nextLine();
                    if (final_input.equals("-1")){
                        return false;
                        // exits from the main page 

                    } else if (final_input.equals("0")){ 
                        return true;
                        // users are taken to the main menu
                    }   
                }
            } else if (next_input.equals("3")){ 
            	// User Selects 3 they are taken to the list of empty rooms 
            	
            	// Sequential ID begins at 11 
                int i = 11;
                show_new_message = "";
                
                // looping through the booking to pick out the Empty Bookings and adding to the System
                for (Booking add_booking : bookings){
                    if (add_booking.getStatus().equals("COMPLETED")){
                        show_new_message = show_new_message + "\n\t" + i + ". " + add_booking;
                    }
                    i++;
                    }
                show_new_message = show_new_message + "\n0. Back to main menu.\n-1. Quit application.\n\n";
                System.out.println(show_new_message);
                // Makes the User Changes 

                
                while (true){
                    String final_input = user_input.nextLine();
                    // Users input the next line 

                    
                    if (final_input.equals("-1")){
                        return false;
                        // exits from the main page 

                    } else if (final_input.equals("0")){ //if they select 1 go to the bookable rooms list
                        return true;
                        // users are taken to the main menu

                    }   
                }
                
                // Invalid Number Inputs 
            } else { 
                show_new_message = "This option does not exist, please select a valid number" ;

                show_new_message = show_new_message + "\n0. Back to main menu.\n-1. Quit application.\n\n";
                System.out.println(show_new_message);
                while (true){
                    String final_input = user_input.nextLine();

                    if (final_input.equals("-1")){
                        return false;
                    } else if (final_input.equals("0")){ 
                        return true;
                    }   
                }
            }
        }
    }
    
    
    //Method to Add Bookings 
    
    public boolean addBooking(int fromMethod){
    	// Using the scanner to enable users to enter values
        Scanner user_input = new Scanner(System.in);
        // Open Method for String 
        String show_message = "";
        if (fromMethod == 0){
            show_message = show_message + "\nUniversity of Knowledge - COVID test\n\nAdding booking (appointment for a COVID test) to the system\n";
        }
        show_message = show_message + "\nList of available time-slots:";
        
        // Generating ID's with sequential lists 
        int i = 11;
        int j = 0;
        int []id = new int [bookableRooms.size()+11];
        boolean assistantAvailable = false;
        // Checking for a valid User Input 
        for (BookableRoom book_new_room : bookableRooms){
            assistantAvailable = false;
            for (AssistantOnShift assistantsonshift_ : assistantsOnShift){
                if (book_new_room.getDate().equals(assistantsonshift_.getAssistantShiftDate()) && book_new_room.getTime().equals(assistantsonshift_.getAssistantShiftTime()) && assistantsonshift_.getStatus().equals("FREE")){
                    assistantAvailable = true;
                    break;
                }
            }
            if ((book_new_room.getStatus().equals("AVAILABLE") || book_new_room.getStatus().equals("EMPTY")) && assistantAvailable == true){
                show_message = show_message + "\n\t" + i + ". " + book_new_room.getDate() + " " + book_new_room.getTime();
                id[i] = j;
                // Increment i 
                i++;
            }
            //Increment j 
            j++;
        }
        String msg = "\n\nPlease, enter one of the following:\n\nThe sequential ID of an available time-slot and the student email, separated by a white space.\n0. Back to main menu.\n-1. Quit application.\n\n";
        show_message = show_message + msg;
        System.out.println(show_message);
        
        while (true){
        	
        	//User Input 
        	String next_input = user_input.nextLine();
            int final_input;
            String entry = " ";
            String email_account = "";
            AssistantOnShift booking_assistant = null;
            
           // Checking for invalid User Inputs (Date, Time) 
            try {
                if (next_input.length() >= 2){
                    entry = next_input.substring(0,2);
                } else if (next_input.length() == 1){
                    entry = next_input.substring(0,1);
                }
                
                final_input = Integer.parseInt(entry);

                if (final_input == -1){
                    return false;
                } else if (final_input == 0){ 
                    return true;
                    
                } else if (final_input > 10 && final_input <= i){
                    try{
                        if (next_input.length() >= 12){
                            
                            boolean duplicate = false;
                            if (next_input.substring(2,3).equals(" ")){
                                email_account = next_input.substring(3);
                            } else if (next_input.substring(3,4).equals(" ")){
                                email_account = next_input.substring(4);
                            }
                            int room_ID = id[final_input];
                            
                            //Loop through the Bookings to find the Rooms 
                            for (Booking current_booking : bookings){
                                if (current_booking.getDate().equals(bookableRooms.get(room_ID).getDate()) && current_booking.getTime().equals(bookableRooms.get(room_ID).getTime()) && current_booking.getEmailAccount().equals(email_account)){// checking if the user inputs are a duplicate
                                    duplicate = true;
                                }
                            }
                            // Loop through the Assistants on Shift too find new Assistant 
                            for (AssistantOnShift add_new_assistant : assistantsOnShift){
                                if (bookableRooms.get(room_ID).getTime().equals(add_new_assistant.getAssistantShiftTime()) && bookableRooms.get(room_ID).getDate().equals(add_new_assistant.getAssistantShiftDate()) && add_new_assistant.getStatus().equals("FREE")){
                                    booking_assistant = add_new_assistant;
                                    break;
                                }
                            }
                            //Correct Conditions have been entered 
                            if (duplicate == false && email_account.substring(email_account.length()-10).equals("@uok.ac.uk")){
                                Booking add_booking = new Booking(booking_assistant, bookableRooms.get(room_ID), email_account);
                                bookings.add(add_booking);
                                System.out.println("\nBooking added successfully:");
                                System.out.println(add_booking);
                                return addBooking(1);
                                
                                //Incorrect Conditions 
                            } else {
                                //returning error if the user_input is a duplicate or the email is incorrect
                                System.out.println("ERROR!");
                                System.out.println("Invalid email format or this booking has already been created ");
                                System.out.println(msg);
                            }
                        } else {
                            //returning error if the length of date/hour isn't valid
                            System.out.println("ERROR!");
                            System.out.println("The length of input value is invalid");
                            System.out.println(msg);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("The format is incorrect");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("The format is incorrect");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    

    //Method to Remove Booking 
    
    public boolean removeBooking(){
    	// Using the scanner to enable users to enter values
        Scanner user_input = new Scanner(System.in);
        
        String show_message = "\nUniversity of Knowledge - COVID test\n";
        int i = 11;
        int j = 0;
        int []id = new int [bookings.size()+11];
        for (Booking booking : bookings){
            if (booking.getStatus().equals("SCHEDULED")){
                show_message = show_message + "\n\t" + i + ". " + booking;
                id[i] = j;
                i++;
            }
            j++;
        }
        show_message = show_message + "\n\nRemoving booking from the system";
        String msg = "\n\nPlease, enter one of the following:\n\nThe sequential ID to select the booking to be removed from the listed bookings above.\n0. Back to main menu.\n-1. Quit application.\n\n";
        show_message = show_message + msg;
        System.out.println(show_message);
        
        while (true){
        	String next_input = user_input.nextLine();
            int final_input;
            String entry = " ";
            
            try {
                if (next_input.length() >= 2){
                    entry = next_input.substring(0,2);
                } else if (next_input.length() == 1){
                    entry = next_input.substring(0,1);
                }
                final_input = Integer.parseInt(entry);

                if (final_input == -1){
                    return false;
                } else if (final_input == 0){ //if they select 0 go to the main menu
                    return true;
                } else if (final_input > 10 && final_input <= i){
                	
                    try{
                        int bookingID = id[final_input];
                        Booking new_entry = bookings.get(bookingID);
                            if (new_entry.getStatus().equals("SCHEDULED")){
                                new_entry.removeBooking();
                                bookings.remove(bookingID);
                                System.out.println("\nBooking removed successfully:");
                                System.out.println(new_entry);
                                System.out.println(msg);
                            } else {
                                System.out.println("ERROR!");
                                System.out.println("Cannot Remove Booking as it has been completed.");
                                System.out.println(msg);
                            }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("Incorrect format for removal of boooking");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("Incorrect format for removal of booking");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    
    
    
    //Method to List Assistants  

    public boolean listAssistantsOnShift(){

    	Scanner user_input = new Scanner(System.in);
        
        String show_message = "\nUniversity of Knowledge - COVID test\n";
        int i = 11;
        for (AssistantOnShift assistant_new_shift : assistantsOnShift){
            show_message = show_message + "\n\t" + i + ". " + assistant_new_shift;
            i++;
        }
        show_message = show_message + "\n\n0. Back to main menu.\n-1. Quit application.\n\n";
        System.out.println(show_message);
        
        while (true){
            if (user_input.equals("-1")){
                return false;
            } else if (user_input.equals("0")){
                return true;
            }   
        }
    }
    
    

    //Method to Add Assistants on Shift 
   
    public boolean addAssistantsOnShift(UniversityResources resources_, BookingSystem book_system){
        Scanner user_input = new Scanner(System.in);
        
        //Adding the assistants to the Array List 
        ArrayList<Assistant> assistants = resources_.getAssistants();
        
        String show_message = "\nUniversity of Knowledge - COVID test\n\nAdding Assistants on shift\n";
        int i = 11;
        for (Assistant add_assistant : assistants){
            show_message = show_message + "\n\t" + i + ". " + add_assistant;
            i++;
        }
        String msg = "\nPlease, enter one of the following:\n\nThe sequential ID of an assistant and date (dd/mm/yyyy), separated by a white space.\n0. Back to main menu.\n-1. Quit application.\n\n";
        show_message = show_message + msg;
        System.out.println(show_message);
        
        while (true){
            String next_input = user_input.nextLine();
            int final_input;
            String entry = " ";
            
            try {
                if (next_input.length() >= 2){
                    entry = next_input.substring(0,2);
                } else if (next_input.length() == 1){
                    entry = next_input.substring(0,1);
                }
                
                final_input = Integer.parseInt(entry);
                if (final_input == -1){
                    return false;
                } else if (final_input == 0){ 
                    return true;
                    
                } else if (final_input > 10 && final_input <= i){
                    try{
                        if (next_input.length() >= 13 && next_input.substring(next_input.length()-11, next_input.length()-10).equals(" ")){
                            boolean duplicate = false;
                            
                            //Loop through current Assistants to check for duplicates
                            for (AssistantOnShift assistantshift : assistantsOnShift){
                                if (assistants.get(final_input-11).equals(assistantshift.getAssistant()) && next_input.substring(next_input.length()-10).equals(assistantshift.getAssistantShiftDate())){// checking if the user inputs are a duplicate
                                    duplicate = true;
                                }
                            }
                            if (duplicate == false){
                                AssistantOnShift assistantshift = new AssistantOnShift(assistants.get(final_input-11), next_input.substring(next_input.length()-10), book_system);
                                assistantsOnShift.add(assistantshift);
                                System.out.println("\nAssistant on Shift added successfully:");
                                System.out.println(assistantshift);
                                System.out.println(msg);
                            } else {
                                
                                System.out.println("ERROR!");
                                System.out.println("Assistant is already on Shift");
                                System.out.println(msg);
                            }
                        } else {
                            //returning error if the length isn't valid
                            System.out.println("ERROR!");
                            System.out.println("Unvalid ID, whitespace or date format");
                            System.out.println(msg);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("Format for new Assistant on Shift is incorrect");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("Format for new Assistant on Shift is incorrect ");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    

    
    //Method to Remove Assistant on Shift 

    public boolean removeAssistantOnShift(){
        Scanner user_input = new Scanner(System.in);

        String show_message = "\nUniversity of Knowledge - COVID test\n\nAdding Assistants on shift\n";
        int i = 11;
        int j = 0;
        int []id = new int [assistantsOnShift.size()+11];
        for (AssistantOnShift assistant_new_shift : assistantsOnShift){
            if (assistant_new_shift.getStatus().equals("FREE")){
                show_message = show_message + "\n\t" + i + ". " + assistant_new_shift;
                id[i] = j;
                i++;
            }
            j++;
        }
        String msg = "\nPlease, enter one of the following:\n\nThe sequential ID to select the assistant on shift to be removed.\n0. Back to main menu.\n-1. Quit application.\n\n";
        show_message = show_message + msg;
        System.out.println(show_message);
        
        while (true){
            String next_input = user_input.nextLine();
            int final_input;
            String entry = " ";
            
            try {
                if (next_input.length() >= 2){
                    entry = next_input.substring(0,2);
                } else if (next_input.length() == 1){
                    entry = next_input.substring(0,1);
                }
                
                final_input = Integer.parseInt(entry);

                if (final_input == -1){
                    return false;
                } else if (final_input == 0){ 
                    return true;
                } else if (final_input > 10 && final_input <= i){
                    try{
                        int assistantID = id[final_input];
                        AssistantOnShift new_entry = assistantsOnShift.get(assistantID);
                        if (new_entry.getStatus().equals("FREE")){
                            assistantsOnShift.remove(assistantID);
                            System.out.println("\nAssistant on shift removed successfully:");
                            System.out.println(new_entry);
                            System.out.println(msg);
                        } else { 
                            System.out.println("ERROR!");
                            System.out.println("Assistant on Shift is busy at proposed time");
                            System.out.println(msg);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("Removing Assistant on Shift format is incorrect");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("Removing Assistant on Shift format is incorrect");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    

    
    //Method to List Rooms that can be booked 

    public boolean listBookableRooms(){
        Scanner user_input = new Scanner(System.in);
        
        String show_message = "\nUniversity of Knowledge - COVID test\n";
        int i = 11;
        for (BookableRoom book_new_room : bookableRooms){
            show_message = show_message + "\n\t" + i + ". " + book_new_room;
            i++;
        }
        show_message = show_message + "\n\n0. Back to main menu.\n-1. Quit application.\n\n";
        System.out.println(show_message);
        
        while (true){
            String next_input = user_input.nextLine();

            if (next_input.equals("-1")){
                return false;
            } else if (next_input.equals("0")){ 
                return true;
            }   
        }
    }
    
    

    
    //Method to Add a Room that can be booked  

    public boolean addBookableRooms(UniversityResources resources_){
        Scanner user_input = new Scanner(System.in);
        
        ArrayList<Room> rooms = resources_.getRooms();
        
        String show_message = "\nUniversity of Knowledge - COVID test\n\nAdding bookable room\n";
        int i = 11;
        for (Room add_room : rooms){
            show_message = show_message + "\n\t" + i + ". " + add_room;
            i++;
        }
        String msg = "\nPlease, enter one of the following:\n\nThe sequential ID listed to a room, a date (dd/mm/yyyy), and a time (HH:MM), separated by a white space.\n0. Back to main menu.\n-1. Quit application.\n\n";
        show_message = show_message + msg;
        System.out.println(show_message);
        
        while (true){

            String next_input = user_input.nextLine();
            int final_input;
            String entry = " ";
            
            try {
                if (next_input.length() >= 2){
                    entry = next_input.substring(0,2);
                } else if (next_input.length() == 1){
                    entry = next_input.substring(0,1);
                }
                
                final_input = Integer.parseInt(entry);
                if (final_input == -1){
                    return false;
                } else if (final_input == 0){ 
                    return true;
                } else if (final_input > 10 && final_input <= i){
                    try{
                        if (next_input.substring(next_input.length()-5).equals("07:00") || next_input.substring(next_input.length()-5).equals("08:00") || next_input.substring(next_input.length()-5).equals("09:00") && next_input.length() >= 19){//checking that the time correct and the length is correct
                            if (next_input.substring(next_input.length()-6, next_input.length()-5).equals(" ")){
                                boolean duplicate = false;
                                for (BookableRoom book_new_room : bookableRooms){
                                    if (rooms.get(final_input-11).equals(book_new_room.getRoom()) && next_input.substring(next_input.length()-16, next_input.length()-6).equals(book_new_room.getDate()) && next_input.substring(next_input.length()-5).equals(book_new_room.getTime())){// checking if the user inputs are a duplicate
                                        duplicate = true;
                                    }
                                }
                                if (duplicate == false){
                                    BookableRoom bookroom = new BookableRoom(rooms.get(final_input-11), next_input.substring(next_input.length()-16, next_input.length()-6), next_input.substring(next_input.length()-5));
                                    bookableRooms.add(bookroom);
                                    System.out.println("\nBookable Room added successfully:");
                                    System.out.println(bookroom);
                                    System.out.println(msg);
                                } else {
                                    System.out.println("ERROR!");
                                    System.out.println("incorrect bookable room is a duplicate");
                                    System.out.println(msg);
                                }
                            } else {
                                
                                System.out.println("ERROR!");
                                System.out.println("Incorrect ID or whitespace ");
                                System.out.println(msg);
                            }
                        } else {
                            System.out.println("ERROR!");
                            System.out.println("Incorrect format for time");
                            System.out.println(msg);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("Incorrect format for bookable room.");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("Incorrect format for bookable room.");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    

    

    
    //Method to Remove a Room 

    public boolean removeBookableRooms(){
        Scanner user_input = new Scanner(System.in);
        
        String show_message = "\nUniversity of Knowledge - COVID test\n";
        int i = 11;
        int j = 0;
        int []id = new int [bookableRooms.size()+11];
        for (BookableRoom book_new_room : bookableRooms){
            if (book_new_room.getStatus().equals("EMPTY")){
                show_message = show_message + "\n\t" + i + ". " + book_new_room;
                id[i] = j;
                i++;
            }
            j++;
        }
        String msg = "\nRemoving bookable room\n\nPlease, enter one of the following:\n\nThe sequential ID  to select the bookable room to be removed.\n0. Back to main menu.\n-1. Quit application.\n\n";
        show_message = show_message + msg;
        System.out.println(show_message);
        
        while (true){
            String next_input = user_input.nextLine();
            int final_input;
            String entry = " ";
            
            try {
                if (next_input.length() >= 2){
                    entry = next_input.substring(0,2);
                } else if (next_input.length() == 1){
                    entry = next_input.substring(0,1);
                }
                
                final_input = Integer.parseInt(entry);

                if (final_input == -1){
                    return false;
                } else if (final_input == 0){ 
                    return true;
                } else if (final_input > 10 && final_input <= i){
                    try{
                        int bookableroomID_ = id[final_input];
                        BookableRoom new_entry = bookableRooms.get(bookableroomID_);
                        if (new_entry.getStatus().equals("EMPTY")){
                            bookableRooms.remove(bookableroomID_);
                            System.out.println("\nBookable Room removed successfully:");
                            System.out.println(new_entry);
                            System.out.println(msg);
                        } else { //making sure that the user user_input is not a room that isn't empty
                            System.out.println("ERROR!");
                            System.out.println("Room is not empty, cannot be removed");
                            System.out.println(msg);
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("Incorrect format for removing bookable room.");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("Incorrect format for removing bookable room.");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
    
 
    
    //Method to Conclude a Booking 

    public boolean concludeBooking(){
        Scanner user_input = new Scanner(System.in);
        
        String show_message = "\nUniversity of Knowledge - COVID test\n";
        int i = 11;
        int j = 0;
        int []id = new int [bookings.size()+11];
        for (Booking booking : bookings){
            if (booking.getStatus().equals("SCHEDULED")){
                show_message = show_message + "\n\t" + i + ". " + booking;
                id[i] = j;
                i++;
            }
            j++;
        }
        show_message = show_message + "\n\nConclude booking";
        String msg = "\n\nPlease, enter one of the following:\n\nThe sequential ID to select the booking to be completed.\n0. Back to main menu.\n-1. Quit application.\n\n";
        show_message = show_message + msg;
        System.out.println(show_message);
        
        while (true){
            String next_input = user_input.nextLine();
            int final_input;
            String entry = " ";
            
            try {
                if (next_input.length() >= 2){
                    entry = next_input.substring(0,2);
                } else if (next_input.length() == 1){
                    entry = next_input.substring(0,1);
                }
                
                final_input = Integer.parseInt(entry);
                if (final_input == -1){
                    return false;
                } else if (final_input == 0){ 
                    return true;
                } else if (final_input > 10 && final_input <= i){
                    try{
                        int bookingID = id[final_input];
                        Booking new_entry = bookings.get(bookingID);
                            if (new_entry.getStatus().equals("SCHEDULED")){
                                new_entry.conclude();
                                System.out.println("\nBooking completed successfully:");
                                System.out.println(new_entry);
                                System.out.println(msg);
                            } else {
                                System.out.println("ERROR!");
                                System.out.println("Booking has been completed earlier");
                                System.out.println(msg);
                            }
                    } catch (Exception e) {
                        System.out.println(e);
                        System.out.println("ERROR!");
                        System.out.println("Incorrect format for completing bookings");
                        System.out.println(msg);
                    }
                    
                } else {
                    System.out.println("ERROR!");
                    System.out.println("Incorrect format for completing booking");
                    System.out.println(msg);
                }
            } catch (NumberFormatException e){
                System.out.println("ERROR!");
                System.out.println(e);
            }
        }
    }
}

