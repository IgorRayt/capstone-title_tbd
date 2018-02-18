package hello.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import hello.model.Person;

@NoRepositoryBean
public interface PersonRepository<T extends Person> extends CrudRepository<T, Long> {
}
