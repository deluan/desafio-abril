import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * http://en.wikipedia.org/wiki/Lowest_common_ancestor
 *
 * @author deluan
 */
public class lca {

    private TreeNode root;

    lca(int... values) {
        for (int value : values) {
            insert(value);
        }
    }

    public void insert(int value) {
        if (root == null) {
            root = new TreeNode(value);
        }
        TreeNode node = root;
        while (node != null) {
            if (value == node.value) {
                return;
            } else if (value < node.value) {
                if (node.left == null) {
                    node.left = new TreeNode(value);
                    return;
                } else {
                    node = node.left;
                }
            } else {
                if (node.right == null) {
                    node.right = new TreeNode(value);
                    return;
                } else {
                    node = node.right;
                }
            }
        }
    }

    private TreeNode search(TreeNode node, Integer value) {
        if (node == null) {
            return null;
        }

        if (value < node.value) {
            return search(node.left, value);
        } else if (value > node.value) {
            return search(node.right, value);
        }
        return node;
    }

    private TreeNode findLCA(TreeNode root, TreeNode x, TreeNode y) {
        if (root == null) {
            return null;
        }
        if (root == x || root == y) {
            return root;
        } else {
            TreeNode left = findLCA(root.left, x, y);
            TreeNode right = findLCA(root.right, x, y);
            if ((left != null) && (right != null)) {
                return root;
            } else if (left != null) {
                return left;
            } else {
                return right;
            }
        }
    }

    public int findLowestCommonAncestor(Integer a, Integer b) {
        TreeNode x = search(root, a);
        TreeNode y = search(root, b);
        TreeNode lca = findLCA(root, x, y);
        if (lca != null) {
            return lca.value;
        } else {
            return -1;
        }
    }

    private class TreeNode {
        TreeNode left, right;
        int value;

        TreeNode(int value) {
            this.value = value;
        }
    }

    public static void main(String args[]) {

        lca tree = new lca(30, 8, 52, 3, 20, 10, 29);

        try {
            FileInputStream fstream = new FileInputStream(args[0]);

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {
                String numbers[] = strLine.split(" ");
                Integer a = Integer.parseInt(numbers[0]);
                Integer b = Integer.parseInt(numbers[1]);
                System.out.println(tree.findLowestCommonAncestor(a, b));
            }

            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            System.exit(1);
        }
    }

}
