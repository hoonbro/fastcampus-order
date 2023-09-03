package com.project.order.interfaces;

import com.project.order.appllication.partner.PartnerFacade;
import com.project.order.common.response.CommonResponse;
import com.project.order.domain.partner.PartnerCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/partners")
public class PartnerApiController {
    private final PartnerFacade partnerFacade;

    @PostMapping
    public CommonResponse registerPartner(PartnerDto.RegisterRequest request){
        // 1. 외부에서 전달된 파라미터 (dto) -> Command, Criteria convert
        var command = request.toCommand();

        // 2. facade 호출 .. PartnerInfo
        var partnerInfo = partnerFacade.registerPartner(command);

        // 3. PartnerInfo -> CommonResponse convert and return
        var response = new PartnerDto.RegisterResponse(partnerInfo);

        return CommonResponse.success(response);
    }
}
