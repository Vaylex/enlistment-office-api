package ru.enlistment_office.base.features.user.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;

public interface UserAccountingRepository extends JpaRepository<UserAccountingEntity, Integer> {}
