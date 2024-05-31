package ru.enlistment_office.base.features.enlistmentOffice;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.enlistment_office.base.features.enlistmentOffice.entities.EnlistmentOfficeEntity;

public interface EnlistmentOfficeRepository extends JpaRepository<EnlistmentOfficeEntity, Integer> {}
