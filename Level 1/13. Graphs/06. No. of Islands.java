public static void dfs(int[][] arr, int srcRow, int srcCol){

   // base case
   if(srcCol < 0 || srcCol >= arr[0].length || srcRow < 0 || srcRow >= arr.length || arr[srcRow][srcCol] != 0){
      // invalid cell || not an island cell(i.e a water cell or already visited cell)
      return;
   }

   arr[srcRow][srcCol] = -1;

   dfs(arr, srcRow, srcCol - 1);
   dfs(arr, srcRow - 1, srcCol);
   dfs(arr, srcRow, srcCol + 1);
   dfs(arr, srcRow + 1, srcCol);

}


// MAIN
int island = 0;
for(int i = 0; i < m; i++){
   for(int j = 0; j < n; j++){
      if(arr[i][j] == 0 && arr[i][j] != -1){
      // neither visited nor water cell
         dfs(arr, i, j);
         island++;
      }
   }
}

System.out.println(island);
