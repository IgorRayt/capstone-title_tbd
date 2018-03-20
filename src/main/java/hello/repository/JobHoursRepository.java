package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.JobHours;

public interface JobHoursRepository extends CrudRepository<JobHours, Long>{
}
