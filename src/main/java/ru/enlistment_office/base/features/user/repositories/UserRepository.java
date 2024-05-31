package ru.enlistment_office.base.features.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.enlistment_office.base.features.user.entities.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByEmail(String email);
}
