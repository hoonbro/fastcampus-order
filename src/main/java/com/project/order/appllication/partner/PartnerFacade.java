package com.project.order.appllication.partner;

import com.project.order.domain.notification.NotificationService;
import com.project.order.domain.partner.PartnerCommand;
import com.project.order.domain.partner.PartnerInfo;
import com.project.order.domain.partner.PartnerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerFacade {

    private final PartnerService partnerService;
    private final NotificationService notificationService;

    public PartnerInfo registerPartner(PartnerCommand command){
        // 1. partnerService register
        var partnerInfo = partnerService.registerPartner(command);

        // 2. send email
        notificationService.sendEmail(partnerInfo.getEmail(), "title", "description");

        return partnerInfo;
    }
}
