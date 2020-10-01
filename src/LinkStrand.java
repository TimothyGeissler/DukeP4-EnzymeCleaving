public class LinkStrand implements IDnaStrand{

    private Node myFirst, myLast;

    private long mySize;

    private int myAppends;

    private class Node {
        String info;
        Node next;

        public Node(String s) {
            info = s;
            next = null;
        }
    }

    public LinkStrand(String s) {
        initialize(s);
    }

    public LinkStrand() {
        this("");
    }

    @Override
    public long size() {
        return mySize;
    }

    @Override
    public void initialize(String source) {
        this.myFirst = new Node(source);
        this.myLast = myFirst;
        this.mySize = source.length();
        this.myAppends = 0;
    }

    @Override
    public IDnaStrand getInstance(String source) {
        return new LinkStrand(source);
    }

    @Override
    public IDnaStrand append(String dna) {
        this.mySize = mySize + dna.length();
        this.myAppends++;
        Node n = new Node(dna);
        this.myLast.next = n;
        this.myLast = myLast.next;
        return this;
    }

    //TODO:
    @Override
    public IDnaStrand reverse() {
        LinkStrand reversedLS = new LinkStrand();
        Node index = this.myFirst;
        reversedLS.myLast = index;
        while (index != null) {
            Node oldFirst = reversedLS.myFirst;
            reversedLS.myFirst = index;
            reversedLS.myFirst.next = oldFirst;
            index = index.next;
        }
        return reversedLS;
    }

    @Override
    public int getAppendCount() {
        return this.myAppends;
    }

    @Override
    public char charAt(int index) {
        return 0;
    }

    @Override
    public String toString() {
        Node index = this.myFirst;
        StringBuilder sb = new StringBuilder();
        while (index != null) {
            System.out.println("INFO: " + index.info);
            sb.append(index.info);
            index = index.next;
        }
        return sb.toString();
    }
}
