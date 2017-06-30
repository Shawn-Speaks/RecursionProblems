package nyc.c4q.shawn;

/**
 * Created by shawnspeaks on 6/29/17.
 */
public class Recursion {

    public static void main(String[] args) {
//        System.out.println(nCombinations(3));
//        System.out.println(coffeeProblem(5));
        int[] arrayOne = new int[]{6,13,27,100,121};
        int[] arrayTwo = new int[]{51,63,65,121};

        mergeArrays(arrayOne, arrayTwo);
    }


    public static int nCombinations(int x){
        if(x < 3){
            return x;
        }
        return nCombinations(x-1) + nCombinations(x-2);
    }


    public static int coffeeProblem(int x) {
        /**
         * 1 credit => 1 shot
         * 2 creidts => doubleShot
         * 4 credits => Latte
         *
         * how many combinations of drinks can we buy with n credits
         */
        if (x < 0) {
            return 0;
        }
        if (x <= 3) {
            return x;
        }
        if (x == 4) {
            return 6;
        }
        return coffeeProblem(x - 1) + coffeeProblem(x - 2) + coffeeProblem(x - 4);
    }

    public static int[] mergeArrays(int[] leftArray, int[] rightArray){
        int[] answerArray = new int[leftArray.length + rightArray.length];
        int leftIdx = 0;
        int rightIdx = 0;
        int answerIdx = 0;

        while(leftIdx < leftArray.length && rightIdx < rightArray.length){
            if(leftArray[leftIdx] > rightArray[rightIdx]){
                answerArray[answerIdx] = rightArray[rightIdx];
                answerIdx++;
                rightIdx++;
            }else{
                answerArray[answerIdx] = leftArray[leftIdx];
                answerIdx++;
                leftIdx++;
            }
        }

        if(leftIdx < leftArray.length){
            for(int i = leftIdx; i < leftArray.length; i++){
                answerArray[answerIdx] = leftArray[leftIdx];
                answerIdx++;
            }
        }else{
            for(int i = rightIdx; i < rightArray.length; i++){
                answerArray[answerIdx] = rightArray[rightIdx];
                answerIdx++;
            }
        }

        for (int i: answerArray){
            System.out.println(i);
        }

        return answerArray;
    }
}
