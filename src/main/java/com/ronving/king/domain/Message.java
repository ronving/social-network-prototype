package com.ronving.king.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;


@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Message {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please fill the message")
    @Length(max = 2048, message = "Message too long (more than 2kB)")
    @NonNull
    private String text;

    @NotBlank(message = "Please add the tag")
    @Length(max = 255, message = "Message too long (more than 255)")
    @NonNull
    private String tag;
    private String filename;

    @NonNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;

    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }
}
