package spring.project.hello.api.address.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import spring.project.hello.api.address.dto.AddressDTO;
import spring.project.hello.api.address.repository.AddressRepository;
import spring.project.hello.api.address.vo.AddressVO;
import spring.project.hello.common.CustomApiCode;
import spring.project.hello.common.ApiResponseVO;
import spring.project.hello.common.ResponseData;
import spring.project.hello.domain.entity.Address;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;

    @Transactional
    public ApiResponseVO getAddress(Long id) {

        ApiResponseVO responseData = null;

        try {

            Optional<Address> addressOptional = addressRepository.findById(id);
            if (addressOptional.isEmpty()) throw new Exception(); // null check

            AddressVO addressVO = AddressVO.builder() // entity to dto
                    .address(addressOptional.get())
                    .build();

            responseData = ResponseData.apiResponse(HttpStatus.OK, addressVO, CustomApiCode.DATA_OK);

        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, CustomApiCode.ERROR);
        }
        return responseData;
    }


    @Transactional
    public ApiResponseVO getAddressList() {

        ApiResponseVO responseData = null;
        try {

            List<Address> entityList = addressRepository.findAllByUseYn('Y');
            List<AddressVO> list = entityList.stream().map(AddressVO::new).toList(); // entity list to vo list

            responseData = ResponseData.apiResponse(HttpStatus.OK, list, CustomApiCode.DATA_OK);

        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, CustomApiCode.ERROR);
        }
        return responseData;

    }

    @Transactional
    public ApiResponseVO insertAddress(AddressDTO addressDTO) {
        ApiResponseVO responseData = null;
        try {

            addressDTO.setUseYn('Y');

            Address addressEntity = Address.builder() // dto to entity
                    .addressDTO(addressDTO)
                    .build();

            addressRepository.save(addressEntity);

            responseData = ResponseData.apiResponse(HttpStatus.OK, null, CustomApiCode.DATA_OK);

        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, CustomApiCode.ERROR);
        }
        return responseData;
    }

    @Transactional
    public ApiResponseVO updateAddress(AddressDTO addressDTO) {
        ApiResponseVO responseData = null;
        try {

            // entity 조회 후 값 변경
            Optional<Address> addressOptional = addressRepository.findById(addressDTO.getId());
            if (addressOptional.isEmpty()) throw new Exception(); // null check
            Address addressEntity = addressOptional.get();

            addressEntity.updateAddress(addressDTO.getAddress());
            addressEntity.updateName(addressDTO.getName());
            addressEntity.updatePhone(addressDTO.getPhone());
            addressEntity.updateEmail(addressDTO.getEmail());

            responseData = ResponseData.apiResponse(HttpStatus.OK, null, CustomApiCode.DATA_OK);

        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, CustomApiCode.ERROR);
        }
        return responseData;
    }

    @Transactional
    public ApiResponseVO updateUseYn(AddressDTO addressDTO) {

        ApiResponseVO responseData = null;
        try {

            Optional<Address> addressOptional = addressRepository.findById(addressDTO.getId());
            if (addressOptional.isEmpty()) throw new Exception(); // null check
            Address addressEntity = addressOptional.get();

            addressEntity.updateUseYn(addressDTO.getUseYn());

            responseData = ResponseData.apiResponse(HttpStatus.OK, null, CustomApiCode.DATA_OK);

        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, CustomApiCode.ERROR);
        }
        return responseData;

    }

    @Transactional
    public ApiResponseVO deleteAddress(Long id) {

        ApiResponseVO responseData = null;
        try {

            addressRepository.deleteById(id);

            responseData = ResponseData.apiResponse(HttpStatus.OK, null, CustomApiCode.DATA_OK);

        } catch (Exception e) {
            responseData = ResponseData.apiResponse(HttpStatus.INTERNAL_SERVER_ERROR, null, CustomApiCode.ERROR);
        }
        return responseData;

    }


}
