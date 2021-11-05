package io.github.freshbread.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StockCalculatorController {

    @RequestMapping("/service/cal")
    public Map<String, Object> serviceCal(HttpServletRequest httpServletRequest, Model model) {

        Map<String, Object> returnObj = new HashMap<>();

        String paramStartDateYear = httpServletRequest.getParameter("startdy");
        String paramPeriodYear = httpServletRequest.getParameter("periody");
        String paramSaveMoney = httpServletRequest.getParameter("smoney");
        // 1년 투자 중 예상 이익 비율
        String paramPeriodBill = httpServletRequest.getParameter("pbill");
        // 1년 예상 이익 비율
        String paramYearBill = httpServletRequest.getParameter("ybill");

        Map<Integer, Double> moneyList = new HashMap<>();

        int startYear = Integer.parseInt(paramStartDateYear);
        int periodYear = Integer.parseInt(paramPeriodYear);
        double allMoney = 0;
        double saveMoney = Double.parseDouble(paramSaveMoney);
        double periodBill = Double.parseDouble(paramPeriodBill);
        double yearBill = Double.parseDouble(paramYearBill);

        for (int cnt = 0; cnt <= periodYear; cnt++) {
            allMoney = (allMoney * yearBill) + (saveMoney * periodBill);

            moneyList.put(startYear + cnt, allMoney);
        }

        returnObj.put("list", moneyList);

        return returnObj;
    }
}
