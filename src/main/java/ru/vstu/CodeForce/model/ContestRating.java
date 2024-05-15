package ru.vstu.CodeForce.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@JsonIgnoreProperties
public class ContestRating {
    private int contestId;
    private String contestName;
    private String handle;
    private int rank;
    private long ratingUpdateTimeSeconds;
    private int oldRating;
    private int newRating;
}
