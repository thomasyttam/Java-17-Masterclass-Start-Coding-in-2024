package dev.lpa;

import java.time.LocalDate;

public enum Generation {

//    GEN_Z(2001, 2025),
//    GEN_Z,
    GEN_Z {
    // instance initializer
        {
            System.out.println("-- SPECIAL FOR " + this + " --");
        }
    },
    MILLENNIAL(1981, 2000),
    GEN_X(1965, 1980),
    BABY_BOOMER(1946, 1964),
    SILENT_GENERATION(1927, 1945),
    GREATEST_GENERATION(1901, 1926);

    private final int startYear;
    private final int endYear;

    // implicit constructor
//    Generation() {
//        System.out.println(this);
//    }
    Generation() {
        this(2001, LocalDate.now().getYear());
    }

    // explicit constructor, cannot be public
    Generation(int startYear, int endYear) {
        this.startYear = startYear;
        this.endYear = endYear;
//        System.out.println(this.name() + " " + startYear + " - " + endYear);
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.name() + " " + startYear + " - " + endYear;
    }
}
