package com.company;

class Circular_Queue {
    private int size;
    private int front,rear;
    private int []queue;

    Circular_Queue(int size){
        this.size=size;
        queue=new int[size];
        front=rear=0;
    }

    boolean isFull(){
        if((rear+1)%size==front){
            return true;
        }
        return false;
    }

    boolean isEmpty(){
        if(rear==front){
            return true;
        }
        return false;
    }

    boolean enqueue(int data){
        if(!isFull()){
            rear=(rear+1)%size;
            queue[rear]=data;
            return true;
        }
        return false;
    }

    int dequeue(){
        int data;
        if(!isEmpty()){
            front=(front+1)%size;
            data=queue[front];
            queue[front]=Integer.MIN_VALUE;
            return data;
        }
        return -1;
    }
}

public class Main {

    public static void main(String[] args) {
        Circular_Queue queue=new Circular_Queue(100);

        for(int i=1;i<=100;i++){
            queue.enqueue(i);
        }

        int k=0;int temp=0;

        while(! queue.isEmpty()){
            temp=queue.dequeue();

            if(k%2==0){
                queue.enqueue(temp);
            }
            k++;
        }

        System.out.println(temp);

    }
}
