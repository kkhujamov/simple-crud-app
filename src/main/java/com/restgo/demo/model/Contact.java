package com.restgo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private Integer id;
    @NotBlank
    @Size(min = 5, max = 20, message = "Name should be between 5 and 20")
    private String name;
    @NotBlank
    @Size(min = 12, max = 12, message = "The number should be in this format : 998*********")
    private String phoneNumber;
}
