package com.mycompany.app;

import org.apache.logging.log4j.*;
import java.util.function.Consumer;

public class LinkedListNode<T> {
    private final T contents;
    private final String name;
    private LinkedListNode<T> prev;
    private LinkedListNode<T> next;
    private final Logger logger;

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

        currentNode.next = new LinkedListNode<T>(newContents, name, currentNode, null, this.logger);
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

    public void printClasses(Logger logger) {
        Consumer<LinkedListNode<T>> consumer = node -> {
            logger.info("Class of contents: " + node.contents.getClass().getSimpleName());

            if(node.prev != null) {
                logger.info("Class of prev: " + node.prev.contents.getClass().getSimpleName());
            }
            else {
                logger.info("Class of prev: N/A" );
            }

            if(node.next != null) {
                logger.info("Class of next: " + node.next.contents.getClass().getSimpleName());
            }
            else {
                logger.info("Class of next: N/A" );
            }
        };

        consumer.accept(this);
    }
 }
