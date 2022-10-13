package com.eatthefrog.UserService.model.okta;

import com.eatthefrog.UserService.model.BaseModel;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.io.Serial;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OktaRequestEvent extends BaseModel {

    @Serial
    private static final long serialVersionUID = 3809344245803083892L;

    private List<OktaRequestEventTarget> target;
}
