package algorithm;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MigratoryBirds {
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();
        int[] birds = new int[5];
        Arrays.fill(birds, 0);
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) == 1) {
                birds[0]++;
            } else if (arr.get(i) == 2) {
                birds[1]++;
            } else if (arr.get(i) == 3) {
                birds[2]++;
            } else if (arr.get(i) == 4) {
                birds[3]++;
            } else {
                birds[4]++;
            }
        }
        //birds[0]=1 birds[1]=0 birds[2]=1 birds[3]=3 birds[4]=1
        int tmp=birds[0];
        int high=0;
        for (int i = 1; i < birds.length; i++) {
            if(tmp<birds[i]){
                tmp=birds[i];
                high=i;
            }else if(tmp==birds[i]){
                if(high>i){
                    high=i;
                }
            }
        }
        high+=1;
//        return high;
    }
}

