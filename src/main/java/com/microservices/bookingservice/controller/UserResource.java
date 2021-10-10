package com.microservices.bookingservice.controller;


import com.microservices.bookingservice.domain.UserEntity;
import com.microservices.bookingservice.dto.commonDTO.UserDTO;
import com.microservices.bookingservice.dto.response.CommonResponse;
import com.microservices.bookingservice.enums.ErrorCodeAndDescription;
import com.microservices.bookingservice.exception.errors.EmailAlreadyUsedException;
import com.microservices.bookingservice.exception.errors.LoginAlreadyUsedException;
import com.microservices.bookingservice.repository.UserRepository;
import com.microservices.bookingservice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import javax.validation.Valid;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


@RestController

@RequestMapping("/api")
public class UserResource {
    private static final List<String> ALLOWED_ORDERED_PROPERTIES = Collections.unmodifiableList(Arrays.asList("id", "login", "firstName", "lastName", "email", "activated", "langKey"));

    private final Logger log = LoggerFactory.getLogger(UserResource.class);

     private final UserService userService;

    private final UserRepository userRepository;

    public UserResource(UserService userService, UserRepository userRepository) {
        this.userService = userService;
        this.userRepository = userRepository;

    }

    /**
     * {@code POST  /users}  : Creates a new user.
     * <p>
     * Creates a new user if the login and email are not already used, and sends an
     * mail with an activation link.
     * The user needs to be activated on creation.
     *
     * @param userDTO the user to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new user, or with status {@code 400 (Bad Request)} if the login or email is already in use.
     * @throws URISyntaxException       if the Location URI syntax is incorrect.
     */
    @PostMapping("/createUser")
    public CommonResponse createUser(@Valid @RequestBody UserDTO userDTO) throws URISyntaxException {
        log.debug("REST request to save User : {}", userDTO);

        if (userRepository.findOneByLogin(userDTO.getLogin().toLowerCase()).isPresent()) {
            throw new LoginAlreadyUsedException();
        }  else if (userRepository.findOneByEmailIgnoreCase(userDTO.getEmail()).isPresent()) {
            throw new EmailAlreadyUsedException();
        }else {
            UserDTO newUser = userService.addUser(userDTO);
            return new CommonResponse(ErrorCodeAndDescription.code_0.getCode(), ErrorCodeAndDescription.code_0.getDescription());
        }
    }

    /**
     * {@code PUT /users} : Updates an existing User.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated user.

    @PutMapping("/updateUser")
    public CommonResponse updateUser(@Valid @RequestBody UserDTO userDTO) {
        log.debug("REST request to update User : {}", userDTO);
        Optional<UserEntity> existingUser = userRepository.findOneByEmailIgnoreCase(userDTO.getEmail());
        if (existingUser.isPresent() && (!existingUser.get().getId().equals(userDTO.getId()))) {
            throw new EmailAlreadyUsedException();
        }
        existingUser = userRepository.findOneByLogin(userDTO.getLogin().toLowerCase());
        if (existingUser.isPresent() && (!existingUser.get().getId().equals(userDTO.getId()))) {
            throw new LoginAlreadyUsedException();
        }
        Optional<UserDTO> updatedUser = userService.updateUser(userDTO);

         return new ARCommonResponse(ErrorCodeAndDescription.code_0.getCode(), ErrorCodeAndDescription.code_0.getDescription());
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDTO>> getAllUsers() {
        Pageable pageable = PageRequest.of(Integer.valueOf(0),
                Integer.valueOf(100), Sort.unsorted());

        final Page<UserDTO> page = userService.getAllManagedUsers(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    private boolean onlyContainsAllowedProperties(Pageable pageable) {
        return pageable.getSort().stream().map(Sort.Order::getProperty).allMatch(ALLOWED_ORDERED_PROPERTIES::contains);
    }


    /**
     * {@code DELETE /users/:login} : delete the "login" User.
     *
     * @param login the login of the user to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/deleteUsers/{login}")
    public CommonResponse deleteUser(@PathVariable String login) {
        Optional<UserEntity> existingUser = userRepository.findOneByLogin(login);
        if(!existingUser.isPresent()){
          return  new CommonResponse(ErrorCodeAndDescription.code_0.getCode(),"No Such User Exist");
        }
        log.debug("REST request to delete User: {}", login);
        //userService.deleteUser(login);
        return new CommonResponse(ErrorCodeAndDescription.code_0.getCode(), ErrorCodeAndDescription.code_0.getDescription());
    }
}
