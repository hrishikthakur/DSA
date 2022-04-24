public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int[] arr1 = new int[n1];
    for(int i=0; i<n1; i++){
        arr1[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int[] arr2 = new int[n2];
    for(int i=0; i<n2; i++){
        arr2[i] = scn.nextInt();
    }

    // HashMap to add all unique elements of array n1
    HashMap<Integer, Boolean> hm = new HashMap<>();
    for(int i = 0; i < arr1.length; i++){
        hm.put(arr1[i], true);

    // Iterate the 2nd array
    for(int i = 0; i < arr2.length; i++){
        if(hm.containsKey(arr2[i]) && hm.get(arr2[i])){
            System.out.println(arr2[i]);
            hm.put(arr2[i], false);
        }
    }
 }

}
