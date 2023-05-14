import java.util.*;

public class Main {
    static SalesPerson[] salesPeople;

    public static String highest(SalesPerson[] salesPeople) {
        double highestTotalSales = 0;
        String highestSalesPersonID = null;

        for (SalesPerson salesPerson : salesPeople) {
            if (salesPerson != null && salesPerson.calcTotalSales() > highestTotalSales) {
                highestTotalSales = salesPerson.calcTotalSales();
                highestSalesPersonID = salesPerson.getId();
            }
        }
        return highestSalesPersonID;
    }

    public static void addSales(Sales s, String id) {
        for (SalesPerson salesPerson : salesPeople) {
            if (salesPerson != null && salesPerson.getId() == id) {
                salesPerson.setSalesHistory(s);
                return;
            }
        }
    }

    public static void main(String[] args) {
        salesPeople = new SalesPerson[6];
        salesPeople[0] = new SalesPerson("100");
        salesPeople[1] = new SalesPerson("101");
        salesPeople[2] = new SalesPerson("102");
        salesPeople[0].setSalesHistory(new Sales("A100",300.00,10));
        salesPeople[0].setSalesHistory(new Sales("A200",1000.00,2));
        salesPeople[1].setSalesHistory(new Sales("A300",2550.40,10));
        System.out.println(salesPeople[2].getId());
        System.out.println(salesPeople[0].getCount());
        System.out.println(salesPeople[1].getSalesHistory()[0].getValue());
        System.out.println(salesPeople[0].calcTotalSales());

        //addSales method
        addSales(new Sales("A400", 120000.00, 15), "102");

        //highest method
        String highestSalesPersonID = highest(salesPeople);
        System.out.println("The salesperson with the highest total sales is: " + highestSalesPersonID);

    }
}