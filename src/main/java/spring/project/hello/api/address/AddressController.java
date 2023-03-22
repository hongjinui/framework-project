package spring.project.hello.api.address;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.project.hello.api.address.dto.AddressDTO;
import spring.project.hello.api.address.service.AddressService;
import spring.project.hello.common.ApiResponseVO;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/address-book")
public class AddressController {

    private final AddressService addressService;

    /**
     * @description 주소 조회
     * @param httpServletRequest
     * @param id
     * @return ResponseEntity
     */
    @GetMapping("{id}")
    public ResponseEntity<?> getAddress(HttpServletRequest httpServletRequest, @PathVariable("id") Long id) {
        ApiResponseVO responseData = addressService.getAddress(id);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    /***
     * @description 주소 리스트 조회
     * @param httpServletRequest
     * @return ResponseEntity
     */
    @GetMapping("list")
    public ResponseEntity<?> getAddressList(HttpServletRequest httpServletRequest) {
        ApiResponseVO responseData = addressService.getAddressList();
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    /***
     * @description 주소 저장
     * @param httpServletRequest
     * @param addressDTO
     * @return ResponseEntity
     */
    @PostMapping("address")
    public ResponseEntity<?> insertAddress(HttpServletRequest httpServletRequest, @RequestBody AddressDTO addressDTO) {
        ApiResponseVO responseData = addressService.insertAddress(addressDTO);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    /***
     * @description 주소 수정
     * @param httpServletRequest
     * @param addressDTO
     * @return
     */
    @PutMapping("address")
    public ResponseEntity<?> updateAddress(HttpServletRequest httpServletRequest, @RequestBody AddressDTO addressDTO) {
        ApiResponseVO responseData = addressService.updateAddress(addressDTO);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    /***
     * @description 주소 정보 사용 유무
     * @param httpServletRequest
     * @param addressDTO
     * @return
     */
    @PutMapping("use-yn")
    public ResponseEntity<?> updateUseYn(HttpServletRequest httpServletRequest, @RequestBody AddressDTO addressDTO) {
        ApiResponseVO responseData = addressService.updateUseYn(addressDTO);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

    /***
     * @description 주소 물리적 삭제
     * @param httpServletRequest
     * @param id
     * @return
     */
    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteAddress(HttpServletRequest httpServletRequest, @PathVariable("id") Long id) {
        ApiResponseVO responseData = addressService.deleteAddress(id);
        return new ResponseEntity<>(responseData, HttpStatus.OK);
    }

}
