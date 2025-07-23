package dev.lpa.sealed;

import java.util.function.Predicate;

public sealed interface SealedInterface permits BetterInterface, StringChecker { // need permits for extend or implement the interface

    boolean testData(Predicate<String> p, String... strings);
}
