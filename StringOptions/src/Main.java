public class Main {

    public static void main(String[] args) {

        String helloWorld = "Hello" + " World";
        helloWorld.concat(" and Goodbye");

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye");

        printInformaion(helloWorld);
        printInformaion(helloWorldBuilder);

        StringBuilder emptyStart = new StringBuilder();
        emptyStart.append("a".repeat(57));

        StringBuilder emptyStart32 = new StringBuilder(32);
        emptyStart32.append("a".repeat(17));

        printInformaion(emptyStart);
        printInformaion(emptyStart32);

        StringBuilder BuilderPlus = new StringBuilder("Hello" + " World");
        BuilderPlus.append(" and Goodbye");

        BuilderPlus.deleteCharAt(16).insert(16,'g');
        System.out.println(BuilderPlus);

        BuilderPlus.replace(16,17,"G");
        System.out.println(BuilderPlus);

//        BuilderPlus.reverse();
//        System.out.println(BuilderPlus);
//
//        BuilderPlus.setLength(7);
//        System.out.println(BuilderPlus);

        BuilderPlus.reverse().setLength(7);
        System.out.println(BuilderPlus);
    }

    public static void printInformaion(String string) {
        System.out.println("String = " + string);
        System.out.println("length = " +string.length());
    }

    public static void printInformaion(StringBuilder bulider) {
        System.out.println("StringBuilder = " + bulider);
        System.out.println("length = " +bulider.length());
        System.out.println("capacity = " + bulider.capacity());
    }
}
