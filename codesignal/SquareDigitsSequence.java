
import java.util.HashSet;
int squareDigitsSequence(int a0) {
    HashSet<Integer> hs = new HashSet<Integer>();
    int nosequence = 1;

    while(!hs.contains(a0)){
        hs.add(a0);
        a0 = getSquareOfInt(a0);
        nosequence++;
    }
    
    return nosequence;
}

int getSquareOfInt(int value){
    // get the squeare of int
    int temp = 0;
    while(value != 0){
        temp += (value % 10) * (value % 10);
        value /= 10;
    }
    return temp;
}