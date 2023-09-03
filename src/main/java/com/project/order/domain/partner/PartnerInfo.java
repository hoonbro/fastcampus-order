package com.project.order.domain.partner;

import lombok.Builder;
import lombok.Getter;

/**
 *
 * PartnerInfo
 *
 * @author : jihoon
 * @date : 2023/09/03
 * @version 1.0.0
 * @description : Partner를 front-end에 return 하는 클래스
 *
**/
@Getter
public class PartnerInfo {
    private final Long id;
    private final String partnerToken;
    private final String partnerName;
    private final String businessNo;
    private final String email;
    private final Partner.Status status;

    @Builder
    public PartnerInfo(Partner partner) {
        this.id = partner.getId();
        this.partnerToken = partner.getPartnerToken();
        this.partnerName = partner.getPartnerName();
        this.businessNo = partner.getBusinessNo();
        this.email = partner.getEmail();
        this.status = partner.getStatus();
    }
}
