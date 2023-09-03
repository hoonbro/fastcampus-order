package com.project.order.domain.partner;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class PartnerServiceImpl implements PartnerService{
    private final PartnerStore partnerStore;
    private final PartnerReader partnerReader;

    @Override
    @Transactional
    public PartnerInfo registerPartner(PartnerCommand command) {
        // 1. command -> initPartner
        var initPartner = command.toEntity();

        // 2. initPartner save to DB
        // 상세구현 infraStructure
        Partner partner = partnerStore.store(initPartner);

        // 3. Partner -> PartnerInfo and return
        return new PartnerInfo(partner);
    }

    @Override
    @Transactional
    public PartnerInfo getPartnerInfo(String partnerToken) {
        // 1. partnerToken -> Partner 조회
        Partner partner = partnerReader.getPartner(partnerToken);

        // 2. Partner -> PartnerInfo and return
        return new PartnerInfo((partner));
    }

    @Override
    @Transactional
    public PartnerInfo enablePartner(String partnerToken) {
        // 1. partnerToken -> Partner 조회
        Partner partner = partnerReader.getPartner(partnerToken);

        // 2. partner.enable()
        partner.enable();

        // 3. Partner -> PartnerInfo and return
        return new PartnerInfo((partner));
    }

    @Override
    @Transactional
    public PartnerInfo disablePartner(String partnerToken) {
        // 1. partnerToken -> Partner 조회
        Partner partner = partnerReader.getPartner(partnerToken);

        // 2. partner.disable()
        partner.disable();

        // 3. Partner -> PartnerInfo and return
        return new PartnerInfo((partner));
    }
}
