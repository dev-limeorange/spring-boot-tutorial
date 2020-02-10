package com.mz.example.examplebook.domain.book;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "book_rental")
public class BookRentalEntity {

    @Id
    @Type(type = "uuid-char")
    @GeneratedValue
    private UUID id;

    @Type(type = "uuid-char")
    @Column(nullable = false)
    private UUID bookId;

    @Column(nullable = false)
    private String userId;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private boolean returned = false;

    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    private Date createAt;

    public BookRentalEntity() {
    }

    public BookRentalEntity(UUID id, UUID bookId, String userId, String userName, boolean returned, Date createAt) {
        this.id = id;
        this.bookId = bookId;
        this.userId = userId;
        this.userName = userName;
        this.returned = returned;
        this.createAt = createAt;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getBookId() {
        return bookId;
    }

    public void setBookId(UUID bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public boolean isReturned() {
        return returned;
    }

    public void setReturned(boolean returned) {
        this.returned = returned;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    @Override
    public String toString() {
        return "BookRentalEntity{" +
                "id=" + id +
                ", bookId=" + bookId +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", returned=" + returned +
                ", createAt=" + createAt +
                '}';
    }
}
