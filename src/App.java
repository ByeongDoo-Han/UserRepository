package UserRepository.src;

import UserRepository.src.data.JavaUserRepository;
import UserRepository.src.data.MysqlUserRepository;
import UserRepository.src.data.UserRepository;
import UserRepository.src.presentation.ENG_UI;
import UserRepository.src.presentation.KOR_UI;
import UserRepository.src.presentation.UI;

public class App {
    public static void main(String[] args) {
        UI ui = new KOR_UI();
        UserRepository userRepository = new JavaUserRepository();

        while(true) {
            ui.start(userRepository);
        }
    }
}

/**
 *  실제 프로그램을 구동시킬 App 계층 입니다.
 *  App에서는 어떤 UI를 사용할지, 어떤 데이터베이스를 사용할지 정하고,
 *  해당 UI와 DB를 바탕으로 프로그램을 구동시킵니다.
 *
 *  line 8
 *  KOR_UI 인스턴스를 생성하고, UI 타입에 ui라는 이름으로 담습니다.
 *  만약 영어 버전으로 프로그램을 구동시키고 싶으면, new KOR_UI();를 new ENG_UI();로만 바꿔주면 됩니다.
 *  KOR_UI와 ENG_UI는 UI 인터페이스를 구현한 클래스이기 때문에, 둘다 UI에 담길 수 있기 때문에 마음대로 바꿀 수 있습니다.
 *  KOR_UI ui = new ENG_UI(); 는 왜 안되는지 생각해봅시다.
 *
 *  만약, 일본어 버전의 JAP_UI, 중국어 버전의 CHN_UI 클래스를 더 만들어달라는 고객의 요청이 있으면,
 *  UI 인터페이스를 구현한 JAP_UI, CHN_UI 클래스를 만들어주기만 하고,
 *  UI ui = new JAP_UI();
 *  UI ui = new CHN_UI();
 *  와 같이 바꿔주면서 갈아끼면 되겠죠
 *
 * --------------------
 *  line 9
 *  JavaUserRepository(자바기반DB) 인스턴스를 생성하고, UserRepository 타입에 담습니다.
 *  만약 Mysql 기반의 DB를 사용하고 싶으면, new JavaUserRepository();를 new MysqlUserRepository();로만 바꿔주면 됩니다.
 *  JavaUserRepository와 MysqlUserRepository 클래스 모두 UserRepository 인터페이스를 구현했기 때문에,
 *  둘다 UserRepository 타입에 담을 수 있기 때문입니다.
 *
 *  ------------------------
 *  new KOR_UI(); 를 new ENG_UI(); 로,
 *  new JavaUserRepository(); 를 new MysqlUserRepository(); 로 마음대로 바꾸면서
 *  kor + java
 *  kor + mysql
 *  eng + java
 *  eng + mysql
 *  조합을 자유자재로 왔다갔다하면서 왜 인터페이스를 선언하고, 구현체를 구현하는지 확인해보세요.
 *  만약 JAP, CHN // MariaDB, PostgreSQL 등 새로운 ui나 db가 만들어진다면,
 *  이 App에서 자유자재로 갈아끼울 수 있게 되는 것 입니다!
 */
