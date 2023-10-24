import java.util.ArrayList;
import java.util.List;

public class DrugStore {
    public List<Item> drugStoreItems = new ArrayList<>(); // 약국 아이템 리스트

    public DrugStore() { //약국에 아이템 추가
        Item 애정폭탄물약 = new Item("애정폭탄 물약",100000,100, "애정 + 200");
        Item 건강폭탄물약 = new Item("건강폭탄 물약",100000,100, "건강 + 200");
        Item 지식폭탄물약 = new Item("지식폭탄 물약",100000,100, "지식 + 200");

        drugStoreItems.add(애정폭탄물약);
        drugStoreItems.add(건강폭탄물약);
        drugStoreItems.add(지식폭탄물약);
    }

    public void showStoreItems(Baby baby){
        System.out.println("약국 아이템 목록");
        //캐릭터가 살 수 있는 상품만 출력
        for (Item item: drugStoreItems) {
            System.out.print((drugStoreItems.indexOf(item)+1)+". ");
            System.out.print(item.name+" //");
            System.out.print(" 기능: "+ item.use);
            System.out.print(" 가격: "+ item.price);
            System.out.println();
        }
        System.out.println();
        System.out.println("무엇을 구매하시겠습니까?");
        System.out.println("약국에서 나가시려면 '99'를 입력해주세요");
        System.out.println();
        System.out.print("구매물품 : ");
    }

    public void drink(int userPick, Baby baby){ //스겜을 하려면 여기 수치를 바꿔주셈
            if(userPick == 1){
                System.out.println("애정폭탄 물약을 마십니다");
                baby.setLoveScore(+200);
                System.out.println("✨✨✨애정이 +200 증가했습니다!✨✨✨");
            } else if (userPick == 2) {
                System.out.println("건강폭탄 물약을 마십니다");
                baby.setHealthScore(+200);
                System.out.println("✨✨✨건강이 +200 증가했습니다!✨✨✨");
            }else if (userPick == 3) {
                System.out.println("지식폭탄 물약을 마십니다");
                baby.setKnowledgeScore(+200);
                System.out.println("✨✨✨지식이 +200 증가했습니다!✨✨✨");
            }

    }

    public void keepBuying(){
        System.out.println("계속 구매하시겠습니까?");
        System.out.println();
        System.out.print("1. 계속 구매 ");
        System.out.println( "2. 나가기");
        System.out.print("선택 : ");
    }
}
