package UserRepository.src.application.Entity;

public class User {
    String loginId;
    String loginPw;

    public User(String loginId, String loginPw) {
        this.loginId = loginId;
        this.loginPw = loginPw;
    }

    public String getLoginId() {
        return loginId;
    }

    public String getLoginPw() {
        return loginPw;
    }
}

/**
 *  User 클래스의 객체는 모두 loginId, loginPw 라는 멤버 변수를 가지고 있습니다.
 *
 *  line 7 ~ 9
 *  User 클래스의 생성자입니다.
 *  인스턴스를 생성할 때, loginId와 loginPw 를 받아, 새로운 User를 생성시킵니다.
 *
 *  line 12 ~ 16
 *  getter 입니다. 멤버변수에 대해 getter를 만들 수 있고,
 *  윈도우 Alt+Insert or 맥북 Command+N을 통해
 *  생성자, 게터, 세터, 메서드 오버라이딩 등 다양한 작업을 할 수 있습니다.
 */