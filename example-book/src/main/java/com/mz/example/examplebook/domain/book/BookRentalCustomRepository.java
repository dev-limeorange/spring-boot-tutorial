package com.mz.example.examplebook.domain.book;

import com.querydsl.core.support.FetchableQueryBase;
import com.querydsl.core.support.QueryBase;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
public class BookRentalCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<BookRentalEntity> listBookRentalByBookId(UUID bookId) {
        JPAQuery<?> query = new JPAQuery<>(entityManager);
        QBookEntity qBookEntity = QBookEntity.bookEntity;
        QBookRentalEntity qBookRentalEntity = QBookRentalEntity.bookRentalEntity;

        List<BookRentalEntity> fetched = query.select(qBookRentalEntity)
                .from(qBookRentalEntity)
                .leftJoin(qBookEntity)
                .on(qBookRentalEntity.bookEntity.id.eq(qBookEntity.id))
                .where(qBookRentalEntity.bookEntity.id.eq(bookId))
                .fetch();

        return fetched;
    }

}
