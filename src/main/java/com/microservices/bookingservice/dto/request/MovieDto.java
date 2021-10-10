/**
 * 
 */
package com.microservices.bookingservice.dto.request;

import java.time.LocalDate;

import com.microservices.bookingservice.enums.CertificateType;
import com.microservices.bookingservice.enums.MovieLanguage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class MovieDto {

	private long id;

	private String name;

	private MovieLanguage language;

	private CertificateType certificateType;

	private LocalDate releaseDate;

}