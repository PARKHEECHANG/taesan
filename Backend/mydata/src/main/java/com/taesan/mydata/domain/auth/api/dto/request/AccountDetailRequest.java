package com.taesan.mydata.domain.auth.api.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountDetailRequest {

    @JsonProperty("org_code")
    private String orgCode;

    @JsonProperty("account_num")
    private String accountNum;

    @JsonProperty("seqno")
    private Integer seqno;

    @JsonProperty("search_timestamp")
    private Long searchTimestamp;

}
