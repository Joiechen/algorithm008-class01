package Week_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsDifference {
    
    //使用asList方法
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>>   listList = new ArrayList<>();
          if (null == arr || arr.length < 2)
              return listList;
          Arrays.sort(arr);
          int min = Integer.MAX_VALUE;
          int abs ;
          for (int i = 0; i < arr.length - 1; i++){
              abs = arr[i+1] - arr[i];
              if (abs < min)
                   min = abs;
          }
          for (int i = 0; i < arr.length - 1; i++){
              abs = arr[i+1] - arr[i];
              if (abs == min)
                  listList.add(Arrays.asList(arr[i], arr[i+1] ));
          }
          return listList;
        }

}