package com.paddle.model;

import lombok.*;

@Getter @Setter @Builder @NoArgsConstructor @AllArgsConstructor public class Customer extends PaddleBase {

    private String id;
    private String name;
    private String email;
    private String locale;

}
