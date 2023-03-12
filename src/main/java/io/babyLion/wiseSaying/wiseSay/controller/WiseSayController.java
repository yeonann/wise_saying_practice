package io.babyLion.wiseSaying.wiseSay.controller;

import io.babyLion.wiseSaying.Container;
import io.babyLion.wiseSaying.WiseSaying;

import java.util.ArrayList;
import java.util.List;

public class WiseSayController {

    private int number;
    private List<WiseSaying> wiseSayings;

    public WiseSayController() {
        this.number = 0;
        this.wiseSayings = new ArrayList<>();
    }

    public void write() {
        int id = number + 1;

        System.out.print("명언 : ");
        String content = Container.getSc().nextLine().trim();
        System.out.print("작가 : ");
        String authorName = Container.getSc().nextLine().trim();

        WiseSaying wiseSaying = new WiseSaying(id, content, authorName);
        wiseSayings.add(wiseSaying);

        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
        number = id;
    }

    public void list() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(20));

        for (WiseSaying wiseSaying : wiseSayings) {
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
        }
    }
}
