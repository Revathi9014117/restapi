package com.example.demo.payload;

import java.util.List;

import org.springframework.stereotype.Service;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class mypayload {
	private String name;
	@Email
	@NotNull
	private String email;
	@Pattern(regexp ="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" )
	@Size(min = 6)
	private String password;
}