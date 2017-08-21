package data_structure.symbol_table;

/**
 * Created by Hiki on 2017/8/21.
 */
public class BST<Key extends Comparable<Key>, Value> {

	private Node root;

	public int size(){
		return size(root);
	}

	public Value get(Key key){
		return get(root, key);
	}

	public void put(Key key, Value val){
		root = put(root, key, val);
	}

	public Key min(){
		return min(root).key;
	}

	public int rank(Key key){
		return rank(key, root);
	}

	public Key select(int k){
		return select(k, root).key;
	}

	public void deleteMin(){
		root = deleteMin(root);
	}

	public void delete(Key key){
		root = delete(key, root);
	}

	public void print(){
		print(root);
	}

	private Value get(Node x, Key key){
		// 在以x为根节点的子树中查找并返回key所对应的值
		if (x == null)
			return null;
		int cmp = key.compareTo(x.key);
		if (cmp < 0) return get(x.left, key);
		else if (cmp > 0) return get(x.right, key);
		else return x.val;
	}

	private Node put(Node x, Key key, Value val){
		// 如果key存在于以x为根结点的子树中则更新它的值，否则将以key和val为键值对的新结点插入到该子树中
		if (x == null)
			return new Node(key, val, 1);
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			x.left = put(x.left, key, val);
		else if (cmp > 0)
			x.right = put(x.right, key, val);
		else x.val = val;
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	private Node min(Node x){
		if (x.left == null)
			return x;
		else
			return min(x.left);
	}

	private int rank(Key key, Node x){
		if (x == null) return 0;
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return rank(key, x.left);
		else if(cmp > 0)
			return 1 + size(x.left) + rank(key, x.right);
		else
			return size(x.left);
	}

	private Node select(int k, Node x){
		if (x == null) return null;
		int t = size(x.left);
		if (k < t)
			return select(k, x.left);
		else if (k > t)
			return select(k-t-1, x.right);
		else
			return x;
	}

	private Node deleteMin(Node x){
		if (x.left == null) return x.right;
		x.left = deleteMin(x.left);
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	private Node delete(Key key, Node x){

		if (x == null) return null;
		// 先找到位置
		int cmp = key.compareTo(x.key);
		if (cmp < 0)
			return delete(key, x.left);
		else if (cmp > 0)
			return delete(key, x.right);
		else {
			if (x.right == null) return x.left;
			if (x.left == null) return x.right;
			Node t = x;
			x = min(t.right);
			x.right = deleteMin(t.right);
			x.left = t.left;
		}
		x.N = size(x.left) + size(x.right) + 1;
		return x;
	}

	private void print(Node x){
		if (x == null) return;
		print(x.left);
		System.out.println(x.key);
		print(x.right);
	}

	private int size(Node x){
		if (x == null) return 0;
		else return x.N;
	}

	private class Node{
		private Key key;
		private Value val;
		private Node left, right;
		private int N; // 以该结点为根的子数中的结点总数

		public Node(Key key, Value val, int N){
			this.key = key;
			this.val = val;
			this.N = N;
		}
	}
}
