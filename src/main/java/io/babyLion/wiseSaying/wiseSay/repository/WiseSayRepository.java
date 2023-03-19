package io.babyLion.wiseSaying.wiseSay.repository;

import io.babyLion.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayRepository {

    private int number;
    private List<WiseSaying> wiseSayings;

    public WiseSayRepository() {
        this.number = 0;
        this.wiseSayings = new ArrayList<>();
    }

    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    public WiseSaying findById (int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if ( wiseSaying.getId() == id ) {
                return  wiseSaying;
            }
        }
        return null;
    }

    public int write(String content, String authorName) {
        int id = number + 1;
        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
        wiseSayings.add(wiseSaying);
        number = id;
        return id; // 등록된 번호를 리턴
    }

    public void remove (WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }

    public void update (WiseSaying wiseSaying, String content, String authorName) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(authorName);
    }
}
