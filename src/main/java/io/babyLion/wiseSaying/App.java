package io.babyLion.wiseSaying;

import io.babyLion.wiseSaying.system.controller.SystemController;
import io.babyLion.wiseSaying.wiseSay.controller.WiseSayController;

public class App {

    public void run() {
        SystemController systemController = new SystemController();
        WiseSayController wiseSayController = new WiseSayController();

        System.out.println("== 명언 앱 ==");

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();
            Rq rq = new Rq(command);

            switch (rq.getActionCode()) {
                case "종료" -> {
                    systemController.exit();
                    return;
                }
                case "등록" -> wiseSayController.write();
                case "목록" -> wiseSayController.list();
                case "삭제" -> wiseSayController.remove(rq);
                case "수정" -> wiseSayController.update(rq);
            }
        }
    }
}
