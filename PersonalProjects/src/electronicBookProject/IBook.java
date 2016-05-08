package electronicBookProject;

/**
 *
 * @author Andrei Mandris
 * @version 1.0
 */

public class IBook extends ElectronicBook {

    /**
     * list of compatible reader devices
     */
    /**
     * type of eBook formats
     */
    private static final String APPIPAD = "Apple iPad";
    private static final String APPIPOD = "Apple iPod";
    private static final String APPIPHONE = "Apple iPhone";

    /**
     * recommended reader
     *
     * @param recommendedReader
     */
    public void setRecommendedReader(iBooksReaders recommendedReader) {
        this.recommendedReader = recommendedReader;
    }

    private iBooksReaders recommendedReader;

    public IBook(String ISBN, String[] authors) {
        super(ISBN, authors);
    }

    public IBook(String ISBN, String[] authors, String[] downloadLinks) {
        super(ISBN, authors, downloadLinks);
    }

    public IBook(String ISBN, String[] authors, String[] downloadLinks, String[] remarksAndNotes) {
        super(ISBN, authors, downloadLinks, remarksAndNotes);
    }

    public enum iBooksReaders {
        APPIPAD, APPIPOD, APPIPHONE
    }

    public iBooksReaders getRecommendedReader() {
        return recommendedReader;
    }
}
