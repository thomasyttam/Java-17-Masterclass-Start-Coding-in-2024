package dev.lpa.sealed;

public sealed class SealedKid extends SpecialAbstractClass { // Sealed class must have subclass

    final class GrandKid extends SealedKid {

    }
}
