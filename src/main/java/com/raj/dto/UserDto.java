package com.raj.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
    private Long id;
	
	@NotBlank(message = "Name Must Be There")
	private String farmerName;
	
	@NotBlank(message = "Village Name Must be there")
	private String village;
	
	@NotBlank(message = "Fertilizer Name Must be there")
	private String fertilizerType;
	
	@NotBlank(message = "Mobile Not be blank")
	@Pattern(regexp = "[0-9]{10}")
	private String mobile;
	
	@NotNull(message = "Count must be there")
	@Min(value = 0)
	@Max(value = 10)
	private Integer count;
	
	@NotNull(message = "Count must be there")
	@Email(message = "Plase put write Email")
    private String email;
	
	
	@NotNull(message = "Password must be there")
	private String password;
	
	
}
