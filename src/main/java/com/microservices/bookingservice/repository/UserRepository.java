package com.microservices.bookingservice.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import com.microservices.bookingservice.domain.UserEntity;

import java.time.Instant;
import java.util.List;
import java.util.Optional;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

	boolean existsByMobile(String mobile);

	@Transactional
	void deleteByMobile(String mobile);

	Optional<UserEntity> findOneByActivationKey(String activationKey);

	List<UserEntity> findAllByActivatedIsFalseAndActivationKeyIsNotNullAndCreatedDateBefore(Instant dateTime);

	Optional<UserEntity> findOneByResetKey(String resetKey);

	Optional<UserEntity> findOneByEmailIgnoreCase(String email);

	Optional<UserEntity> findOneByLogin(String login);

	@EntityGraph(attributePaths = "authorities")
	Optional<UserEntity> findOneWithAuthoritiesByLogin(String login);

	@EntityGraph(attributePaths = "authorities")
	Optional<UserEntity> findOneWithAuthoritiesByEmailIgnoreCase(String email);

	Page<UserEntity> findAllByLoginNot(Pageable pageable, String login);
}