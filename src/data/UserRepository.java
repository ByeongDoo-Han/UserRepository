package UserRepository.src.data;

import UserRepository.src.application.Entity.User;
import UserRepository.src.application.Exception.UserNotFoundException;

public interface UserRepository {
    void saveUser(User user);
    User findUser(String loginId) throws UserNotFoundException;
}

/**
 * 우리가 사용할 레포지토리에서는 어떤 로직을 제공하는지 전반적인 사용법을 기술합니다.
 * Java DB 또는 MySQL DB로 프로그램이 돌아갈거라고 요청을 받았지만,
 * 우리는 언제든 Maria DB, PostgreSQL 등 다양한 DB로의 교체 요청을 받을 확률이 존재합니다.
 * 이러한 상황에 대비하기 위해, 언제든 DB를 갈아낄 수 있도록,
 * 모든 DB에 대해 공통으로 구현해야하는 로직을 간단하게 기술한 UserRepository 인터페이스를 만든겁니다.
 *
 * 이 프로그램을 구동하기 위해서는 saveUser, findUser 메서드만 필요하기 때문에,
 * 인터페이스에서는 해당 메서드만 작성합니다.
 *
 * 만약 이 UserRepository 인터페이스가 없다고 가정합시다.
 * 고객이 "Maria DB로 DB환경 바꾸고싶어요" 라고 말하면,
 * 새로운 MariaDB 클래스를 만들고, 새로 메서드를 정의하고,
 * App 단계에서 MariaDB db = new MariaDB();로 하나밖에 호환안되는 타입으로 db를 설정해야합니다.
 *
 * 하지만, 이 UserRepository 인터페이스를 만들어줘서,
 * MariaDB 클래스를 만들고, 이 UserRepository 인터페이스를 implements 해서 여기 나와있는 메서드만 구현하고,
 * App 단계에서 new MariaUserRepository();
 * 로만 DB 를 갈아끼우기만 하면 되는겁니다.
 * 또한, 언제든 다른 DB로 갈아낄 준비를 할 수 있습니다.
 *
 * 인터페이스에서
 * 메서드이름, 인자타입, 반환값 모두 미리 선언해주기 때문에,
 * 이에 맞춰 구현 클래스에서는 로직만 작성해주고 완성하면,
 * UserRepository에 갈아끼울 수 있게 되는겁니다.
 */