package Day1;
// import java.util.*;
class code
{
    public static void main(String[] args) 
    {
        int[] arr = {3,2,4,5,17,7,8,8,2,3,2,24,5};
        // int[] arr = {1,-1,-1,1,2,-4,6};
        System.out.print(profit(arr));
    }
    
    //Trapping rain water
    static int trap(int[] arr)
    {
            int res = 0;
            int maxLeft = Integer.MIN_VALUE;
            int maxRight = Integer.MIN_VALUE;
            int left = 0;
            int right = arr.length-1;

            while(left <= right)
            {
                if(arr[left] <= arr[right])
                {
                    if(maxLeft < arr[left])
                    {
                        maxLeft = arr[left];
                    }
                    else
                    {
                        res += maxLeft - arr[left];
                    }
                    left++;
                }
                else
                {
                    if(maxRight < arr[right])
                    {
                        maxRight = arr[right];
                    }
                    else
                    {
                        res += maxRight - arr[right];
                    }
                    right--;
                }
            }
            return res;
        }
// For Array[] = {3, 0, 2, 0, 2} 
// Water stored = 0 + 3 + 1 + 3 + 0 = 7 
    //00
//    0               0       0   4
//    0  0           0        0   3
//    0  0           0       0   2
//    0  0           0       0   1 

//min span that will give you maximum profit
//  [23,2,4,5,17,7,8,8,2,3,2,24,5]

// [1,-1,-1,1,2,-4,6]

    static int profit(int[] arr)
    {
        int maxProfit = 0;
        int buyAt = -1;
        int sellAt = -1;
        int minPrice = arr[0];

        for (int i = 0; i < arr.length; i++) 
        {
            if(minPrice <= arr[i])
            {
                minPrice = arr[i];
                buyAt = i;
            }
            // minPrice = Math.min(minPrice, arr[i]);

            if(maxProfit >= arr[i] - minPrice)
            {
                // maxProfit = arr[i] - minPrice;               
                sellAt=i;
            }
            // maxProfit = Math.max(maxProfit, arr[i] - minPrice);            
        }
        return sellAt-buyAt;
    }

}