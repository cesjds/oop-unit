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
        super(id, n, bd);
        setGrade(g);
        setGpa(gp);
    }
    public int getGrade() {
        return this.grade;
    }
    public double getGpa() {
        return this.gpa;
    }
    public void setGrade(int grade) {
        if(grade < 0 || grade > 12)
            throw new IllegalArgumentException("Invalid grade for student " + super.getName());
        this.grade = grade;
    }
    public void setGpa(double gpa) {
        if(gpa < 0 || gpa >= 5)
            throw new IllegalArgumentException("Invalid gpa for student " + super.getName());
        this.gpa = gpa;
    }

}
