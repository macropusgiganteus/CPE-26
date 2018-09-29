/* HW4
 * Due: 20 September 2018
 * Problem Header Hash Code: 9cfcd080e35582c72f69f5b90ec7c2e3
*/ 
package hw.pkg4;

/**
 *
 * @author Patiwet
 */
public class Stock {
    private List list;
    private int totalShares;
    
    public Stock(String costBasis){ //สร้าง object queue หรือ stack
        switch (costBasis) { 
            case "FIFO": 
                list = new Queue();
                break;
            case "LIFO":
                list = new Stack();
                break;
            default:
                System.out.println("Invalid cost basis. Choose FIFO or LIFO");
                break;
        }
    }
    
    public void buy(int boughtShares, double boughtPrice){ //ซื้อหุ้นเข้าบัญชี โดยสร้าง Node มาเก็บค่าจำนวนหุ้นและราคาหุ้นแล้ว push เข้า queue หรือ stack
        list.push(new Node(boughtShares,boughtPrice));
        totalShares += boughtShares; //เพิ่มจำนวนหุ้นทั้งหมดที่มี
    }
    
    public void sell(int soldShares, double soldPrice){ //ขายหุ้นตามจำนวนและราคาที่รับเข้ามา
        if (soldShares <= totalShares){ //ถ้าจำนวนหุ้นที่ขายน้อยกว่าหรือเท่ากับหุ้นที่มี
            double realizedGain = 0.0;
            double unrealizedGain = 0.0;
            while(soldShares!=0){//ถ้ายังขายหุ้นไม่ครบตามจำนวน
                if(list.top().shares<soldShares){ //ถ้า Node บนสุด(สำหรับ stack) หรือหน้าสุด(สำหรับ queue)มีจำนวนหุ้นน้อยกว่าจำนวนหุ้นที่ต้องการขาย
                    realizedGain += ((soldPrice-list.top().price)*list.top().shares); //กำไร/ขาดทุนที่เกิดขึ้นจริง
                }
                else{ //ถ้า Node บนสุด(สำหรับ stack) หรือหน้าสุด(สำหรับ queue)มีจำนวนหุ้นมากกว่าหรือเท่ากับจำนวนหุ้นที่ต้องการขาย
                    realizedGain += ((soldPrice-list.top().price)*soldShares); //กำไร/ขาดทุนที่เกิดขึ้นจริง
                }
                if(soldShares<list.top().shares){ //ถ้าจำนวนหุ้นที่ต้องการขายมีน้อยกว่าจำนวนหุ้นใน Node บนสุด(สำหรับ stack) หรือหน้าสุด(สำหรับ queue)
                    list.top().shares -= soldShares;
                    soldShares = 0;
                }
                else{ //ถ้าจำนวนหุ้นที่ต้องการขายมีมากกว่าหรือเท่ากับจำนวนหุ้นใน Node บนสุด(สำหรับ stack) หรือหน้าสุด(สำหรับ queue)
                    soldShares -= list.top().shares;
                    list.pop();
                }       
            }            
            Node current = list.top(); //ให้ current = Node บนสุด(สำหรับ stack) หรือหน้าสุด(สำหรับ queue)
            while(current!=null){ //เช็ค current จนถึงตัวสุดท้ายของ list
                unrealizedGain += ((soldPrice-current.price)*current.shares); //กำไร/ขำดทุนทำงบัญชี 
                current = current.next;
            }                      
            totalShares -= soldShares; //หุ้นที่มี - หุ้นที่ขาย
            System.out.println("Realized P/L = " + realizedGain + " Unrealized P/L = " + unrealizedGain); //แสดงกำไร/ขาดทุนที่เกิดขึ้นจริง และ กำไร/ขำดทุนทำงบัญชี 
        }else{ //ถ้าจำนวนหุ้นที่ขายมากกว่าหุ้นที่มี
            System.out.println("Sell command rejected");
        }
    }
    
    public void showList(){ //แสดง Node ที่อยู่ใน list ว่ามีอะไรบ้าง
        Node currentNode = list.top(); 
        System.out.print("head -> ");
        while (currentNode!=null){ //เช็ค currentNode จนถึงตัวสุดท้าย
            System.out.print("[" + currentNode.shares + "@" + currentNode.price + "B] -> "); //print Node
            currentNode = currentNode.next;
        }
        System.out.println("tail");
    }
    
}