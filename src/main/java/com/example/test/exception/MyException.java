package com.example.test.exception;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MyException extends RuntimeException {

    private String code = "4000";


    private String message = "my exception";

    public MyException(String message) {
        super(message);
        this.message = message;
        System.out.println();
    }
}
