package io.babyLion.wiseSaying.wiseSay.service;

import io.babyLion.wiseSaying.entity.WiseSaying;
import io.babyLion.wiseSaying.wiseSay.repository.WiseSayRepository;

import java.util.List;

public class WiseSayService {

    private final WiseSayRepository wiseSayRepository;

    public WiseSayService() {
        this.wiseSayRepository = new WiseSayRepository();
    }

    public int write(String content, String authorName) {
        return wiseSayRepository.write(content, authorName);
    }

    public List<WiseSaying> findAll() {
        return wiseSayRepository.findAll();
    }

    public WiseSaying findById (int id) {
        return wiseSayRepository.findById(id);
    }

    public void remove (WiseSaying wiseSaying) {
        wiseSayRepository.remove(wiseSaying);
    }

    public void update (WiseSaying wiseSaying, String content, String authorName) {
        wiseSayRepository.update(wiseSaying, content, authorName);
    }
}