package com.example.lab7_673380594_9.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private String genre;

    private String platform;

    private Double rating;

    private LocalDate releaseDate;

    private Double price;

    private String discountType; // NONE, STUDENT, SEASONAL

    // ต้องมี constructor เปล่า (JPA ต้องการ)
    public Game() {
    }

    public Game(String title, String genre, String platform, Double rating,
                LocalDate releaseDate, Double price, String discountType) {
        this.title = title;
        this.genre = genre;
        this.platform = platform;
        this.rating = rating;
        this.releaseDate = releaseDate;
        this.price = price;
        this.discountType = discountType;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    // Derived property - แปลง discountType ให้อ่านง่ายสำหรับแสดงผล (game.discountName)
    public String getDiscountName() {
        if (discountType == null) {
            return "ไม่มีส่วนลด";
        }
        return switch (discountType) {
            case "STUDENT" -> "ส่วนลดนักศึกษา (10%)";
            case "SEASONAL" -> "ส่วนลดเทศกาล (20%)";
            default -> "ไม่มีส่วนลด";
        };
    }

    public Double getFinalPrice() {
        if (price == null) {
            return 0.0;
        }
        if (discountType == null) {
            return price;
        }
        return switch (discountType) {
            case "STUDENT" -> price * 0.90;
            case "SEASONAL" -> price * 0.80;
            default -> price;
        };
    }
}