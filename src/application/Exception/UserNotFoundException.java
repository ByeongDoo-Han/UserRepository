package UserRepository.src.application.Exception;

public class UserNotFoundException extends Exception{
}

/**
 *  프로그램 구동 중 얘기치 못한 상황이 발생하면, Exception을 던지게 됩니다.
 *  자바 내부 라이브러리에 기존에 정해진 다양한 Exception들이 존재합니다.
 *
 *  해당 Exception 클래스를 구현해, 나만의 Exception을 만들수도 있습니다.
 *  저희가 만드는 프로그램은,
 *  User를 찾을 때, 만약 입력받은 ID값에 해당하는 유저가 없을 경우,
 *  UserNotFoundException을 던져야하기 때문에,
 *  해당 이름의 클래스를 만들고, Exception을 상속받도록 합니다.
 *  4번째 줄에 오른쪽마우스 클릭을 하시고 override 를 클릭하시면,
 *  나만의 Exception을 더 상세하게 커스텀하여 사용할 수 있습니다.
 *
 *  나만의 Exception은 왜 만드는건가요 ?
 *  프로그램을 작동시키면서, 다양한 Exception이 필요합니다.
 *
 *  만약, "gwanho"라는 id를 가진 사람이 회원가입하려고 한다면, exception을 던지고싶다고 가정합시다.
 *  그러면, 기존의 있던 Exception으로는 표현이 불가능하겠죠.
 *  기존에 내부 라이브러리에 있는 IllegalArgumentException을 던진다고 하면,
 *  코드를 봐도, 뭐를 위한 Exception인지 구분하기 힘듭니다.
 *
 *  이때, BanGwanhoException 이라는 커스텀 Exception을 만들어,
 *  프로그램 로직 중에 사용한다면,
 *  다른 사람이 해당 코드를 봤을때, "아 gwanho라는 사람은 ban 되어있어서 exception 을 따로 만들었구나"
 *  라고 판단하고, 해당 Exception에 맞는 로직을 짤 수 있게 됩니다.
 *  (극단적으로 실용성 없는 예시입니다)
 *  또한, BanGwanhoException은 오버라이딩을 통해,
 *  예외에 맞는 더 세세한 로직을 짤 수 있게 됩니다.
 *
 *  만약 은행과 관련된 프로그램을 짠다면
 *  NoMoneyException, MinusAccountException, SuspendedAccountException
 *  등 다양한 Exception을 만들어 사용할 수 있겠죠.
 *
 *  이 프로그램에서는, 동일한 ID로 회원가입을 하려면,
 *  AlreadyExistIdException 정도를 만들어서 로직에 삽입하면,
 *  더 발전된 프로그램을 만들 수 있겠죠.
 */