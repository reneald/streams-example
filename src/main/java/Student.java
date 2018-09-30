public class Student {
    private String firstName;
    private String lastName;
    private int year;
    private int grade;

    public Student(String firstName, String lastName, int year, int grade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.year = year;
        this.grade = grade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
