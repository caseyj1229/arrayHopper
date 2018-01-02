/*
    Goal is to find the minimum number of jumps needed to reach
    the last element of an array of integers.
    Jumps can only be less than
    or equal to the number currently indexed.
    i.e:
        [1,3,5,8,9,2,6,7,6,8,9]
        Since the first element is 1, you can only jump to 3
        From 3 you can jump to 5 8 or 9
        etc...
        Min jumps is 3: 1->3->8->9
 */
import java.util.*;

public class arrayHopper {
    public static void main(String[] args){
        int[] example = {1,3,5,8,9,2,6,7,6,8,9};
        int answer = minJumps(example,0,(example.length - 1));
        System.out.println(answer);

        int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        answer = minJumps(arr,0,(example.length - 1));
        System.out.println(answer);
    }

    //Inputs: Array to be searched, starting index, ending index
    public static int minJumps(int[] arr, int l, int h){
        if(h == l){
            return 0;
        }

        if(arr[l] == 0){
            return 999;
        }

        int min = 999;
        for(int i = l+1; i <= h && i <= (l+arr[l]); i++){
            int tempJumps = minJumps(arr,i,h);
            if(tempJumps != 999 && tempJumps+1 < min){
                min = tempJumps+1;
            }
        }
        //System.out.println(min);
        return min;
    }
}
