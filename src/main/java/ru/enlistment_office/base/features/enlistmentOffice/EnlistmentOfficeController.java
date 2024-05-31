package ru.enlistment_office.base.features.enlistmentOffice;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.enlistment_office.base.common.exceptions.ForbiddenException;
import ru.enlistment_office.base.common.security.AuthInfo;
import ru.enlistment_office.base.features.enlistmentOffice.dto.EnlistmentOfficeDto;
import ru.enlistment_office.base.features.enlistmentOffice.dto.params.CreateEnlistmentOfficeParams;
import ru.enlistment_office.base.features.enlistmentOffice.mappers.EnlistmentOfficeMapper;

import java.util.List;

@RestController
@RequestMapping("/enlistment-offices")
@RequiredArgsConstructor
public class EnlistmentOfficeController {

    private final EnlistmentOfficeService enlistmentOfficeService;

    private final EnlistmentOfficeMapper enlistmentOfficeMapper;

    private final AuthInfo authInfo;

    @GetMapping
    private List<EnlistmentOfficeDto> getAll() {
        return enlistmentOfficeMapper.toDto(enlistmentOfficeService.getAll());
    }

    @PostMapping
    @SecurityRequirement(name = "bearerAuth")
    private EnlistmentOfficeDto create(
            @RequestBody CreateEnlistmentOfficeParams params,
            HttpServletRequest request
    ) {

        if(!authInfo.hasIsAdmin(request))
            throw new ForbiddenException();

        return enlistmentOfficeMapper.toDto(enlistmentOfficeService.create(params));
    }
}
