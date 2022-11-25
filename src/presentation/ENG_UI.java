package UserRepository.src.presentation;

import UserRepository.src.application.Entity.User;
import UserRepository.src.application.Exception.UserNotFoundException;
import UserRepository.src.data.UserRepository;

import java.util.Scanner;

public class ENG_UI implements UI{

    UserRepository userRepository;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void start(UserRepository userRepository) {
        this.userRepository = userRepository;
        System.out.println("========================");
        System.out.println("1. Sign Up");
        System.out.println("2. Find Id By User ID");
        System.out.println("3. Exit");
        System.out.println("========================");
        System.out.print("Enter number: ");
        String s = scanner.nextLine();

        if (s.equals("1")) {
            signUp();
        } else if (s.equals("2")) {
            findUser();
        } else if (s.equals("3")) {
            System.out.println("Exit Program");
            System.exit(0);
        }
    }

    @Override
    public void signUp() {
        System.out.println("========================");
        System.out.print("Enter ID: ");
        String loginId = scanner.nextLine();
        System.out.print("Enter PW: ");
        String loginPw = scanner.nextLine();
        User user = new User(loginId, loginPw);
        userRepository.saveUser(user);
        System.out.println("Saved User");
    }

    @Override
    public void findUser() {
        System.out.println("========================");
        System.out.print("Enter User ID: ");
        String loginId = scanner.nextLine();
        User user = null;
        try {
            user = userRepository.findUser(loginId);
        } catch (UserNotFoundException e) {
            System.out.println("User doesn't exist");
            return;
        }
        System.out.println("User ID is " + user.getLoginId() + ", and password is " + user.getLoginPw());
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