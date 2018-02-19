package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.EmergencyContact;

public interface EmergencyContactRepository extends CrudRepository<EmergencyContact, Long> {
}
