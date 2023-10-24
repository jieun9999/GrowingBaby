import java.util.List;

public class AngelBaby extends Baby {
    public AngelBaby() {
        Item 책 = new Item("책", 10000, 1,"책 읽어주기");
        Item 이불 = new Item("이불",15000,0,"코~재워주기");
        userItems.add(책);
        userItems.add(이불);
    }

    public void performMethod(int choice){
        if(choice >= 1 && choice <= userItems.toArray().length){
            if(choice == 1){
                makeMeal(userItems);
            } else if (choice == 2) {
                changeDiaper(userItems);
            } else if (choice == 3 ) {
                readBook(userItems);
            } else if (choice == 4) {
                putYouToBed(userItems);
            }
        }else{
            System.out.println("유효하지 않은 선택입니다.");
        }
    }

    public void readBook(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("책") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("지식 +20");
                this.setKnowledgeScore(+20);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("책 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void putYouToBed(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("이불") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("애정 +20");
                this.setLoveScore(+30);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("책 아이템이 없습니다. 상점에서 구매하세요.");
    }
}
