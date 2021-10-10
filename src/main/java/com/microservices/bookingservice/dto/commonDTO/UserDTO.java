package com.microservices.bookingservice.dto.commonDTO;

import com.microservices.bookingservice.domain.Authority;
import com.microservices.bookingservice.domain.UserEntity;
import com.microservices.bookingservice.dto.request.TicketDto;
import com.microservices.bookingservice.utils.ConstantUtils;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class UserDTO {
    private Long id;

    private List<TicketDto> tickets;

    @NotBlank(message = "Mobile is Mandatory")
    private String mobile;

    @Pattern(regexp = ConstantUtils.LOGIN_REGEX)
    @NotBlank(message = "Login can not be blank")
    @Size(min = 1, max = 50)
    private String login;


    @NotBlank(message = "Password can not be blank")
    @Size(min = 1, max = 50)
    private String password;

    @Size(max = 50)
    @NotBlank(message = "firstName can not be blank")
    private String firstName;

    @Size(max = 50)
    private String lastName;

    @Email
    @NotBlank(message = "Email can not be blank")
    @Size(min = 5, max = 254)
    private String email;

    private boolean activated = false;

    @Size(min = 2, max = 10)
    private String langKey;

    private String createdBy;

    private Instant createdDate;

    private String lastModifiedBy;

    private Instant lastModifiedDate;

    private Set<String> authorities;

}
