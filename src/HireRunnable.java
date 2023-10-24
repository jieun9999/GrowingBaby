public class HireRunnable implements Runnable {
    //HireRunnable은 인터페이스 Runnable 구현

    Parent parent; // Parent 객체 참조 변수 추가
    int secondMoney = 200;
    int defaultMoney;
    public static volatile boolean isRunning = true; //스레드 제어 변수
    private boolean isWaiting = false; //6초 대기확인 변수
    public long startTime;

    public HireRunnable(Parent parent) { // 생성자 수정
        this.parent = parent;
        this.startTime = System.currentTimeMillis(); //생성될때 시작시간 저장
    }

    public void stopThread() {
        isRunning = false; //스레드 종료조건 설정
    }
    public void startWorker(){
        isWaiting = true; //6초 대기 시작
        startTime = System.currentTimeMillis();
    }

    //위에서 일꾼 고용하기 스레드가 시작되고, 6초 뒤에 makeMoney.keepEarning();이 실행되도록 함
    //스레드가 진행되는 시간이 기준이기 때문에, HireRunnable 안에서 조건문을 만들어줌

    @Override
    public void run() { //일꾼 스레드 시작하면 바로 시작
            long currnetTime = System.currentTimeMillis(); //시작시간 밀리초 저장
            long duration = 600000;
            long outputDuration = 5000;

            System.out.println();

            while(isRunning){

                if(currnetTime - startTime >= 6000 && isWaiting){ //6초가 되었을때 돈을 더 벌거냐고 물어봄
                    parent.keepEarning();
                    isWaiting = false;
                }

                if(currnetTime - startTime < duration){ // 10분동안 계속 돈을 늘립니다
                    defaultMoney = parent.getMoney();
                    defaultMoney += secondMoney;
                    parent.replaceMoney(defaultMoney); // 처음 5초동안만 출력합니다

                    if(currnetTime - startTime < outputDuration){
                        System.out.println("현재 잔액 " + defaultMoney + "원");
                    }

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }else {
                    //10분이 지났으니 현재 스레드를 종료하고, 기본스레드 시작
                    parent.startDefaultThread();
                    break;
                }
                currnetTime = System.currentTimeMillis();  //현재 시간 초마다 재할당

            }

    }
}
