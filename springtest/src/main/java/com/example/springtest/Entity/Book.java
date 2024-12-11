package com.example.springtest.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;


@Entity
@Table(name = "book_record")
@Data
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookId;

    @NonNull
    private String name;

    @NonNull
    private String summary;

    private int rating;

    public Book(long bookId, String ana, String amb, int rating) {
    }

    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void setSummary(@NonNull String summary) {
        this.summary = summary;
    }

    public void setName(@NonNull String name) {
        this.name = name;
    }


    public Long getBookId() {
        return bookId;
    }

    public int getRating() {
        return rating;
    }

    public @NonNull String getSummary() {
        return summary;
    }

    public @NonNull String getName() {
        return name;
    }
}
