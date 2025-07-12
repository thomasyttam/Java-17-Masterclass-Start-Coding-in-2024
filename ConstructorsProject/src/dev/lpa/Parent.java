package dev.lpa;

public class Parent {

//    private String name; // if not constructor, implicit constructor set value to null
//    private String dob; // if not constructor, implicit constructor set value to null

    private final String name; // need initialize
    private final String dob; // need initialize

    protected final int siblings;

    public String getDob() {
        return dob;
    }

    // instance initializer block, execute before any code in constructor
    {
//        name = "John Doe";
//        dob = "01/01/1900";
        System.out.println("In Parent Initializer");
    }

//    public Parent() {
//        System.out.println("In Parent's No Args Constructor");
//    }

    public Parent(String dob, String name, int siblings) {
        this.dob = dob;
        this.name = name;
        this.siblings = siblings;
        System.out.println("In Parent Constructor");
    }

    // keyword final, cannot set
//    public void setDob(String dob) {
//        this.dob = dob;
//    }

    public String getName() {
        return name;
    }

    // keyword final, cannot set
//    public void setName(String name) {
//        this.name = name;
//    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +", dob='" + dob+ '\'';
    }
}
