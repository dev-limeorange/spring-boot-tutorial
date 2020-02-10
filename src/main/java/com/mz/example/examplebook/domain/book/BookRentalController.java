package com.mz.example.examplebook.domain.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class BookRentalController {

    @Autowired
    private BookRentalRepository bookRentalRepository;

    @PostMapping("/book/{bookId}/rental")
    public BookRentalEntity createBookRental(@PathVariable("bookId") UUID bookId,
                                             @RequestBody BookRentalEntity bookRentalEntity) {
        bookRentalEntity.setBookId(bookId);
        BookRentalEntity created = bookRentalRepository.save(bookRentalEntity);
        return created;
    }

    @GetMapping("/book/{bookId}/rental")
    public List<BookRentalEntity> listBookRentalByBookId(@PathVariable("bookId") UUID bookId) {
        return null;
    }

    @PutMapping("/book/{bookId}/rental/{rentalId}/return")
    public BookRentalEntity returnBookRental(@PathVariable("rentalId") UUID rentalId) {
        BookRentalEntity bookRentalEntity = bookRentalRepository.findById(rentalId).get();
        bookRentalEntity.setReturned(true);
        BookRentalEntity returned = bookRentalRepository.save(bookRentalEntity);
        return bookRentalEntity;
    }
}
