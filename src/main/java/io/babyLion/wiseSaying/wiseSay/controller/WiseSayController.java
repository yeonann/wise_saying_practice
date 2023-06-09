package io.babyLion.wiseSaying.wiseSay.controller;

import io.babyLion.wiseSaying.Container;
import io.babyLion.wiseSaying.Rq;
import io.babyLion.wiseSaying.entity.WiseSaying;
import io.babyLion.wiseSaying.wiseSay.service.WiseSayService;

import java.util.List;

public class WiseSayController {

    private final WiseSayService wiseSayService;

    public WiseSayController() {
        this.wiseSayService = new WiseSayService(); // 주입
    }

    public void write() {
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine().trim();
        System.out.print("작가 : ");
        String authorName = Container.getSc().nextLine().trim();

        int id = wiseSayService.write(content, authorName);
        System.out.printf("%d번 명언이 등록되었습니다.\n", id);
    }

    public void list() {

        List<WiseSaying> wiseSayings = wiseSayService.findAll();

        System.out.println("번호 / 작가 / 명언");
        System.out.println("-".repeat(20));

        for (WiseSaying wiseSaying : wiseSayings) {
            System.out.printf("%d / %s / %s\n", wiseSaying.getId(), wiseSaying.getAuthorName(), wiseSaying.getContent());
        }
    }

    public void remove(Rq rq) {

        int id = rq.getParameterIntValue("id", -1);
        if (id == -1) {
            System.out.println("id는 숫자로 입력해주세요.");
            return;
        }

        WiseSaying wiseSaying = wiseSayService.findById(id);
        if ( wiseSaying == null ) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }

        wiseSayService.remove(wiseSaying);
        System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
    }

    public void update(Rq rq) {

        int id = rq.getParameterIntValue("id", -1);
        if (id == -1) {
            System.out.println("id는 숫자로 입력해주세요.");
        }

        WiseSaying wiseSaying = wiseSayService.findById(id);
        if ( wiseSaying == null ) {
            System.out.printf("%d번 명언은 존재하지 않습니다.\n", id);
            return;
        }
        System.out.printf("명언(기존) : %s\n", wiseSaying.getContent());
        System.out.print("명언 : ");
        String content = Container.getSc().nextLine().trim();
        System.out.printf("작가(기존) : %s\n", wiseSaying.getAuthorName());
        System.out.print("작가 : ");
        String authorName = Container.getSc().nextLine().trim();

        wiseSayService.update(wiseSaying, content, authorName);

        System.out.printf("%d번 명언이 수정되었습니다.\n", id);
    }
}