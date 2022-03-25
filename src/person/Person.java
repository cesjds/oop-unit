package person;

public class Person implements Comparable<Person>
{
    // instance attributes
    // These are values that describe an instance of this class.
    // Attributes are private to control how the user of this class
    //  can access the data stores in the attributes.
    private String id;
    private String name;
    private String birthDay;
    //private Date birthDay;

    // default constructor
    // This is one way to declare an instance of the person.Person class.
    public Person()
    {
        id = "";
        name = "";
        birthDay = "";
    }

    // parameter constructor
    // This is another way to declare an instance of the person.Person class.
    // We can send values for the attributes using parameters.
    public Person(String i, String n, String bD)
    {
        id = i;
        name = n;
        birthDay = bD;
    }

    // getters & setters
    // These are how we control the use of the data store in the attributes.
    // If you don't want the user of the class to be able to get a value
    //  or set a value you would not have a getter or setter for it.
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    // overridden methods
    // These methods override the toString an equals methods
    //  in the Object class
    public String toString() {
        String ans = getClass().getName() + ", id: " + id
                + ", name: " + name
                + ", birthday: " + birthDay + "\n";
        return ans;
    }

    public boolean equals(Object o) {
        return id.equals(((Person)o).getId());
        //return (compareTo((person.Person) o) == 0);
    }

    // This implements the compareTo method in the
    //  comparable interface
    public int compareTo(Person p) {
        return id.compareTo(p.getId());
    }
}
