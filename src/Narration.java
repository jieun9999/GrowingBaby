import java.util.Scanner;

public class Narration {
    Scanner scan = new Scanner(System.in);
    public void stay(){
        System.out.println("3초 후에 분열완료됩니다.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("당신은 아이를 선택할 수 없고, 랜덤으로 낳게 됩니다");
        scan.nextLine();
    }

    public void enterExplain(){
        System.out.println();
        System.out.println("1.성장 2.돈 벌기 3.상점 4.약국 5.인벤토리 6.아기 놀아주기 7.게임 종료");
        System.out.println();
        System.out.println("어디로 입장하시겠습니까?");
        System.out.print("입장 번호:");
    }

}
