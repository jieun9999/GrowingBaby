import java.util.List;

public class DevilBaby extends Baby {
    public DevilBaby() {
        Item 휴지 = new Item("휴지",5000,0,"똥 닦아주기");
        Item 사랑의매 = new Item( "사랑의 매",10000,0,"훈육하기");
        Item 김치 = new Item("김치",5000,0,"김치 먹이기");
        userItems.add(휴지);
        userItems.add(사랑의매);
        userItems.add(김치);
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
            }
        }else{
            System.out.println("유효하지 않은 선택입니다.");
        }
    }

    public void wipingPoop(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("휴지") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("지식 +10");
                this.setKnowledgeScore(+10);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("휴지 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void discipline(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("사랑의 매") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("애정 + 10, 지식 +10");
                this.setLoveScore(+10);
                this.setKnowledgeScore(+10);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("사랑의 매 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void feedKimchi(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("김치") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("애정 + 10");
                this.setLoveScore(+10);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("김치 아이템이 없습니다. 상점에서 구매하세요.");
    }
}
