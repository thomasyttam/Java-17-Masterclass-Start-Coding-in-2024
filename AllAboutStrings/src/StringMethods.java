public class StringMethods {

    public static void main(String[] args) {

        String birthDate = "25/11/1982";
        int startingIndex = birthDate.indexOf("1982");
        System.out.println("staringIndex = " + startingIndex);
        System.out.println("Birth year = " + birthDate.substring(startingIndex));

        System.out.println("Month = " + birthDate.substring(3,5));

        String newDate = String.join("/", "25", "11", "1982");
        System.out.println("newDate = " + newDate);

        String newDateTwo = "25";
        newDateTwo = newDateTwo.concat("/");
        newDateTwo = newDateTwo.concat("11");
        newDateTwo = newDateTwo.concat("/");
        newDateTwo = newDateTwo.concat("1982");
        System.out.println("newDateTwo = " + newDateTwo);

        String newDateThree = "25" + "/" + "11" + "/" +"1982";
        System.out.println("newDateThree = " + newDateThree);

        String newDateFour = "25".concat("/").concat("11").concat("/")
                .concat("1982");
        System.out.println("newDateFour = " + newDateFour);

        System.out.println(newDateFour.replace('/', '-'));
        System.out.println(newDateFour.replace("2", "00"));

        System.out.println(newDateFour.replaceFirst("/", "-"));
        System.out.println(newDateFour.replaceAll("/", "---"));

        System.out.println("ABC\n".repeat(3));
        System.out.println("-".repeat(20));

        System.out.println("ABC\n".repeat(3).indent(8));
        System.out.println("-".repeat(20));

        System.out.println("    ABC\n".repeat(3).indent(-2));
        System.out.println("-".repeat(20));
    }
}
