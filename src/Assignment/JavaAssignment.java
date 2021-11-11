package Assignment;
public class JavaAssignment {
    public static void main(String[] args){
        CoronaVirus virus1 = new CoronaVirus();
        CoronaVirus virus2 = virus1.cloneVirus(); // 바이러스 자가 증식.

        // 사람 a, b, c, d 생성 후 humans 에 삽임.
        Human[] humans = new Human[6];
        Human a = new Human("A"); humans[0] = a;
        Human b = new Human("B"); humans[1] = b;
        Human c = new Human("C"); humans[2] = c;
        Human d = new Human("D"); humans[3] = d;
        Human e = new Human("E"); humans[4] = e;
        Human f = new Human("F"); humans[5] = f;

        d.Vaccinate(); e.Vaccinate(); f.Vaccinate(); // d, e, f 에게 백신 접종.

        for(Human human : humans){
            virus1.infect(human); // 각 사람들에게 감염 시도.
            System.out.println(human.get_name() + " / 접종여부: " + human.get_isVaccinated() + " / 감염여부 : " + human.get_isInfected());
        }
    }
}


class CoronaVirus {
    private static int number_of_virus = 0; // 전체 바이러스 개수
    private int number;  // 바이러스 인스턴스의 번호
    final double POWER = 0.4; // 바이러스의 감염력


    public CoronaVirus() { // 기본 생성자 오버로딩
        this.number = ++number_of_virus;
    } // 생성자 오버로딩

    public int get_number(){ // 바이러스 인스턴스 번호 접근자.
        return number;
    }

    public CoronaVirus cloneVirus(){ // 바이러스 자가복제
        return new CoronaVirus();
    } // 바이러스 자가복제

    public void infect(Human human){ // 메세지 패싱
        double random = Math.random();
        double probability;

        if (human.get_isVaccinated()){ // POWER 를 이용해 접종자, 비접종자에 따른 감염 확률 설정.
            probability = POWER / 3; // 접종자일시 POWER 가 1/3 로 감소.
        } else {
            probability = POWER;
        }
        if(probability > random){ // 감염 확률에 따라 랜덤으로 감염.
            human.infected();
        }
    }
}
class Human{

    private String name;
    private boolean isVaccinated; // 접종여부 캡슐화
    private boolean isInfected; // 감염여부 캡슐화

    public Human(String name){ // 생성자 오버로딩
        this.name = name;
        this.isVaccinated = false;
        this.isInfected = false;
    }
    public String get_name(){ // 이름 접근자.
        return name;
    }
    public boolean get_isVaccinated(){ // 접종여부 접근자
        return isVaccinated;
    }
    public boolean get_isInfected(){ // 감염여부 접근자
        return isInfected;
    }
    public void infected(){ // 감염
        this.isInfected = true;
    }
    public void Vaccinate(){ // 백신 접종.
        isVaccinated = true;
    }
}