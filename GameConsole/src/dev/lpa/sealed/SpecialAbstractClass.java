package dev.lpa.sealed;

//public sealed abstract class SpecialAbstractClass {
public sealed abstract class SpecialAbstractClass permits SpecialAbstractClass.Kid {  //need to include outer class name

    final class Kid extends SpecialAbstractClass {

    }
}
