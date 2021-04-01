//Creating a class of Assistants 
public class Assistant {
	// Attributes of the Assistant Object 
	private String name;
	private String email;
	
	// Assistant object with the inputs name and email 
    public Assistant(String add_name, String add_email){
    	    // Add name of Assistant 
            name = add_name;
            // Ensure that ending of email follows the University format 
            if (add_email.endsWith("@uok.ac.uk")){
                email = add_email;
            } else {
                System.out.println("Incorrect email format has been entered");
            }
        }
    
    //Get Name Method
	public String getName() {
		return this.name;
	}
	//Get Email Method
	public String getEmail() {
		return this.email;
	}
	
	// Format in the Structure of the Display 
    @Override
    public String toString() {
        return " | " + this.name + " | " + this.email + " | ";
    }
}
