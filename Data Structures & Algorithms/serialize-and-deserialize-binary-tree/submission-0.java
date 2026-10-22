class Codec {

    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        return sb.toString();
    }

    void preorder(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append("N,");
            return;
        }

        sb.append(root.val).append(",");
        preorder(root.left, sb);
        preorder(root.right, sb);
    }

    int index = 0;
    String[] nodes;

    public TreeNode deserialize(String data) {
        nodes = data.split(",");
        index = 0;
        return build();
    }

    TreeNode build() {
        String value = nodes[index++];

        if (value.equals("N")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));

        root.left = build();
        root.right = build();

        return root;
    }
}