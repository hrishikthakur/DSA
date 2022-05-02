// Time Complexity - O(n), Space Complexity - O(n)
public static void printConsecutive(int[] arr){

    HashMap<Integer, Boolean> hm = new HashMap<>();
    // push all elements into the HM
    for(int i = 0; i < arr.length; i++)
        hm.put(arr[i], true);

    int maxChain = 0;
    int startingPt = 0;
    for(Integer key : hm.keySet()){

        if(hm.containsKey(key - 1) == false){
            // the curr key is the starting point of our chain

            int length = 1;
            while(hm.containsKey(key + length) == true){
                length++;
            }
            if(maxChain < length){
                maxChain = length;
                startingPt = key;
            }
        }
    }

    for(int i = 0; i < maxChain; i++)
        System.out.println(startingPt + i);
}
