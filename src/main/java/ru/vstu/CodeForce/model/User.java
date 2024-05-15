package ru.vstu.CodeForce.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name = "user_info")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String lastName;
    private String country;
    private long lastOnlineTimeSeconds;
    private String city;
    private long vkId;
    private int rating;
    private int friendOfCount;
    private String titlePhoto;
    private String handle;
    private String avatar;
    private String firstName;
    private int contribution;
    private String organization;
    private String rank;
    private int maxRating;
    private long registrationTimeSeconds;
    private String email;
    private String maxRank;
}
