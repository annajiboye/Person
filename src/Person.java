import java.util.Calendar;

public class Person {
    private String firstName;
    private String lastName;
    private String ID;
    private String title;
    private int YOB;


    public Person(String firstName, String lastName, String ID, String title, int YOB) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ID = ID;
        this.title = title;
        this.YOB = YOB;
    }

 
    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getID() {
        return ID;
    }

    public String getTitle() {
        return title;
    }

    public int getYOB() {
        return YOB;
    }

  
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYOB(int YOB) {
        if (YOB >= 1940 && YOB <= 2010) {
            this.YOB = YOB;
        } else {
            throw new IllegalArgumentException("Year of Birth must be between 1940 and 2010.");
        }
    }

  
    public String fullName() {
        return firstName + " " + lastName;
    }

    public String formalName() {
        return title + " " + fullName();
    }

    public String getAge() {
        Calendar now = Calendar.getInstance();
        int currentYear = now.get(Calendar.YEAR);
        int age = currentYear - YOB;
        return String.valueOf(age);
    }

    public String getAge(int year) {
        int age = year - YOB;
        return String.valueOf(age);
    }

   
    public String toCSV() {
        return String.format("%s,%s,%s,%s,%d", ID, firstName, lastName, title, YOB);
    }


    public String toJSON() {
        return String.format("{\"ID\":\"%s\", \"firstName\":\"%s\", \"lastName\":\"%s\", \"title\":\"%s\", \"YOB\":%d}",
                ID, firstName, lastName, title, YOB);
    }

  
    public String toXML() {
        return String.format("<Person><ID>%s</ID><FirstName>%s</FirstName><LastName>%s</LastName><Title>%s</Title><YOB>%d</YOB></Person>",
                ID, firstName, lastName, title, YOB);
    }
}
