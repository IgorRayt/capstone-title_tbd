package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.EmployeeAssignment;

public interface EmployeeAssignmentRepository extends CrudRepository<EmployeeAssignment, Long>{
}
