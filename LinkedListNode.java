import org.apache.logging.log4j.*;

public class LinkedListNode<T> {
    T contents;
    String name;
    LinkedListNode<T> prev;
    LinkedListNode<T> next;
    Logger logger;

    public LinkedListNode(T contents, String name, LinkedListNode<T> prev, LinkedListNode<T> next, Logger logger) {
        this.contents = contents;
        this.name = name;
        this.prev = prev;
        this.next = next;
        this.logger = logger;
    }

    public void addNode(T newContents, String name) {
        // Navigate to end of list.
        LinkedListNode<T> currentNode = this;

        while(currentNode.next != null) {
            currentNode = currentNode.next;
        }

        LinkedListNode<T> newNode = new LinkedListNode<T>(newContents, name, currentNode, null, this.logger);

        currentNode.next = newNode;
    }

    public LinkedListNode<T> deleteNode(String name) {
        // Navigate to node to delete.
        LinkedListNode<T> currentNode = this;

        while(!(currentNode.name.equals(name))) {
            currentNode = currentNode.next;
        }

        LinkedListNode<T> prev = currentNode.prev;
        LinkedListNode<T> next = currentNode.next;

        // First node.
        if(prev == null && next != null) {
            next.prev = null;
            return next;
        }
        // Last node.
        else if(prev != null && next == null) {
            prev.next = null;
        }
        // All other nodes.
        else {
            next.prev = prev;
            prev.next = next;
        }

        return this;
    }

    public void printList() {
        LinkedListNode<T> currentNode = this;
        logger.info(currentNode.contents.toString());

        while(currentNode.next != null) {
            currentNode = currentNode.next;
            logger.info(currentNode.contents.toString());
        }
    }
 }
