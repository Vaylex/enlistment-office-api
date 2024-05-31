package ru.enlistment_office.base.features.user;

import jakarta.security.auth.message.AuthException;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.webjars.NotFoundException;
import ru.enlistment_office.base.common.exceptions.BadRequestException;
import ru.enlistment_office.base.features.enlistmentOffice.EnlistmentOfficeService;
import ru.enlistment_office.base.features.enlistmentOffice.entities.EnlistmentOfficeEntity;
import ru.enlistment_office.base.features.user.dto.AddAccountingParams;
import ru.enlistment_office.base.features.user.dto.passport.AddPassportParams;
import ru.enlistment_office.base.features.user.dto.placeStudy.AddPlaceStudyParams;
import ru.enlistment_office.base.features.user.dto.placeWork.AddPlaceWorkParams;
import ru.enlistment_office.base.features.user.entities.UserEntity;
import ru.enlistment_office.base.features.user.entities.UserRole;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;
import ru.enlistment_office.base.features.user.entities.passport.PassportEntity;
import ru.enlistment_office.base.features.user.entities.placeStudy.PlaceStudyEntity;
import ru.enlistment_office.base.features.user.entities.placeWork.PlaceWorkEntity;
import ru.enlistment_office.base.features.user.repositories.UserAccountingRepository;
import ru.enlistment_office.base.features.user.repositories.UserRepository;
import ru.enlistment_office.base.features.user.security.JwtProvider;
import ru.enlistment_office.base.features.user.security.dto.JwtRequestDto;
import ru.enlistment_office.base.features.user.security.dto.JwtResponseDto;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserAccountingRepository userAccountingRepository;

    private final JwtProvider jwtProvider;

    private final EnlistmentOfficeService enlistmentOfficeService;

    @Transactional(readOnly = true)
    public List<UserEntity> getAll() {
        return userRepository.findAll();
    }

    @SneakyThrows
    @Transactional(readOnly = true)
    public UserEntity getById(Integer id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User not found"));
    }

    @Transactional(readOnly = true)
    public UserAccountingEntity getAccountingById(Integer id) {
        return userAccountingRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("User accounting not found"));
    }

    @SneakyThrows
    @Transactional
    public UserEntity add(String email, String password) {
        if(userRepository.findByEmail(email).isPresent())
            throw new Exception("Такая почта уже зарегистрирована");

        UserEntity user = new UserEntity();
        HashSet<UserRole> roles = new HashSet<>();
        roles.add(UserRole.BASE_USER);

        user.setEmail(email);
        user.setPassword(password);
        user.setRoles(roles);

        return userRepository.save(user);
    }

    @Transactional
    public void addAccounting(Integer userId, AddAccountingParams params) {
        UserEntity user = getById(userId);
        EnlistmentOfficeEntity enlistmentOffice = enlistmentOfficeService.getById(params.enlistmentOfficeId());
        UserAccountingEntity accounting = new UserAccountingEntity();

        accounting.setId(user.getId());
        accounting.setUser(user);
        accounting.setStatus(params.status());
        accounting.setMaritalStatus(params.maritalStatus());
        accounting.setPhoneNumber(params.phoneNumber());
        accounting.setPhoneNumberCode(params.phoneNumberCode());
        accounting.setEnlistmentOffice(enlistmentOffice);

        userAccountingRepository.save(accounting);
    }

    @SneakyThrows
    @Transactional
    public void addWork(Integer accountingId, AddPlaceWorkParams params) {
        UserAccountingEntity accounting = getAccountingById(accountingId);

        PlaceWorkEntity placeWork = new PlaceWorkEntity();
        placeWork.setId(accountingId);
        placeWork.setAccounting(accounting);
        placeWork.setOrganization(params.organization());
        placeWork.setPosition(params.position());
        placeWork.setPostponement(params.postponement());

        accounting.setWork(placeWork);

        userAccountingRepository.save(accounting);
    }

    @Transactional
    public void addStudy(Integer accountingId, AddPlaceStudyParams params) {
        UserAccountingEntity accounting = getAccountingById(accountingId);

        PlaceStudyEntity study = new PlaceStudyEntity();
        study.setId(accountingId);
        study.setAccounting(accounting);
        study.setName(params.name());
        study.setCurrentCourse(params.currentCourse());
        study.setPostponement(params.postponement());
        study.setStartDate(params.startDate());
        study.setEndDate(params.endDate());

        accounting.setStudy(study);

        userAccountingRepository.save(accounting);
    }

    @Transactional
    public void addPassport(Integer accountingId, AddPassportParams params) {
        UserAccountingEntity accounting = getAccountingById(accountingId);

        PassportEntity passport = new PassportEntity();
        passport.setId(accountingId);
        passport.setAccounting(accounting);

        passport.setIssued(params.getIssued());
        passport.setDateIssue(params.getDateIssue());
        passport.setSeries(params.getSeries());
        passport.setNumber(params.getNumber());
        passport.setFirst_name(params.getFirst_name());
        passport.setLast_name(params.getLast_name());
        passport.setMiddle_name(params.getMiddle_name());
        passport.setGender(params.getGender());
        passport.setBirthday(params.getBirthday());
        passport.setAddressCity(params.getAddressCity());
        passport.setAddressStreet(params.getAddressStreet());
        passport.setAddressHouseNumber(params.getAddressHouseNumber());
        passport.setAddressApartmentNumber(params.getAddressApartmentNumber());

        accounting.setPassport(passport);

        userAccountingRepository.save(accounting);
    }

    @SneakyThrows
    @Transactional(readOnly = true)
    public JwtResponseDto login(@NonNull JwtRequestDto authRequest) {
        final UserEntity user = userRepository.findByEmail(authRequest.email())
                .orElseThrow(() -> new BadRequestException("Пользователь не найден"));
        if (user.getPassword().equals(authRequest.password())) {
            final String accessToken = jwtProvider.generateAccessToken(user);
            return new JwtResponseDto(user.getId(), user.getRoles(), accessToken);
        } else {
            throw new BadRequestException("Неправильный пароль");
        }
    }
}
