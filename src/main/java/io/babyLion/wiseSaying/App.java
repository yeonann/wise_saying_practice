package io.babyLion.wiseSaying;

import io.babyLion.wiseSaying.system.controller.SystemController;
import io.babyLion.wiseSaying.wiseSay.controller.WiseSayController;


public class App {

    public void run() {
        SystemController systemController = new SystemController();
        WiseSayController wiseSayController = new WiseSayController();

        System.out.println("== 명언 앱 ==");
        int number = 0;

        while (true) {
            System.out.print("명령) ");
            String command = Container.getSc().nextLine().trim();

            if (command.equals("종료")) {
                systemController.exit();
                break;
            } else if (command.equals("등록")) {
                wiseSayController.write();
            } else if (command.equals("목록")) {
                wiseSayController.list();
            }
        }
    }
}
