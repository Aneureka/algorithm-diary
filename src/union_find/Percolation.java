package union_find;

/**
 * Created by Hiki on 2017/7/16.
 * 模拟渗透问题
 */
public class Percolation {

    private int n;
    private int openSites;
    private int[][] model;
    private int[] size;

    public Percolation(int n) {
        if (n <= 0)
            throw new IllegalArgumentException();
        this.n = n;
        this.openSites = 0;
        this.model = new int[n][n];
        this.size = new int[n*n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                model[i][j] = -1; // -1表示阻塞
                size[i*n+j] = 1;
            }
        }
    }

    public void open(int row, int col){
        model[row][col] = address(row, col);
        openSites++;
        // 将该点与周围开放的点连接
        for (int i = -1; i <= 1; i+=1){
            for (int j = i*i-1; j <= 1-i*i; j+=2){
                if (row+i >= 0 && row+i < n && col+j >= 0 && col+j < n && isOpen(row+i, col+j)){
                    union(row, col, row+i, col+j);
                }
            }
        }
    }

    public boolean isOpen(int row, int col){
        return model[row][col] != -1;
    }

    public boolean isFull(int row, int col){
        if (!isOpen(row, col))
            return false;
        for (int j = 0; j < n; j++){
            if (isOpen(0, j) && model[0][j] == model[row][col]){
                return true;
            }
        }
        return false;
    }

    public int numberOfOpenSites(){
        return openSites;
    }

    public boolean percolates(){
        for (int j = 0; j < n; j++){
            if (isFull(n-1, j))
                return true;
        }
        return false;
    }

    private int address(int row, int col){
        return row * n + col;
    }

    private void union(int row1, int col1, int row2, int col2){
        int rootP = find(address(row1, col1));
        int rootQ = find(address(row2, col2));
        if (rootP == rootQ) return;

        if (size[rootP] < size[rootQ]) {
            model[rootP/n][rootP%n] = rootQ;
            size[rootQ] += size[rootP];
        }
        else {
            model[rootQ/n][rootQ%n] = rootP;
            size[rootP] += size[rootQ];
        }

    }

    private int find(int address) {
//        System.out.println(address/n + " " + address%n);
        while (address != model[address/n][address%n]){
            address = model[address/n][address%n];
        }
        return address;
    }

    public void print(){
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(model[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 10000;
        Percolation percolation = new Percolation(n);
        for (int i = 0; i < n; i++){
            percolation.open(i, i);
            if (i != n-1)
                percolation.open(i, i+1);
        }
//        percolation.print();
        System.out.println(percolation.percolates());
    }

}
