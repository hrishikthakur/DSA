public static char hfc(String str){

    HashMap<Character, Integer> hm = new HashMap<>();
    // toCharArray()
    for(char ch : str.toCharArray()){
        if(hm.containsKey(ch)){
            int oldFreq = hm.get(ch);
            hm.put(ch, oldFreq + 1);

        }else
            hm.put(ch, 1);
    }

    int maxFreq = Integer.MIN_VALUE;
    char ch = str.charAt(0);
    for(Character key : hm.keySet()){
        if(hm.get(key) > maxFreq){
            ch = key;
            maxFreq = hm.get(key);
        }
    }
    return ch;
}
