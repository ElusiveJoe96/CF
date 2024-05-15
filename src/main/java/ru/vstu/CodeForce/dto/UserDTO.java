package ru.vstu.CodeForce.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDTO {
    private UserDTO(){}
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
