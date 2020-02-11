package com.mz.example.examplebook.domain.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BookRentalRepository extends CrudRepository<BookRentalEntity, UUID> {

}
