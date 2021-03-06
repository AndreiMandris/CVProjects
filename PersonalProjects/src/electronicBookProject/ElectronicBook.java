package electronicBookProject;

/**
 * class defines an Electronic Book as parent for eBook and iBook
 *
 * @author Andrei Mandris
 * @version 1.0
 */
public class ElectronicBook {

    private static final int Y2005 = 2005;
    private static final int Y2006 = 2006;
    private static final int Y2007 = 2007;
    private static final int Y2008 = 2008;
    private static final int Y2009 = 2009;
    private static final int Y2010 = 2010;
    private static final int Y2011 = 2011;
    private static final int Y2012 = 2012;
    private static final int Y2013 = 2013;
    private static final int Y2014 = 2014;
    private static final int Y2015 = 2015;
    private static final int Y2016 = 2016;

    enum YearOfPublication {
        Y2005, Y2006, Y2007, Y2008, Y2009, Y2010, Y2011, Y2012, Y2013, Y2014, Y2015,
        Y2016
    }
    /**
     * type of eBook formats
     */
    private static final String AZW = "AZW";
    private static final String AZW3 = "AZW3";
    private static final String KF8 = "KF8";
    private static final String NonDRM = "non-DRM MOBI";
    private static final String DRM = "Adobe DRM";
    private static final String PDF = "PDF";
    private static final String PRC = "PRC";
    private static final String TXT = "TXT";
    private static final String EPUB = "EPUB";
    private static final String EPUBDRM = "EPUB DRM";
    private static final String IBA = "IBA";
    private static final String BBEB = "BBeB";
    private static final String HTML = "HTML";
    private static final String HTM = "HTM";
    private static final String CBR = "CBR (comic)";
    private static final String CBZ = "CBZ (comic)";
    private static final String FB2 = "FB2";
    private static final String FB2ZIP = "FB2.ZIP";
    private static final String DJVU = "DJVU";
    private static final String RTF = "RTF";
    private static final String DOCX = "DOCX";
    private static final String DOC = "DOC";
    private static final String CHM = "CHM";
    private static final String TCR = "TCR";

    public enum FormatOfElectronicBook {
        AZW, AZW3, KF8, NonDRM, DRM, PDF, PRC, TXT, EPUB, EPUBDRM,
        IBA, BBEB, HTML, HTM, CBR, CBZ, FB2, FB2ZIP, DJVU, RTF, DOCX, DOC, CHM, TCR
    }

    /**
     * format of publish
     */
    private FormatOfElectronicBook electronicFormat;
    /**
     * Unique serial number of book
     */
    private String ISBN;
    /**
     * Title of book
     */
    private String title;
    /**
     * List of Authors with one first name, one middle name and one last name
     */
    private String[] authors;
    /**
     * list of links that can be used to download the book
     */
    private String[] downloadLinks;
    /**
     * central list of remarks noted by readers in format - (reader,remark)
     */
    private String[] remarksAndNotes;
    /**
     * the publisher of eBook
     */
    private String publisher;
    /**
     * price
     */
    private float price;
    /**
     * year of publication
     */
    private YearOfPublication yearOfPublication;

    //constructors
    public ElectronicBook(String ISBN, String[] authors) {
        this.ISBN = ISBN;
        this.authors = authors;
    }

    public ElectronicBook(String ISBN, String[] authors, String[] downloadLinks) {
        this.ISBN = ISBN;
        this.authors = authors;
        this.downloadLinks = downloadLinks;
    }

    public ElectronicBook(String ISBN, String[] authors, String[] downloadLinks, String[] remarksAndNotes) {
        this.ISBN = ISBN;
        this.authors = authors;
        this.downloadLinks = downloadLinks;
        this.remarksAndNotes = remarksAndNotes;
    }
    // get-ers and set-ers

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public String[] getDownloadLinks() {
        return downloadLinks;
    }

    public void setDownloadLinks(String[] downloadLinks) {
        this.downloadLinks = downloadLinks;
    }

    public String[] getRemarksAndNotes() {
        return remarksAndNotes;
    }

    public void setRemarksAndNotes(String[] remarksAndNotes) {
        this.remarksAndNotes = remarksAndNotes;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public FormatOfElectronicBook getElectronicFormat() {
        return electronicFormat;
    }

    public void setElectronicFormat(FormatOfElectronicBook electronicFormat) {
        this.electronicFormat = electronicFormat;
    }

    public YearOfPublication getYearOfPublication() {
        return yearOfPublication;
    }

    public void setYearOfPublication(YearOfPublication yearOfPublication) {
        this.yearOfPublication = yearOfPublication;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
