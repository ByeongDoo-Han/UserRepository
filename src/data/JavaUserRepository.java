package UserRepository.src.data;

import UserRepository.src.application.Entity.User;
import UserRepository.src.application.Exception.UserNotFoundException;
import java.util.ArrayList;
import java.util.Optional;

public class JavaUserRepository implements UserRepository {

    ArrayList<User> users = new ArrayList<>();

    public JavaUserRepository() {
        System.out.println("Java 기반의 DB가 실행됩니다.");
    }

    @Override
    public void saveUser(User user) {
        System.out.println("Java 기반의 DB에서 유저를 저장합니다.");
        users.add(user);
    }

    @Override
    public User findUser(String loginId) throws UserNotFoundException {
        System.out.println("Java 기반의 DB에서 유저를 찾습니다.");
        Optional<User> findUser = users.stream().filter(x -> x.getLoginId().equals(loginId)).findFirst();
        return findUser.orElseThrow(() -> new UserNotFoundException());
//        return findUser.orElseThrow(() -> new IllegalArgumentException()) - 이러면, 뭐를 위한 오류인지 알아보기 힘들겠죠?
    }
}

/**
 * Java 기반의 Repository입니다. - DB역할
 *
 * line 12 ~ 14
 * 해당 클래스의 생성자입니다. - 이 클래스의 인스턴스가 생성될때 불립니다.
 * 언제 생성자가 불리는지 확인하기 위해 간단하게 프린트만 찍어봤습니다.
 *
 * line 10.
 * ArrayList에 User라는 타입만 담을 수 있도록 <>에 선언을 해주고, users라는 이름을 줍니다.
 * 이 users는 실제 db역할을 하게 됩니다.
 *
 * line 17 ~ 20
 * saveUser 메서드를 정의합니다. User타입의 객체를 받고,
 * 우리가 db로 사용하는 users에 해당 객체를 add 해줍니다
 * 그러면, users에 우리가 파라미터로 받은 user가 추가되겠죠.
 *
 * line 23 ~ 27
 * 이 메서드는 코드는 보지마시고, 어떤 동작을 하는구나만 보고 넘어가시면 됩니다.
 * loginId 문자열을 받고, users 라는 db를 뒤져서, loginId문자열과 일치하는 사용자가 있는지 확인합니다.
 * 존재하면, 해당 user를 findUser라는 이름에 담아서 return하게 되고,
 * 없다면, 우리가 커스텀한 Exception인 UserNotFoundException을 던지게 됩니다.
 * 우리가 커스텀한 덕분에, 이름만 보고도 "아 일치하는 유저가 없구나" 라고 단번에 알아차릴 수 있습니다.
 * 그러면, 서비스 단계에서, 해당 예외를 잡아서 어떻게 처리할지 작성해주면 되겠죠.
 */