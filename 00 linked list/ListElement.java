public class ListElement {
    private String content;
    private ListElement next;

    public  ListElement(String content){
        if(content == null || content.equals(""))
            throw new IllegalArgumentException("content must not be null");
        this.content = content;
        this.next = null;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        if(content == null || content.equals(""))
            throw new IllegalArgumentException("content must not be null");
        this.content = content;
    }

    public ListElement getNext() {
        return next;
    }

    public void setNext(ListElement next) {
        this.next = next;
    }
}
