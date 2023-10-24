import java.util.List;

public class PsychoBaby extends DevilBaby {

    public PsychoBaby() {
        Item 새콤달콤 = new Item("새콤 달콤",30000,0,"현실친구 사귀기");
        Item 노트북 = new Item("노트북",100000,0,"코딩하기");
        Item 정신과티켓 = new Item("정신과 티켓",50000,0,"정신과 상담받기");

        userItems.add(새콤달콤);
        userItems.add(노트북);
        userItems.add(정신과티켓);
    }

    public void performMethod(int choice){
        if(choice >= 1 && choice <= userItems.toArray().length){
            if(choice == 1){
                makeMeal(userItems);
            } else if (choice == 2) {
                changeDiaper(userItems);
            } else if (choice == 3 ) {
                wipingPoop(userItems);
            } else if (choice == 4) {
                discipline(userItems);
            } else if (choice == 5) {
                feedKimchi(userItems);
            }else if(choice == 6){
                realFriends(userItems);
            } else if (choice == 7) {
                helloCoding(userItems);
            } else if (choice == 8) {
                seePsychiatrist(userItems);
            }
        }else{
            System.out.println("유효하지 않은 선택입니다.");
        }
    }

    public void realFriends(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("새콤 달콤") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("애정 +60");
                this.setLoveScore(+60);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }
        }
        System.out.println("새콤 달콤 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void helloCoding(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("노트북") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("지식 +200");
                this.setKnowledgeScore(+200);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }
        }
        System.out.println("노트북 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void seePsychiatrist (List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("정신과 티켓") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("건강 +100");
                this.setHealthScore(+100);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }
        }
        System.out.println("정신과 티켓 아이템이 없습니다. 상점에서 구매하세요.");
    }
}
