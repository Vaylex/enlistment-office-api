package ru.enlistment_office.base.features.enlistmentSummonDocument;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.enlistment_office.base.common.exceptions.ForbiddenException;
import ru.enlistment_office.base.common.security.AuthInfo;
import ru.enlistment_office.base.features.enlistmentSummonDocument.entities.EnlistmentSummonDocumentType;

@RestController
@RequestMapping("enlistment-summon-document")
@RequiredArgsConstructor
public class EnlistmentSummonDocumentController {

    private final EnlistmentSummonDocumentService enlistmentSummonDocumentService;

    private final AuthInfo authInfo;

    @PostMapping
    @SecurityRequirement(name = "bearerAuth")
    private void add(
            @RequestParam(name = "account_id") Integer accountId,
            EnlistmentSummonDocumentType type,
            HttpServletRequest request
    ) {
        if(!authInfo.hasIsAdmin(request))
            throw new ForbiddenException();

        enlistmentSummonDocumentService.add(accountId, type);
    }
}
