package Day2;
import java.util.*;

class code
{
    class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) 
    {
        int[] arr = {1,2,3,4,5,6};
        String str = "CD";

        System.out.println(valueRN(str));

        int[] res = reverse(arr);
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i]+" ");            
        }        
    }


    //Check whether the given linkedlist is palindrome or not.
    // 1 2 3 4 5
    // 5 4 3 2 1

    static int[] reverse(int[] arr)
    {
        int i =0;
        int j= arr.length-1;
        while(i<j)
        {
            int temp =arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            
            i++;
            j--;
        }
        return arr;
    }

    //Roman Number
    //Input : V  (String)
    //Output : 5
    // I 1
    // V 5
    // X 10
    // L 50
    // C 100
    // D 500
    // M 1000

    

    static int valueRN(String str) //V
    {
        int res = 0;
        HashMap<Character,Integer> map= new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        for (int i = 0; i < str.length(); i++)
        {
            
            char ch=str.charAt(i);

            if(map.containsKey(ch))
            {
                if(ch == 'V'|| ch=='X')
                {
                    if(i > 0 && str.charAt(i-1) == 'I')
                    {
                        res -= 2;
                    }
                }
                
                if(ch=='L' || ch=='C')
                {
                    if(i>0 && str.charAt(i-1)=='X')
                    {
                        res-=20;
                    }
                } 
                if(ch=='D' || ch=='M')
                {
                    if(i>0 && str.charAt(i-1)=='C')
                    {
                        res-=200;
                    }
                } 
                res+=map.get(ch);
            }
        }
        return res;
    }
}