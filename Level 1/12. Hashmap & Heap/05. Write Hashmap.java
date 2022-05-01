public static class HashMap<K, V> {

  private class HMNode{
    K key;
    V value;

    HMNode(){}

    HMNode(K key, V value){
      this.key = key;
      this.value = value;
    }
  }

  // data members
  private LinkedList<HMNode>[] buckets;
  private int noOfNodes;
  private int noOfBuckets;
  private double loadingFactor;

  // CONSTRUCTOR
  public HashMap(){
    noOfBuckets = 4;
    noOfNodes = 0;
    loadingFactor = 0.0;
    init();
  }

  public void init(){
    buckets = new LinkedList[noOfBuckets];

    for(int i = 0; i <noOfBuckets; i++){
      buckets[i] = new LinkedList<>();
    }

  }

  public int getBucketId(K key) throws Exception{
    int hashCode = key.hashCode();
    int bucketId = (Math.abs(hashCode)) % noOfBuckets;
    return bucketId;
  }

  private HMNode getData(int bucketId, K key) throws Exception{
    for(HMNode node : buckets[bucketId]){
      if(node.key.equals(key) == true){
        // key exists
        return node;
      }
    }
    // Node with given key does not exist
    return null;
  }

  public void put(K key, V value) throws Exception {

    // O(1)
    int bucketId = getBucketId(key);
    HMNode data = getData(bucketId, key);

    if(data == null){
      // Insertion

      double newLoadingFactor = (noOfNodes + 1.0) / (noOfBuckets);

      if(newLoadingFactor > 2.0){
        // REHASHING

        LinkedList<HMNode>[] oldBuckets = buckets;
        noOfBuckets = 2 * noOfBuckets;
        init(); // new bucket array will be created 2*noOfBuckets

        // copy from oldBuckets to the newBuckets array
        for(int i = 0; i < oldBuckets.length; i++){
          for(HMNode node : oldBuckets[i]){
            // put(node.key, node.value);
              int newBucketId = getBucketId(node.key);
              buckets[newBucketId].addLast(node);
          }
        }

      }

      int newBucketId = getBucketId(key);
      HMNode node = new HMNode(key, value);
      buckets[newBucketId].addLast(node);
      noOfNodes++;
      loadingFactor = (noOfNodes * 1.0) + noOfBuckets;

    }else{
      // Updation
      data.value = value;
    }

  }

  public V get(K key) throws Exception {
    int bucketId = getBucketId(key);
    HMNode data = getData(bucketId, key);

    if(data != null)
      return data.value;

    else
      return null;
  }

  public boolean containsKey(K key) throws Exception{
    int bucketId = getBucketId(key);
    HMNode data = getData(bucketId, key);

    if(data == null) return false;
    else return true;
  }

  public V remove(K key) throws Exception {
    int bucketId = getBucketId(key);
    HMNode data = getData(bucketId, key);

    if(data == null) return null;

    V val = data.value;
    // LL se remove kar do 'data' namak HMNode ko
    buckets[bucketId].remove(data);
    noOfNodes--;
    return val;
  }

  public ArrayList<K> keyset() throws Exception {
    ArrayList<K> keys = new ArrayList<>();

    for(int i = 0; i < noOfNodes; i++){
      for(HMNode node : buckets[i]){
        keys.add(node.key);
      }
    }

    return keys;
  }

  public int size() throws Exception{
    return noOfNodes;
  }
}
