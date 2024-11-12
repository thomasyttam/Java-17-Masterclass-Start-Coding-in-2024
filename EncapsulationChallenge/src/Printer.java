public class Printer {

    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;


    public Printer() {
        this(100,true);
    }

    public Printer(int tonerLevel, boolean duplex) {
        this.tonerLevel = (tonerLevel < 0 || tonerLevel > 100) ? -1 : tonerLevel;
        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int addToner(int tonerAmount) {
//        if (tonerAmount > 100 || tonerAmount < 0)
//            return -1;
//        if ((this.tonerLevel + tonerAmount) > 100 || (this.tonerLevel + tonerAmount) < 0) {
//            return -1;
//        }
//        tonerLevel += tonerAmount;
//        return tonerLevel;
        if (tonerAmount > 100 || tonerAmount <= 0)
            return -1;
        if ((this.tonerLevel + tonerAmount) > 100) {
            return -1;
        }
        this.tonerLevel += tonerAmount;
        return tonerLevel;
    }

    public int printPages(int pages) {
//        int pagesNeeded = 0;
//        if (duplex) {
//            System.out.println("It's a duplex printer");
//            if (pages % 2 == 0) {
//                pagesNeeded = pages / 2;
//            }
//            else {
//                pagesNeeded = pages / 2 + 1;
//            }
//            pagesPrinted += pagesNeeded;
//            return pagesNeeded;
//        } else {
//            pagesPrinted += pages;
//            return pages;
//        }
        // Better solution from course
        int pagesToPrint = (duplex) ? pages/2 + pages%2 : pages;
        pagesPrinted += pagesToPrint;
        return pagesToPrint;

    }

    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
