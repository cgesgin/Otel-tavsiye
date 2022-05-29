package com.cgesgin.OtelTavsiye;

import com.cgesgin.OtelTavsiye.Entity.Comment;
import com.cgesgin.OtelTavsiye.Entity.Hotel;
import com.cgesgin.OtelTavsiye.Entity.User;
import com.cgesgin.OtelTavsiye.Repository.CommentRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class CommentRepositoryTest {

    @Autowired
    private CommentRepository repository;

    @Test
    public void commentSaveTest(){

        Comment comment = new Comment();
        comment.setUserComment("bla bla bla");

        repository.save(comment);
        Assertions.assertThat(comment.getId()).isGreaterThan(0);
    }
}
