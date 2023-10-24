import java.util.ArrayList;
import java.util.List;

public class Baby {
    String name = "아기";
    int level = 0;
    int loveScore = 100;
    int finalLoveScore = 0;
    int healthScore =50;
    int finalHealthScore = 0;
    int knowledgeScore =50;
    int finalKnowledgeScore =0;
    public BabyCaringRunnable babyCaringRunnable;


    public Baby() {
        //아기캐릭터에 아이템 추가
        Item 기저귀 = new Item("기저귀",5000,1, "기저귀 갈기");
        Item 우유 = new Item("우유", 3000, 1,  "밥 주기");
        userItems.add(기저귀);
        userItems.add(우유);

        //생성자에서 BabyCryingRunnable 및 BabyPeeingRunnable 초기화
        this.babyCaringRunnable = new BabyCaringRunnable(this);

    }

    public ArrayList<Item> userItems = new ArrayList<>(); //아기캐릭터에 아이템 리스트


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level += level;
    }

    public int getLoveScore() {
        return loveScore;
    }

    public void setLoveScore(int loveScore) { //인자 만큼 증가
        this.loveScore += loveScore;
    }

    public int getFinalLoveScore() {
        return finalLoveScore;
    }

    public void setFinalLoveScore(int finalLoveScore, int level) {
        this.finalLoveScore = finalLoveScore * (level +1);
    }

    public int getHealthScore() {
        return healthScore;
    }

    public void setHealthScore(int healthScore) { //인자 만큼 증가
        this.healthScore += healthScore;
    }

    public int getFinalHealthScore() {
        return finalHealthScore;
    }

    public void setFinalHealthScore(int finalHealthScore,int level) {
        this.finalHealthScore = finalHealthScore * (level +1);
    }

    public int getKnowledgeScore() {
        return knowledgeScore;
    }

    public void setKnowledgeScore(int knowledgeScore) { //인자 만큼 증가
        this.knowledgeScore += knowledgeScore;
    }

    public int getFinalKnowledgeScore() {
        return finalKnowledgeScore;
    }

    public void setFinalKnowledgeScore(int finalKnowledgeScore, int level) {
        this.finalKnowledgeScore = finalKnowledgeScore * (level +1);
    }

//    아기 달래는 스레드 시작
    public void startCaringThread() throws InterruptedException {
        Thread babyCaringThread = new Thread(babyCaringRunnable);
        babyCaringThread.start();
        babyCaringThread.join();
    }

    //    아기 달래는 스레드 멈춤
    public void stopCaringThread() throws InterruptedException {
        babyCaringRunnable.stopThread();
    }


    public void printBabyTotalScore(){ //아이의 점수
        System.out.println("=============================상태창============================");
        System.out.println();
        System.out.println("현재 "+this.getName()+"의 상태");
        System.out.println("Lv "+ this.getLevel());
        System.out.println("애정 ("+this.getLoveScore()+"/"+this.getFinalLoveScore()+")" );
        System.out.println("건강 ("+this.getHealthScore()+"/"+this.getFinalHealthScore()+")");
        System.out.println("지식 ("+this.getKnowledgeScore()+"/"+this.getFinalKnowledgeScore()+")" );
        System.out.println();
        System.out.println("==============================================================");
    }

    public void setBabyFinalScore(int finalLoveScore, int finalHealthScore, int finalknowledgeScore, int level){ //아이의 종류에 따라 최종(기준)스코어를 설정해줍니다
        this.setFinalLoveScore(finalLoveScore, level);
        this.setFinalHealthScore(finalHealthScore, level);
        this.setFinalKnowledgeScore(finalknowledgeScore,level);
    } //레벨이 올라가면 파이널스코어의 각 영역이 높아져야 함

    public void levelUpZero(Baby baby){
        //각 스코어 초기화
        baby.loveScore = 0;
        baby.healthScore =0;
        baby.knowledgeScore =0;
    }

    //레벨업 메소드
    public void levelUp(Baby baby){
        //레벨이 0부터 3까지 일때
        if(baby.getLevel() <= 3 && baby.getLoveScore() >= baby.getFinalLoveScore() && baby.getHealthScore() >= baby.getFinalHealthScore() &&  baby.getKnowledgeScore() >= baby.getFinalKnowledgeScore() ){
            baby.setLevel(1);
            //각 스코어 초기화
            levelUpZero(baby);
            System.out.println();
            System.out.println("===========================");

            if(baby.getLevel() == 4) {
                System.out.println("⭐⭐⭐ 최종 진화했다.. 수고했다 ⭐⭐⭐");
            }else{
                System.out.println("⭐⭐⭐ 베이비 진화 ⭐⭐⭐");
                System.out.println(baby.getName() + "가 Lv" + baby.getLevel() + "로 성장하였습니다 !");
            }
            System.out.println("===========================");
            System.out.println();
            System.out.println();
        }
    }

    public  void checkClear(Baby baby){
        if(baby.getLevel() == 4){
            if (baby.getLevel() == 4) {
                System.out.println("❤️❤️❤️❤️❤️❤️❤️❤️"+"LV3 게임클리어!!!"+"❤️❤️❤️❤️❤️❤️❤️❤️");
                System.out.println();
            }
        }
    }

    public void seeAllMethod(int babyLevel){
        System.out.println();
            System.out.println("< 아이 키우기 >");
            System.out.println();
            for (Item item: userItems) {
                System.out.println((userItems.indexOf(item)+1)+"."+item.use+ " : "+item.name+ " 아이템 필요!");
            }
        System.out.println();
        System.out.println("키우기 기능을 선택하세요");
        System.out.println("성장에서 나가시려면 99를 입력해주세요.");
        System.out.println();
        System.out.print("키우기 : ");
    }


    public void printItems(){ //아이캐릭터 보유아이템
        System.out.println("++++++++++++보유한 아이템+++++++++++");
        System.out.println();
        for (Item item: userItems) {
            if(item.num == 0){
                //없음
            } else {
                System.out.print((userItems.indexOf(item)+1)+".");
                System.out.print(item.name);
                System.out.print("-- 가격 : "+ item.price);
                System.out.print(" 갯수 : "+item.num);
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++");
    }

    //메소드
    public void performMethod(int choice){
    if(choice >= 1 && choice <= userItems.toArray().length){
        if(choice == 1){
            makeMeal(userItems);
        } else if (choice == 2) {
            changeDiaper(userItems);
        }
    }else{
        System.out.println("유효하지 않은 선택입니다.");
    }
    }
    public void makeMeal(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("우유") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("건강 +10");
                this.setHealthScore(+10);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("우유 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void changeDiaper(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("기저귀")&& item.getNum() >= 1){
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("건강 +10");
                this.setHealthScore(+10);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }
        }
        System.out.println("기저귀 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void keepDoing(){
        System.out.println("계속 키우시겠습니까?");
        System.out.println();
        System.out.print("1. 계속 키움 ");
        System.out.println( "2. 나가기");
        System.out.print("선택 : ");
    }

}
