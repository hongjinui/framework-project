package spring.project.hello.api.address.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import spring.project.hello.domain.entity.Address;

import java.util.List;
import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address,Long> {

    List<Address> findAllByUseYn(char useYn);
}
