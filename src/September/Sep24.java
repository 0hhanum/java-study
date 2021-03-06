package September;

public class Sep24 {
}

/*
객체 배열
객체를 이용한 배열. 배열 내에 객체의 주소 가 저장된다. 객체가 저장되는 것이 아님.

객체 배열은 참조변수들을 하나로 묶은 참조변수 배열

September.Tv[] tvArr = new September.Tv[3];
// 객체 배열의 생성.
// 이는 객체를 다루기 위한 참조 변수들이 만들어진 것 뿐, 객체가 생성된 것은 아님.

September.Tv tv1, tv2, tv3; // 과 동일하게 참조변수만 선언한 것.

tvArr[0] = new September.Tv(); // 객체 생성 후 참조변수에 주소 저장.

// 다뤄야 할 객체가 많을 때는 for 문을 이용.

September.Tv[] tvArr = new September.Tv[3];
for(int i=0; i<tvArr.length; i++){
  tvArr[i] = new September.Tv();
}
클래스의 또 다른 정의
클래스 - 데이터와 함수의 결합

변수 -> 배열 -> 구조체 -> 클래스

	변수: 하나의 데이터를 저장할 수 있는 공간
	배열: 같은 종류의 여러 데이터를 하나의 집합으로 저장할 수 있는 공간
	구조체: 서로 관련된 여러 데이터를 종류에 관계없이 하나의 집합으로 저장할 수 있는 공간
	클래스: 데이터와 함수의 결합 (구조체 + 함수)
자바와 같은 객체지향언어에서는 변수(데이터)와 함수를 하나의 클래스에 정의하여 서로 관계가 깊은 변수와 함수들을 함께 다룰 수 있게 했다. 이렇게 하면 변수와 함수가 서로 유기적으로 연결되어 작업이 간단하고 명료해진다.

클래스 - 사용자정의 타입(user-defined type)
언어에서 제공하는 자료형 외에 개발자가 서로 관련된 변수들을 묶어 하나의 타입으로 새로 추가하는 것을 사용자정의 타입이라고 한다.

변수와 메서드
선언위치에 따른 변수의 종류
변수는 클래스변수, 인스턴스변수, 지역변수 세 종류가 있다. 변수의 종류를 결정짓는 중요한 요소는 변수의 선언된 위치 이다.

멤버변수를 제외한 나머지는 모두 지역변수이며, 멤버변수 중 static 이 붙은 것은 클래스변수, 붙지 않은 것은 인스턴스변수

class Variables{
  int iv; // 인스턴스변수
  static int cv; // 클래스변수
  void method(){ // 메서드 method()
    int lv = 0; // 지역변수
  }
}
각 변수의 생성시기는 다음과 같다.

클래스변수 - 클래스가 메모리에 올라갈 때
인스턴스변수 - 인스턴스가 생성되었을 때
지역변수 - 변수 선언문이 수행되었을 때
인스턴스변수
클래스 영역에 선언되며, 인스턴스 생성 시에 만들어진다. 인스턴스는 독립적인 저장공간을 가지므로 서로 다른 값을 가질 수 있다.

클래스변수
인스턴스변수 앞에 static 을 붙여 선언한다. 각 인스턴스 내에 독립적인 저장공간을 갖는 인스턴스변수와 달리, 클래스변수는 모든 인스턴스가 공통된 저장공간(변수) 를 공유하게 된다.
인스턴스를 생성하지 않고도 사용할 수 있다. (클래스명.클래스변수 로 사용)
클래스가 메모리에 올라갈 때 생성되어 프로그램이 종료될 때까지 유지되며, public 을 앞에 붙이면 같은 프로그램 내에서 어디서나 접근할 수 있는 전역변수(global variable) 이 된다.

참조변수의 선언이나 객체의 생성과 같이 클래스의 정보가 필요할 때, 클래스는 메모리에 로딩된다.
지역변수
메서드 내에 선언되어 메서드 내에서만 사용 가능하며, 메서드가 종료되면 소멸되어 사용할 수 없게 된다.
for문 또는 while문의 블럭 내에 선언된 지역변수는, 지역변수가 선언된 블럭{} 내에서만 사용 가능하며, 블럭을 벗어나면 소멸 되어 사용할 수 없게 된다.

클래스변수와 인스턴스변수
// 예시
class Card{
  String kind;
  int number; // 위 둘은 인스턴스 변수(카드마다 달라야 함.)

  static int width = 100;
  static int height = 250; // 위 둘은 클래스 변수 (모든 카드가 같아야 함.)
}

 class CardTest{
   public static void main(String[] args){
     Card card = new Card(); // 인스턴스 생성
     card.number = 5; // 인스턴스 card 의 인스턴스변수 초기화.
     // 클래스변수는 아래의 두 방법으로 모두 접근 가능하다.
     System.out.println(Card.width);
     System.out.println(card.width);
}
}
인스턴스변수는 인스턴스가 생성될 때 마다 생성되므로 인스턴스마다 각기 다른 값을 유지할 수 있지만, 클래스 변수는 모든 인스턴스가 하나의 저장공간을 공유하므로, 항상 공통된 값을 갖는다.
 */