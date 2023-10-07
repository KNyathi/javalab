// Abstract class
abstract class Human {
    protected String name;
    protected int age;
    protected String gender;
    
    public Human() {
        this.name = "Khaya";
        this.age = 0;
        this.gender = "unknown";
    }


    public Human(String name, int age, String gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    // Abstract method
    public abstract void introduce();

    // Additional method
    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Gender: " + gender);
    }

    // Getter and Setter methods for name, age, and gender (three fields)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}

// Inherited class 1
class Student extends Human {
    private String studentId;
    private static int studentCounter = 0;
    
    
    public Student() {
        super();
        this.studentId = "unknown";
        studentCounter++;
        
    }


    public Student(String name, int age, String gender, String studentId) {
        super(name, age, gender);
        this.studentId = studentId;
        studentCounter++; // Increment the counter each time a Student is created
    }

    @Override
    public void introduce() {
        System.out.println("I am a student.");
    }

    // Additional method specific to Student
    public void study() {
        System.out.println("Student is studying.");
    }

    // Static method to get the student counter
    public static int getStudentCounter() {
        return studentCounter;
    }
}


// Inherited class 2
class Teacher extends Human {
    private String subject;


    public Teacher() {
        super();
        this.subject = "English";
    }


    public Teacher(String name, int age, String gender, String subject) {
        super(name, age, gender);
        this.subject = subject;
    }

    @Override
    public void introduce() {
        System.out.println("I am a teacher.");
    }

    // Additional method specific to Teacher
    public void teach() {
        System.out.println("Teacher is teaching.");
    }
}

// Inherited class 3
class TeachingAssistant extends Human {

    public TeachingAssistant() {
        super();
    }
	
    public TeachingAssistant(String name, int age, String gender) {
        super(name, age, gender);
    }

    @Override
    public void introduce() {
        System.out.println("I am a teaching assistant.");
    }

    // Additional method specific to TeachingAssistant
    public void assist() {
        System.out.println("Teaching assistant is assisting.");
    }
}







public class Main {
    public static void main(String[] args) {
        // Create instances of Student, Teacher, and TeachingAssistant
        Student student1 = new Student("Alice", 20, "Female", "S123");
        Student student2 = new Student("Bob", 22, "Male", "S124");
        Teacher teacher = new Teacher("Bob", 35, "Male", "Math");
        TeachingAssistant assistant = new TeachingAssistant("Chris", 25, "Non-Binary");
        
        Student defaultStudent = new Student();
        Teacher defaultTeacher = new Teacher();
        TeachingAssistant defaultAssistant = new TeachingAssistant();

        // Display information and introduce each person
        System.out.println("Student Information");
        System.out.println("____________________");
        student1.displayInfo();
        student1.introduce();
        student1.study();
        
        
        System.out.println("____________________");
        defaultStudent.displayInfo();
        defaultStudent.introduce();
        defaultStudent.study();
        
        
        System.out.println(".................................................");
        
        student2.displayInfo();
        student2.introduce();
        student2.study();
	System.out.println(".................................................");
	
        System.out.println("\nTeacher Information");
        System.out.println("______________________");
        teacher.displayInfo();
        teacher.introduce();
        teacher.teach();
        
          
        System.out.println("____________________");
        defaultTeacher.displayInfo();
        defaultTeacher.introduce();
        defaultTeacher.teach();
        
	System.out.println(".................................................");
	
        System.out.println("\nTeaching Assistant Information");
        System.out.println("_________________________________");
        assistant.displayInfo();
        assistant.introduce();
        assistant.assist();
        
         System.out.println("____________________");
         defaultAssistant.displayInfo();
         defaultAssistant.introduce();
         defaultAssistant.assist();
         
        System.out.println(".................................................");
        
        // Display the student counter
        System.out.println("Number of students: " + Student.getStudentCounter());
        
       
    }
}







