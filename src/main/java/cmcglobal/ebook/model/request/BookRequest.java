package cmcglobal.ebook.model.request;


public class BookRequest {

    private String name;
    private String iSBNCode;
    private Long price;
    private Long quantity;
    private String author;
    private String provider;

    public BookRequest(String name, String iSBNCode, Long price, Long quantity, String author, String provider) {
        this.name = name;
        this.iSBNCode = iSBNCode;
        this.price = price;
        this.quantity = quantity;
        this.author = author;
        this.provider = provider;
    }

    public BookRequest() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getISBNCode() {
        return iSBNCode;
    }

    public void setISBNCode(String iSBNCode) {
        this.iSBNCode = iSBNCode;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }


}
