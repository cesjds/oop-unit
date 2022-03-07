public class Student extends Person
{
    private int grade;
    private double gpa;

    public Student()
    {
        super();
        grade = 0;
        gpa = 0;
    }
    public Student(String id, String n, String bd, int g, double gp)
    {
        super(id, n, db);
        setGrade(g);
        setGpa(gp);
    }

    public int getGrade() {
        return this.gpa;
    }
    public void setGrade(int grade) {
        if(grade < 0 || grade > 12)
            throw new IllegalAccessException("Invalid grade");
        this.grade = grade;
    }
    public void setGpa(double gpa) {
        if(gpa < 0 || gpa >= 5)
            throw new IllegalAccessException("Invalid gpa for student " + super.getName());
        this.gpa = gpa;
    }

}
