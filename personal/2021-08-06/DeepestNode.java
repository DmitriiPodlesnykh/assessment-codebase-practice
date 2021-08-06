/**
 * Дано бинарное дерево, нужно найти и вернуть элемент,
 * находящийся на максимальной глубине от корня.
 */
public class DeepestNode {


    private Map<Node, Integer> nodeDeepMap = new HashMap<>();

    public static class Node {
        int val;
        Node left;
        Node right;
    }

    public Node getDeepestNode(Node root){
        getDeepestNode(root, 0);
        int level = getMaxDeepValue();
        return getDeepestElement(level);
    }
    
    private int getMaxDeepValue() {
        int count =0;
        for (Map.Entry<Node, Integer> element: nodeDeepMap.keyValue()) {
            if (element.value  > count) {
                count ++;
            }
        }
        return count;
    } 

    private Note getDeepestElement(int level) {
        for (Map.Entry<Node, Integer> element: nodeDeepMap.keyValue()) {
            if (element.value() == level) {
                return element.key();
            }
        }
    }
    
    private Node getDeepestNode(Node root, int currentDeepLevel){
        nodeDeepMap.put(root, currentDeepLevel);
        
        if (root.left==null && root.right==null) {
            return root;
        }
        
        if (root.left != null) {
            int currentLeft = currentDeepLevel+1;
            return getDeepestNode(root.left, currentLeft);
        }
        if (root.right != null) { 
            int currentRSight = currentDeepLevel+1;
            return getDeepestNode(root.right, currentRSight);
        } else {
            return root;
        }
    }

} 


public Test {
    
    public void getDeepestNode_oneElement_shouldReturn1st() {
        
        Node1 = new Node("", new Node());
        
        
    }
}

//     * 
//    /
//   *

//     * 0
//    /  \
//   * 1  * 2
//  /
// * 2
