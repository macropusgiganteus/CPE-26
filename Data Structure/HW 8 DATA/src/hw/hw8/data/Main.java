/* HW8
 * Due: 18 November 2018
 * Problem Header Hash Code: 8033763464f100405513a3e9d1c5017e
*/ 
package hw8;

/**
 *
 * @author patiw
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StockMarket market = new StockMarket(10, 10); // 10 investos, 10 stocks
                // Add 10 investors and the initial balance
        market.addInvestor("Sarun", 10000); // ID=0
        market.addInvestor("Radit", 10000); // ID=1
        market.addInvestor("Natchapon", 10000); // ID=2
        market.addInvestor("Nirush", 9000); // ID=3
        market.addInvestor("Thanaphon", 9000); // ID=4
        market.addInvestor("Thanawong", 9000); // ID=5
        market.addInvestor("Atichat", 8000); // ID=6
        market.addInvestor("Noratap", 8000); // ID=7
        market.addInvestor("Thut", 8000); // ID=8
        market.addInvestor("Pichchai", 8000); // ID=9
        // Add 10 stocks and the initial price
        market.addStock("PTT", 344);
        market.addStock("CPALL", 60.5);
        market.addStock("SCB", 144);
        market.addStock("KBANK", 170);
        market.addStock("CPF", 27.75);
        market.addStock("TRUE", 7.15);
        market.addStock("CPN", 53);
        market.addStock("BTS", 8.35);
        market.addStock("DTAC", 35.50);
        market.addStock("LH", 8.75);
        
        market.showStockOwnership();
        // Investors spent half of their money to randomly buy stocks from companies (IPO).
        //market.simulateIPO(); //
        market.loadSavedIPO(); // load simulatedIPO
        market.showStockOwnership();
        
        market.portfolio("Radit");
        market.portfolio("Sarun");
        
        // To uncomment below, you need to implement Heap
        
        System.out.println("***************************************************** [Testing] *****************************************************\n");
        market.submitSellOrder("Natchapon", "SCB", 5, 200);
        
        market.submitSellOrder("Atichat", "SCB", 10, 180);
        
        market.quote("SCB");
        
        market.submitBuyOrder("Nirush", "SCB", 6, 250);
        market.submitBuyOrder("Thanaphon", "SCB", 6, 250);
        
        market.portfolio("Nirush");
        market.portfolio("Thanaphon");
        market.portfolio("Natchapon");
        market.portfolio("Atichat");
        
        market.quote("KBANK");
        
        market.submitBuyOrder("Thanawong", "KBANK", 2, 90);
        market.quote("KBANK");
        
        market.submitBuyOrder("Atichat", "KBANK", 1, 85);
        market.quote("KBANK");

        market.submitBuyOrder("Noratap", "KBANK", 3, 90);
        market.quote("KBANK");
        market.submitBuyOrder("Thut", "KBANK", 2, 100);
        market.quote("KBANK");
        market.submitBuyOrder("Pichchai", "KBANK", 2, 80);
        market.quote("KBANK");
        

        market.submitSellOrder("Nirush", "KBANK", 2, 150);
        market.quote("KBANK");
        
        market.submitSellOrder("Nirush", "KBANK", 6, 85);
        
        market.portfolio("Nirush");
        
        market.showStockOwnership();

        market.submitSellOrder("Sarun", "PTT", 3, 350);
        market.submitSellOrder("Sarun", "PTT", 3, 360);
        market.submitSellOrder("Sarun", "PTT", 4, 370);
        market.submitSellOrder("Natchapon", "PTT", 5, 355);
        market.submitSellOrder("Natchapon", "PTT", 5, 365);
        market.submitSellOrder("Natchapon", "PTT", 5, 375);
        market.submitSellOrder("Thanaphon", "PTT", 3, 360);
        market.submitSellOrder("Thanaphon", "PTT", 3, 370);
        market.submitSellOrder("Thanaphon", "PTT", 4, 380);
        
        market.submitBuyOrder("Radit", "PTT", 6, 370);
        market.submitBuyOrder("Nirush", "PTT", 6, 370);
        market.submitBuyOrder("Thanawong", "PTT", 10, 370);
        market.submitBuyOrder("Atichat", "PTT", 10, 370);
        
        market.submitBuyOrder("Noratap", "PTT", 2, 330);
        market.submitBuyOrder("Noratap", "PTT", 2, 300);
        market.submitBuyOrder("Noratap", "PTT", 2, 270);
        
        market.submitBuyOrder("Thut", "PTT", 3, 330);
        market.submitBuyOrder("Thut", "PTT", 3, 250);
        market.submitBuyOrder("Thut", "PTT", 3, 200);
        
        market.submitSellOrder("Pichchai", "PTT", 3, 320);
        market.submitSellOrder("Pichchai", "PTT", 3, 240);
        market.submitSellOrder("Pichchai", "PTT", 4, 220);
        market.submitSellOrder("Radit", "PTT", 3, 320);
        market.submitSellOrder("Radit", "PTT", 3, 240);
        market.submitSellOrder("Radit", "PTT", 4, 220);
        
        market.quote("PTT");
        
        market.showStockOwnership();
        
        market.portfolio("Radit");
        
        market.submitBuyOrder("Sarun", "PTT", 20, 150);
        market.submitBuyOrder("Sarun", "PTT", 20, 100);
        market.submitBuyOrder("Sarun", "PTT", 10, 50);
        
        market.submitSellOrder("Thanawong", "PTT", 10, 125);
        market.submitSellOrder("Atichat", "PTT", 10, 75);
        market.submitSellOrder("Noratap", "PTT", 15, 75);
        market.submitSellOrder("Thut", "PTT", 15, 75);
        
        market.quote("PTT");
        
        market.portfolio("Radit");

        
    }
    
}
