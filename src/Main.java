import javax.sound.sampled.LineUnavailableException;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void handleBabyActions(Baby baby, Parent parent, String name, Narration narration) throws InterruptedException, LineUnavailableException {
        Scanner scan = new Scanner(System.in);
        //상점 객체를 만든다
        Store store = new Store();
        //약국 객체를 만든다
        DrugStore drugStore = new DrugStore();
        //돈벌기 객체를 만든다
        MakeMoney makeMoney = new MakeMoney();

        baby.setName(name);
        scan.nextLine();
        baby.printBabyTotalScore();//아이의 점수를 불러온다
        parent.replaceMoney(50000); //50000원을 줌
        parent.balance(); //유저의 잔액을 보여준다
        narration.enterExplain();
        int selectedNum = scan.nextInt();
        System.out.println();
        while (selectedNum != 7) {
            if (selectedNum == 1) {
                //배경음악 시작
                String musicFilePath = "src/Music/safari-158855.wav"; //배경음악 파일 상대경로
                BackMusicStart backMusicThread = new BackMusicStart(musicFilePath);
                backMusicThread.start();

                //1.성장
                int userStayPick = 1;
                while (userStayPick == 1) {
                    //1.계속 키운다
                    //<주의> 한번 만든 형(타입)을 바꾸는 것은 좋지않다
                    baby.seeAllMethod(baby.getLevel());
                    scan.nextLine();
                    int userMethodPick = scan.nextInt();
                    if (userMethodPick == 99) { //나가고 싶다고 하면 언제든 탈출가능
                        backMusicThread.stopMusic(); //배경음악 멈춤
                        break;
                    }
                    System.out.println();
                    baby.performMethod(userMethodPick);//유저가 기능을 선택
                    baby.levelUp(baby); //성장후 레벨업 확인
                    baby.checkClear(baby);//lv3 게임클리어
                    if(baby.getLevel() == 4){
                        backMusicThread.stopMusic(); //배경음악 멈춤
                        break;
                    }
                    baby.setBabyFinalScore(50,100,50, baby.getLevel());
                    baby.printBabyTotalScore();//아이의 점수를 불러온다
                    parent.balance(); //유저의 잔액을 보여준다
                    baby.keepDoing();
                    userStayPick = scan.nextInt(); //계속 키울건지 말지 답변
                    if (userStayPick == 2) {  //나가고 싶다고 하면 언제든 탈출가능
                        backMusicThread.stopMusic(); //배경음악 멈춤
                        break;
                    }
                }

            }
            else if (selectedNum == 2) {
                //2.돈 벌기
                System.out.println("돈 벌기에 입장하였습니다");
                System.out.println("시간이 없습니다. 빨리빨리 돈을 버세요.");
                System.out.println();
                int userStayPick = 1;
                while (userStayPick == 1) { //1.계속 돈번다
                    makeMoney.enterExplain();
                    scan.nextLine();
                    int userPick = scan.nextInt();
                    if (userPick == 99) { //나가고 싶다고 하면 언제든 탈출가능
                        break;
                    }
                    System.out.println();
                    parent.performMethod(userPick,parent);//유저가 선택한 숫자에 대한 메소드를 실행함
                    //userPick이 1번,5번(기본 돈벌기, 일꾼 고용하기 스레드의 경우, 자체적으로 6초 뒤에 parent.keepEarning(); 실행됨)
                    if(userPick ==2 || userPick ==3 || userPick ==4){
                        parent.keepEarning();
                    }
                    userStayPick = scan.nextInt(); //계속 돈벌거냐고 답변받음
                    if (userStayPick == 2) {  //2. 나가고 싶다고 하면 언제든 탈출가능
                        break;
                    }
                }

            }
            else if (selectedNum == 3) {
                //3.상점
                System.out.println("상점에 입장하였습니다");
                System.out.println();
                int userStayPick = 1;
                while (userStayPick == 1) { //1.계속 산다
                    store.showStoreItems(baby);
                    scan.nextLine();
                    int userPick = scan.nextInt();
                    if (userPick == 99) { //나가고 싶다고 하면 언제든 탈출가능
                        break;
                    }
                    System.out.println();
                    parent.buyItem(userPick, baby.userItems); //유저가 물품을 구매한다
                    System.out.println("=============================상태창============================");
                    System.out.println();
                    parent.balance(); //잔액조회
                    store.keepBuying();
                    userStayPick = scan.nextInt(); //계속 살거냐고 답변받음
                    if (userStayPick == 2) {  //나가고 싶다고 하면 언제든 탈출가능
                        break;
                    }
                }
                //userStayPick이 2인 경우
                //2. 상점 나간다
            }
            else if (selectedNum == 4) {
                //4.약국
                System.out.println("약국에 입장하였습니다");
                System.out.println("신비한 물약을 먹이면, 아이가 쑥쑥 자랍니다 ^ 0 ^");
                System.out.println();
                int userStayPick = 1;
                while (userStayPick == 1) { //1.계속 산다
                    drugStore.showStoreItems(baby);
                    scan.nextLine();
                    int userPick = scan.nextInt();
                    if (userPick == 99) { //나가고 싶다고 하면 언제든 탈출가능
                        break;
                    }
                    System.out.println();
                    parent.buyItem(userPick, drugStore.drugStoreItems); //유저가 물품을 구매한다
                    drugStore.drink(userPick, baby);//약물 먹음
                    baby.levelUp(baby); //성장후 레벨업 확인
                    baby.checkClear(baby);//lv3 게임클리어
                    if(baby.getLevel() == 4){
                        break;
                    }
                    baby.setBabyFinalScore(50,100,50, baby.getLevel());
                    baby.printBabyTotalScore();//아이의 점수를 불러온다
                    System.out.println();
                    parent.balance(); //잔액조회
                    drugStore.keepBuying();
                    userStayPick = scan.nextInt(); //계속 살거냐고 답변받음
                    if (userStayPick == 2) {  //나가고 싶다고 하면 언제든 탈출가능
                        break;
                    }
                }
                //userStayPick이 2인 경우
                //2. 약국 나간다
            }
            else if (selectedNum == 5) {
                //5.인벤토리
                System.out.println("인벤토리에 입장하였습니다");
                System.out.println();
                baby.printItems();
            }
            else if (selectedNum == 6) {
                //6. 아기 놀아주기
                //아이울음소리  배경음악 시작
                String musicFilePath = "src/Music/6.아이놀아주기.wav"; //배경음악 파일 상대경로
                BackMusicStart backMusicThread = new BackMusicStart(musicFilePath);
                backMusicThread.start();
                baby.startCaringThread(); //아이달래기 스레드 시작
                // 하나의 1초 간격으로 실행되는 스레드 만들고, 변수에 +1씩해줘서,
                // 변수가 3의 배수, 5의 배수일때, 15의 배수일때 각각 출력함!
                backMusicThread.stopMusic(); //배경음악 멈춤



            }
            if(baby.getLevel() == 4){
                break;
            }
            // 어떤 장소에서 나올경우, 장소 선택 메뉴얼
            System.out.println();
            System.out.println();
            narration.enterExplain();
            selectedNum = scan.nextInt();
            System.out.println();
        }
        //종료 배경음악 시작
        String musicFilePath = "src/Music/7.게임종료.wav"; //배경음악 파일 상대경로
        BackMusicStart backMusicThread = new BackMusicStart(musicFilePath);
        backMusicThread.start();
        Thread.sleep(3000); //메인 스레드 3초 쉬기

        parent.stopDefaultThread(); // 기본 스레드 종료
        parent.stopHireThread(); //일꾼 스레드 종료
        baby.stopCaringThread(); //아기 우는 스레드 종료

    }
    public static void main(String[] args) throws InterruptedException, LineUnavailableException {

        // 4종류의 베이비 객체를 만든다
        SuperBaby superBaby = new SuperBaby();
        SmartBaby smartBaby = new SmartBaby();
        AttentionBaby attentionBaby = new AttentionBaby();
        PsychoBaby psychoBaby = new PsychoBaby();

        //각 베이비별 LV0 필요점수를 설정함
        superBaby.setBabyFinalScore(50,100,50,0);
        smartBaby.setBabyFinalScore(50,50,100,0);
        attentionBaby.setBabyFinalScore(100,50,50,0);
        psychoBaby.setBabyFinalScore(25,75,100,0);

        // 부모 객체를 만든다
        Parent superParent = new Parent();
        Parent smartparent = new Parent();
        Parent attentionparent = new Parent();
        Parent psychoparent = new Parent();

        Scanner scan = new Scanner(System.in);
        Random random = new Random();
        String[] babyOptions = {
                "슈퍼 베이비",
                "스마트 베이비",
                "관종 베이비",
                "싸이코패스 베이비",
        };

        int randomIndex = random.nextInt(babyOptions.length);
        String randomBaby = babyOptions[randomIndex];

        //해설 객체를 만든다
        Narration narration = new Narration();
        narration.stay();
        Parent defaultParent = new Parent(); // 기본 부모
        defaultParent.bornBaby(randomBaby); //유저가 아이를 낳았다 + 이름을 정한다
        String name = scan.nextLine();

        if(randomBaby.equals("슈퍼 베이비")){
            handleBabyActions(superBaby, superParent, name,narration);
        } else if (randomBaby.equals("스마트 베이비")) {
            handleBabyActions(smartBaby,smartparent,name, narration);
        } else if (randomBaby.equals("관종 베이비")) {
            handleBabyActions(attentionBaby,attentionparent,name,narration);
        } else if (randomBaby.equals("싸이코패스 베이비")) {
            handleBabyActions(psychoBaby,psychoparent,name,narration);
        }

        //게임종료
        System.out.println("게임을 종료합니다.");
    }
    }



