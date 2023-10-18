package com.ishita.contentcalendar.repository;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import com.ishita.contentcalendar.model.Content;
import com.ishita.contentcalendar.model.Status;

public interface ContentRepository extends ListCrudRepository<Content, Integer>{
    //query derivation helpers - findAllBy, findFirstBy
    List<Content> findAllByTitleContains(String keyword);

    //write own query
    @Query("""
            Select * from Content
            where status = :status
            """)
    List<Content> listByStatus(@Param("status") Status status);

}
