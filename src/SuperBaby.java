import java.util.List;

public class SuperBaby extends AngelBaby {

    public SuperBaby() {
        Item 레시피 = new Item("레시피",25000,0,"8첩반상 만들어주기");
        Item 유산균 = new Item("유산균",40000,0,"똥 잘나오는 유산균 챙겨주기");
        Item 헬스클럽회원권 = new Item("헬스 클럽 회원권",60000,0,"살빼기");

        userItems.add(레시피);
        userItems.add(유산균);
        userItems.add(헬스클럽회원권);
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
                eightCheopTable(userItems);
            }else if(choice == 6){
                lactobacillus(userItems);
            } else if (choice == 7) {
                diet(userItems);
            }
        } else {
            System.out.println("유효하지 않은 선택입니다.");
        }
    }

    public void eightCheopTable(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("레시피") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("애정 +20");
                this.setLoveScore(+50);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("레시피 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void lactobacillus(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("유산균") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("애정 +30, 건강 +50");
                this.setLoveScore(+30);
                this.setHealthScore(+50);
                item.setNum(-1); //1개 줄어듦
                return; // 유산균을 찾았으므로 반복문 종료
            }

        }
        System.out.println("레시피 아이템이 없습니다. 상점에서 구매하세요.");
    }

    public void diet(List<Item> userItems){
        for (Item item: userItems) {
            if(item.name.equals("헬스 클럽 회원권") && item.getNum() >= 1){ //수량이 1보다 커야 한다
                System.out.println(item.use+" : "+item.name+ " 아이템 사용");
                System.out.println("애정 +20, 건강 +100");
                this.setLoveScore(+20);
                this.setHealthScore(+100);
                item.setNum(-1); //1개 줄어듦
                return; // 아이템을 찾았으므로 반복문 종료
            }

        }
        System.out.println("헬스 클럽 회원권 아이템이 없습니다. 상점에서 구매하세요.");
    }
}
