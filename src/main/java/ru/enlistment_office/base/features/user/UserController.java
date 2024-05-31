package ru.enlistment_office.base.features.user;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.enlistment_office.base.common.exceptions.ForbiddenException;
import ru.enlistment_office.base.common.security.AuthInfo;
import ru.enlistment_office.base.features.user.dto.AddAccountingParams;
import ru.enlistment_office.base.features.user.dto.UserDetailsDto;
import ru.enlistment_office.base.features.user.dto.UserShortDto;
import ru.enlistment_office.base.features.user.dto.passport.AddPassportParams;
import ru.enlistment_office.base.features.user.dto.placeStudy.AddPlaceStudyParams;
import ru.enlistment_office.base.features.user.dto.placeWork.AddPlaceWorkParams;
import ru.enlistment_office.base.features.user.mappers.UserDetailsMapper;
import ru.enlistment_office.base.features.user.mappers.UserShortMapper;
import ru.enlistment_office.base.features.user.security.dto.JwtAuthentication;
import ru.enlistment_office.base.features.user.security.dto.JwtRequestDto;
import ru.enlistment_office.base.features.user.security.dto.JwtResponseDto;

import java.util.List;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    private final UserDetailsMapper userDetailsMapper;
    private final UserShortMapper userShortMapper;

    private final AuthInfo authInfo;

    @GetMapping
    @SecurityRequirement(name = "bearerAuth")
    private List<UserShortDto> getAll(HttpServletRequest request) {

        if(!authInfo.hasIsAdmin(request))
            throw new ForbiddenException();

        return userShortMapper.toDto(userService.getAll());
    }

    @GetMapping("{id}")
    @SecurityRequirement(name = "bearerAuth")
    private UserDetailsDto getById(
            @PathVariable Integer id,
            HttpServletRequest request
    ) {
        if(!authInfo.hasIsAdmin(request))
            throw new ForbiddenException();

        return userDetailsMapper.toDto(userService.getById(id));
    }

    @GetMapping("info")
    @SecurityRequirement(name = "bearerAuth")
    private UserDetailsDto getById(
            HttpServletRequest request
    ) {
        JwtAuthentication authentication = authInfo.getAuthInfo(request);
        return userDetailsMapper.toDto(userService.getById(authentication.getId()));
    }

    @PostMapping("login")
    private JwtResponseDto login(@RequestBody JwtRequestDto dto) {
        return userService.login(dto);
    }

    @PostMapping
    @SecurityRequirement(name = "bearerAuth")
    private UserShortDto add(
        @RequestParam String email,
        @RequestParam String password,
        HttpServletRequest request
    ) {
        if(!authInfo.hasIsAdmin(request))
            throw new ForbiddenException();

        return userShortMapper.toDto(userService.add(email, password));
    }

    @PostMapping("{id}/accounting")
    @SecurityRequirement(name = "bearerAuth")
    private void addAccounting(
        @PathVariable Integer id,
        @RequestBody AddAccountingParams params,
        HttpServletRequest request
    ) {
        if(!authInfo.hasIsAdmin(request))
            throw new ForbiddenException();

        userService.addAccounting(id, params);
    }

    @PostMapping("accounting/{id}/work")
    @SecurityRequirement(name = "bearerAuth")
    private void addWork(
        @PathVariable Integer id,
        @RequestBody AddPlaceWorkParams params,
        HttpServletRequest request
    ) {
        if(!authInfo.hasIsAdmin(request))
            throw new ForbiddenException();

        userService.addWork(id, params);
    }

    @PostMapping("accounting/{id}/study")
    @SecurityRequirement(name = "bearerAuth")
    private void addWork(
            @PathVariable Integer id,
            @RequestBody AddPlaceStudyParams params,
            HttpServletRequest request
    ) {
        if(!authInfo.hasIsAdmin(request))
            throw new ForbiddenException();

        userService.addStudy(id, params);
    }

    @PostMapping("accounting/{id}/passport")
    @SecurityRequirement(name = "bearerAuth")
    private void addPassport(
            @PathVariable Integer id,
            @RequestBody AddPassportParams params,
            HttpServletRequest request
    ) {
        if(!authInfo.hasIsAdmin(request))
            throw new ForbiddenException();

        userService.addPassport(id, params);
    }
}
