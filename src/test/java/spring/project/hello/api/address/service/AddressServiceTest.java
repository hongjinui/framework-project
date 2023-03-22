package spring.project.hello.api.address.service;

import jakarta.transaction.Transactional;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import spring.project.hello.api.address.dto.AddressDTO;
import spring.project.hello.api.address.repository.AddressRepository;
import spring.project.hello.api.address.vo.AddressVO;
import spring.project.hello.common.ApiResponseVO;
import spring.project.hello.domain.entity.Address;

import java.util.Optional;

import static org.mockito.Mockito.when;

@SpringBootTest
class AddressServiceTest {

    @InjectMocks
    AddressService addressService;
    @Mock
    AddressRepository addressRepository;

    @Test
    @DisplayName("주소 조회")
    @Transactional
    void find() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddress("address");
        addressDTO.setName("name");
        addressDTO.setPhone("phone");
        addressDTO.setEmail("email");

        Address address = Address.builder().addressDTO(addressDTO).build();
        when(addressRepository.findById(1L)).thenReturn(Optional.of(address)); // findById mock

        ApiResponseVO apiResponseVO = addressService.getAddress(1L);
        AddressVO data = (AddressVO) apiResponseVO.getData();

        Assertions.assertThat(data.getAddress()).isEqualTo("address");
    }

    @Test
    @DisplayName("주소 조회 에러")
    @Transactional
    void notFound() {
        AddressDTO addressDTO = new AddressDTO();
        addressDTO.setAddress("address");
        addressDTO.setName("name");
        addressDTO.setPhone("phone");
        addressDTO.setEmail("email");

//        Address address = Address.builder().addressDTO(addressDTO).build();
        when(addressRepository.findById(1L)).thenReturn(Optional.empty()); // findById mock

        ApiResponseVO apiResponseVO = addressService.getAddress(1L);
        AddressVO data = (AddressVO) apiResponseVO.getData();

        Assertions.assertThat(data).isSameAs(null);
    }

    @Test
    @DisplayName("주소 저장")
    @Transactional
    void save() {
        AddressDTO addressDTOParam = new AddressDTO();
        addressDTOParam.setAddress("address param");
        addressDTOParam.setName("name param");
        addressDTOParam.setPhone("phone param");
        addressDTOParam.setEmail("email param");

        ApiResponseVO apiResponseVO = addressService.insertAddress(addressDTOParam);

        Assertions.assertThat(apiResponseVO.getStatus()).isEqualTo(200);
    }


}