package com.intute.profile.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {

    private Date timeSramp;
    private String message;
    private String Details;


}
