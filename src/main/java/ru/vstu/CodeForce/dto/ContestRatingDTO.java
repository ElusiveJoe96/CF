package ru.vstu.CodeForce.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class ContestRatingDTO {
    private int contestId;
    private String contestName;
    private String handle;
    private int rank;
    private String ratingUpdateTimeSeconds;
    private int oldRating;
    private int newRating;

    public static String convertUnixTimestamp(long unixTimestamp) {
        LocalDateTime dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(unixTimestamp), ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy. HH:mm");
        return dateTime.format(formatter);

    }
}
