package dev.lpa;

import java.util.Arrays;

public class PersonImmutable {

    // make final and private for immutable
    private final String name;
    private final String dob;
//    private final PersonImmutable[] kids;
    protected final PersonImmutable[] kids;

    public PersonImmutable(String name, String dob, PersonImmutable[] kids) {
        this.name = name;
        this.dob = dob;
        this.kids = kids == null ? null : Arrays.copyOf(kids, kids.length); // return copy of original data
    }

    public PersonImmutable(String name, String dob) {
        this(name, dob, null);
    }

    protected PersonImmutable(PersonImmutable person) {
        this.name = person.name;
        this.dob = person.dob;
        this.kids = person.kids;
    }

    public String getName() {
        return name;
    }

    // protect not to change name, final -> cannot set the name
//    public void setName(String name) {
//        this.name = name;
//    }

    public String getDob() {
        return dob;
    }

    // protect not to change dob
//    public void setDob(String dob) {
//        this.dob = dob;
//    }

    public final PersonImmutable[] getKids() {
        // Arrays.copyOf create a defensive copy, otherwise it will return the reference of kids.
        return kids == null ? null : Arrays.copyOf(kids, kids.length);
    }

    // not setter for immutable
//    public void setKids(PersonImmutable[] kids) {
//        this.kids = kids;
//    }

    @Override
    public String toString() {

        String kidString = "n/a";
        if (kids != null) {
            String[] names = new String[kids.length];
            Arrays.setAll(names, i -> names[i] = kids[i] == null ? "" : kids[i].name);
            kidString = String.join(", ", names);
        }
//        return name + ", dob = " + dob + ", kids = " + kidString;
        return name + ", dob = " + getDob() + ", kids = " + kidString;
    }
}
