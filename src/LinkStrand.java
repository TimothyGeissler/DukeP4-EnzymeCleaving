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

    @Override
    public IDnaStrand reverse() {
        Node i = this.myFirst;
        String toRev = i.info;
        StringBuilder sb = new StringBuilder(toRev);
        StringBuilder sbRev = sb.reverse();
        LinkStrand res = new LinkStrand(sbRev.toString());
        //Node firstRes = res;
        i = i.next;
        while (i != null) {
            toRev = i.info;
            sb = new StringBuilder(toRev);
            sbRev = sb.reverse();
            Node temp = new Node(sbRev.toString());
            //System.out.println("Temp: " + temp.info + " - > res: " + res.info);
            temp.next = res.myFirst;
            res.myFirst = temp;
            res.mySize = res.mySize + temp.info.length();
            //res.next = new Node(i.info);
            i = i.next;
            //es = res.next;
        }
        return res;
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
