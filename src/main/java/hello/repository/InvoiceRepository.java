package hello.repository;

import org.springframework.data.repository.CrudRepository;

import hello.model.Invoice;

public interface InvoiceRepository extends CrudRepository<Invoice, Long>{
}
