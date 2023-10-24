

import java.util.ArrayList;
import java.util.List;

public class Store {
    List<Item> storeItems = new ArrayList<>(); // 상점 아이템 리스트

    public Store() { //상점에 아이템 추가
        Item 기저귀 = new Item("기저귀",5000,100, "기저귀 갈기");
        Item 우유 = new Item("우유", 3000, 100,  "밥 주기");
        Item 책 = new Item("책", 10000, 100,"책 읽어주기");
        Item 이불 = new Item("이불",15000,100,"코~재워주기");
        Item 휴지 = new Item("휴지",5000,100,"똥 닦아주기");
        Item 사랑의매 = new Item( "사랑의 매",10000,100,"훈육하기");
        Item 김치 = new Item("김치",5000,100,"김치 먹이기");
        Item 레시피 = new Item("레시피",25000,100,"8첩반상 만들어주기");
        Item 유산균 = new Item("유산균",40000,100,"똥 잘나오는 유산균 챙겨주기");
        Item 헬스클럽회원권 = new Item("헬스 클럽 회원권",60000,100,"살빼기");
        Item 도서관회원증 = new Item("도서관 회원증",25000,100,"도서관 vip되기");
        Item 원탁책상 = new Item("원탁 책상",40000,100,"토론대회 나가기");
        Item 유학자금 = new Item("유학 자금", 100000,100,"유학 보내기");
        Item 카메라 = new Item("카메라",25000,100,"유튜버 되기");
        Item 연기학원비 = new Item("연기 학원비",75000,100,"어그로 끌기");
        Item 댄스학원비 = new Item("댄스학원비",75000,100,"제로투 추기");
        Item 새콤달콤 = new Item("새콤달콤",30000,100,"현실친구 사귀기");
        Item 노트북 = new Item("노트북",100000,100,"코딩하기");
        Item 정신과티켓 = new Item("정신과 티켓",50000,100,"정신과 상담받기");

        storeItems.add(기저귀);
        storeItems.add(우유);
        storeItems.add(책);
        storeItems.add(이불);
        storeItems.add(휴지);
        storeItems.add(사랑의매);
        storeItems.add(김치);
        storeItems.add(레시피);
        storeItems.add(유산균);
        storeItems.add(헬스클럽회원권);
        storeItems.add(도서관회원증);
        storeItems.add(원탁책상);
        storeItems.add(유학자금);
        storeItems.add(카메라);
        storeItems.add(연기학원비);
        storeItems.add(댄스학원비);
        storeItems.add(새콤달콤);
        storeItems.add(노트북);
        storeItems.add(정신과티켓);
    }

    public void showStoreItems(Baby baby){
        System.out.println("상점 아이템 목록");
        //캐릭터가 살 수 있는 상품만 출력
        for (Item item: baby.userItems) {
            System.out.print((baby.userItems.indexOf(item)+1)+". ");
            System.out.print(item.name+" //");
            System.out.print(" 기능: "+ item.use);
            System.out.print(" 가격: "+ item.price);
            System.out.println();
        }
        System.out.println();
        System.out.println("무엇을 구매하시겠습니까?");
        System.out.println("상점에서 나가시려면 '99'를 입력해주세요");
        System.out.println();
        System.out.print("구매물품 : ");
    }

    public void keepBuying(){
        System.out.println("계속 구매하시겠습니까?");
        System.out.println();
        System.out.print("1. 계속 구매 ");
        System.out.println( "2. 나가기");
        System.out.print("선택 : ");
    }
}
