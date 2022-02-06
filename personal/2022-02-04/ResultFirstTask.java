class ResultFirstTask {

    /*
     * Complete the 'maximumPages' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_SINGLY_LINKED_LIST head as parameter.
     */

    /*
     * For your reference:
     *
     * SinglyLinkedListNode {
     *     int data;
     *     SinglyLinkedListNode next;
     * }
     *
     */

    public static int maximumPages(SinglyLinkedListNode head) {
    // Write your code here
        SinglyLinkedListNode node = head;
        
        final List<Integer> list = new ArrayList<>();
        while (node != null) {
            list.add(node.data);
            node = node.next;
        }
        
        return findMaxPair(list);
    }
    
    private static int findMaxPair(List<Integer> list) {
        int pairCount = list.size()/2;
        
        //final List<Integer> pairSumList = new ArrayList<>();
        
        int maxValue = 0;
        for (int i=0; i<pairCount; i++) {
            int value = list.get(i) + list.get(list.size()-1 - i);
            if (maxValue < value) {
                maxValue = value;
            }
        }
        
        
        return maxValue;

    }

}
