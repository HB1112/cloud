package com.springmvc.domain;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Product {
    private static final Logger logger = LoggerFactory.getLogger(Product.class);

    private String name;
    private String price; 
    private int rawPrice; 
    private String image;
    private String link;
    private String category1;
    private String category2;
    private String category3;
    private String mallName;
    private String brand;
    private String shippingFee;

    public Product() {}

    public Product(String name, String price, String image, String link, String category1, String category2,
                   String category3, String mallName, String shippingFee, String brand) {
        this.name = name;
        this.price = price;
        this.rawPrice = parsePriceToInt(price);
        this.image = image;
        this.link = link;
        this.category1 = category1;
        this.category2 = category2;
        this.category3 = category3;
        this.mallName = mallName;
        this.shippingFee = (shippingFee != null) ? shippingFee : "무료배송";
        this.brand = brand;
    }

    public void setRawPrice(int rawPrice) {
        this.rawPrice = rawPrice;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
        this.rawPrice = parsePriceToInt(price);
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getCategory1() {
        return category1;
    }

    public void setCategory1(String category1) {
        this.category1 = category1;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public String getCategory3() {
        return category3;
    }

    public void setCategory3(String category3) {
        this.category3 = category3;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getShippingFee() {
        return shippingFee;
    }

    public void setShippingFee(String shippingFee) {
        this.shippingFee = (shippingFee != null) ? shippingFee : "무료배송";
    }

    public int getPriceAsInt() {
        return rawPrice;
    }

    private int parsePriceToInt(String priceStr) {
        if (priceStr == null || priceStr.isEmpty()) {
            return 0;
        }
        try {
            return Integer.parseInt(priceStr.replaceAll("[^0-9]", ""));
        } catch (NumberFormatException e) {
            logger.warn("가격 파싱 실패: price='{}'", priceStr, e);
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               ", price='" + price + '\'' +
               ", rawPrice=" + rawPrice +
               ", image='" + image + '\'' +
               ", link='" + link + '\'' +
               ", category1='" + category1 + '\'' +
               ", category2='" + category2 + '\'' +
               ", category3='" + category3 + '\'' +
               ", mallName='" + mallName + '\'' +
               ", brand='" + brand + '\'' +
               ", shippingFee='" + shippingFee + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
               Objects.equals(price, product.price) &&
               Objects.equals(image, product.image) &&
               Objects.equals(link, product.link) &&
               Objects.equals(category1, product.category1) &&
               Objects.equals(category2, product.category2) &&
               Objects.equals(category3, product.category3) &&
               Objects.equals(mallName, product.mallName) &&
               Objects.equals(brand, product.brand) &&
               Objects.equals(shippingFee, product.shippingFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, image, link, category1, category2, category3, mallName, brand, shippingFee);
    }
}
