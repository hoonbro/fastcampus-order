package com.project.order.infrastructure.partner;

import com.project.order.common.exception.EntityNotFoundException;
import com.project.order.domain.partner.Partner;
import com.project.order.domain.partner.PartnerReader;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PartnerReadImpl implements PartnerReader {
    private final PartnerRepository partnerRepository;

    @Override
    public Partner getPartner(String partnerToken) {
        return partnerRepository.findByPartnerToken(partnerToken)
                .orElseThrow(EntityNotFoundException::new);
    }
}
