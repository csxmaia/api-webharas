package com.apiharas.webharas.interfaces;

import com.apiharas.webharas.entity.Video;

import java.util.List;
import java.util.Optional;

public interface VideoService {

    Optional<Video> getById(Long id);

    List<Video> getListItems();

    Video save(Video object);

    void remove(Long id);

}
