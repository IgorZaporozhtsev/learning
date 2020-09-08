package books.Schildt.core;

public class AccessModifiersStack {
    private int stck[] = new int[10];
    private int tos;

    public AccessModifiersStack() {
        tos = -1;
    }

    void push(int item){
        if (tos == 9){
            System.out.println("stack is full");
        } else {
            stck[++tos] = item;
        }
    }

    int pop(){
        if (tos < 0){
            System.out.println("stack is free");
            return 0;
        } else {
            return stck[tos--];
        }
    }
}


class TestAccessModifiersStack {
    public static void main(String[] args) {
        AccessModifiersStack stack1 = new AccessModifiersStack();
        AccessModifiersStack stack2 = new AccessModifiersStack();

        for (int i = 0; i < 10; i++) {
            stack1.push(i);
        }

        for (int i = 10; i < 20; i++) {
            stack2.push(i);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack1.pop());
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(stack2.pop());
        }

        //it's don't work because value is private
        // stack.tos = -2;
        // stack2.stck[3] = 100;
    }
}
