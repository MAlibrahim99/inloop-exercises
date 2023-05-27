public class List {
    private ListElement head;
    private int size = 0;

    public List() {
        this.head = new ListElement("head");
    }

    public void append(String content) {
        ListElement n = new ListElement(content);
        if (size == 0) {
            head.setNext(n);
            size++;
        } else {
            ListElement temp = head;
            while (true) {

                if (temp.getNext() == null) {
                    temp.setNext(n);
                    size++;
                    break;
                }
                temp = temp.getNext();
            }
        }
    }

    public String remove(String content) {

        if (content == null || content.equals(""))
            throw new IllegalArgumentException("content must not be null");
        ListElement temp = head.getNext();
        if (head.getNext() == null)
            return null;
        else if (size == 1 && head.getNext().getContent().equals(content)) {
            head.setNext(null);
            return content;
        }
        while (temp.getNext() != null) {
            if (temp.getNext().getContent().equals(content) && temp.getNext().getNext() != null) {
                temp.setNext(temp.getNext().getNext());
                return content;
            }if (temp.getNext().getContent().equals(content) && temp.getNext() == null) {
                temp.getNext().setNext(null);
                return content;
            }
            temp = temp.getNext();
        }return null;
    }

    public ListElement getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }
}

