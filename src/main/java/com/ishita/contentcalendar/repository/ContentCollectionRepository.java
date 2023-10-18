package com.ishita.contentcalendar.repository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.ishita.contentcalendar.model.Content;
import com.ishita.contentcalendar.model.Status;
import com.ishita.contentcalendar.model.Type;

import jakarta.annotation.PostConstruct;


@Repository
public class ContentCollectionRepository {
    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){
      // document why this constructor is empty
    }
    public List<Content> findAll(){
        return contentList;
    }
    public Optional<Content> findById(Integer id){
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content){
        contentList.removeIf(c -> c.id().equals(content.id()));
        contentList.add(content);
    }

    public boolean existsById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).count() == 1;
    }

    public void delete(Integer id) {
        contentList.removeIf(c -> c.id().equals(id));
    }

    @PostConstruct
    private void init(){
        Content content = new Content(1,
        "My first blog post",
        "My first blog post desc",
        Status.IDEA,
        Type.ARTICLE,
        LocalDateTime.now(),
        null,
        "");
        
        contentList.add(content);
    }
    
    
}
