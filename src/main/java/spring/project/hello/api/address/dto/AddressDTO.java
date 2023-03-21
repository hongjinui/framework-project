package spring.project.hello.api.address.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    private Long id;
    private String address;
    private String name;
    private String phone;
    private String email;
    private char useYn;
}
