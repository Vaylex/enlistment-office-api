package ru.enlistment_office.base.features.enlistmentSummonDocument;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.enlistment_office.base.common.mail.MailService;
import ru.enlistment_office.base.common.mail.MailType;
import ru.enlistment_office.base.features.enlistmentSummonDocument.entities.EnlistmentSummonDocumentEntity;
import ru.enlistment_office.base.features.enlistmentSummonDocument.entities.EnlistmentSummonDocumentType;
import ru.enlistment_office.base.features.user.UserService;
import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class EnlistmentSummonDocumentService {

    private final EnlistmentSummonDocumentRepository enlistmentSummonDocumentRepository;

    private final MailService mailService;

    private final UserService userService;

    @Transactional
    public EnlistmentSummonDocumentEntity add(Integer accountId, EnlistmentSummonDocumentType type) {
        UserAccountingEntity account = userService.getAccountingById(accountId);
        LocalDate sendDate = LocalDate.now();

        EnlistmentSummonDocumentEntity enlistmentSummonDocument = new EnlistmentSummonDocumentEntity();
        enlistmentSummonDocument.setType(type);
        enlistmentSummonDocument.setSendDate(sendDate);
        enlistmentSummonDocument.setSendDate(sendDate);
        enlistmentSummonDocument.setAccounting(account);

        mailService.sendEmail(account, MailType.ENLISTMENT_SUMMON_DOCUMENT);

        return enlistmentSummonDocumentRepository.save(enlistmentSummonDocument);
    }
}
