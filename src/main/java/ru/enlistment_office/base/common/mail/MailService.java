package ru.enlistment_office.base.common.mail;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import ru.enlistment_office.base.features.user.entities.accounting.UserAccountingEntity;

@Service
@RequiredArgsConstructor
public class MailService {

    private final JavaMailSender mailSender;

    public void sendEmail(UserAccountingEntity accounting, MailType type) {
        switch (type) {
            case ENLISTMENT_SUMMON_DOCUMENT -> enlistmentSummonDocument(accounting);
        }
    }

    @SneakyThrows
    private void enlistmentSummonDocument(UserAccountingEntity accounting) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setSubject("Повестка военкомат");
        message.setFrom("pgk.danila@yandex.ru");
        message.setTo("dan.bel.89@bk.ru");

        String name = "Гражданину " + accounting.getPassport().getFirst_name() + " " +
                accounting.getPassport().getLast_name() + " " + accounting.getPassport().getMiddle_name();
        String address = "необходимо явиться военкомат по адресу Г. " + accounting.getEnlistmentOffice().getCity() + " ул. " + accounting.getEnlistmentOffice().getStreet()
                + " д. " + accounting.getEnlistmentOffice().getHouseNumber();
        String emailContent = name + ", " + address;

        message.setText(emailContent);
        mailSender.send(message);
    }
}
