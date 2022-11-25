package UserRepository.src.presentation;

import UserRepository.src.data.UserRepository;

public interface UI {
    void start(UserRepository userRepository);
    void signUp();
    void findUser();
}

/**
 * UI의 전체적인 틀을 잡기 위한 인터페이스입니다.
 * 우리의 프로그램은 start, signUp, findUser 기능만 제공하기 때문에,
 * "이런 기능을 제공할거다" 라고만 인터페이스에 명세해줍니다.
 *
 * 한국어 버전에서는 한국어 나름대로 메서드를 정의해줄거고,
 * 영어 버전에서는 영어 나름대로 메서드를 정의해주겠죠?
 *
 * 만약, 프로그램이 규모가 커져서 JAP, CHN 버전의 프로그램도 작성해야 한다고 하면,
 * JAP_UI, CHN_UI 클래스를 만들고, 이 인터페이스를 implement해 언어에 맞게 작성하고,
 * App 단계 에서 갈아끼워주기만 하면 됩니다!
 *
 * App 단계에서, 어떤 UI와 어떤 Repository를 사용할지 정해주는데,
 * App 단계에서 프로그램을 구동시키면, UI의 start() 메서드를 실행합니다.
 * (App에서는 어떤 UI, 어떤 DB를 사용할지만 바라보고 있으며,
 * 오직 UI의 start()메서드만 호출합니다)
 *
 * UI는 UserRepository만을 바라봅니다 - UI는 어떻게 유저에 대해 회원가입/회원찾기를 시킬지 UserRepository와만 소통합니다. 
 * 즉, UI는 UserRepository를 멤버변수로 갖고있습니다.
 * 근데, 어떤 UserRepository 구현체를 사용할지는 모르고있습니다. - 각 구현 클래스의 11번 line 확인
 *
 * 하지만, App에서 어떤 UserRepository를 사용할지 정해준다고 했죠?
 * 그래서 App 시작시 무조건 불리는 UI의 start 메서드에,
 * App 에서 결정한 UserRepository 구현체를 start() 메서드에게 던져줍니다.
 * 그러면 UI 에서는 해당 userRepository를 넘겨받아,
 * 자신의 UserRepository 멤버변수에, 해당 구현체를 끼워넣는 작업을 거칩니다. - 각 구현 클래스의 16번 line 확인
 * 따라서 start() 메서드에는, UserRepository가 파라미터로 들어가있게 되는 것 입니다.
 */
