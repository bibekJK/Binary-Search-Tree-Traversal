package binaryTree;

public class Insertion {

	static Node root;

	public static void main(String[] args) {
		Insertion tree = new Insertion();
		tree.insert(4);
		tree.insert(2);
		tree.insert(3);
		tree.insert(8);
		tree.insert(10);
		tree.insert(1);
		tree.display(root);

		// System.out.println("Depth:::" + tree.maxDepth(root));

		// System.out.println("Data Found: " + tree.findData(root, 6));

		System.out.println("After Deletion:");
		tree.delete(10);
		tree.display(root);

	}

	// Insertion with sorting
	public void insert(int data) {
		Node newNode = new Node(data);
		if (root == null) {
			root = newNode;
			return;
		}
		Node current = root;
		Node parent = null;
		while (true) {
			parent = current;
			if (data > current.data) {
				current = current.right;
				if (current == null) {
					parent.right = newNode;
					return;
				}

			} else {
				current = current.left;
				if (current == null) {
					parent.left = newNode;
					return;
				}

			}

		}

	}

	// Deletion

	public void delete(int data) {

		Node parent = new Node(0);
		Node deleteNode = new Node(0);

		parent = findDataNode(root, data);
		if (parent.right.data == data) {
			deleteNode = parent.right;
		} else {
			deleteNode = parent.left;
		}

		if (deleteNode.left == null || deleteNode.right == null) {
			
			parent.right = null;
			return;
		}

		// deleteNode=deleteNode.right.left;

	}

	// Displaying with inorder traversal
	public void display(Node root) {

		if (root != null) {
			display(root.left);
			System.out.println(root.data);
			display(root.right);
		}

	}

	// Finding depth from a given root
	public int maxDepth(Node root) {
		if (root == null) {
			return 0;
		}

		int rightDepth = maxDepth(root.right);
		int leftDepth = maxDepth(root.left);

		if (rightDepth > leftDepth) {
			return rightDepth + 1;
		}
		return leftDepth + 1;
	}

	// Searching a given data
	public boolean findData(Node root, int data) {

		if (root.data == data) {
			return true;
		}

		while (true) {

			if (data > root.data) {
				root = root.right;
				if (root.data == data) {
					return true;
				} else {
					return false;
				}
			} else if (data < root.data) {
				root = root.left;
				if (root.data == data) {
					return true;
				} else {
					return false;
				}

			} else {
				return false;
			}
		}

	}

	// Searching a given data and returning corresponding node
	public Node findDataNode(Node root, int data) {

		Node parent = new Node(0);
		if (root.data == data) {
			return root;
		}

		while (true) {
			parent = root;
			if (data > root.data) {
				root = root.right;
				if (root.data == data) {

					return parent;

				}
			} else if (data < root.data) {
				root = root.left;
				if (root.data == data) {
					return parent;
				}

			} else {
				return null;
			}
		}

	}

}
