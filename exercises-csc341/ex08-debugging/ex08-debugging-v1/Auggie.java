import java.util.ArrayList;
import java.util.Random;

/** 
* Record of individual associated with Augsburg. 
* Can be Student, Staff, or Faculty.
*/
public class Auggie implements Comparable<Auggie> {
	/** username and email address */
    private String username;
    
    /** First Name */
    private String first;
    
    /** Last Name */
    private String last;
    
    /** Role of either Student, Staff, or Faculty */
	private Role role;

	/** Default Constructor.
	*/
	public Auggie() {
		username = "userNobody";
		first = "Anony";
		last = "Mous";
		role = Role.STUDENT;
	}
	
	/** Constructor 
	* @param uname unique username for email
	* @param first name
	* @param last name
	* @param role of Student, Staff, or Faculty
	*/
    public Auggie(String uname, String first, String last, Role role) {
    	this.username = uname;
    	this.first = first;
    	this.last = last;
    	this.role = role;
    }

	@Override
    public String toString() {
        return username+","+first+" "+last+","+role;
    }
    
    @Override
    public boolean equals(Object other) {
    	if (null==other) {
    		return false;
    	}
    	if (!(other instanceof Auggie)) {
    		return false;
    	}
    	Auggie aug = (Auggie) other;
    	// usernames are unique, so this should be sufficient to test equivalency
    	return username.equals(aug.username);
    }
    
    @Override
    public int compareTo(Auggie other) {
    	return username.compareTo(other.username);
    }
    
    // Setters and Getters 
    
    public String username() { return username; }
    public void username(String u) { username = u; }

    public String first() { return first; }
    public void first(String f) { first = f; }

    public String last() { return last; }
    public void last(String l) { last = l; }

    public Role role() { return role;}
    public void role(Role r) { role = r;}
}
