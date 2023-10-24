import java.util.Scanner;

public class BabyCaringRunnable implements Runnable {
    private Baby baby; // Baby 객체 참조 변수 추가
    private volatile boolean isRunning = true; //스레드 제어 변수
    public long startTime;
    public long currentTime;
    Scanner scan = new Scanner(System.in);
    long duration;//입력하는데 걸린시간

    public int getCareNum() {
        return careNum;
    }

    int careNum = 0;


    public void setcareNum(int careNum) {
        this.careNum += careNum;
    }

    public BabyCaringRunnable(Baby baby) {
        this.baby = baby; //Baby 객체를 생성자를 통해 전달받음
        this.startTime = System.currentTimeMillis(); //생성될때 시작시간 저장
    }

    public void stopThread() {
        isRunning = false; //스레드 종료조건 설정
    }

    public void startThread() {
        isRunning = true; //스레드 시작조건 설정
    }


    //BabyCryingRunnable 클래스에서 baby 객체에 접근하려면 baby 객체를 BabyCryingRunnable 클래스에 전달해야함
    //BabyCryingRunnable 클래스의 생성자로 객체 전달

    public void run() { //스레드 시작시 바로 실행
        startThread();//나갔다가 다시 들어와도 스레드 실행되게
        int sec = 0; //정수 변수 하나 만들기

        while (isRunning && sec <= 30 ) {
            //30초 동안만 실행됨
            //3의 배수, 5의 배수, 15의 배수일 때 출력을 다르게 함
              if (sec > 0) {
                if (sec % 15 == 0) { // 15의 배수일때 
                    System.out.println();
                    System.out.println("으아아아아아아앙~!");
                    System.out.println("으아아아아아아앙~!");
                    System.out.println("😢😢😢😢😢");
                    System.out.println("쉬이이이이이이");
                    System.out.println("쉬이이이이이이");
                    System.out.println("🌊🌊🌊🌊🌊");
                    System.out.println();
                    System.out.println("아이가 울고, 바지에 오줌을 쌉니다.");
                    System.out.println("5초 안에 '그만울고, 바지 갈아입자~!'을 입력하세요. 그렇지 않으면 아이의 건강과 애정이 5씩 감소합니다.");
                    System.out.print("입력창 : "); //입력창이 보여지고
                    String input = scan.next();//유저 입력
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (input.equals("그만울고, 바지 갈아입자~!")) { //입력걸린시간이 5초 이하이고, 내용이 동일할때만
                        System.out.println();
                        System.out.println("아이가 울음을 멈추고 바지를 갈아입습니다." + "😊");
                        setcareNum(+1); //케어횟수 +1
                        System.out.println("누적 케어횟수 : " + getCareNum() + "회");
                        stopThread();
                    } else {
                        System.out.println("큰일났습니다.");
                        System.out.println("아이의 건강이 5씩 감소합니다.");
                        baby.setHealthScore(-5);
                        System.out.println("아이의 애정이 5씩 감소합니다.");
                        baby.setLoveScore(-5);
                        System.out.println("현재 건강 " + baby.getHealthScore() + "/" + baby.getFinalHealthScore());
                        System.out.println("현재 애정 " + baby.getLoveScore() + "/" + baby.getFinalLoveScore());
                        System.out.println();
                    }

                }
                else if (sec % 3 == 0) { // 3의 배수이고, 15의 배수는 아닐때
                    System.out.println();
                    System.out.println("😢😢😢😢😢");
                    System.out.println("으아아아아아아앙~!");
                    System.out.println("으아아아아아아앙~!");
                    System.out.println("으아아아아아아앙~!");
                    System.out.println("😢😢😢😢😢");
                    System.out.println();
                    System.out.println("아이가 웁니다.");

                    System.out.println("5초 안에 '울음,뚝!'을 입력하세요. 그렇지 않으면 아이의 건강이 5씩 감소합니다.");
                    System.out.print("입력창 : "); //입력창이 보여지고
                    String input = scan.next();//유저 입력
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    if (input.equals("울음,뚝!")) { //입력걸린시간이 5초 이하이고, 내용이 동일할때만
                        System.out.println();
                        System.out.println("아이가 울음을 멈춥니다." + "😊");
                        setcareNum(+1); //울음 케어횟수 +1
                        System.out.println("누적 케어횟수 : " + getCareNum() + "회");
                        stopThread();
                    }else {
                        System.out.println("큰일났습니다.");
                        System.out.println("아이의 건강이 5씩 감소합니다.");
                        baby.setHealthScore(-5);
                        System.out.println("현재 건강 " + baby.getHealthScore() + "/" + baby.getFinalHealthScore());
                        System.out.println();
                    }
                }
                else if (sec % 5 == 0) { //5의 배수이고, 15의 배수는 아닐때
                    System.out.println();
                    System.out.println("🌊🌊🌊🌊🌊");
                    System.out.println("쉬이이이이이이");
                    System.out.println("쉬이이이이이이");
                    System.out.println("쉬이이이이이이");
                    System.out.println("🌊🌊🌊🌊🌊");
                    System.out.println();
                    System.out.println("아이가 바지에 오줌을 쌉니다.");

                    System.out.println("5초 안에 '바지입자!'를 입력하세요. 그렇지 않으면 아이의 애정이 5씩 감소합니다.");
                    System.out.print("입력창 : "); //입력창이 보여지고
                    String input = scan.next(); //앞뒤 공백제거
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (input.equals("바지입자!")) { //입력걸린시간이 5초 이하이고, 내용이 동일할때만
                        System.out.println();
                        System.out.println("아이가 새 바지로 갈아입었습니다." + "😊");
                        setcareNum(1); // 케어횟수 +1
                        System.out.println("누적 케어횟수 : " + getCareNum() + "회");
                        stopThread();
                    } else{
                        System.out.println("큰일났습니다.");
                        System.out.println("아이의 애정이 5씩 감소합니다.");
                        baby.setLoveScore(-5);
                        System.out.println("현재 애정 " + baby.getLoveScore() + "/" + baby.getFinalLoveScore());
                        System.out.println();
                    }


                }
            } //출력에 대한 조건문 작성

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) { //1초 텀 두고 반복
                    throw new RuntimeException(e);
                }
            sec += 1; //1초마다 +1됨, 즉 몇초후인지를 알려줌

        }


    }
}





