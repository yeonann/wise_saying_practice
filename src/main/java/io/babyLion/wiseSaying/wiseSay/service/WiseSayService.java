package io.babyLion.wiseSaying.wiseSay.service;

import io.babyLion.wiseSaying.entity.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayService {

    private int number;
    private List<WiseSaying> wiseSayings;

    public WiseSayService() {
        this.number = 0;
        this.wiseSayings = new ArrayList<>();
    }

    // 명언을 작성하는 메서드
    public int write(String content, String authorName) {
        int id = number + 1;
        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
        wiseSayings.add(wiseSaying);
        number = id;
        return id;
    }

    // 명언 목록
    public List<WiseSaying> findAll() {
        return wiseSayings;
    }

    // 명언 번호로 찾기
    public WiseSaying findById (int id) {
        for (WiseSaying wiseSaying : wiseSayings) {
            if ( wiseSaying.getId() == id ) {
                return  wiseSaying;
            }
        }
        return null;
    }

    // 명언을 삭제하는 메서드
    public void remove (WiseSaying wiseSaying) {
        wiseSayings.remove(wiseSaying);
    }

    // 명언을 수정하는 메서드
    public void update (WiseSaying wiseSaying, String content, String authorName) {
        wiseSaying.setContent(content);
        wiseSaying.setAuthorName(authorName);
    }
}