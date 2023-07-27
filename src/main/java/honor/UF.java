package honor;

public class UF {

    int[] item;
    int result;

    public UF(int n) {
        item = new int[n + 1];
        result = n;

        for (int i = 0; i < n; i++) {
            item[i] = i;
        }
    }

    public int find(int x) {
        if (item[x] != x) {
            return (item[x] = find(item[x]));
        }
        return x;
    }

    public void union_connect(int x,int y){
        int x_item = find(x);
        int y_item = find(y);

        if (x_item != y_item){
            item[y_item] = x_item;
            result--;
        }
    }
}
