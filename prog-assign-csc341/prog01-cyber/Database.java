import java.util.ArrayList;

public class Database {

	Hasher hasher = null;

	private ArrayList<Pair> users = new ArrayList<>();
	private ArrayList<Student> students = new ArrayList<>();
	
	public Database(Hasher h) {
		hasher = h;
		loadUsers();
		loadStudents();
	}
	
	public boolean valid(String username, String password) {
	
		return false;
	}
	
	/** Open users file and load contents into member variables. */
	public void loadUsers() {
	
		// Open users.txt file -- must use try-catch
		
		// Put each line into new Pair with user value1 and pwd value2
		// Store in users array
	
    }

	/** Open students file and load contents. */
	public void loadStudents() {
	
		// Open students.csv -- must use try-catch
		
		// Put each line into new Student.
		// username, name, major followed by courses.
		// place all courses into a LinkedList.
		
		// store in students array
	}
	
	/** Get student given username. */
	public Student getStudent(String user) {
		return null;
	}
}