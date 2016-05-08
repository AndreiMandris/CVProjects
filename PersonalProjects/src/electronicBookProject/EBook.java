package electronicBookProject;

/**
 * @author Andrei Mandris
 * @version 1.0 class EBook defines ElectronicBooks that can be read on specific
 * devices and with specific software packages. These books cannot be read
 * natively on Apple devices and cannot be bought from App Store.
 *
 */
public class EBook extends ElectronicBook {

    /**
     * list of compatible reader devices
     */
    /**
     * type of EBook formats
     */
    private static final String AMAZON = "Amazon Kindle";
    private static final String FIRE = "Fire";
    private static final String BNNOOK = "Barnes & Noble Nook";
    private static final String NOOK = "Nook Tablet";
    private static final String SONY = "Sony Reader";
    private static final String KOBOEREADER = "Kobo eReader";
    private static final String KOBOARC = "Kobo Arc";
    private static final String POCKETBOOK = "PocketBook Reader";
    private static final String POCKETTOUCH = "PoketBook Touch";

    /**
     * types of EBook readers
     */
    public enum eBooksReaders {
        AMAZON, FIRE, BNNOOK, NOOK, SONY, KOBOEREADER,
        KOBOARC, POCKETBOOK, POCKETTOUCH
    }
    /**
     * recommended reader
     */
    private eBooksReaders recommendedReader;

    // constructors
    public EBook(String ISBN, String[] authors) {
        super(ISBN, authors);
    }

    public EBook(String ISBN, String[] authors, String[] downloadLinks) {
        super(ISBN, authors, downloadLinks);
    }

    public EBook(String ISBN, String[] authors, String[] downloadLinks, String[] remarksAndNotes) {
        super(ISBN, authors, downloadLinks, remarksAndNotes);
    }

    // get-ers and set-ers
    public eBooksReaders getRecommendedReader() {
        return recommendedReader;
    }

    /**
     * recommended reader
     *
     * @param recommendedReader
     */
    public void setRecommendedReader(eBooksReaders recommendedReader) {
        this.recommendedReader = recommendedReader;
    }
}
