/*
Write a class StockSpanner which collects daily price quotes for some stock, and returns the span of that stock's price for the current day.

The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backwards) for which the price of the stock was less than or equal to today's price.

For example, if the price of a stock over the next 7 days were [100, 80, 60, 70, 60, 75, 85], then the stock spans would be [1, 1, 1, 2, 1, 4, 6].

 

Example 1:

Input: ["StockSpanner","next","next","next","next","next","next","next"], [[],[100],[80],[60],[70],[60],[75],[85]]
Output: [null,1,1,1,2,1,4,6]
Explanation: 
First, S = StockSpanner() is initialized.  Then:
S.next(100) is called and returns 1,
S.next(80) is called and returns 1,
S.next(60) is called and returns 1,
S.next(70) is called and returns 2,
S.next(60) is called and returns 1,
S.next(75) is called and returns 4,
S.next(85) is called and returns 6.

Note that (for example) S.next(75) returned 4, because the last 4 prices
(including today's price of 75) were less than or equal to today's price.
 

Note:

Calls to StockSpanner.next(int price) will have 1 <= price <= 10^5.
There will be at most 10000 calls to StockSpanner.next per test case.
There will be at most 150000 calls to StockSpanner.next across all test cases.
The total time limit for this problem has been reduced by 75% for C++, and 50% for all other languages.
*/
/**
Apporach, Stack the values that are incomming as an additional data structure that hold the value of the stock as well as how many others have passed that are smaller than himself as values. 
this way you can retrieve with ease how many before him where before as well as compare with the new current value.
 */
class StockSpanner {
    Stack<Stock> stack1;

    public StockSpanner() {
        stack1 = new Stack<Stock>();
        
    }
    
    public int next(int price) {
        stack1.push(new Stock(price,1));
        Stock temp = new Stock();
        int counter = 0;
        while(!stack1.isEmpty() && stack1.peek().svalue <= price){
            temp = stack1.pop();
            counter += temp.vbvalue;
        }
        
        stack1.push(new Stock(price,counter));
        return counter;
    }
}

class Stock{
    int svalue;
    int vbvalue; //value before value.
    
    public Stock(){}
    public Stock(int svalue, int vbvalue){
        this.svalue = svalue;
        this.vbvalue = vbvalue;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */