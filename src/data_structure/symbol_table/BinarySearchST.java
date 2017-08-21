package data_structure.symbol_table;

/**
 * Created by Hiki on 2017/8/21.
 * Symbol table implementation based on array.
 */
public class BinarySearchST<Key extends Comparable<Key>, Value> {

	private static final int INIT_CAPACITY = 2;
	private Key[] keys;
	private Value[] vals;
	private int n = 0;

	public BinarySearchST() {
		this(INIT_CAPACITY);
	}

	public BinarySearchST(int capacity){
		keys = (Key[]) new Comparable[capacity];
		vals = (Value[]) new Object[capacity];
	}

	private void resize(int capacity) {
		Key[] tempk = (Key[]) new Comparable[capacity];
		Value[] tempv = (Value[]) new Object[capacity];
		for (int i = 0; i < n && i < capacity; i++) {
			tempk[i] = keys[i];
			tempv[i] = vals[i];
		}
		vals = tempv;
		keys = tempk;
	}

	public int size(){
		return n;
	}

	public Value get(Key key){
		if (isEmpty())
			return null;
		int i = rank(key);
		if (i < n && keys[i].compareTo(key) == 0)
			return vals[i];
		return null;
	}

	public void put(Key key, Value val)  {
		if (key == null) throw new IllegalArgumentException("first argument to put() is null");

		if (val == null) {
			delete(key);
			return;
		}

		int i = rank(key);

		// key is already in table
		if (i < n && keys[i].compareTo(key) == 0) {
			vals[i] = val;
			return;
		}

		// insert new key-value pair
		if (n == keys.length) resize(2*keys.length);

		for (int j = n; j > i; j--)  {
			keys[j] = keys[j-1];
			vals[j] = vals[j-1];
		}
		keys[i] = key;
		vals[i] = val;
		n++;

		assert check();
	}

	public void delete(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to delete() is null");
		if (isEmpty()) return;

		// compute rank
		int i = rank(key);

		// key not in table
		if (i == n || keys[i].compareTo(key) != 0) {
			return;
		}

		for (int j = i; j < n-1; j++)  {
			keys[j] = keys[j+1];
			vals[j] = vals[j+1];
		}

		n--;
		keys[n] = null;  // to avoid loitering
		vals[n] = null;

		// resize if 1/4 full
		if (n > 0 && n == keys.length/4) resize(keys.length/2);

		assert check();
	}

	private boolean check() {
		return isSorted() && rankCheck();
	}

	private boolean isSorted() {
		for (int i = 1; i < size(); i++)
			if (keys[i].compareTo(keys[i-1]) < 0) return false;
		return true;
	}

	private boolean rankCheck() {
		for (int i = 0; i < size(); i++)
			if (i != rank(select(i))) return false;
		for (int i = 0; i < size(); i++)
			if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
		return true;
	}

	public Key select(int k) {
		if (k < 0 || k >= size()) {
			throw new IllegalArgumentException("called select() with invalid argument: " + k);
		}
		return keys[k];
	}



	public int rank(Key key) {
		if (key == null) throw new IllegalArgumentException("argument to rank() is null");

		int lo = 0, hi = n-1;
		while (lo <= hi) {
			int mid = lo + (hi - lo) / 2;
			int cmp = key.compareTo(keys[mid]);
			if      (cmp < 0) hi = mid - 1;
			else if (cmp > 0) lo = mid + 1;
			else return mid;
		}
		return lo;
	}


	public boolean contains(Key key) {
		if (key == null)
			throw new IllegalArgumentException("argument to contains() is null");
		return get(key) != null;
	}

	public boolean isEmpty(){
		return size() == 0;
	}

}
