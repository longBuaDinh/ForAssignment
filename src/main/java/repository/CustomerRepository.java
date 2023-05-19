package repository;

import entity.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.ArrayList;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Integer> {
    ArrayList<CustomerEntity> findByName(String name);
    ArrayList<CustomerEntity> findByPhoneOrEmail(String phone, String email);
    ArrayList<CustomerEntity> findByBirthdateBetween(LocalDate start,LocalDate end);
}
