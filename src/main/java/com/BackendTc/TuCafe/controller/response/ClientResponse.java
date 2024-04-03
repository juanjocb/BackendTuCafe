package com.BackendTc.TuCafe.controller.response;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class ClientResponse {

    private String name;
    private String country;
    private String city;
    private String email;
    private String phone;
    private String password;
    private List<Byte> photo;

}
