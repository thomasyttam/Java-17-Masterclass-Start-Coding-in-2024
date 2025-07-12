package dev.external;

import dev.lpa.Parent;

public class Child extends Parent {

    public Child(){
//        super(); // no "no argument" constructor in parent
        super("Jane Doe", "02/02/1920");
    }
}
