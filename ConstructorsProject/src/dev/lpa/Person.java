package dev.lpa;

public record Person(String name, String dob) { // canonical constructor

//    public Person(String name, String dob) {
//        this.name = name;
//        this.dob = dob.replace('-', '/');
//        // Variable 'dob' might already have been assigned to (final)
//        // this.dob = this.dob.trim();
//    }

    // Instance initializer is not allowed in record
//    {
//        this.dob = "01/01/1950";
//    }

    // Copy constructor
    public Person(Person p) {
        this(p.name, p.dob);
    }

    public Person {
        if (dob == null) throw new IllegalArgumentException("Bad data");
//        Variable 'this.dob' might not have been initialized
//        dob = this.dob.replace('-', '/');
        dob = dob.replace('-', '/');
        // Cannot assign a value to final variable 'dob'
//        this.dob = dob;
    }
}
