package by.application.javaWeb.model.product;

import javax.persistence.*;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "nameprod")
    private String nameprod;
    @Column(name = "price")
    private String price;
    @Column(name = "manufacturer")
    private String manufacturer;
    @Column(name = "releaseDate")
    private String releaseDate;
    @Lob
    @Column(name = "photo")
    private byte[] photo;

    public Product(String nameprod, String price, String manufacturer, String releaseDate, byte[] photo) {
        this.nameprod = nameprod;
        this.price = price;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
        this.photo = photo;
    }
    public Product(int Id, String nameprod, String price, String manufacturer, String releaseDate) {
        this.id = id;
        this.nameprod = nameprod;
        this.price = price;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
    }
    public Product(int Id, String nameprod, String price, String manufacturer, String releaseDate, byte[] photo) {
        this.id = id;
        this.nameprod = nameprod;
        this.price = price;
        this.manufacturer = manufacturer;
        this.releaseDate = releaseDate;
        this.photo = photo;
    }

    public Product(Product product) {
    }

    public Product(int id) {
        this.id = id;
    }

    public Product() {

    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameprod() {
        return nameprod;
    }

    public void setNameprod(String nameprod) {
        this.nameprod = nameprod;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "\nProduct{" +
                "id=" + id +
                ", nameprod='" + nameprod + '\'' +
                ", price='" + price + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }
}
