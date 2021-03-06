package September;

public class Sep25 {

    public static void main(String[] args){
        MethodExample example = new MethodExample();
        System.out.println(example.add(3,5));
    }
}
class MethodExample{
    int add(int a, int b) { return a + b; }
}
/*
메서드
특정 작업을 수행하는 일련의 문장들을 하나로 묶은 것 -> 메서드 (함수)

메서드를 사용하는 이유
높은 재사용성(reusability)
중복된 코드의 제거
프로그램의 구조화 (Devide & conquer)
메서드의 선언과 구현
메서드는 크게 두 부분, '선언부' 와 '구현부' 로 이루어져 있다.

int add(int a, int b){ // 선언부

  int result = a + b;
  return result; // 구현부
}
메서드 선언부
메서드 선언부는 '메서드의 이름' 과 '매개변수 선언', 그리고 '반환타입' 으로 구성되어 있다.
메서드의 선언부를 변경하면 그 메서드가 호출되는 모든 곳도 같이 변경해야 하기 때문에 신중하게 작성.

매개변수 선언
메서드가 작업을 수해아는데 필요한 값들을 제공받음. 매개변수들의 타입이 같아도 변수의 타입을 생략할 수 없다. 입력해야 할 값이 많을 때는 배열이나 참조변수를 사용한다. * 매개변수도 메서드 내에 선언된 것으로 지역변수이다.

반환타입
메서드의 반환값의 타입을 적는다. 반환값이 없는 경우 반환타입으로 void 를 적어야 한다.

메서드 구현부
return 문
메서드의 반환타입이 void 가 아닌 경우, 구현부 { } 내에 반환값이 반드시 포함되어야 한다. 이 때 이 값의 타입은 반환타입과 일치하거나 적어도 자동 형변환이 가능한 것이어야 한다.
지역변수
메서드 내에 선언된 변수들은 그 메서드 내에서만 사용할 수 있으므로 서로 다른 메서드라면 같은 이름의 변수를 선언해도 된다. (매개변수 포함)

메서드의 호출
메서드를 정의했어도 호출되지 않으면 아무 일도 일어나지 않는다. main 메서드는 프로그램 실행 시 OS 에 의해 자동적으로 호출된다.

add(3, 5); 와 같이 호출

인자와 매개변수
메서드를 호출할 때 괄호() 안에 지정해 준 값들을 인자라고 한다. 인자의 개수와 순서는 메서드에 선언된 매개변수와 일치해야 한다. 당연히 타입도 일치하거나 자동 형변환이 가능한 것이어야 한다.

메서드의 실행흐름
같은 클래스 내의 메서드끼리는 참조변수를 사용하지 않고도 서로 호출이 가능하지만 static 메서드는 같은 클래스 내의 인스턴스 메서드를 호출할 수 없다. static 메서드 내에선 static 메서드만 호출 가능.

클래스, 인스턴스 변수와 마찬가지로 static 이 붙은 메서드가 클래스 메서드. (클래스 변수와 마찬가지로 객체 생성 없이도 호출 가능)

예시
class September.MethodExample {
  int add(int a, int b) { return a + b; }

  static staticMethod() {
  int result = add(3, 5);  // 이런 식으로는 호출 불가능하다. 클래스메서드에서 인스턴스메서드를 호출했기 때문에.
  return result;
  }
}
class Main{
  public static void main(String[] args){
  // 인스턴스 메서드를 호출하려면 객체를 생성해야 한다. (인스턴스변수와 동일)
  September.MethodExample example = new September.MethodExample();
  System.out.println(example.add(3,5)); // 객체에서 호출
  }
}
메서드 실행 중 메서드 호출 시, 지금까지 실행 중이던 메서드는 실행을 잠시 멈추고 호출된 메서드의 문장들이 실행된다. 호출된 메서드의 작업이 모두 끝나면, 다시 호출한 메서드로 돌아와 이후의 문장들을 실행한다.

return 문
return 문은 현재 실행중인 메서드를 종료하고 호출한 메서드로 되돌아간다. 모든 메서드에는 return 문이 있어야 하며, 반환타입이 void 인 경우, 컴파일러가 메서드의 마지막에 return; 을 자동적으로 추가해준다.
 */