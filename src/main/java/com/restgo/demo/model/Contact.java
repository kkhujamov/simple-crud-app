package com.restgo.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contact {
    private Integer id;
    @NotNull
    private String name;
    private String phoneNumber;
}
