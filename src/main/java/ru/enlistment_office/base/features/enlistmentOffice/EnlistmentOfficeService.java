package ru.enlistment_office.base.features.enlistmentOffice;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import ru.enlistment_office.base.features.enlistmentOffice.dto.params.CreateEnlistmentOfficeParams;
import ru.enlistment_office.base.features.enlistmentOffice.entities.EnlistmentOfficeEntity;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EnlistmentOfficeService {

    private final EnlistmentOfficeRepository enlistmentOfficeRepository;

    @Transactional(readOnly = true)
    public List<EnlistmentOfficeEntity> getAll() {
        return enlistmentOfficeRepository.findAll();
    }

    @Transactional(readOnly = true)
    public EnlistmentOfficeEntity getById(Integer id) {
        return enlistmentOfficeRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("enlistment office not found"));
    }

    @Transactional
    public EnlistmentOfficeEntity create(CreateEnlistmentOfficeParams params) {
        EnlistmentOfficeEntity enlistmentOffice = new EnlistmentOfficeEntity();

        enlistmentOffice.setCity(params.city());
        enlistmentOffice.setStreet(params.street());
        enlistmentOffice.setHouseNumber(params.houseNumber());

        return enlistmentOfficeRepository.save(enlistmentOffice);
    }
}
