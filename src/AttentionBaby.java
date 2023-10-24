import java.util.List;

public class AttentionBaby extends DevilBaby {

    public AttentionBaby() {
        Item 카메라 = new Item("카메라",25000,0,"유튜버 되기");
        Item 연기학원비 = new Item("연기 학원비",75000,0,"어그로 끌기");
        Item 댄스학원비 = new Item("댄스 학원비",75000,0,"제로투 추기");

        userItems.add(카메라);
        userItems.add(연기학원비);
        userItems.add(댄스학원비);
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
                kidsYoutuber(userItems);
            } else if (choice == 7) {
                aggro(userItems);
            } else if (choice == 8) {
                zero2(userItems);
            }
        }else{
            System.out.println("유효하지 않은 선택입니다.");
        }
    }


    public void kidsYoutuber(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("카메라") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("지식 +50");
                this.setKnowledgeScore(+50);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("카메라 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void aggro(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("연기 학원비") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("건강 +150");
                this.setHealthScore(+150);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("연기 학원비 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void zero2(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("댄스 학원비") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("애정 +150");
                this.setLoveScore(+150);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }
        }
        System.out.println("댄스 학원비 아이템이 없습니다. 상점에서 구매하세요.");
    }

}
