package com.eatthefrog.UserService.model.okta;

import com.eatthefrog.UserService.model.BaseModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OktaUser extends BaseModel {

    @Serial
    private static final long serialVersionUID = -9157295695416967872L;

    private String oktaUUID;
    private String email;
    private String name;
}