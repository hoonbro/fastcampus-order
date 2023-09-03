package com.project.order.domain.partner;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


/**
 *
 * PartnerCommand
 *
 * @author : jihoon
 * @date : 2023/09/03
 * @version 1.0.0
 * @description : Partner를 front-end 요구시 받는 클래스
 *
**/
@Getter
@Builder
@ToString
public class PartnerCommand {

    private final String partnerName;
    private final String businessNo;
    private final String email;

    public Partner toEntity(){
        return Partner.builder()
                .partnerName(partnerName)
                .businessNo(businessNo)
                .email(email)
                .build();
    }
}
