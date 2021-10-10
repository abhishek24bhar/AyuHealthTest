/**
 * 
 */
package com.microservices.bookingservice.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.microservices.bookingservice.utils.ConstantUtils;
import lombok.*;
import org.hibernate.annotations.BatchSize;


@Getter
@Setter
@Entity
@Data
@Table(name = "users")
@NoArgsConstructor
@Builder
@AllArgsConstructor
@ToString
public class UserEntity extends AbstractAuditingEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull
	@Pattern(regexp = ConstantUtils.LOGIN_REGEX)
	@Size(min = 1, max = 50)
	@Column(length = 50, unique = true, nullable = false)
	private String login;

	@JsonIgnore
	@NotNull
	@Column(name = "password_hash", length = 60, nullable = false)
	private String password;

	@Size(max = 50)
	@Column(name = "first_name", length = 50)
	private String firstName;

	@Size(max = 50)
	@Column(name = "last_name", length = 50)
	private String lastName;

	@Email
	@Size(min = 5, max = 254)
	@Column(length = 254, unique = true)
	private String email;

	@NotNull
	@Column(nullable = false)
	private boolean activated = false;

	@Column(name = "mobile", nullable = false)
	private String mobile;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<TicketEntity> ticketEntities;

	@JsonIgnore
	@ManyToMany
	@JoinTable(
			name = "ar_user_authority",
			joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
			inverseJoinColumns = {@JoinColumn(name = "authority_name", referencedColumnName = "name")})
	@BatchSize(size = 20)
	private Set<Authority> authorities = new HashSet<>();
}