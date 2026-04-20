package hw9.src.sdt202.hw9.driver;

import sdt202.hw9.impl.BSTOrderedSymbolTable;

public class BSTDriver {
    public static void main(String[] args) {

        BSTOrderedSymbolTable<Integer, String> st = new BSTOrderedSymbolTable<>();

        st.put(5, "A");
        st.put(2, "B");
        st.put(8, "C");
        st.put(1, "D");
        st.put(3, "E");

        System.out.println("Size: " + st.size());
        System.out.println("Min: " + st.min());
        System.out.println("Max: " + st.max());

        System.out.println("Get 3: " + st.get(3));
        System.out.println("Contains 7: " + st.contains(7));

        System.out.println("Floor(4): " + st.floor(4));
        System.out.println("Ceiling(4): " + st.ceiling(4));

        System.out.println("Rank(5): " + st.rank(5));
        System.out.println("Select(2): " + st.select(2));

        System.out.println("Keys 2..8:");
        for (Integer k : st.keys(2, 8)) {
            System.out.println(k);
        }

        st.delete(2);
        System.out.println("After delete(2), size: " + st.size());
    }
}