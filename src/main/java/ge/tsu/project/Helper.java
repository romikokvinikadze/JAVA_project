package ge.tsu.project;

import java.util.HashMap;


public class Helper {
    HashMap<String, Currency> map;

    Helper(HashMap<String, Currency> map){
        this.map = map;
    }

    void getRate(String from, String to, double quantity){
        if (!map.containsKey(from) || !map.containsKey(to)){
            System.out.println("invalid input argument(s), please try again!");
            return;
        }

        Currency currency1 = map.get(from);
        Currency currency2 = map.get(to);

        double curr1 = currency1.getRate() / (double) currency1.getQuantity();
        double curr2 = currency2.getRate() / (double) currency2.getQuantity();

        System.out.printf("%.2f %s(%s) === %.2f %s(%s)", quantity, currency1.getName(), currency1.getCode(), quantity * (curr1 / curr2), currency2.getName(), currency2.getCode());
    }

}
