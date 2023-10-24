import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Parent {
    Scanner scan = new Scanner(System.in);
    public int money;

    //DefaultRunnable 및 HireRunnable 과 같은 스레드 접근과 제어를
    //Parent 클래스 내부로 옮기는 것이 좋다
    // 이유: 이렇게 하면 Parent 클래스에서 스레드를 멈추고 재생시키는 제어가 쉽다
    public DefaultRunnable defaultRunnable;
    public HireRunnable hireRunnable;

    //생성자에서 DefaultRunnable 및 HireRunnable 초기화
    public Parent() {
        this.defaultRunnable = new DefaultRunnable(this); //인자로 parent(this)fmf 가지는 이유: parent.replaceMoney(defaultMoney);
        this.hireRunnable = new HireRunnable(this);
    }

    //기본 돈벌기 스레드 시작
    public void startDefaultThread(){
        Thread defaultThread = new Thread(defaultRunnable);
        defaultThread.start();
    }

    //기본 돈벌기 스레드 멈춤
    public void stopDefaultThread(){
        defaultRunnable.stopThread();
    }

    //일꾼 고용하기
    public void hireWorker(){
        System.out.println("일꾼을 고용합니다. -5만원");
        setMoney(-50000);
        System.out.println("1초에 1시간동안 200원씩 법니다");
        System.out.println("일꾼 고용하기가 끝나면, 처음처럼 1초에 100원씩 법니다.");
        stopDefaultThread(); //기존 스레드 멈춤
        Thread hireThread = new Thread(hireRunnable);
        hireThread.start();// 일꾼 고용하기 스레드 시작
    }

    //일꾼 고용하기 스레드 멈춤
    public void stopHireThread(){
        hireRunnable.stopThread();
        startDefaultThread(); //일꾼 고용하기 러너블 멈추면, 기존 스레드 재시작
    }

    public void bornBaby(String randomBaby){
        System.out.println(randomBaby+ "를 낳았습니다");
        System.out.println("아이의 이름을 정해주세요");
        System.out.print("아이 이름: ");
    }

    public void balance(){
        System.out.println("현재 잔액 : "+getMoney()+"원");
    }

    public int getMoney() {
        return money;
    }
    public void setMoney(int money) {
        this.money += money;
    }

    public void replaceMoney(int money){
        this.money = money;
    }


    public void coding(){
        int codingMoney = 1000;
        setMoney(+codingMoney);
        System.out.println("코딩해서 "+codingMoney+"원 을 벌었습니다!");
        balance();
    }

    public void invest(int investMoney){
        System.out.println(investMoney+"원을 투자했습니다.");

        try {
            Thread.sleep(3000); //3초 동안 대기
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //3초동안 스레드가 잠들어 있을때, 다른 스레드가 이 스레드를 깨우려고 하는 예외가 발생하면,
        // 그 예외를 실행하지 않고 상위레벨로 보낸다

        Random random = new Random();
        double probability = random.nextDouble(); //0.0부터 1.0 사이의 난수생성
        int randomInvestMoney;

        if(probability <= 0.5){ //50퍼센트 확률로 돈을 얻음
            randomInvestMoney = (int) (investMoney * 0.3);
            setMoney(+randomInvestMoney);
            System.out.println(randomInvestMoney+ "원을 벌었습니다.");
        } else{ //50퍼센트 확률로 돈을 잃음
            randomInvestMoney = (int) (-investMoney * 0.3);
            setMoney(+randomInvestMoney);
            System.out.println(-randomInvestMoney+ "원을 잃었습니다.");
        }
        balance();
    }

    public void gamble(int gambleMoney){
        System.out.println(gambleMoney+"원을 도박했습니다.");

        try {
            Thread.sleep(3000); //3초 동안 대기
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        Random random = new Random();
        double probability = random.nextDouble(); //0.0부터 1.0 사이의 난수생성
        int randomGambleMoney;

        if(probability <= 0.3){ //승률 30퍼센트
            randomGambleMoney = (int) (gambleMoney * 0.5);
            setMoney(+randomGambleMoney);
            System.out.println(randomGambleMoney+ "원을 벌었습니다.");
        } else{ //50퍼센트 확률로 돈을 잃음
            randomGambleMoney = (int) (-gambleMoney * 0.5);
            setMoney(+randomGambleMoney);
            System.out.println(-randomGambleMoney+ "원을 잃었습니다.");
        }
        balance();
    }

    public void buyItem(int itemNum, List<Item> userItems){ //유저가 아이템을 구매한다
        if(itemNum == 99){
            System.out.println("상점에서 나왔습니다.");
            System.out.println();
        }
        for (Item item: userItems) {
            if((userItems.indexOf(item)+1) == itemNum){ //유저가 가진 아이템의 갯수가 +1 됨
                if(item.price > this.getMoney()){
                    System.out.println("돈이 부족합니다.");
                    System.out.println(item.price - this.getMoney()+"원이 더 필요합니다.");
                    System.out.println("돈벌기 맵으로 이동하세요.");
                } //잔액초과라면, 구매 불가능
                item.setNum(+1);
                setMoney(-item.price); //유저의 돈이 차감됨
                System.out.println(item.name +"을 구매하였습니다");
                break;
            }
        }

    }

    public void performMethod(int choice, Parent parent){
        int userPick = 0;
        if(choice  == 1){ //기본 돈벌기도 Parent if문으로 조작
            System.out.println("현재 1초에 100원씩 버는 중입니다. 추가로 돈을 더 버세요.");
            startDefaultThread();
            defaultRunnable.startMoney(); //6초동안 대기한 후 keepEarning(); 할건지 물어봄
        }
        else if(choice == 2){
            coding();
        }
        else if(choice == 3){
            investAmount();
            userPick = scan.nextInt();
            if(userPick == 1){
                int investMoney = (int) (getMoney()* 0.3);
                invest(investMoney);
            }else if(userPick == 2){
                int investMoney = (int) (getMoney()* 0.6);
                invest(investMoney);
            }else if(userPick == 3){
                int investMoney = getMoney();
                invest(investMoney);
            }else {
                System.out.println("유효하지 않은 선택입니다.");
            }
        }
        else if(choice == 4){
            gambleAmount();
            userPick = scan.nextInt();
            if(userPick == 1){
                int gambleMoney = (int) (getMoney()* 0.3);
                gamble(gambleMoney);
            }else if(userPick == 2){
                int gambleMoney = (int) (getMoney()* 0.6);
                gamble(gambleMoney);
            }else if(userPick == 3){
                int gambleMoney = getMoney();
                gamble(gambleMoney);
            }else {
                System.out.println("유효하지 않은 선택입니다.");
            }
        }
        else if(choice == 5){
           //일꾼 고용하기
            hireWorker();
            hireRunnable.startWorker(); //6초동안 대기한 후 keepEarning(); 할건지 물어봄
        }
        else{
            System.out.println("유효하지 않은 선택입니다.");
        }
    }

    public void investAmount(){
        System.out.println("가진돈의 몇퍼센트를 투자하시겠습니까?");
        System.out.println();
        System.out.println("1. 30%     2.60%     3.100%");
        System.out.println("숫자 입력: ");
    }

    public void gambleAmount(){
        System.out.println("가진돈의 몇퍼센트를 도박하시겠습니까?");
        System.out.println();
        System.out.println("1. 30%     2.60%     3.100%");
        System.out.println("숫자 입력: ");
    }

    public void keepEarning(){
        System.out.println("계속 버시겠습니까?");
        System.out.println();
        System.out.print("1. 계속 돈벌기 ");
        System.out.println( "2. 나가기");
        System.out.println();
        System.out.print("선택 : ");
    }


}
