import java.util.LinkedList;
import java.util.Random;

/** Stored information for a student. */
public class Student {

    /** Possible majors and course designators. */
    public static enum Major {
    	CSC, MAT, DST, MIS, BIO, PHY, CHE
    };
    
    private static Major[] majors = Major.values();

    /** Usernames are unique 8 digit words used to login to the system. */
    private String username;

    /** First name of student */
    private String name;

    /** Chosen major. */
    private Major major;

    /** List of courses for which they earned credit. */
    private LinkedList<String> courses = new LinkedList<>();

    /** Constructor that randomly generates a student
     * @param uname unique username for student used to login to system
     */
    public Student(String uname) {
        Random rand = new Random();
        username = uname;

        // Randomly choose a name from list
        name = names[rand.nextInt(names.length)];

        // Randomly choose a major
        major = majors[rand.nextInt(majors.length)];

        // Generate a random list of 1 to 8 courses
        int completed = rand.nextInt(7)+1;
        for (int i=0; i<completed; i++) {
        	String dept = majors[rand.nextInt(majors.length)].toString();
        	courses.add(dept + (rand.nextInt(300)+100));
        }
    }
    
    /** Constructor with all information provided.
    * @parame u username
    * @param n name of Student
    * @param m major
    * @param cc completed courses
    */
    public Student(String u, String n, String m, LinkedList<String> clist) {
    	username = u;
    	name = n;
    	courses = clist;
    	// convert String major back to enum Major
    	for (Major major : majors) {
    		if (major.toString().equals(m)) {
    			this.major = major; 	
    		}
    	}
    }

    @Override
    public String toString() {
        // formatted so that it can be nicely written to a csv file
        return username+","+name+","+major+formatCourses();
    }

    /** Generate a csv list of courses */
    private String formatCourses() {
        String toPrint = "";
        for (String course : courses) {
            toPrint+=","+course;
        }
        return toPrint;
    }
    
    /* ---------- GETTERS ----------------- */
    public String username() { return username; }
    public String name() { return name; }
    public Major major() { return major; }
    public LinkedList<String> courses() { return courses; }
    

    // a bunch of names to choose from
    private static String[] names = { 
        "Amy", "Erik", "Pavel", "Matt", "Abdi", "Sadaq", "Miguel", "Jocelyn", "Adnan", "Emily", "Drew", "Everett", "Ayden", "Walta", "Joshua", "Keiran", "Elias", "Faiaz", "Sergio", "Ivan", "Max", "Awal", "Chelsey", "Johnny", "Pao", "Jaron", "Liban", "Taha", "Tenley", "Josh", "Xeng", "Gabriel", "Asli", "Adi","Hodan", "Jamila", "Amaal", "Ari", "Quinn", "Mohamud", "Derek", "Dori", "Guleid", "Yuva", "Rudwan", "Aisha", "Hamsa", "Ethan", "Talib", "Kwadwo", "Melissa", "Jake", "Chris", "Skyler", "Zach", "Jade","Liban", "Fatima", "Kodjo", "Corey", "Kebba", "Hannah", "Eric", "Jeffrey", "Esmeralda", "Leah", "Aaga","Halah", "Krystal", "Rahma", "Romeo", "Ivie", "Ben","Andy", "Karen", "Elisha", "Khadro", "Adna", "Sundus", "Mohamed", "Ivan", "Timothy", "Vinny", "Mayali", "Betelehem", "Ermais", "Matt", "Collin", "Adnan", "Tommy", "Moua", "Long", "Miriam", "Keenan", "Sumayyah", "Nathan", "Matthew", "Angel", "Vivika", "Thor", "Brandon", "Andy", "Erica", "Bailey", "Ariana", "Linus", "Elliott", "Vincent", "Josh", "Sean", "Katelynn", "Saryn", "Bjorn", "Doua", "Amina", "Luis","Muna", "Xera", "Khaalid", "Mitchell", "Zakaria", "Leban", "Chris", "Khalid", "Ryan", "Alinase", "Brian", "Anna", "Zak", "Nikita", "Luke", "Ridwan", "Najma", "Brooklyn", "Ella", "Ceazar", "Mackenzie", "Stephanie", "Myles", "Christopher", "Kevin", "Jason", "Justin", "Odin", "Katie", "Jacob", "Lucy", "Vincent", "Najma", "Ly", "Rayan", "Eyasue" 
    };
}
