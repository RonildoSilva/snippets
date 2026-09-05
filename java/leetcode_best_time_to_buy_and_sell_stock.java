class Solution {
    public int maxProfit(int[] prices) {
        //int bestDay = 0;
        int day = 0;
        int profit= 0;

        while(day < prices.length-1){
            if(prices[day] < prices[]){ // 
                int temp = prices[buyDay+1] - prices[buyDay];
                if(temp > profit){
                    profit = temp;
                }
            }
        }
}
//ex: [6,7,4,3,1]




  7,1,5,3,6,4
7 0 -6 -2 -4 -1 -3
1 
5 
3 
6 
4 
                .
1   2   3   4   5   6
7,  2,  5,  3,  6,  4
0, -5, -2, -4, -1, -3 // descobrimos o indice do melhor dia de venda (dia de venda) // nao tivmoes lucro , muda o dia

0, -6, -2, -4, -1, -3 
    0   3   1   4 



[7, 6, 4, 3, 1]
[0,-1,-3,-4,-6]



Ane Fernandes
20:55
class Solution {
    public int maxProfit(int[] prices) {
        int bestBuy = 0;
        int bestSell = 1;
        int profit=0;

        //encontrar o melhor dia de venda. 
        while(day < prices.length-1){ // [7,1,5,3,6,4]
            int temp = prices[bestSell] - prices[day]; [5] - [7] = -6
            if(temp > profit || bestSell < prices.length-1){ // -6 
                profit = temp;
            }
            bestSell++;
        }

}
//ex: [6,7,4,3,1]