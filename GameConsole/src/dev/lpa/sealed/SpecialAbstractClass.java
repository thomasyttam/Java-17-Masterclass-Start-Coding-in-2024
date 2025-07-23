package dev.lpa.sealed;

//public sealed abstract class SpecialAbstractClass {
public sealed abstract class SpecialAbstractClass permits FinalKid,
        NonSealedKid, SealedKid, SpecialAbstractClass.Kid {  //need to include outer class name for nested subclass (Kid), only direct subclass need in permits clause

    final class Kid extends SpecialAbstractClass {

    }
}
