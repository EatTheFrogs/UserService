package com.eatthefrog.UserService.model.okta;

import com.eatthefrog.UserService.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OktaRequestEventTarget extends BaseModel {

    @Serial
    private static final long serialVersionUID = 3241528388599110871L;

    private String id;
    private String type;
    private String alternateId;
    private String displayName;
}
