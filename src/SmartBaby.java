import java.util.List;

public class SmartBaby extends AngelBaby {

    public SmartBaby() {
        Item 도서관회원증 = new Item("도서관 회원증",25000,0,"도서관 vip되기");
        Item 원탁책상 = new Item("원탁 책상",40000,0,"토론대회 나가기");
        Item 유학자금 = new Item("유학 자금", 100000,0,"유학 보내기");

        userItems.add(도서관회원증);
        userItems.add(원탁책상);
        userItems.add(유학자금);
    }

    public void performMethod(int choice) {
        if (choice >= 1 && choice <= userItems.toArray().length) {
            if (choice == 1) {
                makeMeal(userItems);
            } else if (choice == 2) {
                changeDiaper(userItems);
            } else if (choice == 3 ) {
                readBook(userItems);
            } else if (choice == 4) {
                putYouToBed(userItems);
            } else if (choice == 5) {
                librabryVIP(userItems);
            }else if(choice == 6){
                debateContest(userItems);
            } else if (choice == 7) {
                studyAbroad(userItems);
            }
        } else {
            System.out.println("유효하지 않은 선택입니다.");
        }
    }

    public void librabryVIP(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("도서관 회원증") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("지식 +50");
                this.setKnowledgeScore(+50);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("도서관 회원증 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void debateContest(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("원탁 책상") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("애정 +30 지식 +50");
                this.setLoveScore(+30);
                this.setKnowledgeScore(+50);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("원탁 책상 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void studyAbroad(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("유학 자금") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("지식 +200");
                this.setKnowledgeScore(+200);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("유학 자금 아이템이 없습니다. 상점에서 구매하세요.");
    }
}
