package dev.lpa.generic;

public class BaseClass {

    // final mean cannot override in subclass
    public final void recommendedMethod() {

        System.out.println("[BaseClass.recommendedMethod]: Best Way to Do it");
        optionalMethod();
        mandatoryMethod();
    }

    protected void optionalMethod() {
        System.out.println("[BaseClass.optionalMethod]: Customize Optional Method");
    }

    // private mean cannot call in subclass and other class
    private void mandatoryMethod() {
        System.out.println("[BaseClass.mandatoryMethod]: NON-NEGOTIABLE!");
    }

    // if add keyword final, same for the static method, subclass cannot override or hide
    public static void recommendedStatic() {

        System.out.println("[BaseClass.recommendedStatic] BEST Way to Do it");
        optionalStatic();
        mandatoryStatic();
    }

    protected static void optionalStatic() {
        System.out.println("[BaseClass.optionalStatic]: Optional");
    }

    private static void mandatoryStatic() {
        System.out.println("[BaseClass.mandatoryStatic]: MANDATORY");
    }

}
