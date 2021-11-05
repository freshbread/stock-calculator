import org.junit.jupiter.api.Test;

public class CalculatorTest {

    @Test
    public void test() {

        int dateYear = 2021;
        double allMoney = 0;
        double saveYear1 = 400;
        //double saveYear2 = 1300;
        double bill1 = 1.06;
        double bill2 = 1.11;

        for (int cnt = 1; cnt <= 27; cnt++) {
//            if (dateYear < 2031) {
//                allMoney = (allMoney * bill2) + (saveYear1 * bill1);
//            } else {
//                allMoney = (allMoney * bill2) + (saveYear2 * bill1);
//            }
            allMoney = (allMoney * bill2) + (saveYear1 * bill1);
            System.out.println(dateYear + "년 투자 결과 금액: " + allMoney + "만원");
            dateYear++;
        }
    }
}
