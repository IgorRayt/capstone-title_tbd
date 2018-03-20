package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Project;

public interface ProjectRepository extends CrudRepository<Project, Long>{
}
