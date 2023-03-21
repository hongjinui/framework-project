package spring.project.hello.api.address.vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import spring.project.hello.domain.entity.Address;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class AddressVO {

    private Long id;
    private String address;
    private String name;
    private String phone;
    private String email;

//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;

    @Builder
    public AddressVO(Address address){
        this.id = address.getId();
        this.address = address.getAddress();
        this.name = address.getName();
        this.phone = address.getPhone();
        this.email = address.getEmail();
    }


}
