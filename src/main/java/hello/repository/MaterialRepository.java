package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Material;

public interface MaterialRepository extends CrudRepository<Material, Long> {
}
