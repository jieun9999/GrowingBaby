public class DefaultRunnable implements Runnable {
    //DefaultRunnable는 인터페이스 Runnable을 구현

    public Parent parent; // Parent 객체 참조 변수 추가
    public int secondMoney = 100;
    public int defaultMoney;
    public volatile boolean isRunning = true; //스레드 제어 변수
    public boolean isWaiting = false; //6초 대기확인 변수
    public long startTime;

    public DefaultRunnable(Parent parent) {
        this.parent = parent; // Parent 객체를 생성자를 통해 전달받음
        this.startTime = System.currentTimeMillis(); //생성될때 시작시간 저장
    }


    public void stopThread() {
        isRunning = false; //스레드 종료조건 설정
    }

    public void startMoney(){
        isWaiting = true; //6초 대기 시작
        startTime = System.currentTimeMillis();
    }

    //DefaultRunnable 클래스에서 parent객체에 접근하려면 parent 객체를 DefaultRunnable 클래스에 전달해야함
    //DefaultRunnable 클래스의 생성자로 객체 전달

    @Override
    public void run() { //기본 돈벌기 스레드 실행되면 바로 시작

        long currnetTime = System.currentTimeMillis();
        long outputDuration = 5000;

        System.out.println();

        while (isRunning) {
            //현재 잔액 출력
            defaultMoney = parent.getMoney();
            defaultMoney += secondMoney;
            parent.replaceMoney(defaultMoney); // Parent 객체의 setMoney 메서드를 호출하여 동기화

            if(currnetTime - startTime < outputDuration){
                System.out.println("현재 잔액 " + defaultMoney + "원");
            }

            if(currnetTime - startTime >= 6000 && isWaiting){ //6초가 되었을때 돈을 더 벌거냐고 물어봄
                parent.keepEarning();
                isWaiting = false;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            currnetTime = System.currentTimeMillis(); //현재 시간 초마다 재할당
        }
    }
}

