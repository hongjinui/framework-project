package spring.project.hello.domain.entity;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import spring.project.hello.api.address.dto.AddressDTO;
import spring.project.hello.domain.common.BaseEntity;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TB_ADDRESS_BOOK")
@Getter
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ADD_ID")
    private Long id;

    @Column(name = "ADDRESS")
    private String address;

    @Column(name = "NAME")
    private String name;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "USE_YN", columnDefinition = "char(1) default 'Y'")
    private char useYn;

    @Builder
    public Address(AddressDTO addressDTO) {
//        this.id = addressDTO.getId();
        this.address = addressDTO.getAddress();
        this.name = addressDTO.getName();
        this.phone = addressDTO.getPhone();
        this.email = addressDTO.getEmail();
        this.useYn = addressDTO.getUseYn();
    }

    public void updateAddress(String address) {
        this.address = address;
    }

    public void updateName(String name) {
        this.name = name;
    }

    public void updatePhone(String phone) {
        this.phone = phone;
    }

    public void updateEmail(String email) {
        this.email = email;
    }
    public void updateUseYn(char useYn) {
        this.useYn = useYn;
    }


}
