package UserRepository.src.presentation;

import UserRepository.src.application.Entity.User;
import UserRepository.src.application.Exception.UserNotFoundException;
import UserRepository.src.data.UserRepository;
import java.util.Scanner;

public class KOR_UI implements UI{

    UserRepository userRepository;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void start(UserRepository userRepository) {
        this.userRepository = userRepository;
        System.out.println("========================");
        System.out.println("1. 회원가입 하기");
        System.out.println("2. ID로 회원찾기");
        System.out.println("3. 프로그램 종료");
        System.out.println("========================");
        System.out.print("원하는 작업 번호를 입력해주세요:");
        String s = scanner.nextLine();

        if (s.equals("1")) {
            signUp();
        } else if (s.equals("2")) {
            findUser();
        } else if (s.equals("3")) {
            System.out.println("프로그램을 종료합니다.");
            System.exit(0);
        }
    }

    @Override
    public void signUp() {
        System.out.println("========================");
        System.out.print("아이디를 입력해주세요: ");
        String loginId = scanner.nextLine();
        System.out.print("비밀번호를 입력해주세요: ");
        String loginPw = scanner.nextLine();
        User user = new User(loginId, loginPw);
        userRepository.saveUser(user);
        System.out.println("유저를 성공적으로 저장했습니다.");
    }
    @Override
    public void findUser() {
        System.out.println("========================");
        System.out.print("찾고싶은 유저의 아이디를 입력해주세요: ");
        String loginId = scanner.nextLine();
        User user = null;
        try {
            user = userRepository.findUser(loginId);
        } catch (UserNotFoundException e) {
            System.out.println("찾으시는 아이디는 존재하지 않습니다.");
            return;
        }
        System.out.println("찾으시는 유저의 아이디는 " + user.getLoginId() + "이며, 해당 비밀번호는 " + user.getLoginPw() + "입니다.");
    }
}

/**
 * line 52 ~ 59.
 * scanner를 통해 입력받은 문자열을 loginId에 담고,
 * userRepository.findUser(loginId)를 통해 해당 loginId를 갖고있는 user를 찾아옵니다.
 * 그런데, userRepository의 findUser메서드에서, 일치하는 user가 없으면 UserNotFoundException을 던져주기로 했습니다.
 * 그래서, try-catch문을 통해 해당 메서드를 실행했을때, UserNotFoundException이 발생한다면 그걸 catch해서
 * 찾으시는 아이디는 존재하지 않는다는 프린트를 찍어주게 되고, 메서드가 종료되는 로직입니다.
 * 만약, UserNotFoundException이 발생하지 않는다면, catch문은 동작하지 않아 메서드가 종료되지 않을거고,
 * 59번 line까지 무사히 도착해 찾는 user의 아이디와 비밀번호를 가져올 수 있게 됩니다.
 */